package us.rynet.akaifire.listeners;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.MidiController;
import us.rynet.akaifire.controls.Button;
import us.rynet.akaifire.controls.Pad;

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
