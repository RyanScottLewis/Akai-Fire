package us.rynet.akaifire;

import java.util.ArrayList;

public class ControlFactory {

  protected ArrayList<Control> controls = new ArrayList<Control>();

  public ControlFactory(ArrayList<Control> controls) {
    this.controls = controls;
  }

  public <T extends Control> T create(String type, int controlNumber) {
    Control result = null;

    switch(type) {
      case "Button":
        result = new Button(controlNumber);
        break;
      case "Pad":
        result = new Pad(controlNumber);
        break;
      case "Knob":
        result = new Knob(controlNumber);
        break;
      default:
        // TODO: Exception
    }

    controls.add(result);

    return (T)result;
  }

  public <T extends Control> ArrayList<T> create(String type, int count, int initialControlNumber) {
    ArrayList<T> result = new ArrayList<T>();

    for (int index=0; index < count; index++)
      result.add( create(type, initialControlNumber + index) );

    return result;
  }

}
