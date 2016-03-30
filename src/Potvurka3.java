import java.awt.*;

/**
 * Created by Admin on 23.3.2016.
 */
public class Potvurka3 {
    private int x;
    private int y;
    private int rychlost;
    private int smerY;
    public Potvurka3(Level1 level1){
        vychoziPoloha();
    }
    public void vychoziPoloha(){
        this.x = 255;
        this.y = 443;
        rychlost = -3;
        pohyb();
    }
    public void pohyb(){
        if(y <= 0){
            vychoziPoloha();
        }else{
            smerY = rychlost;
            y += rychlost;
        }
    }
    public void vykresleniPotvurky3(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 20, 20);
    }
    public Rectangle getOkrajePP3(){
        return new Rectangle(x, y, 20, 20);
    }
}
