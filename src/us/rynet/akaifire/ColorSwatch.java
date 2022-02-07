package us.rynet.akaifire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.AbstractButton;

import us.rynet.akaifire.controls.Pad;

public class ColorSwatch extends AbstractButton {

  private static final long serialVersionUID = -3733266728451388517L;

  protected Pad pad;

  public ColorSwatch(Pad pad) {
    this.pad = pad;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Dimension originalSize = super.getPreferredSize();
    int       gap          = (int)(originalSize.height * 0.2);
    int       x            = originalSize.width + gap;
    int       y            = gap;

    Color color = new Color(pad.getRed() * 2, pad.getGreen() * 2, pad.getBlue() * 2);
    g.setColor(color);

    Dimension size = getPreferredSize();
    g.drawRect(x, y, size.width, size.height);
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension size = super.getPreferredSize();
    size.width += size.height;
    return size;
  }

}