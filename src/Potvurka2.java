import java.awt.*;
public class Potvurka2 {
    private int pp1, pp2, smerX, smerY, rychlost, cislo;
    private Mojevokno vokno;
    private Prekazky smerr;
    public Potvurka2(Mojevokno mojevokno) {
        this.vokno = vokno;
        this.smerr = smerr;
        Bod1();
    }
    public void Bod1() {
        pp1 = 25;
        pp2 = 23;
        rychlost = 2;
        polohaPotvurky();
    }
    public void polohaPotvurky(){
        pp2 += smerY;
        smerY = rychlost;
        if(pp2 < 5){
            rychlost = 2;
        }
        if(pp2 > 455){
            rychlost = - 2;
        }
    }
    public void kresleniPotvurky2(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(pp1, pp2, 20, 20);
    }
    public Rectangle getOkrajePP2(){
        return new Rectangle(pp1, pp2, 20, 20);
    }
}
