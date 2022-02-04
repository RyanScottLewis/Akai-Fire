package us.rynet.akaifire.listeners;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.controls.Button;
import us.rynet.akaifire.controls.Knob;

public class KnobLargeStepListener implements ButtonListener {

  protected AkaiFire akaiFire;

  public KnobLargeStepListener(AkaiFire akaiFire) {
    this.akaiFire = akaiFire;
  }

  public void onPressed(Button button) { // TODO: Doesnt work - Needs onStart and onStop
    for (Knob knob : akaiFire.getKnobs())
      knob.setUseLargeSteps(button.getPressed());
  }

}
