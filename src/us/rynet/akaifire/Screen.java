package us.rynet.akaifire;

public class Screen {

  public int[][] BIT_MUTATE = {
    { 13,  19,  25,  31,  37,  43,  49 },
    {  0,  20,  26,  32,  38,  44,  50 },
    {  1,   7,  27,  33,  39,  45,  51 },
    {  2,   8,  14,  34,  40,  46,  52 },
    {  3,   9,  15,  21,  41,  47,  53 },
    {  4,  10,  16,  22,  28,  48,  54 },
    {  5,  11,  17,  23,  29,  35,  55 },
    {  6,  12,  18,  24,  30,  36,  42 }
  };

  protected int[] bitmap = new int[1171]; // The OLED has 1171 bytes for xfer: ceil(128*64/7)

  public int[] getBitmap() {
    return bitmap;
  }

  public void setBitmap(int[] bitmap) {
    for (int x = 0; x < 128; x++) {
      for (int y = 0; y < 64; y++) {
        int index = x + (128 * y);

        plotPixel(x, y, bitmap[index]);
      }
    }
  }

  public void plotPixel(int x, int y, int c) {
    int remapBit;
    int position;

    if (x < 128 && y < 64) {
      // Unwind 128x64 arrangement into a 1024x8 arrangement of pixels.
      x += 128 * (y / 8);
      y %= 8;

      remapBit = BIT_MUTATE[y][x % 7]; // Remap by tiling 8x7 block of translated pixels.
      position = x / 7 * 8 + remapBit / 7;

      if (c > 0) {
        bitmap[position] |= 1 << (remapBit % 7);
      } else {
        bitmap[position] &= ~(1 << (remapBit % 7));
      }
    }
  }

  public void midiSend(MidiController controller) {
    ScreenMessage message = new ScreenMessage();

    controller.send( message.toByteArray(this) );
  }


}
