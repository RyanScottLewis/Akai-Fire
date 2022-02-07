package us.rynet.akaifire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WindowPanel extends JPanel {

  private static final long serialVersionUID = 9138758044020206126L;

  protected Application application;
  private JColorChooser colorChooser;

  public WindowPanel(Application application) {
    super(new BorderLayout());

    JButton buttonGrid = new JButton("Grid");
    buttonGrid.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        application.showGrid();
      }
    });

    JButton buttonLogo = new JButton("Logo");
    buttonLogo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        application.showLogo();
      }
    });

    JPanel panelScreenButtons = new JPanel();
    panelScreenButtons.setLayout(new BoxLayout(panelScreenButtons, BoxLayout.X_AXIS));
    panelScreenButtons.add(buttonGrid);
    panelScreenButtons.add(buttonLogo);
    panelScreenButtons.setBorder(BorderFactory.createTitledBorder("Screen"));

    add(panelScreenButtons, BorderLayout.PAGE_START);

    colorChooser = new JColorChooser();
    colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        Color color = colorChooser.getColor();

        byte   red   = (byte)(color.getRed() / 2);
        byte   green = (byte)(color.getGreen() / 2);
        byte   blue  = (byte)(color.getBlue() / 2);
        byte[] rgb   = { red, green, blue };

        application.getPaintState().setColor(rgb);

        application.getAkaiFire().knobs.get(0).setValue(red);
        application.getAkaiFire().knobs.get(1).setValue(green);
        application.getAkaiFire().knobs.get(2).setValue(blue);

        application.sendPads();
      }
    });
    colorChooser.setBorder(BorderFactory.createTitledBorder("Pad Color"));

    add(colorChooser, BorderLayout.PAGE_END);
  }

  public JColorChooser getColorChooser() { return colorChooser; }

}
