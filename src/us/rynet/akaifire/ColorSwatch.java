package us.rynet.akaifire;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

import us.rynet.akaifire.controls.Pad;

public class ColorSwatch extends JButton {

  private static final long serialVersionUID = -3733266728451388517L;

  protected Pad pad;

  public ColorSwatch(Pad pad) {
    this.pad = pad;
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    Color color = new Color(pad.getRed() * 2, pad.getGreen() * 2, pad.getBlue() * 2);
    graphics.setColor(color);
    graphics.fillRect(0, 0, getWidth(), getHeight());

    graphics.dispose();
  }

}