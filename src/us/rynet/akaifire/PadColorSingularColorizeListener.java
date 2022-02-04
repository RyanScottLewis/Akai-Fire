package us.rynet.akaifire;

public class PadColorSingularColorizeListener implements ButtonListener {

  protected AkaiFire       akaiFire;
  protected MidiController controller;
  protected PaintState     state;

  public PadColorSingularColorizeListener(AkaiFire akaiFire, MidiController controller, PaintState state) {
    this.akaiFire   = akaiFire;
    this.controller = controller;
    this.state      = state;
  }

  public void onPressed(Button button) {
    for (Pad pad : akaiFire.pads)
      pad.setColor( state.getTint() );

    akaiFire.pads.midiSend(controller);
  }

}
