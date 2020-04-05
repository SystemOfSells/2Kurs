import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Point {
    private Mat point = new Mat(1,3, CvType.CV_32FC1);

    public Point(){
        point.put(0,2, 1);
    }
    public Point(int x, int y){
        point.put(0,0, x);
        point.put(0,1, y);
        point.put(0,2, 1);
    }

    public Mat getPoint(){
        return point;
    }

    public void setX(int x){
        point.put(0,0, x);
    }

    public void setY(int y){
        point.put(0,1, y);
    }

    public int getX(){
        return (int)point.get(0,0)[0];
    }
    public int getY(){
        return (int)point.get(0,1)[0];
    }
}
