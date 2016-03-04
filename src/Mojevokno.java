import com.sun.prism.*;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.management.Query;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class Mojevokno extends JPanel {
    private int zivoty;
    private Prekazky prekazky;
    private PozorKolize PozorKolize;
    private String label;
    private final int SIRKA_CTVERCE = 300;
    private final int VYSKA_CTVERCE = 500;
    public int  POCET_CTVERCU = 150;
    private Vyhrals vyhra;
    private  Prekazky[] poleCtvercu;
    ArrayList<Prekazky> jidlo = new ArrayList<Prekazky>();
    public boolean viditelny = true;
    int PocetKontrolichCtvercu = 0;
    public int cas;
    private boolean vyhrals = false;
    public int score = 0;
    private boolean hrajeSe = true;
    private Potvurka potvurka;
    private Mojevokno mojevokno;
    public Mojevokno(){
        this.poleCtvercu = new Prekazky[POCET_CTVERCU];
        this.PozorKolize = new PozorKolize(this);
        this.potvurka = new Potvurka(this);
        //Random generator = new Random();
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
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //pocetZivotu(g);
        vypisScore(g);
            for (int i = 0; i < POCET_CTVERCU; i++) {
                if (jidlo.get(i).isViditelny()) {
                    jidlo.get(i).vykresliSe(g);
                } else {
                    g.setColor(Color.RED);
                }
            }
            PozorKolize.vykresliSe(g);
        if(hrajeSe == false){
            vypsaniProhry(g);
        }
        if(vyhrals == true){
            vypisVyhru(g);
        }
        potvurka.kresleniPotvurky1(g);
        if(zivoty < 0){
            vypsaniProhry(g);
        }
        /*
        vykresliBaf(g);
        */
    }
    public void vypisScore(Graphics g){
        g.setColor(Color.BLUE);
        g.getFontMetrics();
        g.drawString(String.valueOf(score), 270 , 15);
    }
    public void vypisVyhru(Graphics g){
        g.setColor(Color.BLUE);
        g.drawString("V Y H R Á L / A  J S I .", 90, 270);
    }
    public void vypsaniProhry(Graphics g){
        g.setColor(Color.orange);
        g.drawString("P A R D O N ,  A L E  G A M E  O V E R .", 70, 270);
    }
    public void pocetZivotu(Graphics g){
        g.setColor(Color.BLUE);
        g.setFont(Font.getFont(Font.MONOSPACED));
        g.drawString(zivoty+"UP", 15, 15);
    }
    /*
    public void vykresliBaf(Graphics g){
        g.setColor(Color.YELLOW);
        g.drawString("B   A   F",143, 251);
    }
    */
    private class PoslouchaniCasovace implements ActionListener{
        public int pomoc;
        @Override
        public void actionPerformed(ActionEvent e){
            Rectangle okrajePozorKolize = PozorKolize.getOkraje();
            pomoc++;
            cas = pomoc/100;
            PozorKolize.move();
            int i = 0;
            for(; i < POCET_CTVERCU;i++) {
                    Prekazky prek = jidlo.get(i);
                    Rectangle okrajePrekazky = jidlo.get(i).getOkraje();
                    if (okrajePozorKolize.intersects(okrajePrekazky)) {
                        if(jidlo.get(i).isViditelny() == true){
                            score++;
                            PocetKontrolichCtvercu++;
                            if(PocetKontrolichCtvercu == 75){
                                vyhrals = true;
                            }
                        }
                        jidlo.get(i).skryt();
                    }
            }
            if(okrajePozorKolize.intersects(potvurka.getOkrajePP1())){
                zivoty--;
            }
            //score = score + cas;
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

}