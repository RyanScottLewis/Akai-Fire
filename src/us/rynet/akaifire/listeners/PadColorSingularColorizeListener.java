package us.rynet.akaifire.listeners;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.MidiController;
import us.rynet.akaifire.controls.Button;
import us.rynet.akaifire.controls.Pad;
import us.rynet.akaifire.states.PaintState;

public class PadColorSingularColorizeListener implements ButtonListener {

  protected AkaiFire       akaiFire;
  protected MidiController controller;
  protected PaintState     state;

  public PadColorSingularColorizeListener(AkaiFire akaiFire, MidiController controller, PaintState state) {
    this.akaiFire   = akaiFire;
    this.controller = controller;
    this.state      = state;
  }

  public void onPressed(Button button) {
    for (Pad pad : akaiFire.pads)
      pad.setColor( state.getTint() );

    akaiFire.pads.midiSend(controller);
  }

}
