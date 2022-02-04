package us.rynet.akaifire.receivers;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public abstract class MidiReceiver implements Receiver {

  AkaiFire akaiFire;

  public MidiReceiver(AkaiFire akaiFire) {
    this.akaiFire = akaiFire;
  }

}
