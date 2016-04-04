package urovne;

import java.awt.*;

/**
 * Created by Admin on 4.4.2016.
 */
public class Uroven1 {
    private int[][] parametryPrekazek = {
            {50, 40, 70, 210},
            {150, 40, 100, 90},
            {150, 160, 100, 90},
            {50, 280, 200, 60},
            {50, 370, 95, 60},
            {180, 370, 70, 60}
    };
    private int pocet;
    public int pocetPrekazek(){
        return parametryPrekazek.length;
    }
    public void vykresliPrekazky(Graphics g) {
        for (int i = 0; i < parametryPrekazek.length; i++) {
            int[] parametryPrekazky = parametryPrekazek[i];
            g.setColor(Color.darkGray);
            g.fillRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
            g.setColor(Color.YELLOW);
            g.drawRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
        }
    }

    public Rectangle getOkraje(int i) {
        return new Rectangle(parametryPrekazek[i][0], parametryPrekazek[i][1], parametryPrekazek[i][2], parametryPrekazek[i][3]);
    }
}
