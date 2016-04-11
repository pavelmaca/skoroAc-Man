package urovne;

import postavicky.Postavicka;
//import postavicky.Potvurkaa;
import postavicky.Smery;

import java.awt.*;

/**
 * Created by Admin on 4.4.2016.
 */
public class Uroven2 extends Uroven {
    //private Potvurkaa potvurkaa;
    private Postavicka postavicka;
    public Uroven2() {
        parametryPrekazek = new int[][]{
                {53, 40, 20, 215},
                {70, 75, 100, 20},
                {100, 20, 174, 20},
                {200, 75, 20, 60},
                {254, 40, 20, 150},
                {100, 135, 70, 20},
                {100, 195, 125, 20},
                {200, 163, 25, 35},
                {27, 283, 20, 170},
                {230, 230, 25, 49},
                {107, 259, 125, 20},
                {40, 433, 227, 20},
                {250, 318, 20, 135},
                {200, 280, 20, 65},
                {130, 280, 20, 65},
                {77, 310, 20, 83},
                {97, 373, 130, 20}
        };
        barvaVnitrku = Color.RED;
        //this.potvurkaa = new Potvurkaa(15, 15, Smery.dolu);
    }

}

