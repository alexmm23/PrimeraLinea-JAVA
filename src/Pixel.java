import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel extends JFrame {
    private BufferedImage buffer;

    public static void main(String[] args) {
        Pixel v = new Pixel();
        v.MiVentana();
    }

    public void MiVentana() {
        setTitle("Mi ventana");
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        setVisible(true);
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Zig zag horizontal
        drawZigZagHorizontal(100, 100, 100, Color.BLUE, g);

        // Zig zag vertical
        drawZigZagVertical(250, 100, 100, Color.GREEN, g);

        // Línea con pendiente -1
        drawLineWithNegativeSlope(100, 100, 50, Color.RED, g);

        // Rombo
        drawRombo(300, 200, 50, Color.BLUE, g);
    }

    public void drawZigZagHorizontal(int startX, int startY, int length, Color color, Graphics g) {
        int x = startX;
        int y = startY;
        int stepSize = 10;
        boolean positiveSlope = true;

        for (int i = 0; i < length / stepSize; i++) {
            if (positiveSlope) {
                for (int j = 0; j < stepSize; j++) {
                    putPixel(x, y, color);
                    x++;
                    y--;
                }
            } else {
                for (int j = 0; j < stepSize; j++) {
                    putPixel(x, y, color);
                    x++;
                    y++;
                }
            }
            positiveSlope = !positiveSlope;
        }
    }

    public void drawZigZagVertical(int startX, int startY, int length, Color color, Graphics g) {
        int x = startX;
        int y = startY;
        int stepSize = 10;
        boolean positiveSlope = true;

        for (int i = 0; i < length / stepSize; i++) {
            if (positiveSlope) {
                for (int j = 0; j < stepSize; j++) {
                    putPixel(x, y, color);
                    x++;
                    y++;
                }
            } else {
                for (int j = 0; j < stepSize; j++) {
                    putPixel(x, y, color);
                    x--;
                    y++;
                }
            }
            positiveSlope = !positiveSlope;
        }
    }

    // Dibuja una línea con pendiente -1
    public void drawLineWithNegativeSlope(int startX, int startY, int length, Color color, Graphics g) {
        int x = startX;
        int y = startY;

        for (int i = 0; i < length; i++) {
            putPixel(x, y, color);
            x++;
            y--;
        }
    }

    // Dibuja un rombo centrado en (startX, startY) con un lado de longitud `size`
    public void drawRombo(int centerX, int centerY, int size, Color color, Graphics g) {
        int x = centerX;
        int y = centerY;

        // Lado superior (pendiente positiva 1)
        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x++;
            y--;
        }

        // Lado derecho (pendiente negativa 1)
        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x++;
            y++;
        }

        // Lado inferior (pendiente positiva 1)
        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x--;
            y++;
        }

        // Lado izquierdo (pendiente negativa 1)
        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x--;
            y--;
        }
    }
}
