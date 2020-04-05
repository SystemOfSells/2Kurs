import java.util.Scanner;

public class Line {

    private Point p1;
    private Point p2;

    public Line(int x1, int y1, int x2, int y2){
        p1 = new Point();
        p2 = new Point();
        p1.setX(x1); p1.setY(y1);
        p2.setX(x2); p2.setY(y2);
    }

    public Point getP1(){
        return p1;
    }
    public Point getP2(){
        return p2;
    }
}
