package us.rynet.akaifire.listeners;

import java.util.ArrayList;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.ColorSwatch;
import us.rynet.akaifire.controls.Pad;

public class ColorSwatchPadChangeListener implements PadListener {

  protected AkaiFire               akaiFire;
  protected ArrayList<ColorSwatch> colorSwatches;

  public ColorSwatchPadChangeListener(AkaiFire akaiFire, ArrayList<ColorSwatch> colorSwatches) {
    this.akaiFire      = akaiFire;
    this.colorSwatches = colorSwatches;
  }

  public void onPressed(Pad pad) {
    for (ColorSwatch colorSwatch : colorSwatches)
      colorSwatch.repaint();
  }

}
