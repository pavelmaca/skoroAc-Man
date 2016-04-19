package objekty.postavicky;

import java.awt.*;
import okna.oknoHry;
/**
 * Created by Admin on 4.4.2016.
 */
import java.util.Random;
public class Potvurkaa{
    private oknoHry vokno;
    protected int [][] parametryPotvurek;
    Color barva = Color.ORANGE;
    int x;
    int y;
    Random gen = new Random();
    int cislo;
    int rychlost = 1;
    int smerX;
    int smerY;
    public int velikost = 20;
    public int getVelikost(){return velikost;}
    public Potvurkaa(){
        vygenerovaniSmeru();
    }
    public void vygenerovaniSmeru(){
        for (int i = 0; i < parametryPotvurek.length ; i++) {
            cislo = gen.nextInt(4);
            smery();
            pohybPotvurky();
        }
    }
    public void pohybPotvurky(){
        smerX = -rychlost;
        if(!kontrolaKolize(x+smerX, y+smerY)){
            x += smerX;
            y += smerY;
        }else {
            smery();
        }
    }
    public void smery(){
        if (cislo == 0) {
            smerY = 0;
            smerX = -rychlost;
        }
        if (cislo == 1) {
            smerX = 0;
            smerY = rychlost;
        }
        if (cislo == 2) {
            smerY = 0;
            smerX = -rychlost;
        }
        if (cislo == 3) {
            smerX = 0;
            smerY = rychlost;
        }
    }
    public boolean kontrolaKolize(int x, int y) {
        //v okne zprava
        if ((x >= 300 - (velikost + 1)) && 500 > 0) {
            return true;
        }
        if ((y >= 300 - (velikost + 1)) && (500 > 0)) {
            return true;
        }
        if(x < 0 || y < 0){
            return true;
        }
        for (int j = 0; j < parametryPotvurek.length; j++) {
            for (int i = 0; i < vokno.getAktualniUroven().pocetPrekazek(); i++) {
                if (new Rectangle(x - 1, y - 1, velikost + 2, velikost + 2).intersects(vokno.getAktualniUroven().getOkraje(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
