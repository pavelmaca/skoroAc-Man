import java.awt.*;

/**
 * Created by Admin on 24.3.2016.
 */
public class SuperJidlo {
    private int souradniceX, souradniceY, cislo;
    private final int velikost = 10;
    private boolean viditelny = true;
    private Level1 vokno;
    public SuperJidlo(){
        umisteni();
    }
    public void umisteni(){
        souradniceX = 50;
        souradniceY = 20;
    }
    public void vykresleniSuperJidla(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(souradniceX, souradniceY, velikost, velikost);
    }
    public boolean isViditelny(){
        return viditelny;
    }
    public void skryt(){
        viditelny = false;
    }
}
