import jidlo.Svaca;
import urovne.Uroven;
import urovne.Uroven1;
import urovne.Uroven2;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class oknoHry extends JPanel {
    private int zivoty = 3;
    private Hrac Hrac;
    public int  POCET_CTVERCU = 150;
    public int POCET_KONTROLNICH_CTVERCU = 85;
    private  Svaca[] poleCtvercu;
    public boolean viditelny = true;
    public int cas;
    private boolean vyhrals = false;
    public int score = 0;
    private Potvurka potvurka;
    private OkrajeP1 okrajeP1;
    private Potvurka2 potvurka2;
    private Potvurka3 potvurka3;
    private Uroven aktualniUroven;
    private SuperJidlo superjidlo;
    public int uroven = 1;
    public Spusteni program;
    public oknoHry(Spusteni hrac){
        pusteniLevel1(uroven, POCET_KONTROLNICH_CTVERCU, vyhrals, score, zivoty);
    }
    public void pusteniLevel1(int uroven,int POCET_KONTROLNICH_CTVERCU,boolean vyhrals, int score, int zivoty){
        this.poleCtvercu = new Svaca[POCET_CTVERCU];
        this.Hrac = new Hrac(this);
        this.potvurka = new Potvurka(this);
        this.potvurka2 = new Potvurka2(this);
        this.potvurka3 = new Potvurka3(this);
        this.superjidlo = new SuperJidlo(this);
        this.setPreferredSize(new Dimension(300, 500));
        if(uroven == 1) {
            this.setBackground(Color.RED);
            this.aktualniUroven = new Uroven1();
        }
        if(uroven == 2){
            this.setBackground(Color.DARK_GRAY);
            this.aktualniUroven = new Uroven2();
        }
        this.setFocusable(true);
        int y = 25;
        PoslouchaniCasovace publikum = new PoslouchaniCasovace();
        Timer casovac = new Timer(10, publikum);
        casovac.start();
        this.addKeyListener(Hrac);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pocetZivotu(g);
        vypisScore(g);
        if(vyhrals == true){
            this.setBackground(Color.BLUE);
            vypisVyhru(g);
            uroven++;
            aktualniUroven.vykresliUroven(g);
        }
        aktualniUroven.vykresliUroven(g);
        if(zivoty <= 0){
            vypsaniProhry(g);
            return;
        }
        Hrac.vykresliSe(g);
            //aktualniUroven.vykresliPrekazky(g);
            if(viditelny == true) {
                superjidlo.vykresleniSuperJidla(g);
            }
        if(uroven == 1) {
            potvurka.kresleniPotvurky1(g);
            potvurka2.kresleniPotvurky2(g);
            if (score < 100) {
                potvurka3.vykresleniPotvurky3(g);
            }
        }
    }
    public void vypisScore(Graphics g){
        g.setColor(Color.YELLOW);
        g.getFontMetrics();
        g.drawString(String.valueOf(score), 270 , 15);
    }
    public void vypisVyhru(Graphics g){
        g.setColor(Color.ORANGE);
        g.drawString("V Y H R Á L / A  J S I .", 90, 270);
    }
    public void vypsaniProhry(Graphics g){
        g.setColor(Color.orange);
        g.drawString("P A R D O N ,  A L E  G A M E  O V E R .", 70, 270);
    }
    public void pocetZivotu(Graphics g){
        g.setColor(Color.YELLOW);
        g.setFont(Font.getFont(Font.MONOSPACED));
        g.drawString("Z I V O T Y :     "+zivoty, (getSIRKA_PANELU()/2)-45,15);
    }
    private class PoslouchaniCasovace implements ActionListener{
        public int pomoc;
        @Override
        public void actionPerformed(ActionEvent e){
            if(vyhrals == true){
                return;
            }
            Rectangle okrajePozorKolize = Hrac.getOkraje();
            //Rectangle OkrajePN = pre.getOkraje1();
            Rectangle superJidlo = getOkraje();
            if (okrajePozorKolize.intersects(superJidlo)){
                if(isViditelny() == true) {
                    score = score * 2;
                    skryt();
                }
            }
            cas = pomoc/100;
            int i = 0;
            for(; i < POCET_CTVERCU;i++) {
                Rectangle okrajeJidla = aktualniUroven.jidlo.get(i).getOkraje();
                    for (int j = 0; j < aktualniUroven.pocetPrekazek(); j++) {
                        Rectangle prekazka = aktualniUroven.getOkraje(j);
                        if (prekazka.intersects(okrajeJidla)) {
                            if(aktualniUroven.jidlo.get(i).isViditelny()) {
                                POCET_KONTROLNICH_CTVERCU--;
                            }
                            aktualniUroven.jidlo.get(i).skryt();
                            //System.out.println(POCET_KONTROLNICH_CTVERCU);
                        }
                    }
                    Svaca prek = aktualniUroven.jidlo.get(i);
                    Rectangle okrajePrekazky = aktualniUroven.jidlo.get(i).getOkraje();
                    if (okrajePozorKolize.intersects(okrajePrekazky)) {
                        if(aktualniUroven.jidlo.get(i).isViditelny() == true){
                            aktualniUroven.jidlo.get(i).skryt();
                            score++;
                            POCET_KONTROLNICH_CTVERCU--;
                        }
                    }
            }
            if(POCET_KONTROLNICH_CTVERCU == 0){
                vyhrals = true;
                score = score + zivoty * 30;
                uroven++;
                POCET_KONTROLNICH_CTVERCU = 150;
                vyhrals = false;
                pusteniLevel1(uroven, POCET_KONTROLNICH_CTVERCU, vyhrals, score, zivoty);
            }
            /*
            Rectangle OP1 = prekazky.getOkraje1();
            if(potvurka.getOkrajePP1().intersects(OP1)){
                potvurka.generovani();
            }
            Rectangle OP2 = prekazky.getOkraje1();
            if(potvurka.getOkrajePP1().intersects(OP2)){
                potvurka.generovani();
            }
            Rectangle OP3 = prekazky.getOkraje1();
            if(potvurka.getOkrajePP1().intersects(OP3)){
                potvurka.generovani();
            }
            Rectangle OP4 = prekazky.getOkraje1();
            if(potvurka.getOkrajePP1().intersects(OP4)){
                potvurka.generovani();
            }
            Rectangle OP5 = prekazky.getOkraje1();
            if(potvurka.getOkrajePP1().intersects(OP1)){
                potvurka.generovani();
            }
            Rectangle OP6 = prekazky.getOkraje1();
            if(potvurka.getOkrajePP1().intersects(OP6)){
                potvurka.generovani();
            }
            */
            if(uroven == 1) {
                if (okrajePozorKolize.intersects(potvurka.getOkrajePP1())) {
                    zivoty--;
                    Hrac.x = 130;
                    Hrac.y = 230;
                    Hrac.smerX = 0;
                    Hrac.smerY = 0;
                }
                if (okrajePozorKolize.intersects(potvurka2.getOkrajePP2())) {
                    zivoty--;
                    Hrac.x = 130;
                    Hrac.y = 230;
                    Hrac.smerX = 0;
                    Hrac.smerY = 0;
                }
                if (score < 100) {
                    if (okrajePozorKolize.intersects(potvurka3.getOkrajePP3())) {
                        zivoty--;
                        Hrac.x = 130;
                        Hrac.y = 230;
                        Hrac.smerX = 0;
                        Hrac.smerY = 0;
                    }
                    potvurka3.pohyb();
                }
                potvurka.polohaPotvurky();
                potvurka2.polohaPotvurky();
            }
            Hrac.move();
            repaint();
        }
    }
    public boolean isViditelny(){
        return viditelny;
    }
    public int getSIRKA_PANELU() {
        return this.getWidth();
    }
    public int getVYSKA_PANELU(){

        return this.getHeight();
    }
    public int getUroven(){return this.uroven;}
    public void skryt() {
        viditelny = false;
    }
    private Rectangle getOkraje(){
        return new Rectangle(130, 200, 10, 10);
    }
    public Uroven getAktualniUroven(){
        return aktualniUroven;
    }

}