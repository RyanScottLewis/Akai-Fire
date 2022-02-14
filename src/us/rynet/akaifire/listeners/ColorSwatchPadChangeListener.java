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
    // TODO: Only update the related colorSwatch to the Pad pressed...
    // Like: if (colorSwatch.getPad() == pad) { colorSwatch.repaint(); break; }
    // Or index colorSwatches by pads in a Hash map
    for (ColorSwatch colorSwatch : colorSwatches)
      colorSwatch.repaint();
  }

}
