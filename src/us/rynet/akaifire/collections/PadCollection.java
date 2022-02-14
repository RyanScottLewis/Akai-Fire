package us.rynet.akaifire.collections;

import us.rynet.akaifire.AkaiFire;
import us.rynet.akaifire.MidiController;
import us.rynet.akaifire.controls.Pad;
import us.rynet.akaifire.messages.PadColorMessage;

public class PadCollection extends ControlCollection<Pad> {

  private static final long serialVersionUID = -5375387472893488160L;

  public Pad getAtCoordinates(int row, int column) {
    int index = column + (AkaiFire.PAD_COLUMN_COUNT * row);

    return get(index);
  }

  public Pad getAtControl(int controlIndex) {
    return get(controlIndex - AkaiFire.PAD_INDEX_LOWER);
  }

  public void midiSend(MidiController controller) {
    PadColorMessage message = new PadColorMessage();

    controller.send(message.toByteArray(this));
  }

}
