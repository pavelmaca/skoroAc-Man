/**
 * Created by Admin on 16.2.2016.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class PrekazkyNepohyblivy {
    private int x1, x2, x3, x4, x5, y1, y2, y3, y4, y5, sirkaPrekazky1, sirkaPrekazky2, sirkaPrekazky3, vyskaPrekazky1, vyskaPrekazky2, vyskaPrekazky3;
    public PrekazkyNepohyblivy(){
        x1 = 25;
        y1 = 25;
        sirkaPrekazky1 = 25;
        vyskaPrekazky1 = 47;
        x2 = 47;
        y2 = 27;
        sirkaPrekazky2 = 49;
        vyskaPrekazky2 = 97;
        x3 = 35;
        y3 = 25;
        sirkaPrekazky3 = 25;
        vyskaPrekazky3 = 47;
        x4 = 250;
        y4 = 290;
        x5 = 170;
        y5 = 157;
    }
    public void vykresleniPrekazekNepohyblivych(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(25, 25, 9, 9);
        g.fillRect(37, 37, 9, 9);
        g.fillRect(75, 75, 9, 9);
        g.fillRect(95, 95, 9, 9);
        g.fillRect(127, 127, 9, 9);
    }
}
