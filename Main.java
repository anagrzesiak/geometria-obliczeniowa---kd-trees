package com.company;
import javax.swing.*;
import java.io.IOException;
import java.lang.String;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

    public class Main{
        public Main g;
        private JFrame frame;
        private JButton btnREADY;
        private JLabel lbResultX;
        private JLabel lbResultY;
        private JLabel lbResultNX;
        private JLabel lbResultNY;
        private JTextField tfInputX;
        private JTextField tfInputY;
        private btnSubmitAction btn1;
        JPanel panel = new JPanel(null);

        // Constructor
        public Main() {
             btn1 = new btnSubmitAction(g);
            // Create the textfield to read input
            tfInputX = new JTextField(30);
            tfInputX.setBounds(10, 10, 100, 20);

            // Create the textfield to read input
            tfInputY = new JTextField(30);
            tfInputY.setBounds(10, 40, 100, 20);

            // Create the button to submit the value
            btnREADY = new JButton("READY!");
            btnREADY.addActionListener(new btnSubmitAction(this));
            btnREADY.setBounds(150, 25, 100, 20);
            btnREADY.setBackground(Color.magenta);

            // Create the label to display the result
            lbResultX = new JLabel("Enter x and y...");
            lbResultX.setBounds(10, 70, 200, 20);
            lbResultY = new JLabel("...And then press READY");
            lbResultY.setBounds(10, 90, 200, 20);
            lbResultNX = new JLabel("");
            lbResultNX.setBounds(220, 70, 200, 20);
            lbResultNY = new JLabel("");
            lbResultNY.setBounds(220, 90, 200, 20);
            // JPanel panel = new JPanel(null);
            panel.add(btnREADY);
            panel.add(lbResultX);
            panel.add(lbResultY);
            panel.add(lbResultNX);
            panel.add(lbResultNY);
            panel.add(tfInputX);
            panel.add(tfInputY);
            panel.setBackground(Color.white);
            panel.setPreferredSize(new Dimension(530, 530));


            frame = new JFrame("NEAREST POINT SEARCHER");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.white);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }

        public String getTextFieldInputX() {
            return tfInputX.getText();
        }

        public String getTextFieldInputY() {
            return tfInputY.getText();
        }

        public void setTextLabelResultX(String s) {
            lbResultX.setText(s);
        }

        public void setTextLabelResultY(String s1) {
            lbResultY.setText(s1);
        }

        public void setTextLabelResultNX(String s) {
            lbResultNX.setText(s);
        }

        public void setTextLabelResultNY(String s1) {
            lbResultNY.setText(s1);
        }

        public PlotComponent createComponent(double x, double y) {
            PlotComponent plotComponent = new PlotComponent(x, y);
            plotComponent.setBounds(10, 110, 400, 400);
            plotComponent.setVisible(true);
            panel.add(plotComponent);
            plotComponent.revalidate();
            plotComponent.repaint();
            return plotComponent;
        }

        public static void main(String[] args) throws IOException {
                SwingUtilities.invokeLater(Main::new);
            }
        }
