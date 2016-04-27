package PacMan;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Potvurkaa;
import PacMan.objekty.postavicky.Smery;
import PacMan.sluzby.Movinator3000;
import PacMan.sluzby.VystavenyLevelu;
import PacMan.urovne.Uroven;

import java.util.ArrayList;

/**
 * This abstract class includes all of thinks witch have all class in share.
 * For example Pac-Man's pills, power pill(if power pill exist), walls, ghosts & player's figure.
 */
public class Engine {
    private int zivoty = 3;
    protected int score = 0;
    protected Uroven aktualni;
    protected Movinator3000 movinator3000;

    protected VystavenyLevelu tvorbaUrovne = new VystavenyLevelu();
    public int uroven = 0;

    public Engine() {
        //hrac = new Hrac();
        nactiUroven(uroven);
    }

    protected void nactiUroven(int cisloUrovene) {

        aktualni = tvorbaUrovne.get(cisloUrovene);
        movinator3000 = new Movinator3000(300, 500, aktualni);
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Svaca> getSvaca() {
        return aktualni.getSvaca();
    }

    public ArrayList<Potvurkaa> getPotvurky() {
        return aktualni.getPotvurky();
    }

    public Hrac getHrac() {
        return aktualni.getHrac();
    }

    public ArrayList<Prekazka> getPrekazky() {
        return aktualni.getPrekazky();
    }

    public int getZivoty() {
        return zivoty;
    }

    public boolean hracVyhral() {
        return aktualni.getSvaca().size() == 0;
    }

    public void zmenSmer(Smery smer){
       // getHrac().
    }

    /**
     * Method with paint walls.
     *
     * @param g
     */
/*    private void vykresliPrekazky(Graphics g) {
        for (int i = 0; i < parametryPrekazek.length; i++) {
            int[] parametryPrekazky = parametryPrekazek[i];
            g.setColor(barvaVnitrkuPrekazek);
            g.fillRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
            g.setColor(barvaOkrajePrekazek);
            g.drawRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
        }
    }

*/
    /**
     * Method paints actual level. Here the picture of level gets together from smaller parts.
     *
     * @param g
     */
  /*  public void vykresliUroven(Graphics g) {
        vykresliPrekazky(g);
        //vykresliPostavicky(g);
    }
*/
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
 public Rectangle getOkrajePotvurky(int i) {
 return new Rectangle(parametryPotvurek[i][0], parametryPotvurek[i][1], parametryPotvurek[i][2], parametryPotvurek[i][3]);
 }
 */
}

