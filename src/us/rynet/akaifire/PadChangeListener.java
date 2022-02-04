package us.rynet.akaifire;

public class PadChangeListener implements PadListener {

  protected AkaiFire   akaiFire;
  protected MidiBus    midiBus;
  protected PaintState state;

  public PadChangeListener(AkaiFire akaiFire, MidiBus midiBus, PaintState state) {
    this.akaiFire = akaiFire;
    this.midiBus  = midiBus;
    this.state    = state;
  }

  public void onPressed(Pad pad) {
    pad.setColor( state.getTint() );
    pad.midiSend(midiBus);
  }

}
