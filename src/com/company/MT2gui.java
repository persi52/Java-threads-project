package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MT2gui extends JPanel {

    public JButton wojownik;
    private JPanel panel1;
    private JButton Sura;
    private JButton Ninja;
    private JButton Szaman;
    public JLabel WojMobs;
    private JLabel SuraMobs;
    private JLabel NinjaMobs;
    private JLabel ShamanMobs;
    private JLabel pictureLabel;
    private JLabel ShamanPicture;
    private JLabel NinjaPicture;
    private JLabel SuraPicture;
    private JLabel WojPicture;


    public JPanel getPanel() {
        return this.panel1;
    }

    public MT2gui() throws IOException {

        BufferedImage myPicture = ImageIO.read(new File("pictures/metinLogo.jpg"));
        pictureLabel.setIcon(new ImageIcon(myPicture));
        myPicture = ImageIO.read(new File("pictures/WojPicture.jpg"));
        WojPicture.setIcon(new ImageIcon(myPicture));
        myPicture = ImageIO.read(new File("pictures/SuraPicture.jpg"));
        SuraPicture.setIcon(new ImageIcon(myPicture));
        myPicture = ImageIO.read(new File("pictures/NinjaPicture.jpg"));
        NinjaPicture.setIcon(new ImageIcon(myPicture));
        myPicture = ImageIO.read(new File("pictures/ShamanPicture.jpg"));
        ShamanPicture.setIcon(new ImageIcon(myPicture));








        wojownik.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Attack attackWarrior = new Attack("Wojownik", WojMobs); //tworze nowy za kazdym razem bo synchronizacja sie sypała
                Muzyka.grajPan(new File(attackWarrior.getFilepath()));
               // attackWarrior.start();


            }
        });

        Sura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Attack attackSura = new Attack("Sura", SuraMobs);
                Muzyka.grajPan(new File(attackSura.getFilepath()));
               // attackSura.start();


            }
        });

        Ninja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Attack attackNinja = new Attack("Ninja", NinjaMobs);
                Muzyka.grajPan(new File(attackNinja.getFilepath()));
               // attackNinja.start();


            }
        });

        Szaman.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Attack attackShaman = new Attack("Szaman", ShamanMobs);
                Muzyka.grajPan(new File(attackShaman.getFilepath()));
               // attackShaman.start();


            }
        });
    }

}
