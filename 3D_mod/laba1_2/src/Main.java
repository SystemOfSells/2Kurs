import javax.swing.*;
import java.awt.*;

import static java.lang.Math.sin;
import static java.lang.StrictMath.cos;


public class Main extends JComponent{

    static double x=400;
    static double y=400;

    JFrame jframe = new JFrame();

    public Main(){
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setLocation(10, 10);
        jframe.setMinimumSize(new Dimension(800, 800));

        jframe.getContentPane().add(this);
        jframe.setVisible(true);
    }

    void DrawKoch(Graphics2D g ,double dir, double len, int n)
    {
        if(n==0) {
            g.setStroke(new BasicStroke(2.0f));
            g.drawLine((int) x, (int) y, (int) (x + len * cos(dir)), (int) (y + len * sin(dir)));
            x=x + len * cos(dir); y = y + len * sin(dir);
        } else {
            n--;
            len/=4;
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n); dir+=-Math.PI/2;
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n); dir+=Math.PI/2;
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n); dir+=Math.PI/2;
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n);
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n); dir+=-Math.PI/2;
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n); dir+=-Math.PI/2;
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n); dir+=Math.PI/2;
            g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),
                    (int)(Math.random()*255)));
            DrawKoch(g, dir,len,n);
        }
    }

    public void paint(Graphics2D g2, int x1, int y1, int length,double ang, int count){
        x=x1;
        y=y1;
        int flag;
        double tempAng=0;
        int n = 1;
        for(int i=0; i<count; i++) {
            flag = (int)(Math.random()*4);
            if(flag==1)
                tempAng = ang + Math.PI / 2;
            else if(flag == 0)
                tempAng = ang - Math.PI / 2;
            else  tempAng = ang;
            DrawKoch(g2, 0 + tempAng, length, n);
            length-=length/count;
            
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(34, 139, 34));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10.0f));
        g2.setColor(new Color(0, 128, 0));
        int length = 200;
        paint(g2, 0, 100, length, 0, 5);
        paint(g2, 0, 100, length, 0, 6);
        paint(g2, 0, 100, length, 0, 7);


    }

    public static void main(String[] args) {
        Main frame = new Main();
    }


}