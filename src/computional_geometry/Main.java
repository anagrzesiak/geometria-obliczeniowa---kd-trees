package computional_geometry;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Main{

    public static void main(String[] args) throws IOException{
        int numpoints = 10;
        KDTree kdt = new KDTree(numpoints);
        double[] x = new double[2];
        Random r = new Random();

        for(int i=0; i<numpoints; i++){
            x[0]=Math.abs(r.nextDouble()*100);
            x[1]=Math.abs(r.nextDouble()*100);
            kdt.add(x);
        }

        System.out.println("Enter the x coordinate of the point: ");
        Scanner scan = new Scanner(System.in);
        double sx = scan.nextDouble();
        System.out.println("Enter the y coordinate of the point: ");
        double sy = scan.nextDouble();
        double[] s = { sx, sy };
        KDNode kdn = kdt.find_nearest(s);
        System.out.println("The nearest neighbor of your point is: ");
        System.out.println("(" + kdn.x[0] + " , " + kdn.x[1] + ")");
    }
}