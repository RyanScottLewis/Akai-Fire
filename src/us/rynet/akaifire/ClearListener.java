package us.rynet.akaifire;

public class ClearListener implements ButtonListener {

  protected AkaiFire akaiFire;
  protected MidiBus  midiBus;

  public ClearListener(AkaiFire akaiFire, MidiBus midiBus) {
    this.akaiFire = akaiFire;
    this.midiBus  = midiBus;
  }

  public void onPressed(Button button) {
    for (Pad pad : akaiFire.pads)
      pad.setColor(0, 0, 0);

    akaiFire.pads.midiSend(midiBus);
  }

}
