package PacMan.objekty.mistaZmenySmeru;

import java.awt.*;

/**
 * Created by Admin on 29.4.2016.
 */
public class MistaZmenySmeru {
    int x;
    int y;
    int sirka;
    int vyska;
    public MistaZmenySmeru(int x, int y, int sirka, int vyska){
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
    }
    public void vykresliSe(Graphics g){
        g.setColor(Color.CYAN);
        g.drawRect(x, y, sirka, vyska);
    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, sirka, vyska);
    }
}
