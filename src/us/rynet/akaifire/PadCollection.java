package us.rynet.akaifire;

public class PadCollection extends ControlCollection<Pad> {

  public Pad getAtCoordinates(int row, int column) {
    int index = row + (AkaiFire.PAD_COLUMN_COUNT * column);

    return get(index);
  }

  public Pad getAtControl(int controlIndex) {
    return get(controlIndex - AkaiFire.PAD_INDEX_LOWER);
  }

  public void midiSend(MidiBus midiBus) {
    PadColorMessage message = new PadColorMessage();

    midiBus.sendMessage( message.toByteArray(this) );
  }

}
