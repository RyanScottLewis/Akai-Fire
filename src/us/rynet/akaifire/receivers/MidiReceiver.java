package us.rynet.akaifire.receivers;

import javax.sound.midi.Receiver;

import us.rynet.akaifire.AkaiFire;

public abstract class MidiReceiver implements Receiver {

  AkaiFire akaiFire;

  public MidiReceiver(AkaiFire akaiFire) {
    this.akaiFire = akaiFire;
  }

}
