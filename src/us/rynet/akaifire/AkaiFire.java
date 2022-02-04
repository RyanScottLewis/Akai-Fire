package us.rynet.akaifire;

import java.util.ArrayList;

import us.rynet.akaifire.collections.ButtonCollection;
import us.rynet.akaifire.collections.KnobCollection;
import us.rynet.akaifire.collections.PadCollection;
import us.rynet.akaifire.controls.Button;
import us.rynet.akaifire.controls.Control;
import us.rynet.akaifire.controls.ControlFactory;
import us.rynet.akaifire.controls.Knob;

// TODO: Rename to simply Device
public class AkaiFire {

  public static final String DEVICE_NAME            = "FL STUDIO FIRE";
  public static final int    CONTROL_START          = 144;
  public static final int    CONTROL_STOP           = 128;
  public static final int    KNOB_CHANGED           = 176;
  public static final int    PAD_COUNT              = 64;
  public static final int    PAD_COLUMN_COUNT       = 16;
  public static final int    PAD_ROW_COUNT          = 4;
  public static final int    PAD_INDEX_LOWER        = 54;
  public static final int    PAD_INDEX_UPPER        = 117;
  public static final int    TRANSPORT_BUTTON_COUNT = 4;
  public static final int    TRANSPORT_INDEX_LOWER  = 50;
  public static final int    CONTROL_BUTTON_COUNT   = 6;
  public static final int    CONTROL_INDEX_LOWER    = 44;
  public static final int    MUTE_SOLO_BUTTON_COUNT = 4;
  public static final int    MUTE_SOLO_INDEX_LOWER  = 36;
  public static final int    MODE_INDEX             = 26;
  public static final int    KNOB_COUNT             = 4;
  public static final int    KNOB_INDEX_LOWER       = 16;
  public static final int    PATTERN_BUTTON_COUNT   = 2;
  public static final int    PATTERN_INDEX_LOWER    = 31;
  public static final int    BROWSER_INDEX          = 33;
  public static final int    SELECT_KNOB_INDEX      = 118;
  public static final int    SELECT_BUTTON_INDEX    = 25;
  public static final int    GRID_BUTTON_COUNT      = 2;
  public static final int    GRID_INDEX_LOWER       = 34;

  protected ArrayList<Control> controls         = new ArrayList<Control>();
  protected Screen             screen           = new Screen();
  protected PadCollection      pads             = new PadCollection();
  protected ButtonCollection   transportButtons = new ButtonCollection();
  protected ButtonCollection   controlButtons   = new ButtonCollection();
  protected ButtonCollection   muteSoloButtons  = new ButtonCollection();
  protected Button             modeButton;
  protected KnobCollection     knobs            = new KnobCollection();
  protected ButtonCollection   patternButtons   = new ButtonCollection();
  protected Button             browserButton;
  protected Knob               selectKnob;
  protected Button             selectButton;
  protected ButtonCollection   gridButtons      = new ButtonCollection();

  public AkaiFire() {
    setupControls();
  }

  public ArrayList<Control> getControls() { return controls; }

  public void setControls(ArrayList<Control> controls) { this.controls = controls; }

  public Screen getScreen() { return screen; }

  public PadCollection getPads() { return pads; }

  public ButtonCollection getTransportButtons() { return transportButtons; }

  public ButtonCollection getControlButtons() { return controlButtons; }

  public ButtonCollection getMuteSoloButtons() { return muteSoloButtons; }

  public Button getModeButton() { return modeButton; }

  public KnobCollection getKnobs() { return knobs; }

  public ButtonCollection getPatternButtons() { return patternButtons; }

  public Button getBrowserButton() { return browserButton; }

  public Knob getSelectKnob() { return selectKnob; }

  public Button getSelectButton() { return selectButton; }

  public ButtonCollection getGridButtons() { return gridButtons; }

  protected void setupControls() {
    ControlFactory controlFactory = new ControlFactory(getControls());

    modeButton    = controlFactory.create("Button", MODE_INDEX);
    browserButton = controlFactory.create("Button", BROWSER_INDEX);
    selectKnob    = controlFactory.create("Knob", SELECT_KNOB_INDEX);
    selectButton  = controlFactory.create("Button", SELECT_BUTTON_INDEX);

    pads.addAll(controlFactory.create("Pad", PAD_COUNT, PAD_INDEX_LOWER));
    transportButtons.addAll(controlFactory.create("Button", TRANSPORT_BUTTON_COUNT, TRANSPORT_INDEX_LOWER));
    controlButtons.addAll(controlFactory.create("Button", CONTROL_BUTTON_COUNT, CONTROL_INDEX_LOWER));
    muteSoloButtons.addAll(controlFactory.create("Button", MUTE_SOLO_BUTTON_COUNT, MUTE_SOLO_INDEX_LOWER));
    knobs.addAll(controlFactory.create("Knob", KNOB_COUNT, KNOB_INDEX_LOWER));
    patternButtons.addAll(controlFactory.create("Button", PATTERN_BUTTON_COUNT, PATTERN_INDEX_LOWER));
    gridButtons.addAll(controlFactory.create("Button", GRID_BUTTON_COUNT, GRID_INDEX_LOWER));
  }

}
