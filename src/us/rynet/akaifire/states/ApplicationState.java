package us.rynet.akaifire.states;

public class ApplicationState {

  public enum Mode {
    PAINT,
  }

  Mode mode = Mode.PAINT;

  public Mode getMode() { return mode; }

}
