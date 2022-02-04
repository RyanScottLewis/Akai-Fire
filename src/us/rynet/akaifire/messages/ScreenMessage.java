package us.rynet.akaifire.messages;

import java.io.ByteArrayOutputStream;

import us.rynet.akaifire.Screen;

public class ScreenMessage {

  protected ByteArrayOutputStream stream = new ByteArrayOutputStream();

  public byte[] toByteArray(Screen screen) {
    stream.reset();

    int[] screenBitmap = screen.getBitmap();

    writeHeader(stream);
    writeSize(stream, screenBitmap.length + 4);
    writeBitmapHeader(stream);
    writeData(stream, screenBitmap);
    writeFooter(stream);

    return stream.toByteArray();
  }

  protected void writeHeader(ByteArrayOutputStream stream) {
    stream.write((byte)0xF0); // System Exclusive
    stream.write((byte)0x47); // Akai Manufacturer ID (see the MMA site for a list)
    stream.write((byte)0x7F); // The All-Call address
    stream.write((byte)0x43); // Fire Sub-ID
    stream.write((byte)0x0E); // Write OLED command
  }

  protected void writeSize(ByteArrayOutputStream stream, int size) {
    // Size as two 7-bit fields for MIDI
    stream.write((byte)(size >> 7)); // High length byte, bits 7 through 13 of following payload
    stream.write((byte)(size & 0x7F)); // Low length byte, bits 0 through 7 of following payload
  }

  protected void writeBitmapHeader(ByteArrayOutputStream stream) {
    stream.write((byte)0x00); // Start 8-pixel band of update
    stream.write((byte)0x07); // End 8-pixel band of update (here, 8 bands of 8 pixels, i.e. the whole display)
    stream.write((byte)0x00); // Start colum of update
    stream.write((byte)0x7F); // End column of update
  }

  protected void writeData(ByteArrayOutputStream stream, int[] bitmap) {
    for (int pixel : bitmap)
      stream.write(pixel);
  }

  protected void writeFooter(ByteArrayOutputStream stream) {
    stream.write((byte)0xF7); // End of Exclusive
  }

}
