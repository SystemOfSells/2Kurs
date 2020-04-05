import javax.swing.*;
import java.awt.*;

public class Frame extends JComponent{

    JFrame jframe = new JFrame();
    Line line;

    public Frame(Line line1){
        line = line1;
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setLocation(10, 10);
        jframe.setMinimumSize(new Dimension(800, 800));

        jframe.getContentPane().add(this);
        jframe.setVisible(true);
    }

    public void drawField(Graphics g){
        g.setColor(new Color(0, 0, 0));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1.0f));
        g2.setColor(new Color(0, 0, 0));
        for(int i=50; i<800; i+=50)
            g2.drawLine(i, 0, i, 800);
        for(int i=50; i<800; i+=50)
            g2.drawLine(0, i, 800, i);
    }

    public void drawXY(Graphics g){
        g.setColor(new Color(0, 0, 0));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3.0f));
        g2.drawLine(0, 400, 800, 400);
        g2.drawLine(400, 0, 400, 800);
    }
    @Override
    public void paintComponent(Graphics g) {
        drawField(g);
        drawXY(g);
        g.drawLine(line.getP1().getX()+400, 400-line.getP1().getY(),
                line.getP2().getX()+400,400 - line.getP2().getY());
        g.setColor(new Color(255, 0, 0));
        Graphics2D g2 = (Graphics2D) g;
        System.out.print(Operations.points.size());
        for (Point p: Operations.points){
            g.drawOval(p.getX()+400, 400-p.getY(), 5, 5);
        }
    }
}
