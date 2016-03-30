import com.sun.prism.*;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class Level1 extends JPanel {
    private int zivoty;
    private PozorKolize PozorKolize;
    public int  POCET_CTVERCU = 150;
    public int POCET_KONTROLNICH_CTVERCU;
    private  Prekazky[] poleCtvercu;
    ArrayList<Prekazky> jidlo = new ArrayList<Prekazky>();
    public boolean viditelny = true;
    public int cas;
    private boolean vyhrals = false;
    public int score = 0;
    private Potvurka potvurka;
    private OkrajeP1 okrajeP1;
    private Potvurka2 potvurka2;
    private Potvurka3 potvurka3;
    private SuperJidlo superjidlo;
    public Level1(){
        pusteniLevel1();
    }
    public void pusteniLevel1(){
        this.poleCtvercu = new Prekazky[POCET_CTVERCU];
        this.PozorKolize = new PozorKolize(this);
        this.potvurka = new Potvurka(this);
        this.potvurka2 = new Potvurka2(this);
        this.okrajeP1 = new OkrajeP1(this);
        this.okrajeP1 = new OkrajeP1(this);
        this.okrajeP1 = new OkrajeP1(this);
        this.okrajeP1 = new OkrajeP1(this);
        this.okrajeP1 = new OkrajeP1(this);
        this.okrajeP1 = new OkrajeP1(this);
        this.potvurka3 = new Potvurka3(this);
        this.setPreferredSize(new Dimension(300, 500));
        this.setBackground(Color.RED);
        this.setFocusable(true);
        zivoty = 3;
        int y = 25;
        for(int i = 0;i < 15;i++){
            int x = 10;
            for(int k = 0;k < 10;k++) {
                x = x + 25;
                Prekazky p = new Prekazky(x, y);
                jidlo.add(p);
            }
            y = y + 30;
        }
        PoslouchaniCasovace publikum = new PoslouchaniCasovace();
        Timer casovac = new Timer(10, publikum);
        casovac.start();
        this.addKeyListener(PozorKolize);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pocetZivotu(g);
        vypisScore(g);
            for (int i = 0; i < POCET_CTVERCU; i++) {
                if (jidlo.get(i).isViditelny()) {
                    jidlo.get(i).vykresliSe(g);
                } else {
                    g.setColor(Color.RED);
                }
            }
        if(vyhrals == true){
            this.setBackground(Color.BLUE);
            vypisVyhru(g);
            return;
        }
        if(zivoty <= 0){
            vypsaniProhry(g);
            return;
        }
        if(viditelny == true) {
            vykresleniSuperJidla(g);
        }
        PozorKolize.vykresliSe(g);
        potvurka.kresleniPotvurky1(g);
        potvurka2.kresleniPotvurky2(g);
        if(score < 100) {
            potvurka3.vykresleniPotvurky3(g);
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
    public void vykresleniSuperJidla(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(133, 200, 10, 10);
    }
    private class PoslouchaniCasovace implements ActionListener{
        public int pomoc;
        @Override
        public void actionPerformed(ActionEvent e){
            if(vyhrals == true){
                return;
            }
            Rectangle okrajePozorKolize = PozorKolize.getOkraje();
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
                    Prekazky prek = jidlo.get(i);
                    Rectangle okrajePrekazky = jidlo.get(i).getOkraje();
                    if (okrajePozorKolize.intersects(okrajePrekazky)) {
                        if(jidlo.get(i).isViditelny() == true){
                            jidlo.get(i).skryt();
                            score++;
                            POCET_KONTROLNICH_CTVERCU++;
                        }
                    }
            }
            if(POCET_KONTROLNICH_CTVERCU == 75){
                vyhrals = true;
                score = score + zivoty * 30;
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
            if(okrajePozorKolize.intersects(potvurka.getOkrajePP1())){
                zivoty--;
                PozorKolize.x = 130;
                PozorKolize.y = 230;
                PozorKolize.smerX = 0;
                PozorKolize.smerY = 0;
            }
            if(okrajePozorKolize.intersects(potvurka2.getOkrajePP2())){
                zivoty--;
                PozorKolize.x = 130;
                PozorKolize.y = 230;
                PozorKolize.smerX = 0;
                PozorKolize.smerY = 0;
            }
            if(score < 100) {
                if (okrajePozorKolize.intersects(potvurka3.getOkrajePP3())) {
                    zivoty--;
                    PozorKolize.x = 130;
                    PozorKolize.y = 230;
                    PozorKolize.smerX = 0;
                    PozorKolize.smerY = 0;
                }
                potvurka3.pohyb();
            }
            PozorKolize.move();
            potvurka.polohaPotvurky();
            potvurka2.polohaPotvurky();
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
    public void skryt() {
        viditelny = false;
    }
    private Rectangle getOkraje(){
        return new Rectangle(130, 200, 10, 10);
    }

}