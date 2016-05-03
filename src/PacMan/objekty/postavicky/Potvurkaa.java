package PacMan.objekty.postavicky;

import java.awt.*;

import PacMan.okna.Hra;
/**
 * Created by Admin on 4.4.2016.
 */
import java.util.Random;

public class Potvurkaa  extends Postavicka{

    Color barva = Color.ORANGE;



    public Potvurkaa(int x, int y, Smery smer) {
        super(x, y, smer);
    }

    public void vykresliSe(Graphics g){
        g.setColor(barva);
        g.fillOval(x, y, velikost, velikost);
    }

    public Rectangle getOkraje(){return new Rectangle(x, y, velikost, velikost);}



/*
    public boolean kontrolaKolize(int x, int y) {
        //v okne zprava
        if ((x >= 300 - (velikost + 1)) && 500 > 0) {
            return true;
        }
        if ((y >= 300 - (velikost + 1)) && (500 > 0)) {
            return true;
        }
        if (x < 0 || y < 0) {
            return true;
        }
        for (int j = 0; j < parametryPotvurek.length; j++) {
            for (int i = 0; i < hra.getEngine().pocetPrekazek(); i++) {
                if (new Rectangle(x - 1, y - 1, velikost + 2, velikost + 2).intersects(vokno.getEngine().getOkraje(i))) {
                    return true;
                }
            }
        }
        return false;
    }
    */
}
