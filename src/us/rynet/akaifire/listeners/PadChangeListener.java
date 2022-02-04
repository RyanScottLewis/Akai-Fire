package us.rynet.akaifire.listeners;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.MidiController;
import us.rynet.akaifire.controls.Pad;
import us.rynet.akaifire.states.PaintState;

public class PadChangeListener implements PadListener {

  protected AkaiFire       akaiFire;
  protected MidiController controller;
  protected PaintState     state;

  public PadChangeListener(AkaiFire akaiFire, MidiController controller, PaintState state) {
    this.akaiFire   = akaiFire;
    this.controller = controller;
    this.state      = state;
  }

  public void onPressed(Pad pad) {
    pad.setColor( state.getTint() );
    pad.midiSend(controller);
  }

}
