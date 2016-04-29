package PacMan.sluzby;

import PacMan.Spusteni;
import PacMan.objekty.Prekazka;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Postavicka;
import PacMan.objekty.postavicky.Potvurkaa;
import PacMan.objekty.postavicky.Smery;
import PacMan.urovne.Uroven;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 19.4.2016.
 */
public class Movinator3000 {
    int maxSirka;
    int maxVyska;
    Random generator;

    protected Uroven uroven;

    public Movinator3000(int maxSirka, int maxVyska, Uroven uroven) {
        this.maxSirka = maxSirka;
        this.maxVyska = maxVyska;
        this.uroven = uroven;
        generator = new Random();
    }
    public void nahodnySmer(Potvurkaa potvurka){
        int nahoda = generator.nextInt(29) + 1;
        if(nahoda % 2 == 0) {
            Smery[] smer = Smery.values();
            potvurka.setSmer(smer[generator.nextInt(Smery.values().length - 1)]);
        }
    }

    public void pohniVsim() {
        if(kontrolaKolize(uroven.getHrac())){
            uroven.getHrac().pohyb();
        }




        for (int i = 0; i < uroven.getPotvurky().size(); i++) {
            Potvurkaa potvurka = uroven.getPotvurky().get(i);
            if(kontrolaKolize(potvurka)){
                potvurka.pohyb();
            }else{
                Smery[] smer = Smery.values();

                potvurka.setSmer(smer[generator.nextInt(Smery.values().length - 1)]);
            }
            int[] budouci = potvurka.budouciPozice();
            if(kontrolaKolizesMistem(budouci[0], budouci[1], potvurka)){
                nahodnySmer(potvurka);
            }
        }
    }

    private boolean kontrolaKolize(Postavicka postavicka) {
        int[] budouci = postavicka.budouciPozice();
        boolean kontrolaKolizeVOkne = kontrolaKolizesOkrajemaHry(budouci[0], budouci[1], postavicka);
        boolean kontrolaKolizePrekazky = kontrolaKolizeSPrekazkama(budouci[0], budouci[1], postavicka);
        //boolean kontrolaKOlizeSMistem = kontrolaKolizesMistem(budouci[0], budouci[1], postavicka);
        return !kontrolaKolizeVOkne && !kontrolaKolizePrekazky; //kontrolaKOlizeSMistem;
    }

    private boolean kontrolaKolizesMistem(int x, int y, Postavicka postavicka){
        for (int i = 0; i < uroven.getMistaZmenySmeru().size() ; i++) {
            if(new Rectangle(x - 1, y - 1, postavicka.getVelikost() + 2, postavicka.getVelikost() + 2).intersects(uroven.getMistaZmenySmeru().get(i).getOkraje()));
            return true;
        }
        return false;

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


    public boolean kontrolaKolizeSPrekazkama(int x, int y, Postavicka postavicka) {
        for (int i = 0; i < uroven.getPrekazky().size(); i++) {
            if (new Rectangle(x - 1, y - 1, postavicka.getVelikost() + 2, postavicka.getVelikost() + 2).intersects(uroven.getPrekazky().get(i).getOkraje())) {
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
