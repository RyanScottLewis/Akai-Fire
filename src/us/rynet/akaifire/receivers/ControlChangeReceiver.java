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
    int status        = (int)message.getStatus();
    int controlNumber = (int)(message.getMessage()[1] & 0xFF);
    int value         = (int)(message.getMessage()[2] & 0xFF);

    if (status == AkaiFire.CONTROL_START || status == AkaiFire.CONTROL_STOP) {
      // TODO: Should be ALL controls - rename setPressed to isChanging or something
      akaiFire.getControls().stream().filter(control -> (control instanceof Button) && control.getIndex() == controlNumber).forEach(control -> ((Button)control).setPressed(status == AkaiFire.CONTROL_START));
    } else if (status == AkaiFire.KNOB_CHANGED) {
      akaiFire.getControls().stream().filter(control -> (control instanceof Knob) && control.getIndex() == controlNumber).forEach(control -> ((Knob)control).midiChange((byte)value));
    }
  }

  public void close() {}

}
