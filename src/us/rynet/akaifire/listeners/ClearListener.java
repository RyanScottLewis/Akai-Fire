package us.rynet.akaifire;

public class ClearListener implements ButtonListener {

  protected AkaiFire       akaiFire;
  protected MidiController controller;

  public ClearListener(AkaiFire akaiFire, MidiController controller) {
    this.akaiFire   = akaiFire;
    this.controller = controller;
  }

  public void onPressed(Button button) {
    for (Pad pad : akaiFire.pads)
      pad.setColor(0, 0, 0);

    akaiFire.pads.midiSend(controller);
  }

}
