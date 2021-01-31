package com.company;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Attack implements Runnable {

    private Thread t;
    private String klasa;
    private int[] hitSynchro;
    private JLabel label;
    int currentHits;
    int killedMobs;
    String filepath;
    ScheduledExecutorService scheduledExecutorService;



    public Attack(String klasa, JLabel label) {
        this.klasa = klasa;
        this.label = label;
        setHitSynchro();
        this.filepath = "audio/" + klasa + ".wav";
        this.start();
    }


    @Override
    public void run() {

        killedMobs = Integer.parseInt(label.getText());
        scheduledExecutorService = Executors.newScheduledThreadPool(1); //dla efektu zabijania stworow w czasie rzeczywistym do dźwięku


        if (klasa.equals("Ninja")) {
            System.out.println("Zabite moby " + this.klasa + " " + killedMobs);

            label.setText(String.valueOf(killedMobs + 4));
            currentHits++;

            if (currentHits < 7)
                scheduledExecutorService.schedule(this, getHitSynchro()[currentHits - 1], TimeUnit.MILLISECONDS);
            else {
                currentHits = 0;
                scheduledExecutorService.shutdown();
            }

        } else {

            System.out.println("Zabite moby " + this.klasa + " " + killedMobs);

            label.setText(String.valueOf(killedMobs + 7));
            currentHits++;

            if (currentHits < 4)
                scheduledExecutorService.schedule(this, getHitSynchro()[currentHits - 1], TimeUnit.MILLISECONDS);
            else {
                currentHits = 0;
                scheduledExecutorService.shutdown();
            }

        }

    }


    public void start() {
        if(t==null){
        t = new Thread(this);
        t.start();
        }
    }

    public void setHitSynchro() {  //odstępy między hitami w audio

        switch (this.klasa) {

            case "Wojownik":
                hitSynchro = new int[]{500, 850, 950, 800};//{350,1150,2100,2900};
                break;

            case "Sura":
                hitSynchro = new int[]{300, 600, 600, 550};//{300, 900, 1500, 2050};
                break;

            case "Ninja":
                hitSynchro = new int[]{300, 300, 300, 200, 180, 370, 450};//{300,600,900,1100,1280,1650,2100};
                break;

            case "Szaman":
                hitSynchro = new int[]{610, 350, 390, 750};//{610,960,1350,2000};
                break;

        }

    }

    public int[] getHitSynchro() {
        return this.hitSynchro;
    }

    public String getFilepath() {
        return this.filepath;
    }

}
