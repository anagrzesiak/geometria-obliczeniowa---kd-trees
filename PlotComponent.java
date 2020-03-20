package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class PlotComponent extends JComponent {

    FindNearestUser fnu=new FindNearestUser();
    double Nearestx=btnSubmitAction.nearestx;
    double Nearesty=btnSubmitAction.nearesty;

    private final ArrayList<Point2D> points = new ArrayList<>();
    private static final int X_MARKS = 10, X_START = 0, X_INCREMENT = 1,Y_MARKS = 10,
            Y_START = 0, Y_INCREMENT = 1, POINT_SIZE = 2;

    public PlotComponent(double x, double y) {
        addPoint(new Point2D.Double(x*1000, y*1000));
        addPoint(new Point2D.Double(Nearestx*1000, Nearesty*1000));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double x_start_point = xStart();
        double y_start_point = yStart();
        double y_end_point = yEnd();
        double width = xEnd() - xStart();
        double height = yEnd() - yStart();

        double div_x= width/X_MARKS;
        double div_y= height/Y_MARKS;

        double xOrigin = x_start_point - div_x *(X_START/X_INCREMENT);
        double yOrigin = y_end_point  + div_y *(Y_START/Y_INCREMENT);

        Rectangle2D shape=new Rectangle2D.Double(x_start_point,y_start_point,width,height);
        g2.setColor(Color.WHITE);
        g2.fill(shape);
        g2.setColor(Color.magenta);
        g2.draw(shape);

        int xMarkValue= X_START;
        for(int i=0; i <= X_MARKS;i++){
            Shape xMark = new Line2D.Double(x_start_point+div_x*i, y_end_point,
                    x_start_point+ div_x*i,y_end_point*1.02);
            g2.draw(xMark);
            g2.drawString(Integer.toString(xMarkValue), (float) (x_start_point+div_x*i-3.5),
                    (float)(y_end_point*1.07));
            xMarkValue+=X_INCREMENT;
        }

        int yMarkValue=Y_START;
        for(int i=0; i<= Y_MARKS;i++){

            Shape yMark = new Line2D.Double(x_start_point,y_end_point-div_y*i,
                    x_start_point*0.85,y_end_point-div_y*i);
            g2.draw(yMark);
            g2.drawString(Integer.toString(yMarkValue),7,(float) (y_end_point-div_y*i));
            yMarkValue+=Y_INCREMENT;
        }

        g2.translate(xOrigin, yOrigin);
        g2.setColor(Color.blue);

        for( Point2D p : points){
            Shape point =  new Ellipse2D.Double((p.getX()/div_x), (- p.getY()/div_y), POINT_SIZE, POINT_SIZE);
            g2.draw(point);
        }

    }

    private double xStart() {
        return (int)(getWidth()*0.09);
    }
    private double xEnd() {
        return (int)(getWidth()*0.9);
    }

    private double yStart() {
        return (int)(getHeight()*0.09);
    }
    private double yEnd() {
        return (int)(getHeight()*0.9);
    }

    public void addPoint(Point2D p) {
        points.add(p);
    }
}