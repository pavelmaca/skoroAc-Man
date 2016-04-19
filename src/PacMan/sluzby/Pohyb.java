package PacMan.sluzby;

import java.awt.*;

/**
 * Created by Admin on 19.4.2016.
 */
public class Pohyb {
    int maxSirka;
    int maxVyska;
    int [][] prekazky;
    Pohyb(int maxSirka, int maxVyska, int[][] prekazky){
        this.maxSirka = maxSirka;
        this.maxVyska = maxVyska;
    }
    /**
    public void kontrolaSnedeniJidla(){
        for (int i = 0; i < jidlo.size() ; i++) {
            Rectangle okrajeJidla = jidlo.get(i).getOkraje();
            if (hrac.getOkraje().intersects(okrajeJidla)) {
                score++;
                jidlo.remove(i);
            }
        }
    }
     */
}
