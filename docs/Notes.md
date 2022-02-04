
# MIDI Listeners

Notice all bytes below are converted to integeres using the following system:
  int i = (int)(byte & 0xFF)
This properly convertes an unsigned byte (MIDI uses unsigned bytes) to a signed int
Because java only supports signed bytes, you will get incorrect values if you don't do so
