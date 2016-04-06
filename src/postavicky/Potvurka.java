package postavicky;

import java.awt.*;

/**
 * Created by Admin on 4.4.2016.
 */
public class Potvurka {
    int[] souradnice = new int[2];
    int velikost = 20;
    Smery smer;
    Color barva = Color.orange;
    //int rychlost;

    public Potvurka(int x, int y, Smery smer){
        souradnice[0] = x;
        souradnice[1] = y;
        this.smer = smer;
    }

    public void vykresleni(Graphics g){
        g.setColor(barva);
        g.fillRect(souradnice[0],souradnice[1] , velikost, velikost);
    }
}
