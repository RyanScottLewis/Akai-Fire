package us.rynet.akaifire.controls;

import us.rynet.akaifire.listeners.ControlListener;
import us.rynet.akaifire.listeners.KnobListener;

public class Knob extends Control {

  public int STEP_NORMAL = 1;
  public int STEP_LARGE  = 5;

  protected byte    value         = 0;
  protected boolean useLargeSteps = false;

  public Knob() {
    super();
  }

  public Knob(int index) {
    super(index);
  }

  public Knob(int index, byte value) {
    super(index);

    this.value = value;
  }

  public byte getValue() { return value; }

  public void setValue(byte value) { this.value = value; }

  public boolean getUseLargeSteps() { return useLargeSteps; }

  public void setUseLargeSteps(boolean useLargeSteps) { this.useLargeSteps = useLargeSteps; }

  public void midiChange(byte value) {
    if (value <= 63) {
      increment();
    } else {
      decrement();
    }
  }

  public void increment() {
    increment(useLargeSteps ? STEP_NORMAL : STEP_LARGE);
  }

  public void increment(int steps) {
    value += steps;

    if (value > 127)
      value = 127;

    publish();
  }

  public void decrement() {
    decrement(useLargeSteps ? STEP_NORMAL : STEP_LARGE);
  }

  public void decrement(int steps) {
    value -= steps;

    if (value < 0)
      value = 0;

    publish();
  }

  protected void publish() {
    for (ControlListener listener : listeners)
      ((KnobListener)listener).onChange(this);
  }

}
