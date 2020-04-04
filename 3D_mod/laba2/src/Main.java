import org.opencv.core.Mat;


public class Main {

    public static Frame frame;

    public static void main(String[] args) {
        System.load("D:\\opencv\\build\\java\\x64\\opencv_java420.dll");
        Paint paint = new Paint();
        frame = new Frame();
        paint.Operations();
    }
}
