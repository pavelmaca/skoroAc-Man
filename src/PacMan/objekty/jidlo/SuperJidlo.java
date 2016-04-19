package PacMan.objekty.jidlo;

import PacMan.okna.Hra;

import java.awt.*;

/**
 * Created by Admin on 24.3.2016.
 */
public class SuperJidlo {
    private int souradniceX, souradniceY, cislo;
    private final int velikost = 10;
    private boolean viditelny = true;
    private Hra vokno;
    public SuperJidlo(Hra oknoHry){

    }
    public void vykresleniSuperJidla(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(133, 200, 10, 10);
    }
    public boolean isViditelny(){
        return viditelny;
    }
    public void skryt(){
        viditelny = false;
    }
}
