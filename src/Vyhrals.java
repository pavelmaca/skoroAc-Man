import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 18.2.2016.
 */
public class Vyhrals extends JPanel {
    private JLabel vyhra;
    public Vyhrals(){
        this.setFocusable(true);
        this.setBackground(Color.blue);
        this.setPreferredSize(new Dimension(300, 500));
    }
    public void vykresleniVyhry(Graphics g){
        g.setColor(Color.white);
        g.drawOval(15,38, 50, 50);
        g.drawString("V Y H R A L / A  J S I .", 57, 249);
    }
}
