import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Random;

// TW: flashing/bright colors! Do not run if you are sensitive.
public class Graphic extends JFrame{

  public static void main(String[] args){
    new Graphic();
  } // end main

  public Graphic(){
    MyCanvas c = new MyCanvas();

    this.add(c, BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBackground(Color.white);
    this.setSize(640, 480);
    this.setVisible(true);

  } // end constructor

  class MyCanvas extends JPanel{
    public void paintComponent(Graphics g){
        // text above butterfly
        g.setColor(Color.blue);
        g.setFont(new Font("Monospaced", 0, 12));
        g.drawString("butterfly.", 290, 150);

        // body of butterfly
        g.setColor(Color.black);
        g.fillOval(320, 200, 10, 100);
        g.drawArc(316, 173, 100, 200, 100, 40);
        g.drawArc(316, 173, 100, 200, 100, -35);
        g.drawArc(234,  173, 100, 200, 80, -40);
        g.drawArc(234,  173, 100, 200, 80, 35);
        

        // right wing of butterfly
        Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = 0.3f;//1.0 for brilliant, 0.0 for dull
        final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
        Color color = Color.getHSBColor(hue, saturation, luminance);
        g.setColor(color);
        int x1 = 331;
        int x2 = 332;
        int x3 = 360;
        int y1 = 210;
        int y2 = 240;
        int y3 = 238;
        for(int i = 0; i < 6; i++){
          g.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
          x1 += 15;
          x2 += 26;
          x3 += 27;
          y2 -= 6;
          y3 -= 6;
        }

        g.setColor(color);
        x1 = 333;
        x2 = 334;
        x3 = 362;
        y1 = 243;
        y2 = 273;
        y3 = 271;
        for(int i = 0; i < 6; i++){
          g.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
          x1 += 20;
          x2 += 26;
          x3 += 30;
          y2 -= 6;
          y3 -= 8;
        }

        g.setColor(color);
        x1 = 331;
        x2 = 332;
        x3 = 360;
        y1 = 274;
        y2 = 304;
        y3 = 302;
        for(int i = 0; i < 6; i++){
          g.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
          x1 += 20;
          x2 += 26;
          x3 += 30;
          y1 += 5;
          y2 += 1;
          y3 += 1;
        }

        // left wing of butterfly
        // create an empty buffered image object
        BufferedImage leftWing = null;

        // attempt to load the image from a file
        try{
          leftWing = ImageIO.read(new File("wing2.png"));
        } catch(Exception e){
          System.out.println("file error");
        }

        // draw the image to fill left side of butterfly
        g.drawImage(leftWing, 200, 160, 352, 320, 0, 0, leftWing.getWidth(), leftWing.getHeight(), null);
        // request repainting at the appropriate time
        this.repaint();
    }
  }
}
