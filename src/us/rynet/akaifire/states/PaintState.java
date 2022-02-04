package us.rynet.akaifire.states;

public class PaintState {

  public enum Mode {
    DRAW,
    PREVIEW,
  }

  protected Mode  mode          = Mode.DRAW;
  protected int   modeChangedAt = 0;
  protected int[] tint          = { 0, 0, 0 };

  public Mode getMode() {
    return mode;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public int getModeChangedAt() {
    return modeChangedAt;
  }

  public void setModeChangedAt(int modeChangedAt) {
    this.modeChangedAt = modeChangedAt;
  }

  public int[] getTint() {
    return tint;
  }

  public void setTint(int[] tint) {
    this.tint = tint;
  }

  public void setTintPartial(int colorIndex, int value) {
    tint[colorIndex] = value;
  }

  public int getTintPartial(int colorIndex) {
    return tint[colorIndex];
  }

}
