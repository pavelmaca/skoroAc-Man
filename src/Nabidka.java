import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Admin on 24.3.2016.
 */
public class Nabidka extends JPanel implements ActionListener{
    private Spusteni program;
    private Object g;
    public Nabidka(Spusteni program){
        Button start = new Button("Spustit");
        Button vypnout = new Button("Vypnout");
        add(start);
        add(vypnout);
        start.addActionListener(this);
        vypnout.addActionListener(this);
        this.program = program;
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String pri = ae.getActionCommand();
        if (pri.equals("Spustit")) {
            program.otevriLevel1();
        }
        if(pri.equals("Vypnout")){
            program.dispose();
        }
    }
}
