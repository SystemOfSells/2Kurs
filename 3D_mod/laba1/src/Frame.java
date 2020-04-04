import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.sin;
import static java.lang.StrictMath.cos;


public class Frame extends JComponent{

    static double x=300;
    static double y=500;
    static double xMid=300;
    static double yMid=300;
    static int color=100;

    public int newColor(){
        color = (int)(Math.sqrt(Math.pow(x-xMid, 2)+Math.pow(y-yMid, 2))+30);
        System.out.println(x+" "+y+"   "+xMid+" "+yMid+"   "+color);
        return color;
    }

    JFrame jframe = new JFrame();

    public Frame(){
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setLocation(10, 10);
        jframe.setMinimumSize(new Dimension(800, 800));

        jframe.getContentPane().add(this);
        jframe.setVisible(true);
    }

    void DrawKoch(Graphics2D g ,double dir, double len, int n)
    {
        if(n==0) {
            g.setStroke(new BasicStroke(5.0f));
            g.drawLine((int) x, (int) y, (int) (x + len * cos(dir)), (int) (y + len * sin(dir)));
            x=x + len * cos(dir); y = y + len * sin(dir);
        } else {
            n--;
            len/=4;
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n); dir+=-Math.PI/2;
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n); dir+=Math.PI/2;
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n); dir+=Math.PI/2;
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n);
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n); dir+=-Math.PI/2;
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n); dir+=-Math.PI/2;
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n); dir+=Math.PI/2;
            g.setColor(new Color(0, 0, newColor()));
            DrawKoch(g, dir,len,n);
        }
    }

    public void paint(Graphics2D g2, int x1, int y1, int length,double ang){
        x=x1;
        y=y1;
        int n =2;
        DrawKoch(g2,0+ang,length, n);
        DrawKoch(g2,Math.PI/2+ang,length, n);
        DrawKoch(g2,Math.PI+ang,length, n);
        DrawKoch(g2,-Math.PI/2+ang,length, n);
    }
    @Override
    public void paintComponent(Graphics g) {
        Image img = null;
        try {
            img = ImageIO.read(new File("img.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(img, 0, 0, null);
        g2.setStroke(new BasicStroke(10.0f));
        int lenght=200;
        double dir=-Math.PI/2;
        x=(int)(x-lenght/2); y=(int)(y-lenght/2);
        dir = getDir(g2, lenght, dir);
    }

    private double getDir(Graphics2D g2, int lenght, double dir) {
        paint(g2,(int)x,(int)y, lenght, dir);
//        x=x + lenght * cos(dir);
//        y = y + lenght * sin(dir);
//        dir-=-Math.PI/3;
//        paint(g2,(int)x,(int)y, lenght, dir);
//        x=x + lenght * cos(dir);
//        y = y + lenght * sin(dir);
//        dir-=-Math.PI/3;
//        paint(g2,(int)x,(int)y, lenght, dir);
//        x=x + lenght * cos(dir);
//        y = y + lenght * sin(dir);
//        dir-=-Math.PI/3;
        return dir;
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }


}
