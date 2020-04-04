import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.util.ArrayList;
import java.util.Scanner;

public class Paint {

    public static ArrayList<Point> point = new ArrayList<Point>();
    Scanner in = new Scanner(System.in);


   public Paint(){
       String flag;
       do {
           Point p = new Point();
           System.out.println("Do you want to add new Point?(y/n): ");
           flag=in.nextLine();
           if (flag.equals("n")) break;
           System.out.print("x: ");
           p.setX(in.nextInt());
           System.out.print("y: ");
           p.setY(in.nextInt());
           point.add(p);
           in.nextLine();
       } while (true);
   }

   public void Operations(){
       int flag=0;
       while (true) {
           System.out.println("Choose operation:");
           System.out.println("1-scale; 2-move; 3-terning; any other button -exit");
           flag = in.nextInt();
           if (flag == 1) scale();
           else if (flag == 2) move();
           else if (flag == 3) terning();
           else break;
           Main.frame.repaint();
       }
   }

   public void scale(){
       System.out.println("Enter sx:");
       float sx=in.nextFloat();
       System.out.println("Enter sy:");
       float sy=in.nextFloat();
       Mat scale = new Mat(3,3, CvType.CV_32FC1);
       float[] temp = new float[]{sx,0,0,0,sy,0,0,0,1};
       scale.put(0,0, temp);
       for (Point p : point) {
           Core.gemm(p.getPoint(), transform(scale), 1, new Mat(), 0, p.getPoint());
       }
   }


   public void move(){
        System.out.println("Enter dx:");
        int dx=in.nextInt();
        System.out.println("Enter dy:");
        int dy=in.nextInt();
        Mat move = new Mat(3,3,  CvType.CV_32FC1);
        float[] temp = new float[]{1,0,0,0,1,0,dx,dy,1};
        move.put(0,0, temp);
        for (Point p : point) {
            Core.gemm(p.getPoint(), move, 1, new Mat(), 0, p.getPoint());
            System.out.print(p.getPoint().dump());
        }
   }

   public void terning() {
       System.out.println("Enter angle:");
       double alpha = in.nextInt();
       alpha=alpha*Math.PI/180;
       Mat terning = new Mat(3, 3,  CvType.CV_32FC1);
       float[] temp = new float[]{(float)Math.cos(alpha),(float)Math.sin(alpha), 0, (float)-Math.sin(alpha),(float)Math.cos(alpha), 0, 0, 0, 1};
       terning.put(0, 0, temp);
       for (Point p : point) {
           Core.gemm(p.getPoint(), transform(terning), 1, new Mat(), 0, p.getPoint());
           System.out.print(p.getPoint().dump());
       }
   }


   public Mat transform(Mat operation){
       Mat buff = new Mat();
       Mat buff2 = new Mat();
       Mat mat = new Mat(3,3, CvType.CV_32FC1);
       float[] temp = new float[]{1,0,0,0,1,0,-point.get(0).getX(),-point.get(0).getY(),1};
       mat.put(0,0,temp);
       Core.gemm(mat,operation,1,new Mat(),0, buff);
       temp = new float[]{1,0,0,0,1,0,point.get(0).getX(),point.get(0).getY(),1};
       mat.put(0,0,temp);
       Core.gemm(buff, mat,1,new Mat(),0, buff2);
       return buff;
   }
}
