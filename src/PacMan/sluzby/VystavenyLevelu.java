package PacMan.sluzby;

import PacMan.Engine;
import PacMan.objekty.postavicky.Smery;
import PacMan.urovne.Uroven;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Admin on 4.4.2016.
 */
public class VystavenyLevelu {
    private ArrayList<Uroven> sezanam = new ArrayList<>();

    public VystavenyLevelu() {
        vytvorUroven1();
    }

    public Uroven get(int uroven) {
        return sezanam.get(uroven);
    }

    private void vytvorUroven1() {
        Uroven lvl = new Uroven(Color.darkGray, Color.yellow);

        lvl.addPrekazka(30, 40, 90, 210);
        lvl.addPrekazka(150, 40, 120, 90);
        lvl.addPrekazka(150, 160, 120, 90);
        lvl.addPrekazka(30, 280, 240, 60);
        lvl.addPrekazka(30, 370, 125, 60);
        lvl.addPrekazka(180, 370, 90, 60);


        lvl.addPotvurka(5, 5, Smery.dolu);
        lvl.addPotvurka(285, 400, Smery.pravo);
        lvl.addPotvurka(160, 370, Smery.levo);

        lvl.addMistoZnemySmeru(9, 260, 15, 15);
        lvl.addMistoZnemySmeru(9, 19, 15, 15);
        lvl.addMistoZnemySmeru(130, 19, 15, 15);
        lvl.addMistoZnemySmeru(280, 19, 15, 15);
        lvl.addMistoZnemySmeru(130, 140, 15, 15);
        lvl.addMistoZnemySmeru(280, 140, 15, 15);
        lvl.addMistoZnemySmeru(280, 260, 15, 15);
        lvl.addMistoZnemySmeru(280, 350, 15, 15);
        lvl.addMistoZnemySmeru(9, 350, 15, 15);
        lvl.addMistoZnemySmeru(130, 260, 15, 15);
        lvl.addMistoZnemySmeru(160, 350, 15, 15);

        lvl.vytvoreniJidla();
        sezanam.add(lvl);
        sezanam.set(0, lvl);

    }

    protected void vytvorUroven2() {
      /*  {53, 40, 20, 215},
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
    vytvoreniJidla();
    barvaVnitrkuPrekazek = Color.RED;*/
    }
    public Rectangle getOkraje(int i){
        return new Rectangle();
    }

}
