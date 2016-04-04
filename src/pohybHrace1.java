/**
 * Created by Admin on 31.3.2016.
 */
/**
public class pohybHrace1 {
    private int x;
    private int y;
    private final int vyskaKruhu = 15;
    private final int sirkaKruhu = 15;
    private oknoHry vokno;
    public pohybHrace1(oknoHry oknoHry){
    this.vokno = vokno;
    }



    public void pohybyHrace1(){
        //v okne zprava
        if ((x >= vokno.getSIRKA_PANELU() - (sirkaKruhu + 1)) && (vokno.getSIRKA_PANELU() > 0)){
            x = vokno.getSIRKA_PANELU() - (sirkaKruhu + 1);
        }
        //1. prakazka zleva
        if(25 < y && y < 250){
            if(36 > x && x > 34){
                x = 34;
            }
        }
        //1. prekazka zprava
        if(25 < y && y < 250){
            if(119 < x && x < 121){
                x = 121;
            }
        }
        //v levo nahore zleva
        if(25 < y && y < 130){
            if(x > 134 && x < 136){
                x = 134;
            }
        }
        //v levo nahore zprava
        if(25 < y && y < 130){
            if(x > 249 && x < 251){
                x = 251;
            }
        }
        //v levo niz zleva
        if(144 < y && y < 250){
            if(136 > x && x > 134){
                x = 134;
            }
        }
        //v levo niz zprava
        if(144 < y && y < 250){
            if(249 < x && x < 251){
                x = 251;
            }
        }
        //p vprostred zleva
        if(264 < y && y < 341){
            if(x < 36 && x > 34){
                x = 34;
            }
        }
        //p vravo dole zleva
        if(355 < y && y < 430){
            if(168 > x && x > 164){
                x = 164;
            }
        }
        //vprava dole zprava
        if(355 < y && y < 430){
            if(x > 249 && x < 251){
                x = 251;
            }
        }
        // v levo dole zleva
        if(355 < y && y < 430){
            if(34 < x && x < 37){
                x = 34;
            }
        }
        //prostredek zprava :-)
        if(264 < y && y < 341){
            if(x < 251 && x > 249){
                x = 251;
            }
        }
        //vlevo dole zprava
        if(355 < y && y < 430){
            if(146 > x && x > 143){
                x = 146;
            }
        }
        //v okne zleva
        if (x <= 0) {
            x = 0;
        }
        if ((y >= vokno.getVYSKA_PANELU() - (vyskaKruhu + 1)) && (vokno.getVYSKA_PANELU() > 0)) {
            y = vokno.getVYSKA_PANELU() - (vyskaKruhu + 1);
        }
        //1. no nahore
        if(x > 35 && x < 121){
            if(y > 24 && y < 249){
                y = 24;
            }
        }
        //1. no dole
        if(x > 35 && x < 121){
            if(y > 24 && y < 251){
                y = 251;
            }
        }
        //v levo nahore no nahore
        if(x > 135 && x < 250){
            if(y > 24 && y < 129){
                y = 24;
            }
        }
        //v levo dole no dole
        if(x > 135 && x < 250){
            if(y > 24 && y < 131){
                y = 131;
            }
        }
        //v levo niz no nahore
        if(x > 135 && x < 250){
            if(y > 144 && y < 146){
                y = 144;
            }
        }
        //v levo niz no niz
        if(x > 135 && x < 250){
            if(y > 239 && y < 251){
                y = 251;
            }
        }
        //v prostred no nohore
        if(x > 35 && x < 250){
            if(y > 264 && y < 267){
                y = 264;
            }
        }
        //v prostred no dole
        if(x > 35 && x < 250){
            if(y > 337 && y < 341){
                y = 341;
            }
        }
        //v levo dole no nahore
        if(x > 35 && x < 145){
            if(y > 354 && y < 357){
                y = 354;
            }
        }
        //v levo dole no dole
        if(x > 35 && x < 145){
            if(y > 429 && y < 431){
                y = 431;
            }
        }
        //vpravo dole no nahore
        if(x > 164 && x < 250){
            if(y > 354 && y < 373){
                y = 354;
            }
        }
        //vpravo dole no
        if(x > 164 && x < 250){
            if(y > 429 && y < 431){
                y = 431;
            }
        }
        if (y <= 0) {
            y = 0;
        }
    }
}
 */
