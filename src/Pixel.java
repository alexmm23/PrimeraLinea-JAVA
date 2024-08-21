import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;

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
        graPixel = (Graphics2D) buffer.createGraphics();
        setVisible(true);
    }

    public void putPixel(int x, int y, Color c) {
        //se le da color al pizel
        buffer.setRGB(0, 0, c.getRGB());
        //Se establecen las caracteristicas de ese pixel
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 150, y = 0, m = 1, b = 5, aux = 150, counter = 0, lastx = 0;
        g.drawString("Punto inicial: (" + x + ", " + y + ")", 10, 20);
        //Zig zag en horizontal
        for (int i = 0; i < 200; i++) {
            if (i < 50) {
                y = m * aux + b;
                putPixel(x, y, Color.RED);
                aux++;
                x--;
            } else if (i < 100) {
                if (counter >= 1) {
                    y = m * x + b;
                    putPixel(x, y, Color.BLACK);
                    x++;
                    lastx = x;
                } else {
                    x = 150;
                    y = 0;
                    aux = 150;
                    counter++;
                }
            } else if (i < 150) {
                if (counter == 1) {
                    y = 0;
                    x = lastx + 50;
                    counter++;
                } else {
                    y = m * aux + b;
                    putPixel(x, y, Color.BLUE);
                    aux++;
                    x--;
                }
            } else {
                //TODO: Implement the last part of the exercise
            }
        }
        //Linea inclinada al reves
        y = 100;
        x = 300;
        aux = x;
        for (int i = 0; i < 100; i++) {
            y = m * aux + b;
            putPixel(x, y, Color.RED);
            aux++;
            x--;
        }
        x = 50;
        aux = 50;
        y = 0;
        b = 1;
        counter = 0;
        //Zig zag en vertical
        for (int i = 0; i < 100; i++) {
            if (i < 25) {
                y = m * x + b;
                putPixel(x, y, Color.RED);
                x++;
            } else if (i < 50) {
                if (counter >= 1) {
                    y = m * x + b;
                    putPixel(x, y, Color.CYAN);
                    x++;
                    lastx = x;
                } else {
                    x = 50;
                    y = 0;
                    aux = 50;
                    counter++;
                }
            } else {
                if (counter == 1) {
                    y = 0;
                    x = lastx + 50;
                    counter++;
                } else {
                    y = m * aux + b;
                    putPixel(x, y, Color.BLUE);
                    aux++;
                    x--;
                }
            }
        }

    }
}
