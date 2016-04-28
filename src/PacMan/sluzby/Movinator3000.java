package PacMan.sluzby;

import PacMan.Spusteni;
import PacMan.objekty.Prekazka;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Postavicka;
import PacMan.objekty.postavicky.Smery;
import PacMan.urovne.Uroven;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Admin on 19.4.2016.
 */
public class Movinator3000 {
    int maxSirka;
    int maxVyska;

    protected Uroven uroven;

    public Movinator3000(int maxSirka, int maxVyska, Uroven uroven) {
        this.maxSirka = maxSirka;
        this.maxVyska = maxVyska;
        this.uroven = uroven;
    }
    public void pohniVsim(){
        pohniHrace();
    }
    private void pohniHrace(){
        int[] budouci = uroven.getHrac().budouciPozice();
        if(!kontrolaKolizesOkrajemaHry(budouci[0], budouci[1], uroven.getHrac())) {
            uroven.getHrac().pohyb();
        }
    }
    private boolean kontrolaKolizesOkrajemaHry(int x, int y, Postavicka postavicka) {
        if ((x >= maxSirka - postavicka.getVelikost())) {
            return true;
        } else if ((y >= maxVyska - postavicka.getVelikost())) {
            return true;
        } else if (x < 0 || y < 0) {
            return true;
        }
        return false;
    }




    public boolean kontrolaKolizeHrace(int x, int y) {
        //this.x = x;
        //this.y = y;
        //this.hra = hra;
        //v okne zprava
            for (int i = 0; i < uroven.getPrekazky().size(); i++) {
                if (new Rectangle(x - 1, y - 1, uroven.getHrac().getVelikost() + 2, uroven.getHrac().getVelikost() + 2).intersects(uroven.getPrekazky().get(i).getOkraje())) {
                    return true;
                }
            }
            return false;
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
