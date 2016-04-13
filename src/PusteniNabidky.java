import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 28.3.2016.
 */
public class PusteniNabidky extends JFrame{
    public PusteniNabidky(){
        setTitle("hra.Nabidka");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 500));
        //hra.Nabidka vokno = new hra.Nabidka(this);
        //add(vokno);
        setResizable(false);
        pack();
        return;
    }
    public static void main(String[] args) {
        new PusteniNabidky().setVisible(true);
    }
}
