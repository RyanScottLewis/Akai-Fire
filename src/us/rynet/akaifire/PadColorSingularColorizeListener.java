package us.rynet.akaifire;

public class PadColorSingularColorizeListener implements ButtonListener {

  protected AkaiFire   akaiFire;
  protected MidiBus    midiBus;
  protected PaintState state;

  public PadColorSingularColorizeListener(AkaiFire akaiFire, MidiBus midiBus, PaintState state) {
    this.akaiFire = akaiFire;
    this.midiBus  = midiBus;
    this.state    = state;
  }

  public void onPressed(Button button) {
    for (Pad pad : akaiFire.pads)
      pad.setColor( state.getTint() );

    akaiFire.pads.midiSend(midiBus);
  }

}
