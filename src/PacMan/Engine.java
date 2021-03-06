package PacMan;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.SuperJidlo;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
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
    protected int scoreHrace = 0;
    protected int scorePotvurek = 0;
    protected Uroven aktualni;
    protected Movinator3000 movinator3000;
    private int velikostSirka;
    private int velikostVyska;

    protected VystavenyLevelu tvorbaUrovne = new VystavenyLevelu();
    public int uroven = 0;

    public Engine(int velikostSirka, int velikostVyska) {
        //hrac = new Hrac();
        this.velikostSirka = velikostSirka;
        this.velikostVyska = velikostVyska;
        nactiUroven(uroven);
    }

    protected void nactiUroven(int cisloUrovene) {

        aktualni = tvorbaUrovne.get(cisloUrovene);
        movinator3000 = new Movinator3000(velikostSirka, velikostVyska, aktualni, zivoty, scorePotvurek, scoreHrace);
    }

    public int getScoreHrace() {
        return movinator3000.getScoreHrace();
    }

    public int getScorePotvurek() {
        return movinator3000.getScorePotvurek();
    }

    public ArrayList<Svaca> getSvaca() {
        return aktualni.getSvaca();
    }

    public ArrayList<Potvurkaa> getPotvurky() {
        return aktualni.getPotvurky();
    }
    public ArrayList<SuperJidlo> getSuperJidlo(){return aktualni.getSuperJidlo();}

    public Hrac getHrac() {
        return aktualni.getHrac();
    }

    public ArrayList<Prekazka> getPrekazky() {
        return aktualni.getPrekazky();
    }

    public int getZivoty() {
        return movinator3000.getZivoty();
    }

    public boolean hracVyhral() {
        return getScoreHrace() > getScorePotvurek();
    }

    public ArrayList<MistaZmenySmeru> getMistaZmenySmeru() {
        return aktualni.getMistaZmenySmeru();
    }

    public int getUroven() {
        return uroven;
    }
    public int setUroven(int uroven){
        return this.uroven = uroven;
    }

    public void setScoreHrace(int score) {
        scoreHrace = score;
    }

    public void setScorePotvurek(int score) {
        scorePotvurek = score;
    }
    public int getZivotyHrace(){return zivoty;}
    public int setZivotyHrace(int zivoty){return this.zivoty = zivoty;}

    public void zmenSmer(Smery smer) {
        aktualni.getHrac().setSmer(smer);
    }

    public void skok() {
        movinator3000.pohniVsim();

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

