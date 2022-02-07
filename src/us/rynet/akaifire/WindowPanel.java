package us.rynet.akaifire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WindowPanel extends JPanel {

  private static final long serialVersionUID = 9138758044020206126L;

  protected static final String TITLE = "Akai Fire";

  protected JColorChooser colorChooser;

  protected Application application;

  public static void run(Application application) {
    JFrame frame = new JFrame(TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComponent newContentPane = new WindowPanel(application);
    newContentPane.setOpaque(true); // content panes must be opaque
    frame.setContentPane(newContentPane);

    frame.pack();
    frame.setVisible(true);
  }

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
        
        byte[] rgb = { (byte)(color.getRed() / 2), (byte)(color.getGreen() / 2), (byte)(color.getBlue() / 2) };
        application.getPaintState().setColor(rgb);
        
        application.sendPads();
      }
    });
    colorChooser.setBorder(BorderFactory.createTitledBorder("Pad Color"));

    add(colorChooser, BorderLayout.PAGE_END);
  }

}
