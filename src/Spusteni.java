import javax.swing.*;
import java.awt.*;
public class Spusteni extends JFrame {
    public Spusteni(){
        setTitle("Hra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 500));
        Mojevokno vokno = new Mojevokno();
        add(vokno);
        setResizable(false);
        pack();
        return;
    }
    public static void main(String[] args) {
        new Spusteni().setVisible(true);
    }
}
