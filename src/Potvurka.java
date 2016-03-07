import java.awt.*;
import java.util.Random;
/**
 * Created by Admin on 4.3.2016.
 */
public class Potvurka {
    private int pp1, pp2, smerX, smerY, rychlost, cislo;
    private Mojevokno vokno;
    private Random generator = new Random();
    public Potvurka(Mojevokno mojevokno) {
        this.vokno = vokno;
        polohaPotvurky();
    }
    public void Bod1(){
        pp1 = 150;
        pp2 = 346;
        rychlost = 2;
        generovani();
        polohaPotvurky1();
    }
    public int generovani(){
        cislo = generator.nextInt(4) + 1;
        if(cislo == 1){
            smerY = 0;
            smerX = -rychlost;
        }else{
            if(cislo == 2){
                smerX = 0;
                smerY = rychlost;
            }else{
                if(cislo == 3){
                    smerY = 0;
                    smerX = rychlost;
                }else{
                    if(cislo == 4){
                        smerX = 0;
                        smerY = -rychlost;
                    }
                }
            }
        }
        //System.out.println(cislo);
        return cislo;
    }

    private void generator() {
    }
    public void polohaPotvurky(){
        Bod1();
    }
    public void polohaPotvurky1(){
        pp1 += smerX;
        pp2 += smerY;
        omezeniZ1();
    }
    public void polohaPotvurky2(){
        pp1 += smerX;
        pp2 += smerY;
        omezeniZ2();
    }
    public void omezeniZ1(){
        if(pp1 > 255){
            //pp1 = 255;
            smerX = 0;
            bod4();
        }
        if(pp1 < 25){
            //pp1 = 25;
            smerX = 0;
            bod2();
        }
        if(pp2 > 435){
            //pp2 = 450;
            smerY = 0;
            bod3();
        }
        if(pp2 < 346){
            generovani();
        }
    }
    public void bod2(){
        generovani();
        polohaPotvurky2();
    }
    public void omezeniZ2(){
        if(pp2 > 435){
            smerY = 0;
        }
        if(pp2 < 35){
            smerY = 0;
        }
        if(pp1 < 25){
            smerX = 0;
        }
        if(pp1 > 150){
            Bod1();
        }
    }
    public void bod3(){
        generovani();
        polohoPotvurky3();
    }
    public void polohoPotvurky3(){
        smerX += rychlost;
        smerY += rychlost;
        omezeniZ3();
    }
    public void omezeniZ3(){
        if(pp2 > 435){
            pp2 = 435;
            generovani();
        }
        if(pp1 < 25){
            smerX = 0;
        }
        if(pp1 > 255) {
            smerX = 0;
        }
        if(pp2 < 346);
        Bod1();
    }
    public void bod4(){
        generovani();
        //polohaPotvurky4();
    }
    public void omezeniZ4(){

    }
    public void kresleniPotvurky1(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(pp1, pp2, 20, 20);
    }
    public Rectangle getOkrajePP1(){
        return new Rectangle(pp1, pp2, 20, 20);
    }
}
