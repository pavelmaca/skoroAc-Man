package PacMan.okna;


import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.postavicky.*;
import PacMan.Engine;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Author: Štěpán Mudra.
 */
public class Hra extends JPanel {
    private Engine engine;
    private Timer casovac;

    public Hra() {
        PoslouchaniCasovace publikum = new PoslouchaniCasovace();
        casovac = new Timer(10, publikum);
        casovac.start();

        this.setPreferredSize(new Dimension(300, 500));

        this.engine = new Engine();
        /* TODO změna barvy pozadí při vyším levelu
        if (engine.getUroven() == 1) {
            this.setBackground(Color.RED);
        }
        if (engine.getUroven() == 2) {
            this.setBackground(Color.DARK_GRAY);
        }*/

        // TODO doplnit key listener pro hrače
       // this.addKeyListener(Hrac);

        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        pocetZivotu(g);
        vypisScore(g);
        g.drawString("Štěpán ", 5, 15);
        if (engine.hracVyhral()) {
            vypisVyhru(g);
            return;
        }
        vykresliPromene(g);
        if (engine.getZivoty() <= 0) {
            vypsaniProhry(g);
            return;
        }
        /**
         if (uroven == 1) {
         potvurky.kresleniPotvurky1(g);
         potvurka2.kresleniPotvurky2(g);
         if (score < 100) {
         potvurka3.vykresleniPotvurky3(g);
         }
         if (viditelny) {
         superjidlo.vykresleniSuperJidla(g);
         }
         }
         */
    }

    private void vykresliPromene(Graphics g) {
        ArrayList<Svaca> jidlo = engine.getJidlo();
        for (int i = 0; i < jidlo.size(); i++) {
            jidlo.get(i).vykresliSe(g);
        }

        engine.getHrac().vykresliSe(g);

        Potvurkaa[] potvurky = engine.getPotvurky();
        for (int i = 0; i < potvurky.length ; i++) {
            potvurky[i].vykresliSe(g);
        }
    }

    private void vypisScore(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawString(String.valueOf(engine.getScore()), 270, 15);
    }

    private void vypisVyhru(Graphics g) {
        this.setBackground(Color.BLUE);
        g.setColor(Color.ORANGE);
        g.drawString("V Y H R Á L / A  J S I .", 90, 270);
    }

    private void vypsaniProhry(Graphics g) {
        g.setColor(Color.orange);
        g.drawString("P A R D O N ,  A L E  G A M E  O V E R .", 70, 270);
    }

    private void pocetZivotu(Graphics g) {
        g.setColor(Color.YELLOW);
        g.setFont(Font.getFont(Font.MONOSPACED));
        g.drawString("Z I V O T Y :     " + engine.getZivoty(), (getSIRKA_PANELU() / 2) - 45, 15);
    }

    private class PoslouchaniCasovace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.skok();
            /**
             Rectangle okrajePozorKolize = Hrac.getOkraje();
             Rectangle superJidlo = getOkraje();
             if (okrajePozorKolize.intersects(superJidlo)) {
             if (isViditelny()) {
             score *= 2;
             skryt();
             }
             }
             for (int i = 0; i < engine.jidlo.size(); i++) {
             Rectangle okrajeJidla = engine.jidlo.get(i).getOkraje();
             if (Hrac.getOkraje().intersects(okrajeJidla)) {
             score++;
             engine.jidlo.remove(i);
             }
             }
             if (engine.jidlo.size() == 0) {
             score = score + zivoty * 30;
             uroven++;
             if (uroven == 3) {
             Hrac.smerX = 0;
             Hrac.smerY = 0;
             vyhrals = true;
             casovac.stop();
             } else {
             pusteniLevel1(uroven, score, zivoty);
             }
             }
             if (uroven == 1) {
             if (okrajePozorKolize.intersects(potvurky.getOkrajePP1())) {
             snedeniHracePotvurkou();
             }
             if (okrajePozorKolize.intersects(potvurka2.getOkrajePP2())) {
             snedeniHracePotvurkou();
             }
             if (score < 100) {
             if (okrajePozorKolize.intersects(potvurka3.getOkrajePP3())) {
             snedeniHracePotvurkou();
             }
             potvurka3.pohyb();
             }
             potvurky.polohaPotvurky();
             potvurka2.polohaPotvurky();
             }
             if (uroven == 2) {
             //potvurkaa.pohybPotvurky();
             }
             Hrac.move();
             */
            repaint();
        }
    }


    public int getSIRKA_PANELU() {
        return this.getWidth();
    }

    public int getVYSKA_PANELU() {

        return this.getHeight();
    }

}