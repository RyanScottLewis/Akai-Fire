package us.rynet.akaifire.listeners;

import javax.swing.JColorChooser;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.controls.Knob;
import us.rynet.akaifire.states.PaintState;

public class ColorKnobListener implements KnobListener { // TODO Rename to ColorPartial

  protected AkaiFire      akaiFire;
  protected PaintState    state;
  protected int           colorIndex;
  protected JColorChooser colorChooser;

  public ColorKnobListener(AkaiFire akaiFire, PaintState state, int colorIndex, JColorChooser colorChooser) {
    this.akaiFire     = akaiFire;
    this.state        = state;
    this.colorIndex   = colorIndex;
    this.colorChooser = colorChooser;
  }

  public void onChange(Knob knob) {
    state.setColorPartial(colorIndex, knob.getValue());
    state.setMode(PaintState.Mode.PREVIEW);

    byte[] color = state.getColor();
    colorChooser.setColor(color[0] * 2, color[1] * 2, color[2] * 2);
  }

}
