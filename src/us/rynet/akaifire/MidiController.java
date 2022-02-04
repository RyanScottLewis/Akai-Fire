package us.rynet.akaifire;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

public class MidiController {

  public MidiController() {
    setupDevices();
  }

  protected MidiDevice receiver;
  protected MidiDevice transmitter;

  public MidiDevice getReceiver() { return receiver; }

  public MidiDevice getTransmitter() { return transmitter; }

  public void setup() {
    MidiDevice.Info[] infos = getMidiDeviceInfos();

    findDevices(infos);
  }

  public void open() {
    try {
      receiver.open();
      transmitter.open();
    } catch (MidiUnavailableException error) {
      System.err.println("Can't open MIDI device");
    }
  }

  public void close() {
    receiver.close();
    transmitter.close();
  }

  protected MidiDevice.Info[] getMidiDeviceInfos() {
    MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();

    if (infos.length == 0) {
      System.err.println("No MIDI devices found");
      return new MidiDevice.Info[0];
    }

    return infos;
  }

  protected void findDevices(MidiDevice.Info[] infos) {
    for (MidiDevice.Info info : infos) {
      if ( info.getName().equals(AkaiFire.DEVICE_NAME) ) {
        MidiDevice device = getMidiDevice(info);

        assignDeviceToController(device);
      }
    }
  }

  protected MidiDevice getMidiDevice(MidiDevice.Info info) {
    MidiDevice device = null;

    try {
      device = MidiSystem.getMidiDevice(info);
    } catch (MidiUnavailableException error) {
      System.err.println("Can't get MIDI device");
    }

    return device;
  }

  protected void assignDeviceToController(MidiDevice device) {
    if (device.getMaxReceivers() != 0) {
      receiver = device;
    } else if (device.getMaxTransmitters() != 0) {
      transmitter = device;
    }
  }

}
