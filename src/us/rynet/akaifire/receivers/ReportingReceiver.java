package us.rynet.akaifire.receivers;

public class ReportingReceiver extends MidiReceiver {

  public void send(MidiMessage message, long timeStamp) {
    System.out.println();
    System.out.println("MidiMessage Data:");
    System.out.println("--------");
    System.out.println("Status Byte/MIDI Command:"+message.getStatus());

    for (int i = 1;i < message.getMessage().length;i++)
      System.out.println("Param "+(i+1)+": "+(int)(message.getMessage()[i] & 0xFF));
  }

  public void close() {}

}
