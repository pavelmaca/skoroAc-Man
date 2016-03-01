import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class PozorKolize implements KeyListener{
    private Color barva = Color.WHITE;
    private final int vyskaKruhu = 15;
    private final int sirkaKruhu = 15;
    private int x, y, smerX, smerY, zivoty, rychlost;
    private Prekazky prekazky;
    private OkrajeP1 p1;
    private Mojevokno vokno;
    public PozorKolize(Mojevokno vokno){
        rychlost = 1;
        this.vokno = vokno;
        x = 130;
        y = 230;
        zivoty = 3;
    }
    public void vykresliSe(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(x, y, sirkaKruhu, vyskaKruhu);
        g.setColor(barva);
        g.fillOval(x, y, sirkaKruhu, vyskaKruhu);
        g.setColor(Color.black);
        g.drawOval(x, y, sirkaKruhu, vyskaKruhu);
    }
    public void move(){
        x += smerX;
        y += smerY;
        if ((x >= vokno.getSIRKA_PANELU() - (sirkaKruhu + 1)) && (vokno.getSIRKA_PANELU() > 0)){
            x = vokno.getSIRKA_PANELU() - (sirkaKruhu + 1);
        }
        if(25 < y && y < 250){
            if(36 > x && x > 34){
                x = 34;
            }
        }
        if(25 < y && y < 250){
            if(36 < x && x < 121){
                x = 121;
            }
        }
        if(25 < y && y < 130){
            if(x > 134 && x < 136){
                x = 134;
            }
        }
        if(25 < y && y < 130){
            if(x > 137 && x < 251){
                x = 251;
            }
        }
        if(144 < y && y < 250){
            if(151 > x && x > 134){
                x = 134;
            }
        }
        if(144 < y && y < 250){
            if(155 < x && x < 251){
                x = 251;
            }
        }
        if(264 < y && y < 341){
            if(x < 36 && x > 34){
                x = 34;
            }
        }
        if(355 < y && y < 430){
            if(181 > x && x > 179){
                x = 179;
            }
        }
        if(355 < y && y < 430){
            if(x > 185 && x < 251){
                x = 251;
            }
        }
        if(355 < y && y < 430){
            if(37 < x && x < 250){
                x = 251;
            }
        }
        if(264 < y && y < 341){
            if(x < 251 && x > 37){
                x = 251;
            }
        }
        if(355 < y && y < 430){
            if(146 > x && x > 143){
                x = 146;
            }
        }
        if (x <= 0) {
            x = 0;
        }
        if ((y >= vokno.getVYSKA_PANELU() - (vyskaKruhu + 1)) && (vokno.getVYSKA_PANELU() > 0)) {
            y = vokno.getVYSKA_PANELU() - (vyskaKruhu + 1);
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 249){
                y = 24;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 251){
                y = 251;
            }
        }
        if(x > 135 && x < 250){
            if(y > 24 && y < 129){
                y = 24;
            }
        }
        if(x > 135 && x < 250){
            if(y > 24 && y < 131){
                y = 131;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 249){
                y = 24;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 251){
                y = 251;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 249){
                y = 24;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 251){
                y = 251;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 249){
                y = 24;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 251){
                y = 251;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 249){
                y = 24;
            }
        }
        if(x > 35 && x < 121){
            if(y > 24 && y < 251){
                y = 251;
            }
        }
        if (y <= 0) {
            y = 0;
        }
    }
    @Override
    public void keyPressed(KeyEvent e){
        int klavesa = e.getKeyCode();
        if(klavesa == KeyEvent.VK_A || klavesa == KeyEvent.VK_LEFT){
            smerY = 0;
            smerX = -rychlost;
        }else if(klavesa == KeyEvent.VK_W || klavesa == KeyEvent.VK_UP){
            smerX = 0;
            smerY = -rychlost;
        }else if(klavesa == KeyEvent.VK_D || klavesa == KeyEvent.VK_RIGHT){
            smerY = 0;
            smerX = rychlost;
        }else if(klavesa == KeyEvent.VK_S || klavesa == KeyEvent.VK_DOWN){
            smerX = 0;
            smerY = rychlost;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int klavesa = e.getKeyCode();
        if(klavesa == KeyEvent.VK_A || klavesa == KeyEvent.VK_LEFT){
            smerY = 0;
            smerX = -rychlost;
        }else if(klavesa == KeyEvent.VK_W || klavesa == KeyEvent.VK_UP){
            smerX = 0;
            smerY = -rychlost;
        }else if(klavesa == KeyEvent.VK_D || klavesa == KeyEvent.VK_RIGHT){
            smerY = 0;
            smerX = rychlost;
        }else if(klavesa == KeyEvent.VK_S || klavesa == KeyEvent.VK_DOWN){
            smerX = 0;
            smerY = rychlost;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, sirkaKruhu, vyskaKruhu);
    }
}
