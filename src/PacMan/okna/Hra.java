package PacMan.okna;


import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
import PacMan.objekty.postavicky.*;
import PacMan.Engine;
import PacMan.urovne.Uroven;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        int sirka = 300;
        int vyska = 500;
        PoslouchaniCasovace publikum = new PoslouchaniCasovace();
        casovac = new Timer(10, publikum);
        casovac.start();
        this.setPreferredSize(new Dimension(sirka, vyska));
        setBackground(Color.RED);
        this.engine = new Engine(sirka, vyska);
        if (engine.getUroven() == 0) {
            this.setBackground(Color.RED);
        }
        if (engine.getUroven() == 1) {
            this.setBackground(Color.DARK_GRAY);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Smery novySmer = null;
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W :
                    case KeyEvent.VK_UP :
                        novySmer = Smery.nahoru; break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        novySmer = Smery.dolu; break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        novySmer = Smery.levo; break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        novySmer = Smery.pravo; break;
                }

                if(novySmer != null){
                    engine.zmenSmer(novySmer);
                }
            }
        });

        setFocusable(true);
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
    }

    private void vykresliPromene(Graphics g) {
        ArrayList<Svaca> jidlo = engine.getSvaca();
        for (int i = 0; i < jidlo.size(); i++) {
            jidlo.get(i).vykresliSe(g);
        }

        engine.getHrac().vykresliSe(g);

        ArrayList<Potvurkaa> potvurky = engine.getPotvurky();
        for (int i = 0; i < potvurky.size() ; i++) {
            potvurky.get(i).vykresliSe(g);
        }
        ArrayList<Prekazka> prekazkay = engine.getPrekazky();
        for (int i = 0; i < prekazkay.size(); i++) {
            prekazkay.get(i).vykresliSe(g);
        }
        /**
        ArrayList<MistaZmenySmeru> mistaZmenySmeru = engine.getMistaZmenySmeru();
        for (int i = 0; i < mistaZmenySmeru.size() ; i++) {
            mistaZmenySmeru.get(i).vykresliSe(g);
        }
         */

    }

    private void vypisScore(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawString(String.valueOf(engine.getScoreHrace()), 270, 15);
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
            if(engine.jeKonecHry()){
                System.out.println("Gamee over");
            }
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