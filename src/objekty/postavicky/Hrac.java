package objekty.postavicky;

import okna.oknoHry;
import urovne.Engine;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Hrac implements KeyListener{
    private Color barva = Color.WHITE;
    private final int vyskaKruhu = 15;
    private final int sirkaKruhu = 15;
    public int x, y, smerX, smerY, zivoty, rychlostHrace;
    private oknoHry vokno;
    private Engine aktualniUroven;
    private boolean poh = true;
    public Hrac(oknoHry vokno){
        //this.vokno = new okna.oknoHry();
        this.vokno = vokno;
        x = 130;
        y = 230;
        zivoty = 3;
        rychlostHrace = 1;
    }
    public void vykresliSe(Graphics g){
        g.setColor(barva);
        g.fillOval(x, y, sirkaKruhu, vyskaKruhu);
        g.setColor(Color.black);
        g.drawOval(x, y, sirkaKruhu, vyskaKruhu);
    }
    public void move() {
        if(!kontrolaKolize(x+smerX, y+smerY)){
            x += smerX;
            y += smerY;
        }
    }
    public boolean kontrolaKolize(int x, int y) {
        //v okne zprava
        if ((x >= vokno.getSIRKA_PANELU() - (sirkaKruhu + 1)) && (vokno.getSIRKA_PANELU() > 0)) {
            return true;
        }
        if ((y >= vokno.getVYSKA_PANELU() - (vyskaKruhu + 1)) && (vokno.getVYSKA_PANELU() > 0)) {
            return true;
        }
        if(x < 0 || y < 0){
            return true;
        }
            for (int i = 0; i < vokno.getAktualniUroven().pocetPrekazek(); i++) {
                if (new Rectangle(x - 1, y - 1, sirkaKruhu + 2, vyskaKruhu + 2).intersects(vokno.getAktualniUroven().getOkraje(i))) {
                    return true;
                }
            }
        return false;
    }
    @Override
    public void keyPressed(KeyEvent e){
        int klavesa = e.getKeyCode();
        if(klavesa == KeyEvent.VK_A || klavesa == KeyEvent.VK_LEFT){
                smerY = 0;
                smerX = -rychlostHrace;
        }else if(klavesa == KeyEvent.VK_W || klavesa == KeyEvent.VK_UP){
                smerX = 0;
                smerY = -rychlostHrace;
        }else if(klavesa == KeyEvent.VK_D || klavesa == KeyEvent.VK_RIGHT){
                smerY = 0;
                smerX = rychlostHrace;
        }else if(klavesa == KeyEvent.VK_S || klavesa == KeyEvent.VK_DOWN){
                smerX = 0;
                smerY = rychlostHrace;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int klavesa = e.getKeyCode();
        if(klavesa == KeyEvent.VK_A || klavesa == KeyEvent.VK_LEFT){
                smerY = 0;
                smerX = -rychlostHrace;
        }else if(klavesa == KeyEvent.VK_W || klavesa == KeyEvent.VK_UP){
                smerX = 0;
                smerY = -rychlostHrace;
        }else if(klavesa == KeyEvent.VK_D || klavesa == KeyEvent.VK_RIGHT){
                smerY = 0;
                smerX = rychlostHrace;
        }else if(klavesa == KeyEvent.VK_S || klavesa == KeyEvent.VK_DOWN){
                smerX = 0;
                smerY = rychlostHrace;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, sirkaKruhu, vyskaKruhu);
    }

}
