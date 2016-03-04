import java.awt.*;

/**
 * Created by Admin on 4.3.2016.
 */
public class Potvurka {
    private int pp1, pp2;

    public Potvurka(Mojevokno mojevokno) {
        pp1 = 150;
        pp2 = 350;
    }

    public void polohaPotvurky(){
    }
    public void kresleniPotvurky1(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(pp1, pp2, 20, 20);
    }
    public Rectangle getOkrajePP1(){
        return new Rectangle(pp1, pp2, 20, 20);
    }
}
