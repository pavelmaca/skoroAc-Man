import java.awt.*;
public class Prekazky {
    private final int DELKASTRANY = 5;
    private int x, y;
    private boolean viditelny = true;
    private Mojevokno vokno;
    public Prekazky(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void vykresliSe(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, DELKASTRANY, DELKASTRANY);
        g.setColor(Color.darkGray);
        g.fillRect(50, 40, 70, 210);
        g.setColor(Color.YELLOW);
        g.drawRect(50, 40, 70, 210);
        g.setColor(Color.darkGray);
        g.fillRect(150, 40, 100, 90);
        g.setColor(Color.YELLOW);
        g.drawRect(150, 40, 100, 90);
        g.setColor(Color.darkGray);
        g.fillRect(150, 160, 100, 90);
        g.setColor(Color.YELLOW);
        g.drawRect(150, 160, 100, 90);
        g.setColor(Color.darkGray);
        g.fillRect(50, 280, 200, 60);
        g.setColor(Color.YELLOW);
        g.drawRect(50, 280, 200, 60);
        g.setColor(Color.darkGray);
        g.fillRect(50, 370, 95, 60);
        g.setColor(Color.YELLOW);
        g.drawRect(50, 370, 95, 60);
        g.setColor(Color.darkGray);
        g.fillRect(180, 370, 70, 60);
        g.setColor(Color.YELLOW);
        g.drawRect(180, 370, 70, 60);
    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, DELKASTRANY, DELKASTRANY);
    }
    public Rectangle getOkraje1(){return new Rectangle(50, 40, 70, 210);}
    public Rectangle getOkraje2(){
        return new Rectangle(150, 40, 100, 90);
    }
    public Rectangle getOkraje3(){
        return new Rectangle(150, 160, 100, 90);
    }
    public Rectangle getOkraje4(){
        return new Rectangle(50, 280, 200, 60);
    }
    public Rectangle getOkraje5(){
        return new Rectangle(50, 370, 95, 60);
    }
    public Rectangle getOkraje6(){
        return new Rectangle(180, 370, 70, 60);
    }

    public boolean isViditelny(){
        return viditelny;
    }
    public void skryt(){
        //vokno.score++;
        viditelny = false;
    }

    public void removeIf(boolean intersects) {

    }
}
