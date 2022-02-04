package us.rynet.akaifire;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;
import javax.sound.midi.Transmitter;

public class MidiController {

  protected MidiDevice inputDevice;           // TODO: Are these named backwards? Confusing..
  protected MidiDevice outputDevice;
  protected boolean    sendTimestamps = false;
  protected Receiver   receiver;

  public void setup() {
    MidiDevice.Info[] infos = getMidiDeviceInfos();

    findDevices(infos);

    try {
      receiver = inputDevice.getReceiver();
    } catch (MidiUnavailableException error) {
      error.printStackTrace();
    }
  }

  public void send(byte[] data) { // Ripped from TheMidiBus
    if ((int)((byte)data[0] & 0xFF) == MetaMessage.META) {
      MetaMessage message = new MetaMessage();

      try {
        byte[] payload = new byte[data.length - 2];
        System.arraycopy(data, 2, payload, 0, data.length - 2);
        message.setMessage((int)((byte)data[1] & 0xFF), payload, data.length - 2);

        send(message);
      } catch (InvalidMidiDataException e) {
        System.err.println("Message not sent, invalid MIDI data");
      }
    } else if ((int)((byte)data[0] & 0xFF) == SysexMessage.SYSTEM_EXCLUSIVE || (int)((byte)data[0] & 0xFF) == SysexMessage.SPECIAL_SYSTEM_EXCLUSIVE) {
      SysexMessage message = new SysexMessage();

      try {
        message.setMessage(data, data.length);

        send(message);
      } catch (InvalidMidiDataException e) {
        System.err.println("Message not sent, invalid MIDI data");
      }
    } else {
      ShortMessage message = new ShortMessage();

      try {
        if (data.length > 2) {
          message.setMessage((int)((byte)data[0] & 0xFF), (int)((byte)data[1] & 0xFF), (int)((byte)data[2] & 0xFF));
        } else if (data.length > 1) {
          message.setMessage((int)((byte)data[0] & 0xFF), (int)((byte)data[1] & 0xFF), 0);
        } else {
          message.setMessage((int)((byte)data[0] & 0xFF));
        }

        send(message);
      } catch (InvalidMidiDataException e) {
        System.err.println("Message not sent, invalid MIDI data");
      }
    }
  }

  public synchronized void send(MidiMessage message) {
    if (sendTimestamps)
      receiver.send(message, System.currentTimeMillis());
    else
      receiver.send(message, -1);
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

  public void addReceiver(Receiver receiver) {
    Transmitter transmitter = null;

    try {
      transmitter = outputDevice.getTransmitter();
    } catch (MidiUnavailableException error) {
      error.printStackTrace();
    }

    transmitter.setReceiver(receiver);
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
      if (info.getName().equals(AkaiFire.DEVICE_NAME)) {
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
