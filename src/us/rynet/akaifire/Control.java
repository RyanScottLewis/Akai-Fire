package us.rynet.akaifire;

import java.util.ArrayList;

public abstract class Control {

  protected int                        index     = 0; // TODO: Rename to controlNumber
  protected ArrayList<ControlListener> listeners = new ArrayList<>();

  public Control() {
  }

  public Control(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  public void addListener(ControlListener listener) {
    listeners.add(listener);
  }

}
