package us.rynet.akaifire.controls;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.MidiController;
import us.rynet.akaifire.listeners.ControlListener;
import us.rynet.akaifire.listeners.PadListener;
import us.rynet.akaifire.messages.PadColorMessage;

public class Pad extends Button {

  private int red   = 0; // 0-127
  private int green = 0; // 0-127
  private int blue  = 0; // 0-127

  public Pad() {
    super();
  }

  public Pad(int index) {
    super(index);
  }

  public Pad(int index, int red, int green, int blue) {
    super(index);

    setColor(red, green, blue);
  }

  public int getRed() {
    return red;
  }

  public void setRed(int red) {
    this.red = red;
  }

  public int getGreen() {
    return green;
  }

  public void setGreen(int green) {
    this.green = green;
  }

  public int getBlue() {
    return blue;
  }

  public void setBlue(int blue) {
    this.blue = blue;
  }

  public void setColor(int red, int green, int blue) {
    this.setRed(red);
    this.setGreen(green);
    this.setBlue(blue);
  }

  public void setColor(int[] rgb) {
    this.setRed(rgb[0]);
    this.setGreen(rgb[1]);
    this.setBlue(rgb[2]);
  }

  public void midiSend(MidiController controller) {
    PadColorMessage message = new PadColorMessage();

    controller.send( message.toByteArray(this) );
  }

  public byte[] toByteArray() {
    int controlNumber = index - AkaiFire.PAD_INDEX_LOWER;

    return new byte[] { (byte)controlNumber, (byte)getRed(), (byte)getGreen(), (byte)getBlue() };
  }

  protected void publish() {
    for (ControlListener listener : listeners)
      ((PadListener)listener).onPressed(this);
  }

}
