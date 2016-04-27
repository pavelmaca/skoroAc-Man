package PacMan.objekty.postavicky;

import PacMan.Engine;
import PacMan.Grafika;
import PacMan.Spusteni;
import PacMan.okna.Hra;
import PacMan.sluzby.Movinator3000;

import java.awt.*;

/**
 * Created by Admin on 7.4.2016.
 */
abstract public class Postavicka {
    protected int x;
    protected int y;

    protected Smery smer;
    protected int rychlost = 1;

    public Postavicka(int x, int y, Smery smer) {
        this.x = x;
        this.y = y;
        this.smer = smer;
    }

    public void pohyb() {
        int[] pozice = budouciPozice();
        x = pozice[0];
        y = pozice[1];
    }

    public int[] budouciPozice() {
        int[] pozice = new int[2];
        if (smer == Smery.dolu) {
            pozice[1] = y + rychlost;
        }

        /// TODO ostatní směry
        return pozice;
    }
}

