# TODO

* OLED screen
  * Pragmatically use bitmap fonts
* Use a "double buffer" and render to pads only the "viewport"
  * Load bitmap
* Modal
  * General
    * Hold Browser button to select mode with Select knob
  * Paint (only current mode)
    * Palette mode
      * Set each pad to a color by holding the pad and rotating color knobs
      * Select a color by pressing color
    * Save/load into slots
    * Ability to pan & zoom (use viewport from above)
    * Fill (https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/)
    * Eraser
    * Maybe use a single button to select filters (Select knob)
      * Select/display from LED
      * Move `invert` from button to filter
* Rename Listener to ControlListener
* All control listeners should have onStart and onStop and use an abstract class or something...

* Knob values are overflowing due to being a byte now, therefore they need guards for the min/max for bytes... also get signs
