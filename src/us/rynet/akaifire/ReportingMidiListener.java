package us.rynet.akaifire;

import themidibus.StandardMidiListener;
import javax.sound.midi.MidiMessage;

public class ReportingMidiListener extends AkaiMidiListener implements StandardMidiListener {

  public ReportingMidiListener(AkaiFire akaiFire) {
    super(akaiFire);
  }

  public void midiMessage(MidiMessage message, long timeStamp) {
    System.out.println();
    System.out.println("MidiMessage Data:");
    System.out.println("--------");
    System.out.println("Status Byte/MIDI Command:"+message.getStatus());

    for (int i = 1;i < message.getMessage().length;i++)
      System.out.println("Param "+(i+1)+": "+(int)(message.getMessage()[i] & 0xFF));
  }


}
