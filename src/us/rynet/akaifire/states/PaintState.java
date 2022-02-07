package us.rynet.akaifire.states;

public class PaintState {

  public enum Mode {
    DRAW, PREVIEW,
  }

  protected Mode   mode          = Mode.DRAW;
  protected double modeChangedAt = 0;
  protected byte[] color         = { 0, 0, 0 };

  public Mode getMode() { return mode; }

  public void setMode(Mode mode) {
    this.mode          = mode;
    this.modeChangedAt = System.nanoTime();
  }

  public byte[] getColor() { return color; }

  public void setColor(byte[] tint) { this.color = tint; }

  public void setColorPartial(int colorIndex, byte value) {
    color[colorIndex] = value;
  }

  public int getColorPartial(byte colorIndex) {
    return color[colorIndex];
  }

  public double getTimeSinceModeChange() { return (System.nanoTime() - modeChangedAt) / 1e6; }

}
