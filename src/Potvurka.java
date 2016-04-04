import java.awt.*;
public class Potvurka {
    private int pp1, pp2, smerX, smerY, rychlost, cislo;
    private oknoHry vokno;
    private Svaca smerr;
    public Potvurka(oknoHry oknoHry) {
        Bod1();
    }
    public void Bod1() {
        pp1 = 150;
        pp2 = 346;
        rychlost = 2;
        polohaPotvurky();
    }
    public void polohaPotvurky(){
        this.smerr = smerr;
        pp1 += smerX;
        smerX = rychlost;
        if(pp1 < 45){
            rychlost = 2;
        }
        if(pp1 > 235){
            rychlost = - 2;
        }
    }
    public void kresleniPotvurky1(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(pp1, pp2, 20, 20);
    }
    public Rectangle getOkrajePP1(){
        return new Rectangle(pp1, pp2, 20, 20);
    }
}
