package us.rynet.akaifire;

import javax.sound.midi.MidiMessage;
import themidibus.MidiListener;

public class AkaiMidiListener implements MidiListener {

  protected AkaiFire akaiFire;

  public AkaiMidiListener(AkaiFire akaiFire) {
    this.akaiFire = akaiFire;
  }

}
