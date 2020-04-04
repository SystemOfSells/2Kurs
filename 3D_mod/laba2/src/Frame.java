import javax.swing.*;
import java.awt.*;

public class Frame extends JComponent{

    JFrame jframe = new JFrame();

    public Frame(){
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setLocation(10, 10);
        jframe.setMinimumSize(new Dimension(800, 800));

        jframe.getContentPane().add(this);
        jframe.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3.0f));
        g2.setColor(new Color(0, 0, 0));
        g2.drawLine(400, 0, 400, 800);
        g2.drawLine(0, 400, 800, 400);
        for(int i=0; i< Paint.point.size()-1; i++)
        g2.drawLine(Paint.point.get(i).getX()+400, 400-Paint.point.get(i).getY(), Paint.point.get(i+1).getX()+400, 400-Paint.point.get(i+1).getY());
        g2.drawLine(Paint.point.get(0).getX()+400, 400-Paint.point.get(0).getY(), Paint.point.get(Paint.point.size()-1)
                .getX()+400, 400-Paint.point.get(Paint.point.size()-1).getY());
    }
}
