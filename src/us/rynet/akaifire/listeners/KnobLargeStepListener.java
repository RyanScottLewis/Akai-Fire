package us.rynet.akaifire.listeners;

public class KnobLargeStepListener implements ButtonListener {

  protected AkaiFire akaiFire;

  public KnobLargeStepListener(AkaiFire akaiFire) {
    this.akaiFire = akaiFire;
  }

  public void onPressed(Button button) { // TODO: Doesnt work - Needs onStart and onStop
    for (Knob knob : akaiFire.knobs)
      knob.setUseLargeSteps( button.getPressed() );
  }

}
