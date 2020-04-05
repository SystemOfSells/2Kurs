import java.util.ArrayList;
import java.util.Scanner;

public class Operations {

    private Line line;
    public static ArrayList<Point> points = new ArrayList<Point>();
    Scanner in = new Scanner(System.in);

    public int round(int number){
        int residue = number%50;
        if(Math.abs(residue)>25) {
            if (number > 0)
                return number - residue + 50;
            else return number - residue - 50;
        }else return number - residue;
    }

    public int input(String s){
        System.out.println("Enter "+s+": ");
        return in.nextInt();
    }

    public Line getLine(){
        System.out.println("Enter line coordinates: ");
        return line = new Line(input("x1"), input("y1"), input("x2"), input("y2"));
    }

    public void BresenhamX(){
        int x = 0;
        while (Math.abs(x)<=round(Math.abs(line.getP1().getX()-line.getP2().getX()))){
            int y = Math.abs(line.getP1().getY() - line.getP2().getY()) * x /
                    Math.abs(line.getP1().getX() - line.getP2().getX());
            if(line.getP2().getX()<line.getP1().getX())
                y*=-1;
            if(line.getP2().getY()<line.getP1().getY())
                y*=-1;
            Point point = new Point(round(x+line.getP1().getX()), round(y+line.getP1().getY()));
            points.add(point);
            System.out.println(x+" "+y);
            if(line.getP2().getX()<line.getP1().getX())
                x-=50;
            else x+=50;
        }
    }

    public void BresenhamY(){
        int y = 0;
        while (Math.abs(y)<=round(Math.abs(line.getP1().getY()-line.getP2().getY()))){
            int x = Math.abs(line.getP1().getX() - line.getP2().getX()) * y /
                    Math.abs(line.getP1().getY() - line.getP2().getY());
            if(line.getP2().getY()<line.getP1().getY())
                x*=-1;
            if(line.getP2().getX()<line.getP1().getX())
                x*=-1;
            Point point = new Point(round(x+line.getP1().getX()), round(y+line.getP1().getY()));
            points.add(point);
            System.out.println(x+" "+y);
            if(line.getP2().getY()<line.getP1().getY())
                y-=50;
            else y+=50;
        }
    }
}
