package us.rynet.akaifire;

public enum PaintMode { // TODO: Rename tp Mode and put in class after converting to straight Java
  DRAW,
  PREVIEW,
}

public class PaintState {

  protected PaintMode mode          = PaintMode.DRAW;
  protected int       modeChangedAt = 0;
  protected int[]     tint          = { 0, 0, 0 };

  public PaintMode getMode() {
    return mode;
  }

  public void setMode(PaintMode mode) {
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
