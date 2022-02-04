package us.rynet.akaifire.receivers;

public class ControlChangeMidiReceiver extends MidiReceiver {

  public void send(MidiMessage message, long timeStamp) {
    int status        = message.getStatus();
    int controlNumber = (int)(message.getMessage()[1] & 0xFF);
    int value         = (int)(message.getMessage()[2] & 0xFF);

    if (status == AkaiFire.CONTROL_START || status == AkaiFire.CONTROL_STOP) {
      akaiFire.controls.stream().
        filter(control -> (control instanceof Button) && control.index == controlNumber).
        forEach(control -> ((Button)control).setPressed(status == AkaiFire.CONTROL_START)); // TODO: Should be ALL controls - rename setPressed to isChanging or something
    } else if (status == AkaiFire.KNOB_CHANGED) {
      akaiFire.controls.stream().
        filter(control -> (control instanceof Knob) && control.index == controlNumber).
        forEach(control -> ((Knob)control).midiChange(value));
    }
  }

  public void close() {}

}
