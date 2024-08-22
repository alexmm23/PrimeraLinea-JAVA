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

        drawZigZagHorizontal(100, 100, 100, Color.BLUE, g);

        drawZigZagVertical(250, 100, 100, Color.GREEN, g);

        drawLineWithNegativeSlope(100, 100, 50, Color.RED, g);

        drawRombo(300, 200, 50, Color.BLUE, g);
    }

    public void drawZigZagHorizontal(int startX, int startY, int length, Color color, Graphics g) {
        int x = startX;
        int y = startY;
        int stepSize = 20;
        // para saber si la pendiente es positiva o negativa
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
        int stepSize = 20;
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
    public void drawLineWithNegativeSlope(int startX, int startY, int length, Color color, Graphics g) {
        int x = startX;
        int y = startY;

        for (int i = 0; i < length; i++) {
            putPixel(x, y, color);
            x++;
            y--;
        }
    }
    public void drawRombo(int centerX, int centerY, int size, Color color, Graphics g) {
        // para la ubicación de los puntos
        int x = centerX;
        int y = centerY;

        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x++;
            y--;
        }

        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x++;
            y++;
        }

        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x--;
            y++;
        }

        for (int i = 0; i < size; i++) {
            putPixel(x, y, color);
            x--;
            y--;
        }
    }
}
