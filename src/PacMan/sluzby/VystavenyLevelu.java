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
        //vytvorUroven2();
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
        lvl.addPrekazka(30, 467, 240, 10);


        lvl.addPotvurka(70, 480, Smery.dolu);
        lvl.addPotvurka(270, 480, Smery.pravo);
        lvl.addPotvurka(160, 480, Smery.levo);
        lvl.addPotvurka(130, 480, Smery.levo);

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
        lvl.addMistoZnemySmeru(160, 440, 15, 15);
        lvl.addMistoZnemySmeru(9, 440, 15, 15);
        lvl.addMistoZnemySmeru(280, 440, 15, 15);


        lvl.vytvoreniJidla();

        lvl.addSuperJidlo(195, 142);
        lvl.addSuperJidlo(250, 350);
        lvl.addSuperJidlo(163, 443);



        sezanam.add(lvl);
        sezanam.set(0, lvl);

    }

    protected void vytvorUroven2() {
        Uroven lvl = new Uroven(Color.RED);
        lvl.addPrekazka(53, 40, 20, 215);
        lvl.addPrekazka(70, 75, 100, 20);
        lvl.addPrekazka(100, 20, 174, 20);
        lvl.addPrekazka(200, 75, 20, 60);
        lvl.addPrekazka(254, 40, 20, 150);
        lvl.addPrekazka(100, 135, 70, 20);
        lvl.addPrekazka(100, 195, 125, 20);
        lvl.addPrekazka(200, 163, 25, 35);
        lvl.addPrekazka(27, 283, 20, 170);
        lvl.addPrekazka(230, 230, 25, 49);
        lvl.addPrekazka(107, 259, 125, 20);
        lvl.addPrekazka(40, 433, 227, 20);
        lvl.addPrekazka(250, 318, 20, 135);
        lvl.addPrekazka(200, 280, 20, 65);
        lvl.addPrekazka(130, 280, 20, 65);
        lvl.addPrekazka(77, 310, 20, 83);
        lvl.addPrekazka(97, 373, 130, 20);


        lvl.vytvoreniJidla();


        lvl.addPotvurka(150, 290, Smery.dolu);
        lvl.addPotvurka(170, 290, Smery.pravo);
        lvl.addPotvurka(150, 310, Smery.levo);
        lvl.addPotvurka(170, 310, Smery.levo);


        sezanam.add(lvl);
        sezanam.set(1, lvl);
    }

    public Rectangle getOkraje(int i) {
        return new Rectangle();
    }

}
