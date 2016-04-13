import hra.oknoHry;

import java.awt.*;

/**
 * Created by Admin on 7.4.2016.
 */
public class HighScore {
    private String jmeno;
    private oknoHry vokno;
    String[] highScoreJmena =  new String[10];
    int[] highScore = new int[10];
    private int x;
    private int y;
    public HighScore(){
    }
    public void vykresleni(Graphics g){
        for (int i = 0; i < highScoreJmena.length ; i++) {
            g.drawString(highScoreJmena[i], x, y );
        }
    }
    public void nacteniSCore(){

    }
}
