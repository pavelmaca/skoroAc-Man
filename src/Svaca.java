import java.awt.*;
public class Svaca {
    private final int DELKASTRANY = 5;
    private int x, y;
    private boolean viditelny = true;
    public Svaca(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void vykresliSeSvaca(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, DELKASTRANY, DELKASTRANY);

    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, DELKASTRANY, DELKASTRANY);
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
