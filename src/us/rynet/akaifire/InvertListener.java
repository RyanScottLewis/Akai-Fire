package us.rynet.akaifire;

public class InvertListener implements ButtonListener {

  protected AkaiFire       akaiFire;
  protected MidiController controller;

  public InvertListener(AkaiFire akaiFire, MidiController controller) {
    this.akaiFire   = akaiFire;
    this.controller = controller;
  }

  public void onPressed(Button button) {
    for (Pad pad : akaiFire.pads) {
      pad.red   = 127 - pad.red;
      pad.green = 127 - pad.green;
      pad.blue  = 127 - pad.blue;
    }

    akaiFire.pads.midiSend(controller);
  }

}
