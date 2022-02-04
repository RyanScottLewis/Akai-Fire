package us.rynet.akaifire;

public class Pad extends Button {

  protected int red   = 0; // 0-127
  protected int green = 0; // 0-127
  protected int blue  = 0; // 0-127

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

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
  }

  public void setColor(int red, int green, int blue) {
    this.red   = red;
    this.green = green;
    this.blue  = blue;
  }

  public void setColor(int[] rgb) {
    this.red   = rgb[0];
    this.green = rgb[1];
    this.blue  = rgb[2];
  }

  public void midiSend(MidiBus midiBus) {
    PadColorMessage message = new PadColorMessage();

    midiBus.sendMessage( message.toByteArray(this) );
  }

  public byte[] toByteArray() {
    int controlNumber = index - AkaiFire.PAD_INDEX_LOWER;

    return new byte[] { (byte)controlNumber, (byte)red, (byte)green, (byte)blue };
  }

  protected void publish() {
    for (ControlListener listener : listeners)
      ((PadListener)listener).onPressed(this);
  }

}
