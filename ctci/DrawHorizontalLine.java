/*
 * 5.8
 * Draw a horizontal line
 * screen is a 1D byte array, each byte has 8 pixel
 * width is the # of pixels in a line
 * draw line (x1, y), (x2, y)
 */
public class DrawHorizontalLine {
    public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        int x1Bit = width * y + x1;
        int x2Bit=  width * y + x2;
        int x1Byte = x1Bit / 8;
        int x1Offset = x1Bit % 8;
        int x2Byte = x2Bit / 8;
        int x2Offset = x2Byte % 8;
        // error test
        if (x1Byte >= screen.length || x2Byte >= screen.length) return;
        // if two dots in the same byte
        if (x1Byte == x2Byte) {
            screen[x1Byte] |= constructByte(x1Offset, x2Offset);
            return;
        } else {
            // set start partial
            screen[x1Byte] |= constructByte(x1Offset, 7);
            // set mid complete byte
            for (int i = x1Byte + 1; i < x2Byte; i++) {
                screen[i] = (byte)0xff;
            }
            // set end partial
            screen[x2Byte] |= constructByte(0, x2Offset);
        }
    }

    // set bit from i to j -> 1
    private byte constructByte(int i, int j) {
        int len = j - i + 1;
        return (byte)(((1 << len) - 1) << (7 - j));
    }
}
