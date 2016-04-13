package hra;

import jidlo.Svaca;
import postavicky.Potvurka;
import postavicky.Potvurka2;
import postavicky.Potvurka3;
import urovne.Uroven;
import urovne.Uroven1;
import urovne.Uroven2;
import postavicky.Hrac;
import jidlo.SuperJidlo;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Author: Koule7b.
 */
public class oknoHry extends JPanel {
    private int zivoty = 3;
    private Hrac Hrac;
    private int  POCET_CTVERCU = 150;
    private int POCET_KONTROLNICH_CTVERCU = 150;
    private  Svaca[] poleCtvercu;
    private boolean viditelny = true;
    private int cas;
    private boolean vyhrals = false;
    public int score = 0;
    private Potvurka potvurka;
    private Potvurka2 potvurka2;
    private Potvurka3 potvurka3;
    private Uroven aktualniUroven;
    private SuperJidlo superjidlo;
    private int uroven = 2;
    private double fps;
    private double lastTime;
    int tickindex=0;
    int ticksum=0;
    int ticklist[] = new int[100];
    public Spusteni program;
    //public PocitadloFPS pocitadloFPS;
    public oknoHry(Spusteni hrac){
        PoslouchaniCasovace publikum = new PoslouchaniCasovace();
        Timer casovac = new Timer(10, publikum);
        casovac.start();
        pusteniLevel1(uroven, POCET_KONTROLNICH_CTVERCU, vyhrals, score, zivoty);
    }
    private void pusteniLevel1(int uroven,int POCET_KONTROLNICH_CTVERCU,boolean vyhrals, int score, int zivoty){
        this.poleCtvercu = new Svaca[POCET_CTVERCU];
        this.Hrac = new Hrac(this);
        this.potvurka = new Potvurka();
        this.potvurka2 = new Potvurka2();
        this.potvurka3 = new Potvurka3();
        this.superjidlo = new SuperJidlo(this);
        //this.pocitadloFPS = new PocitadloFPS();
        this.setPreferredSize(new Dimension(300, 500));
        if(uroven == 1) {
            this.setBackground(Color.RED);
            this.aktualniUroven = new Uroven1();
        }
        this.addKeyListener(Hrac);
        if(uroven == 2){
            this.setBackground(Color.DARK_GRAY);
            this.aktualniUroven = new Uroven2();
        }
        this.setFocusable(true);
        int y = 25;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pocetZivotu(g);
        vypisScore(g);
        g.drawString("Koule7b ", 5, 15);
        if(vyhrals){
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
        if(uroven == 1) {
            potvurka.kresleniPotvurky1(g);
            potvurka2.kresleniPotvurky2(g);
            if (score < 100) {
                potvurka3.vykresleniPotvurky3(g);
            }
            if(viditelny) {
                superjidlo.vykresleniSuperJidla(g);
            }
        }
    }
    private void vypisScore(Graphics g){
        g.setColor(Color.YELLOW);
        g.getFontMetrics();
        g.drawString(String.valueOf(score), 270 , 15);
    }
    private void vypisVyhru(Graphics g){
        g.setColor(Color.ORANGE);
        g.drawString("V Y H R Á L / A  J S I .", 90, 270);
    }
    private void vypsaniProhry(Graphics g){
        g.setColor(Color.orange);
        g.drawString("P A R D O N ,  A L E  G A M E  O V E R .", 70, 270);
    }
    private void pocetZivotu(Graphics g){
        g.setColor(Color.YELLOW);
        g.setFont(Font.getFont(Font.MONOSPACED));
        g.drawString("Z I V O T Y :     "+zivoty, (getSIRKA_PANELU()/2)-45,15);
    }
    private class PoslouchaniCasovace implements ActionListener{
        private int pomoc;
        @Override
        public void actionPerformed(ActionEvent e){
            if(vyhrals){
                return;
            }
            Rectangle okrajePozorKolize = Hrac.getOkraje();
            //Rectangle OkrajePN = pre.getOkraje1();
            Rectangle superJidlo = getOkraje();
            if (okrajePozorKolize.intersects(superJidlo)){
                if(isViditelny()) {
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
                        if(aktualniUroven.jidlo.get(i).isViditelny()){
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
                if(uroven == 3){
                    vyhrals = true;
                }
                pusteniLevel1(uroven, POCET_KONTROLNICH_CTVERCU, vyhrals, score, zivoty);
                return;
            }
            if(uroven == 1) {
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
            //pocitadloFPS.fps();;
            Hrac.move();
            repaint();
        }
    }
    private void snedeniHracePotvurkou(){
        zivoty--;
        Hrac.x = 130;
        Hrac.y = 230;
        Hrac.smerX = 0;
        Hrac.smerY = 0;
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

/* need to zero out the ticklist array before starting */
/* average will ramp up until the buffer is full */
/* returns average ticks per frame over the sto last frames */

        double CalcAverageTick(int newtick)
        {
            ticksum-=ticklist[tickindex];  /* subtract value falling off */
            ticksum+=newtick;              /* add new value */
            ticklist[tickindex]=newtick;   /* save new value so it can be subtracted later */
            if(++tickindex==100)    /* inc buffer index */
                tickindex=0;

    /* return average */
            return((double)ticksum/100);
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