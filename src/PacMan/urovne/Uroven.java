package PacMan.urovne;

import PacMan.objekty.Prekazka;
import PacMan.objekty.postavicky.Potvurkaa;
import PacMan.objekty.postavicky.Smery;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Admin on 19.4.2016.
 */
public class Uroven {
    protected ArrayList<Prekazka> prekazky = new ArrayList<>();
    protected ArrayList<Potvurkaa> potvurky = new ArrayList<>();

    Color barvaVnitrku;
    Color barvaOkraje;

    public Uroven(Color barvaVnitrku){
        this.barvaOkraje = barvaVnitrku;
        this.barvaVnitrku = barvaVnitrku;
    }

    public Uroven(Color barvaVnitrku, Color barvaOkraje){
        this.barvaOkraje = barvaOkraje;
        this.barvaVnitrku = barvaVnitrku;
    }

    public void addPotvurka(int x, int y, int rychlost, Smery smer){
        Potvurkaa potvurka = new Potvurkaa();
        potvurky.add(potvurka);
    }

    public void addPrekazka(int x, int y, int sirka, int vyska){
        Prekazka prekazka = new Prekazka(x, y, sirka, vyska, barvaVnitrku, barvaOkraje);
        prekazky.add(prekazka);
    }
}
