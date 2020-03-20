package com.company;

import java.util.Random;

public class FindNearestUser {
     public static double[] Finally(){
        int numpoints = 10;
        KDTree kdt = new KDTree(numpoints);
        double[] x = new double[2];
        Random r = new Random();
        for (int i = 0; i < numpoints; i++) {
            x[0] = Math.abs(r.nextDouble() * 10);
            x[1] = Math.abs(r.nextDouble() * 10);
            kdt.add(x);
        }

        double sx=btnSubmitAction.getx();
        double sy=btnSubmitAction.gety();
        double[] s = {sx, sy};
        KDNode kdn = kdt.find_nearest(s);

        return kdn.x;
    }
    public static final double[] Naprawde(){
         return Finally();
    }
}
