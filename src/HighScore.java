import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Admin on 7.4.2016.
 */
public class HighScore {
    private String jmeno;
    private oknoHry vokno;
    String[] highScore =  new String[10];
    private int x;
    private int y;
    public HighScore(){
        x = 25;
        y = 25;
        for (int i = 0; i < highScore.length ; i++) {
            highScore[i] = "_ _ _ _ _ _ _.............................."+vokno.score;
            y +=25;
        }

    }
    public void vykresleni(Graphics g){
        for (int i = 0; i < highScore.length ; i++) {
            g.drawString(highScore[i], x, y );
        }
    }
}
