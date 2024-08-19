import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel extends JFrame {
    private BufferedImage image;
    private Graphics graPixel;
    public static void main(String[] args) {
        Pixel v = new Pixel();
        v.MiVentana();
    }
    public void MiVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        graPixel = image.createGraphics();
        setVisible(true);
    }
    public void putPixel(int x, int y, Color c) {
        System.out.println("Punto: (" + x + ", " + y + ")"  + " Color: " + c.getRGB());
        image.setRGB(x, y, c.getRGB());
        getGraphics().drawImage(image, 0, 0, this);
    }
    @Override
    public void paint(Graphics g) {
       super.paint(g);
       int x = 150, y = 0, m = 1, b = 5, aux = 150, counter = 0, lastx = 0, lasty = 0;
       g.drawString("Punto inicial: (" + x + ", " + y + ")", 10, 20);
       for(int i = 0; i<100; i++) {
           if(i<25){
               y = m * aux + b;
               putPixel(x, y, Color.RED);
               aux++;
               x--;
           }else if(i<50){
                if(counter >= 1){
                    y = m * x + b;
                    putPixel(x, y, Color.GREEN);
                    x++;
                }else{
                    x = 150;
                    y = 0;
                    aux = 150;
                    counter++;
                }
           }else {
               if(counter == 1){
                   y = 0;
                   x = 150;
                   counter ++;
               }else{
                   y = m * aux + b;
                   putPixel(x, y, Color.RED);
                   aux++;
                   x--;
               }
           }
       }
       g.drawString("Punto final: (" + x + ", " + y + ")", 10, 40);
    }
}
