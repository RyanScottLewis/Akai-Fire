package us.rynet.akaifire.listeners;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.controls.Knob;
import us.rynet.akaifire.states.PaintState;

public class ColorKnobListener implements KnobListener { // TODO Rename to ColorPartial

  protected AkaiFire   akaiFire;
  protected PaintState state;
  protected int        colorIndex;

  public ColorKnobListener(AkaiFire akaiFire, PaintState state, int colorIndex) {
    this.akaiFire   = akaiFire;
    this.state      = state;
    this.colorIndex = colorIndex;
  }

  public void onChange(Knob knob) {
    state.setTintPartial(colorIndex, knob.value);
    state.setMode(PaintState.Mode.PREVIEW);
    state.setModeChangedAt( millis() ); // TODO: I hate that this is here
  }

}
