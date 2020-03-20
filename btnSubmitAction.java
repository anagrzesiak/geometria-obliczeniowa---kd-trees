package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnSubmitAction implements ActionListener {
    FindNearestUser fnu=new FindNearestUser();
    public static double[]tb= FindNearestUser.Naprawde();
    public static double nearestx=tb[0];
    public static double nearesty=tb[1];


    public static Main g;

    public btnSubmitAction(Main g){
        this.g=g;
    }

    public static double castValue(String s){
        return Double.parseDouble(s);
    }

    private static double x;

    public static double getx(){
        return x;
    }

    private static double y;

    public static double gety(){
        return y;
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
       /* FindNearestUser fnu=new FindNearestUser();
        double[] tab=fnu.Finally();
        double nearestx=tab[0];
        double nearesty=tab[1];*/

        String s = g.getTextFieldInputX();
        String s_new = String.valueOf(castValue(s));
        String s1=g.getTextFieldInputY();
        String s1_new = String.valueOf(castValue(s1));
        String x_new=String.valueOf(nearestx);
        String y_new=String.valueOf(nearesty);
        g.setTextLabelResultX("YOUR X:    "+s_new);
        g.setTextLabelResultY("            Y:    " + s1_new);
        g.setTextLabelResultNX("NEAREST X:    "+x_new);
        g.setTextLabelResultNY("                   Y:    " + y_new);
        x=castValue(s);
        y=castValue(s1);
        g.createComponent(x, y);
    }
}

