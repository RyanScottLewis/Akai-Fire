package us.rynet.akaifire.receivers;

import javax.sound.midi.MidiMessage;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.controls.Button;
import us.rynet.akaifire.controls.Knob;

public class ControlChangeReceiver extends MidiReceiver {

  public ControlChangeReceiver(AkaiFire akaiFire) {
    super(akaiFire);
  }

  public void send(MidiMessage message, long timeStamp) {
    byte status        = (byte)message.getStatus();
    byte controlNumber = (byte)(message.getMessage()[1] & 0xFF);
    byte value         = (byte)(message.getMessage()[2] & 0xFF);

    if (status == AkaiFire.CONTROL_START || status == AkaiFire.CONTROL_STOP) {
      // TODO: Should be ALL controls - rename setPressed to isChanging or something
      akaiFire.getControls().stream().filter(control -> (control instanceof Button) && control.getIndex() == controlNumber).forEach(control -> ((Button)control).setPressed(status == AkaiFire.CONTROL_START));
    } else if (status == AkaiFire.KNOB_CHANGED) {
      akaiFire.getControls().stream().filter(control -> (control instanceof Knob) && control.getIndex() == controlNumber).forEach(control -> ((Knob)control).midiChange(value));
    }
  }

  public void close() {}

}
