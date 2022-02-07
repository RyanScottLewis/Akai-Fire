package us.rynet.akaifire.listeners;

import us.rynet.akaifire.Application;
import us.rynet.akaifire.controls.Button;

public class PadFillListener implements ButtonListener {

  protected Application application;

  public PadFillListener(Application application) {
    this.application = application;
  }

  public void onPressed(Button button) {
    application.fillPads();
  }

}
