package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        JFrame frame = new JFrame("Metin2 simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MT2gui().getPanel());
        frame.setPreferredSize(new Dimension(600, 340));
        frame.pack();
        frame.setVisible(true);

        Muzyka.grajPan(new File("audio/enter_the_east.wav"));

    }
}