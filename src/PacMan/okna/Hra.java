package PacMan.okna;


import PacMan.objekty.postavicky.Potvurka;
import PacMan.objekty.postavicky.Potvurka2;
import PacMan.objekty.postavicky.Potvurka3;
import PacMan.Engine;
import PacMan.urovne.Uroven1;
import PacMan.urovne.Uroven2;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.jidlo.SuperJidlo;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Author: Štěpán Mudra.
 */
public class Hra extends JPanel {
    private int zivoty = 3;
    private Hrac Hrac;
    private boolean viditelny = true;
    private boolean vyhrals = false;
    public int score = 0;
    private Potvurka potvurka;
    private Potvurka2 potvurka2;
    private Potvurka3 potvurka3;
    private Engine aktualniUroven;
    private SuperJidlo superjidlo;
    private int uroven;

    public Hra() {
        uroven = 1;
        PoslouchaniCasovace publikum = new PoslouchaniCasovace();
        Timer casovac = new Timer(10, publikum);
        casovac.start();
        pusteniLevel1(uroven, score, zivoty);
    }

    private void pusteniLevel1(int uroven, int score, int zivoty) {
        this.Hrac = new Hrac(this);
        this.potvurka = new Potvurka();
        this.potvurka2 = new Potvurka2();
        this.potvurka3 = new Potvurka3();
        this.superjidlo = new SuperJidlo(this);
        this.setPreferredSize(new Dimension(300, 500));
        if (uroven == 1) {
            this.setBackground(Color.RED);
            this.aktualniUroven = new Uroven1();
        }
        this.addKeyListener(Hrac);
        if (uroven == 2) {
            this.setBackground(Color.DARK_GRAY);
            this.aktualniUroven = new Uroven2();
        }
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        pocetZivotu(g);
        vypisScore(g);
        g.drawString("Štěpán ", 5, 15);
        if (vyhrals) {
            this.setBackground(Color.BLUE);
            vypisVyhru(g);
            return;
        }
        aktualniUroven.vykresliUroven(g);
        if (zivoty <= 0) {
            vypsaniProhry(g);
            return;
        }
        Hrac.vykresliSe(g);
        if (uroven == 1) {
            potvurka.kresleniPotvurky1(g);
            potvurka2.kresleniPotvurky2(g);
            if (score < 100) {
                potvurka3.vykresleniPotvurky3(g);
            }
            if (viditelny) {
                superjidlo.vykresleniSuperJidla(g);
            }
        }
    }

    private void vypisScore(Graphics g) {
        g.setColor(Color.YELLOW);
        g.getFontMetrics();
        g.drawString(String.valueOf(score), 270, 15);
    }

    private void vypisVyhru(Graphics g) {
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
        g.drawString("Z I V O T Y :     " + zivoty, (getSIRKA_PANELU() / 2) - 45, 15);
    }

    private class PoslouchaniCasovace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vyhrals) {
                return;
            }
            Rectangle okrajePozorKolize = Hrac.getOkraje();
            Rectangle superJidlo = getOkraje();
            if (okrajePozorKolize.intersects(superJidlo)) {
                if (isViditelny()) {
                    score *= 2;
                    skryt();
                }
            }
            for (int i = 0; i < aktualniUroven.jidlo.size(); i++) {
                Rectangle okrajeJidla = aktualniUroven.jidlo.get(i).getOkraje();
                if (Hrac.getOkraje().intersects(okrajeJidla)) {
                    score++;
                    aktualniUroven.jidlo.remove(i);
                }
            }
            if (aktualniUroven.jidlo.size() == 0) {
                score = score + zivoty * 30;
                uroven++;
                if (uroven == 3) {
                    Hrac.smerX = 0;
                    Hrac.smerY = 0;
                    vyhrals = true;
                } else {
                    pusteniLevel1(uroven, score, zivoty);
                }
            }
            if (uroven == 1) {
                if (okrajePozorKolize.intersects(potvurka.getOkrajePP1())) {
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
                potvurka.polohaPotvurky();
                potvurka2.polohaPotvurky();
            }
            if (uroven == 2) {
                //potvurkaa.pohybPotvurky();
            }
            Hrac.move();
            repaint();
        }
    }

    private void snedeniHracePotvurkou() {
        zivoty--;
        Hrac.x = 130;
        Hrac.y = 230;
        Hrac.smerX = 0;
        Hrac.smerY = 0;
    }

    public boolean isViditelny() {
        return viditelny;
    }

    public int getSIRKA_PANELU() {
        return this.getWidth();
    }

    public int getVYSKA_PANELU() {

        return this.getHeight();
    }

    public void skryt() {
        viditelny = false;
    }

    private Rectangle getOkraje() {
        return new Rectangle(130, 200, 10, 10);
    }

    public Engine getAktualniUroven() {
        return aktualniUroven;
    }

}