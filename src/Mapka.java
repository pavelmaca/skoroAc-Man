import objekty.jidlo.Svaca;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 16.2.2016.
 */
public class Mapka extends JPanel {
    private int sloupce = 30, radky = 50, velikostCtverce = 10, y = 0;
    private boolean nam;
    private Svaca[][] svaca = new Svaca[radky][sloupce];
    public Mapka(){
        setPreferredSize(new Dimension(sloupce * velikostCtverce, 50 * velikostCtverce));
        setBackground(Color.RED);
        for(int radek = 0; radek < radky; radek++){
            for(int sloupec = 0; sloupec < sloupce;sloupec++){
                svaca[radek][sloupec] = new Svaca((radek-1) * velikostCtverce, (sloupec - 1) * velikostCtverce);
            }
        }
    }
    public void nakres(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(0,0,velikostCtverce,velikostCtverce);
    }

    public static void main(String[] args) {
        new Mapka();
    }

}
