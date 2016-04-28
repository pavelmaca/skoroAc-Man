package PacMan;

import PacMan.okna.Hra;
import PacMan.okna.Nabidka;

import javax.swing.*;
import java.awt.*;

public class Grafika extends JFrame {
    private Nabidka nabidka;
    private Hra hra;

    public Grafika() {
        setTitle("Hra_Semestrální_Projekt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        return;
    }

    public void otevriNabidku() {
        nabidka = new Nabidka(this);
        add(nabidka);
        pack();
        this.setVisible(true);
    }

    public void otevriHru() {
        nabidka.setVisible(false);
        hra = new Hra();
        add(hra);
        pack();
        hra.requestFocus();
        this.setVisible(true);
    }
}
