package PacMan.objekty.postavicky;

import java.awt.*;

/**
 * Created by Admin on 7.4.2016.
 */
abstract public class Postavicka {
    int[] souradnice = new int[2];
    Smery smer;
    Color barva;
    private int velikost;
    public Postavicka(int x, int y, Smery smer, Color barva, int velikost){
        souradnice[0] = x;
        souradnice[1] = y;
        this.smer = smer;
    }
    public Postavicka(){
    }
    public void vykresleni(Graphics g){
        g.setColor(barva);
        g.fillRect(souradnice[0],souradnice[1] , velikost, velikost);
    }
}
