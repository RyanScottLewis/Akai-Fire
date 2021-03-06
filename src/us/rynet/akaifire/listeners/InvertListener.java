package us.rynet.akaifire.listeners;

import us.rynet.akaifire.Application;
import us.rynet.akaifire.controls.Button;

public class InvertListener implements ButtonListener {

  protected Application application;

  public InvertListener(Application application) {
    this.application = application;
  }

  public void onPressed(Button button) {
    application.invertPads();
  }

}
