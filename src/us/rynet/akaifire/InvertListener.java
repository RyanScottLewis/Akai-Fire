package us.rynet.akaifire;

public class InvertListener implements ButtonListener {

  protected AkaiFire akaiFire;
  protected MidiBus  midiBus;

  public InvertListener(AkaiFire akaiFire, MidiBus midiBus) {
    this.akaiFire = akaiFire;
    this.midiBus  = midiBus;
  }

  public void onPressed(Button button) {
    for (Pad pad : akaiFire.pads) {
      pad.red   = 127 - pad.red;
      pad.green = 127 - pad.green;
      pad.blue  = 127 - pad.blue;
    }

    akaiFire.pads.midiSend(midiBus);
  }

}
