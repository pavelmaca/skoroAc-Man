package urovne;

import java.awt.*;

/**
 * Created by Admin on 4.4.2016.
 */
public class Uroven1 extends Uroven {
    public Uroven1(){
        parametryPrekazek = new int[][]{
                {50, 40, 70, 210},
                {150, 40, 100, 90},
                {150, 160, 100, 90},
                {50, 280, 200, 60},
                {50, 370, 95, 60},
                {180, 370, 70, 60}
        };
        barvaVnitrku = Color.DARK_GRAY;
        barvaOkraje = Color.YELLOW;

    }
    public void vykresliSuperJidlo(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(133, 200, 10, 10);
    }
}
