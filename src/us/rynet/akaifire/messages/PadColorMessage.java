package us.rynet.akaifire.messages;

import java.io.ByteArrayOutputStream;

import us.rynet.akaifire.collections.PadCollection;
import us.rynet.akaifire.controls.Pad;

public class PadColorMessage {

  protected ByteArrayOutputStream stream = new ByteArrayOutputStream();

  public byte[] toByteArray(PadCollection pads) {
    stream.reset();

    writeHeader(stream);
    writePadSize(stream, pads.size());
    writePads(stream, pads);
    writeFooter(stream);

    return stream.toByteArray();
  }

  public byte[] toByteArray(Pad pad) {
    stream.reset();

    writeHeader(stream);
    writePadSize(stream, 1);
    writePad(stream, pad);
    writeFooter(stream);

    return stream.toByteArray();
  }

  protected void writeHeader(ByteArrayOutputStream stream) {
    stream.write((byte)0xF0); // System Exclusive
    stream.write((byte)0x47); // Akai Manufacturer ID (see the MMA site for a list)
    stream.write((byte)0x7F); // The All-Call address
    stream.write((byte)0x43); // Fire Sub-ID
    stream.write((byte)0x65); // Write Pad Array command
  }

  protected void writePadSize(ByteArrayOutputStream stream, int padCount) {
    int size = padCount * 4;

    // Size as two 7-bit fields for MIDI
    stream.write((byte)(size >> 7));   // High length byte, bits 7 through 13 of following payload
    stream.write((byte)(size & 0x7F)); // Low length byte, bits 0 through 7 of following payload
  }

  protected void writePad(ByteArrayOutputStream stream, Pad pad) {
    for (byte padByte : pad.toByteArray())
      stream.write(padByte);
  }

  protected void writePads(ByteArrayOutputStream stream, PadCollection pads) {
    for (Pad pad : pads)
      writePad(stream, pad);
  }

  protected void writeFooter(ByteArrayOutputStream stream) {
    stream.write((byte)0xF7); // End of Exclusive
  }

}
