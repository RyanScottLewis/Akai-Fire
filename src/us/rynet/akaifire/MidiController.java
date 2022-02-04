package us.rynet.akaifire;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class MidiController {

  public MidiController() {
    setupDevices();
  }

  protected MidiDevice inputDevice;
  protected MidiDevice outputDevice;

  public void setup() {
    MidiDevice.Info[] infos = getMidiDeviceInfos();

    findDevices(infos);
  }

  public void open() {
    try {
      inputDevice.open();
      outputDevice.open();
    } catch (MidiUnavailableException error) {
      System.err.println("Cannot open MIDI device");
    }
  }

  public void close() {
    inputDevice.close();
    outputDevice.close();
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
      System.err.println("Cannot get MIDI device");
    }

    return device;
  }

  protected void assignDeviceToController(MidiDevice device) {
    if (device.getMaxReceivers() != 0) {
      inputDevice = device;
    } else if (device.getMaxTransmitters() != 0) {
      outputDevice = device;
    }
  }

}
