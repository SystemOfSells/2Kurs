import java.awt.*;

public class Main {
    public static Frame frame;

    public static void main(String[] args) {
        System.load("D:\\opencv\\build\\java\\x64\\opencv_java420.dll");
        Operations operations = new Operations();
        Line line = operations.getLine();
        if(Math.abs(line.getP2().getX()-line.getP1().getX())>
        Math.abs(line.getP2().getY()-line.getP1().getY()))
        operations.BresenhamX();
        else operations.BresenhamY();
        frame = new Frame(line);
    }
}
