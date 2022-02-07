package us.rynet.akaifire;

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

import us.rynet.akaifire.controls.Pad;

public class WindowPanel extends JPanel {

  private static final long serialVersionUID = 9138758044020206126L;

  protected Application   application;
  protected JColorChooser colorChooser;

  public WindowPanel(Application application) {
    super();

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    this.application = application;

    createPanelButtons();
    createColorChooser();

    JPanel panelPads = new JPanel();
    panelPads.setLayout(new BoxLayout(panelPads, BoxLayout.Y_AXIS));

    AkaiFire akaiFire = application.getAkaiFire();

    for (int row = 0; row < AkaiFire.PAD_ROW_COUNT; row++) {
      JPanel panelRow = new JPanel();

      for (int column = 0; column < AkaiFire.PAD_COLUMN_COUNT; column++) {
        
        System.out.println("Row: " + row + " Col: " + column);
        Pad         pad         = akaiFire.getPadAtCoordinates(row, column);
        ColorSwatch colorSwatch = new ColorSwatch(pad);

        panelRow.add(colorSwatch);
      }

      panelPads.add(panelRow);
    }

    panelPads.setBorder(BorderFactory.createTitledBorder("Pads"));

    add(panelPads);
  }

  public JColorChooser getColorChooser() { return colorChooser; }

  private void createPanelButtons() {
    JPanel panelScreenButtons = createPanelScreenButtons();
    JPanel panelPadButtons    = createPanelPadButtons();
    JPanel panelButtons       = new JPanel();

    panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));

    panelButtons.add(panelScreenButtons);
    panelButtons.add(panelPadButtons);

    add(panelButtons);
  }

  private JPanel createPanelScreenButtons() {
    JButton buttonScreenGrid   = createButtonScreenGrid(application);
    JButton buttonScreenLogo   = createButtonScreenLogo(application);
    JPanel  panelScreenButtons = new JPanel();

    panelScreenButtons.add(buttonScreenGrid);
    panelScreenButtons.add(buttonScreenLogo);

    panelScreenButtons.setBorder(BorderFactory.createTitledBorder("Screen Buttons"));

    return panelScreenButtons;
  }

  private JButton createButtonScreenGrid(Application application) {
    JButton buttonScreenGrid = new JButton("Grid");

    buttonScreenGrid.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        application.showGrid();
      }
    });

    return buttonScreenGrid;
  }

  private JButton createButtonScreenLogo(Application application) {
    JButton buttonScreenLogo = new JButton("Logo");

    buttonScreenLogo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        application.showLogo();
      }
    });

    return buttonScreenLogo;
  }

  private JPanel createPanelPadButtons() {
    JButton buttonPadClear  = createButtonPadClear(application);
    JButton buttonPadInvert = createButtonPadInvert(application);
    JButton buttonPadFill   = createButtonPadFill(application);
    JPanel  panelPadButtons = new JPanel();

    panelPadButtons.add(buttonPadClear);
    panelPadButtons.add(buttonPadInvert);
    panelPadButtons.add(buttonPadFill);

    panelPadButtons.setBorder(BorderFactory.createTitledBorder("Pad Buttons"));

    return panelPadButtons;
  }

  private JButton createButtonPadClear(Application application) {
    JButton buttonPadClear = new JButton("Clear");

    buttonPadClear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        application.clearPads();
      }
    });

    return buttonPadClear;
  }

  private JButton createButtonPadInvert(Application application) {
    JButton buttonPadInvert = new JButton("Invert");

    buttonPadInvert.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        application.invertPads();
      }
    });

    return buttonPadInvert;
  }

  private JButton createButtonPadFill(Application application) {
    JButton buttonPadFill = new JButton("Fill");

    buttonPadFill.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        application.fillPads();
      }
    });

    return buttonPadFill;
  }

  private void createColorChooser() {
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

    add(colorChooser);
  }

}
