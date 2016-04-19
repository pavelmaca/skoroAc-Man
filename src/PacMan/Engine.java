package PacMan;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Potvurkaa;
import PacMan.urovne.Urovene;

import java.awt.*;
import java.util.ArrayList;

/**
 * This abstract class includes all of thinks witch have all class in share.
 * For example Pac-Man's pills, power pill(if power pill exist), walls, ghosts & player's figure.
 */
public class Engine {
    private int zivoty = 3;
    protected Prekazka[] prekazky;
    protected Hrac hrac;
    protected Potvurkaa[] potvurky;
    protected ArrayList<Svaca> jidlo = new ArrayList<Svaca>();

    protected int score = 0;

    public Engine(){
        nactiUroven(1);
    }

    protected void nactiUroven(int cisloUrovene) {
        Uroven aktualni = Urovne.get(cisloUrovene);

        prekazky = aktualni.getPrekazky();
        hrac = aktualni.getHrac();
        potvurky = aktualni.getPotvurky();
        jidlo = aktualni.getSvaca();
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Svaca> getJidlo() {
        return jidlo;
    }

    public Potvurkaa[] getPotvurky() {
        return potvurky;
    }

    public Hrac getHrac() {
        return hrac;
    }

    public Prekazka[] getPrekazky() {
        return prekazky;
    }

    public int getZivoty() {
        return zivoty;
    }

    /**
     * Method with paint walls.
     *
     * @param g
     */
    private void vykresliPrekazky(Graphics g) {
        for (int i = 0; i < parametryPrekazek.length; i++) {
            int[] parametryPrekazky = parametryPrekazek[i];
            g.setColor(barvaVnitrkuPrekazek);
            g.fillRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
            g.setColor(barvaOkrajePrekazek);
            g.drawRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
        }
    }

    /**
     * Method witch create a pills. It works like an array list.
     */
    protected void vytvoreniJidla() {
        for (int i = 0; i < 150; i++) {
            int x = 25 * (i % 10) + 35;
            int y = 30 * (i / 10) + 25;
            boolean kolize = false;
            Svaca p = new Svaca(x, y);
            for (int j = 0; j < parametryPrekazek.length; j++) {
                if (p.getOkraje().intersects(getOkraje(j))) {
                    kolize = true;
                }

            }
            if (kolize == false) {
                jidlo.add(p);
            }
        }
    }

    /**
     * Method paints actual level. Here the picture of level gets together from smaller parts.
     *
     * @param g
     */
    public void vykresliUroven(Graphics g) {
        vykresliPrekazky(g);
        //vykresliPostavicky(g);
    }

    /**
     * Method, witch draws pills.
     *
     * @param g
     */
/*
    private void vykresliPostavicky(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int i = 0; i < parametryPotvurek.length; i++) {
            int[] parmetryPotvurky = parametryPotvurek[i];
            g.fillRect(parmetryPotvurky[0], parmetryPotvurky[1], parmetryPotvurky[2], parmetryPotvurky[3]);
        }
    }
*/

    /**
     * Method witch gets space for every wall.
     *
     * @param i index of wall
     * @return Rectangle
     */
    public Rectangle getOkraje(int i) {
        return new Rectangle((parametryPrekazek[i][0]), (parametryPrekazek[i][1]), (parametryPrekazek[i][2]), (parametryPrekazek[i][3]));
    }
/**
 public Rectangle getOkrajePotvurky(int i) {
 return new Rectangle(parametryPotvurek[i][0], parametryPotvurek[i][1], parametryPotvurek[i][2], parametryPotvurek[i][3]);
 }
 */
}

