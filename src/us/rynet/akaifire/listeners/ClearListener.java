package us.rynet.akaifire.listeners;

import us.rynet.akaifire.Application;
import us.rynet.akaifire.controls.Button;

public class ClearListener implements ButtonListener {

  protected Application application;

  public ClearListener(Application application) {
    this.application = application;
  }

  public void onPressed(Button button) {
    application.clearPads();
  }

}
