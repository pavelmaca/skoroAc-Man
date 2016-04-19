package hra;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by Admin on 24.3.2016.
 */
public class Nabidka extends JPanel implements ActionListener{
    private Spusteni program;
    private Object g;
    public Nabidka(Spusteni program){
        setBackground(Color.BLUE);
        Button start = new Button("Spustit");
        Button nejlepsich10 = new Button("Nejlepších 10");
        //Button pribeh = new Button("Příběh");
        //Button  navod = new Button("Návod");
        //Button tvurce = new Button("Tvůrce");
        Button vypnout = new Button("Vypnout");
        add(start);
        add(nejlepsich10);
        //add(pribeh);
        //add(navod);
        //add(tvurce);
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
        if (pri.equals("Příběh")) {

        }
        if (pri.equals("Návod")) {

        }
        if (pri.equals("Tvůrce")) {

        }
        if(pri.equals("Vypnout")){
            program.dispose();
        }
    }
}
