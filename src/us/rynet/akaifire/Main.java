package us.rynet.akaifire;

public class Main {

  protected MidiController controller;

  public static void main(String[] args) {
    new Main().run();
  }

  public Main() {
    controller = new MidiController();
  }

  protected void run() {
    controller.setup();

    System.out.println( controller.getReceiver() );
    System.out.println( controller.getTransmitter() );

  }

}
