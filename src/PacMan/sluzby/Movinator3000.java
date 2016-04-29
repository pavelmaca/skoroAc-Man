package PacMan.sluzby;

import PacMan.Engine;
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
    int scoreHrace;
    int scorePotvurek;
    Random generator;
    protected Engine engine;

    protected Uroven uroven;

    public Movinator3000(int maxSirka, int maxVyska, Uroven uroven) {
        this.maxSirka = maxSirka;
        this.maxVyska = maxVyska;
        this.uroven = uroven;
        generator = new Random();
    }
    public void nahodnySmer(int i){
        int nahoda = generator.nextInt(19000) + 1;
        if(nahoda % 300 == 0) {
            Smery[] smer = Smery.values();
            uroven.getPotvurky().get(i).setSmer(smer[generator.nextInt(Smery.values().length - 1)]);
        }
    }

    public void pohniVsim() {
        if(kontrolaKolize(uroven.getHrac())){
            uroven.getHrac().pohyb();
            int[] budouci = uroven.getHrac().budouciPozice();
            if(kontrolaSnedeniJidla(budouci[0], budouci[1], uroven.getHrac())){
            }

        }




        for (int i = 0; i < uroven.getPotvurky().size(); i++) {
            Potvurkaa potvurka = uroven.getPotvurky().get(i);
            if(kontrolaKolize(potvurka)){
                potvurka.pohyb();
            }else{
                Smery[] smer = Smery.values();

                potvurka.setSmer(smer[generator.nextInt(Smery.values().length - 1)]);
            }
            int[] budouci = uroven.getPotvurky().get(i).budouciPozice();
            if(kontrolaKolizesMistem(budouci[0], budouci[1], uroven.getPotvurky().get(i))){
                nahodnySmer(i);
            }
            if(kontrolaSnedeniJidla(budouci[0] - 1, budouci[1] - 1, uroven.getPotvurky().get(i))){
            }
        }
    }

    private boolean kontrolaKolize(Postavicka postavicka) {
        int[] budouci = postavicka.budouciPozice();
        boolean kontrolaKolizeVOkne = kontrolaKolizesOkrajemaHry(budouci[0], budouci[1], postavicka);
        boolean kontrolaKolizePrekazky = kontrolaKolizeSPrekazkama(budouci[0], budouci[1], postavicka);
        //boolean kontrolaKOlizeSMistem = kontrolaKolizesMistem(budouci[0], budouci[1], postavicka);
        kontrolaSnedeniJidla(budouci[0], budouci[1], postavicka);
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
        } else if (x < 9 || y < 19) {
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
     public boolean kontrolaSnedeniJidla(int x, int y, Postavicka postavicka){
     for (int i = 0; i < uroven.getSvaca().size() ; i++) {
     Rectangle okrajeJidla = uroven.getSvaca().get(i).getOkraje();
     if (new Rectangle(x - 1, y - 2, postavicka.getVelikost(), postavicka.getVelikost()).intersects(okrajeJidla)) {
         uroven.getSvaca().remove(i);
         return true;
     }
     }
         return false;
     }
}
