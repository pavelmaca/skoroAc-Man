package urovne;

import jidlo.Svaca;

import java.awt.*;
import java.util.ArrayList;

/**
 * This abstract class includes all of thinks witch have all class in share.
 * For example Pac-Man's pills, power pill(if power pill exist), walls, ghosts & player's figure.
 */
abstract public class Uroven {
    protected int[][] parametryPrekazek;
    protected Color barvaVnitrku;
    protected Color barvaOkraje;
    public int pocetPrekazek(){
        return parametryPrekazek.length;
    }
    //public int pocetPotvurek(){return parametryPotvurek.lenght;}
    public ArrayList<Svaca> jidlo = new ArrayList<Svaca>();
    //protected int x;
    //protected int y;
    protected int POCET_CTVERCU;
    public int POCET_KONTROLNICH_CTVERCU;
    public Uroven(){
        POCET_CTVERCU = 150;
        POCET_KONTROLNICH_CTVERCU = 150;
        vytvoreniJidla();
    }

    /**
     * Method witch create a pills. It works like an array list.
     */
    private void vytvoreniJidla(){
        int y = 25;
        for(int i = 0;i < 15;i++){
            int x = 10;
            for(int k = 0;k < 10;k++) {
                x = x + 25;
                Svaca p = new Svaca(x, y);
                jidlo.add(p);
            }
            y = y + 30;
        }
    }

    /**
     * Method with paint walls.
     * @param g
     */
    private void vykresliPrekazky(Graphics g) {
        for (int i = 0; i < parametryPrekazek.length; i++) {
            int[] parametryPrekazky = parametryPrekazek[i];
            g.setColor(barvaVnitrku);
            g.fillRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
            g.setColor(barvaOkraje);
            g.drawRect(parametryPrekazky[0], parametryPrekazky[1], parametryPrekazky[2], parametryPrekazky[3]);
        }
    }

    /**
     * Method paints actual level. Here the picture of level gets together from smaller parts.
     * @param g
     */
    public void vykresliUroven(Graphics g){
        vykresliPrekazky(g);
        vykresliJidlo(g);
        //if()
    }

    /**
     * Method, witch draws pills.
     * @param g
     */
    private void vykresliJidlo(Graphics g){
        for (int i = 0; i < POCET_CTVERCU; i++) {
            if (jidlo.get(i).isViditelny()) {
                jidlo.get(i).vykresliSeSvaca(g);
            } else {
                g.setColor(Color.RED);
            }
        }
    }
    /**
    private void vykresliPostavicky(Graphics g){
        for (int i = 0; i < parametryPotvurek.lenght; i++) {

        }
    }
    */
    /**
     * Method witch gets space for every wall.
     * @param i index of wall
     * @return Rectangle
     */
    public Rectangle getOkraje(int i) {
        return new Rectangle((parametryPrekazek[i][0]), (parametryPrekazek[i][1]), (parametryPrekazek[i][2]), (parametryPrekazek[i][3]));
    }
}

