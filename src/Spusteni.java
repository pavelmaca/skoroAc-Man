import javax.swing.*;
import java.awt.*;
public class Spusteni extends JFrame {
    public int poustec;
    public Nabidka nabidka;
    public Level1 hra = new Level1();
    public Spusteni(){
        setTitle("Žravá_koule");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 500));
        //add(vokno);
        //remove(vokno);
        //add(hra);
        setResizable(false);
        //pack();
        return;
    }
    public static void main(String[] args) {
        Spusteni program = new Spusteni();
        program.otevriNabidku();
        //program.otevriLevel1();
    }
    private void otevriNabidku(){
        nabidka = new Nabidka(this);
        //add(hra);
        //hra.setVisible(false);
        add(nabidka);
        pack();
        this.setVisible(true);
    }
    public void otevriLevel1(){
        nabidka.setVisible(false);
        add(hra);
        pack();
        hra.requestFocus();
        this.setVisible(true);
    }
}
