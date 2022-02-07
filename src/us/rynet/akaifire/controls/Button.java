package us.rynet.akaifire.controls;

import us.rynet.akaifire.listeners.ButtonListener;
import us.rynet.akaifire.listeners.ControlListener;

public class Button extends Control {

  protected boolean pressed    = false;
  protected boolean isPressing = false;

  public Button() {
    super();
  }

  public Button(int index) {
    super(index);
  }

  public boolean getPressed() { return pressed; }

  public boolean setPressed(boolean value) {
    pressed = value;
    if (!pressed) publish();

    return pressed;
  }

  protected void publish() {
    for (ControlListener listener : listeners)
      ((ButtonListener)listener).onPressed(this);
  }

}
