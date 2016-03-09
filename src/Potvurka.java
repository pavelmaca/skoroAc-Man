import java.awt.*;
import java.util.Random;
/**
 * Created by Admin on 4.3.2016.
 */
public class Potvurka {
    private int pp1, pp2, smerX, smerY, rychlost, cislo;
    private Mojevokno vokno;
    private Prekazky smerr;
    private Random generator = new Random();
    public Potvurka(Mojevokno mojevokno) {
        this.vokno = vokno;
        this.smerr = smerr;
        Bod1();
    }
    public void Bod1(){
        pp1 = 150;
        pp2 = 346;
        rychlost = 2;
        generovani();
        polohaPotvurky();
    }
    public int generovani(){
        cislo = generator.nextInt(4) + 1;
        if(cislo == 1){
            smerY = 0;
            smerX = -rychlost;
        }else{
            if(cislo == 2){
                smerX = 0;
                smerY = rychlost;
            }else{
                if(cislo == 3){
                    smerY = 0;
                    smerX = rychlost;
                }else{
                    if(cislo == 4){
                        smerX = 0;
                        smerY = -rychlost;
                    }
                }
            }
        }
        //System.out.println(cislo);
        return cislo;
    }

    private void generator() {
    }
    public void polohaPotvurky(){
        this.smerr = smerr;
        pp1 += smerX;
        pp2 = pp2 + smerY;
        /*
        if(getOkrajePP1().intersects(smerr.getOkraje1())){
            if(smerX != 0){
                smerX = 0;
            }
            if(smerY != 0){
                smerY = 0;
            }
            generovani();
        }
        if(getOkrajePP1().intersects(smerr.getOkraje2())){
            if(smerX != 0){
                smerX = 0;
            }
            if(smerY != 0){
                smerY = 0;
            }
            generovani();
        }
        if(getOkrajePP1().intersects(smerr.getOkraje3())){
            if(smerX != 0){
                smerX = 0;
            }
            if(smerY != 0){
                smerY = 0;
            }
            generovani();
        }
        if(getOkrajePP1().intersects(smerr.getOkraje4())){
            if(smerX != 0){
                smerX = 0;
            }
            if(smerY != 0){
                smerY = 0;
            }
            generovani();
        }
        if(getOkrajePP1().intersects(smerr.getOkraje5())){
            if(smerX != 0){
                smerX = 0;
            }
            if(smerY != 0){
                smerY = 0;
            }
            generovani();
        }
        if(getOkrajePP1().intersects(smerr.getOkraje6())){
            if(smerX != 0){
                smerX = 0;
            }
            if(smerY != 0){
                smerY = 0;
            }
            generovani();
        }
        if(pp1 >= 270 || pp1 <= 29){
            generovani();
        }
        if(pp2 <= 29 || pp2 >= 470){
            generovani();
        }
        */
        //v okne zprava
        if ((pp1 >= 279) && (279 > 0)){
            pp1 = 279;
            generovani();
        }
        //1. prakazka zleva
        if(25 < pp2 && pp2 < 250){
            if(31 > pp1 && pp1 > 29){
                pp1 = 29;
                generovani();
            }
        }
        //1. prekazka zprava
        if(25 < pp2 && pp2 < 250){
            if(119 < pp1 && pp1 < 116){
                pp1 = 116;
                generovani();
            }
        }
        //v levo nahore zleva
        if(25 < pp2 && pp2 < 130){
            if(pp1 > 129 && pp1 < 136){
                pp1 = 129;
                generovani();
            }
        }
        //v levo nahore zprava
        if(25 < pp2 && pp2 < 130){
            if(pp1 > 244 && pp1 < 246){
                pp1 = 246;
                generovani();
            }
        }
        //v levo niz zleva
        if(144 < pp2 && pp2 < 250){
            if(136 > pp1 && pp1 > 129){
                pp1 = 129;
                generovani();
            }
        }
        //v levo niz zprava
        if(144 < pp2 && pp2 < 250){
            if(249 < pp1 && pp1 < 246){
                pp1 = 246;
                generovani();
            }
        }
        //p vprostred zleva
        if(264 < pp2 && pp2 < 341){
            if(pp1 < 36 && pp1 > 29){
                pp1 = 29;
                generovani();
            }
        }
        //p vravo dole zleva
        if(355 < pp2 && pp2 < 430){
            if(168 > pp1 && pp1 > 159){
                pp1 = 159;
                generovani();
            }
        }
        //vprava dole zprava
        if(355 < pp2 && pp2 < 430){
            if(pp1 > 244 && pp1 < 246){
                pp1 = 246;
                generovani();
            }
        }
        // v levo dole zleva
        if(355 < pp2 && pp2 < 430){
            if(29 < pp1 && pp1 < 37){
                pp1 = 29;
                generovani();
            }
        }
        //prostredek zprava :-)
        if(264 < pp2 && pp2 < 341){
            if(pp1 < 246 && pp1 > 244){
                pp1 = 246;
                generovani();
            }
        }
        //vlevo dole zprava
        if(355 < pp2 && pp2 < 430){
            if(141 > pp1 && pp1 > 139){
                pp1 = 141;
                generovani();
            }
        }
        //v okne zleva
        if (pp1 <= 0) {
            pp1 = 0;
            generovani();
        }
        if ((pp2 >= 450) && (479) > 0) {
            pp2 = 450;
            generovani();
        }
        //1. no nahore
        if(pp1 > 35 && pp1 < 121){
            if(pp2 > 19 && pp2 < 249){
                pp2 = 19;
                generovani();
            }
        }
        //1. no dole
        if(pp1 > 35 && pp1 < 121){
            if(pp2 > 24 && pp2 < 246){
                pp2 = 246;
                generovani();
            }
        }
        //v levo nahore no nahore
        if(pp1 > 135 && pp1 < 250){
            if(pp2 > 19 && pp2 < 129){
                pp2 = 19;
                generovani();
            }
        }
        //v levo dole no dole
        if(pp1 > 135 && pp1 < 250){
            if(pp2 > 24 && pp2 < 126){
                pp2 = 126;
                generovani();
            }
        }
        //v levo niz no nahore
        if(pp1 > 135 && pp1 < 250){
            if(pp2 > 139 && pp2 < 146){
                pp2 = 139;
                generovani();
            }
        }
        //v levo niz no niz
        if(pp1 > 135 && pp1 < 250){
            if(pp2 > 239 && pp2 < 246){
                pp2 = 246;
                generovani();
            }
        }
        //v prostred no nohore
        if(pp1 > 35 && pp1 < 250){
            if(pp2 > 259 && pp2 < 267){
                pp2 = 259;
                generovani();
            }
        }
        //v prostred no dole
        if(pp1 > 35 && pp1 < 250){
            if(pp2 > 334 && pp2 < 336){
                pp2 = 336;
                generovani();
            }
        }
        //v levo dole no nahore
        if(pp1 > 35 && pp1 < 145){
            if(pp2 > 349 && pp2 < 357){
                pp2 = 349;
                generovani();
            }
        }
        //v levo dole no dole
        if(pp1 > 35 && pp1 < 145){
            if(pp2 > 424 && pp2 < 426){
                pp2 = 426;
                generovani();
            }
        }
        //vpravo dole no nahore
        if(pp1 > 164 && pp1 < 250){
            if(pp2 > 349 && pp2 < 373){
                pp2 = 349;
                generovani();
            }
        }
        //vpravo dole no
        if(pp1 > 164 && pp1 < 250){
            if(pp2 > 424 && pp2 < 426){
                pp2 = 426;
                generovani();
            }
        }
        if (pp2 <= 0) {
            pp2 = 0;
            generovani();
        }
    }
    public void kresleniPotvurky1(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(pp1, pp2, 20, 20);
    }
    public Rectangle getOkrajePP1(){
        return new Rectangle(pp1, pp2, 20, 20);
    }
}
