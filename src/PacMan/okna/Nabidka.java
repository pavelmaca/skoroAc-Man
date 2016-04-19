package PacMan.okna;

import PacMan.Grafika;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Admin on 24.3.2016.
 */
public class Nabidka extends JPanel implements ActionListener {
    private Grafika okno;
    final private String TLACITKO_SPUSTIT = "Spustit";
    final private String TLACITKO_VYPNOUT = "Vypnout";

    public Nabidka(Grafika okno) {
        setBackground(Color.BLUE);
        Button start = new Button(TLACITKO_SPUSTIT);
        //Button nejlepsich10 = new Button("Nejlepších 10");
        Button vypnout = new Button(TLACITKO_VYPNOUT);
        add(start);
        //add(nejlepsich10);
        add(vypnout);
        start.addActionListener(this);
        vypnout.addActionListener(this);
        this.okno = okno;
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String pri = ae.getActionCommand();
        if (pri.equals(TLACITKO_SPUSTIT)) {
            okno.otevriHru();
        }
        if (pri.equals(TLACITKO_VYPNOUT)) {
            okno.dispose();
        }
    }
}
