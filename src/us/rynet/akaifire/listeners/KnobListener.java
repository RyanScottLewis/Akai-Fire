package us.rynet.akaifire.listeners;

import us.rynet.akaifire.controls.Knob;

public interface KnobListener extends ControlListener {

  public void onChange(Knob knob);

}
