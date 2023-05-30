package GUI;

import Vizhalozat.Cso;
import Vizhalozat.Mezo;

import java.awt.*;
import java.util.ArrayList;

public class CsoMegfigyelo extends MezoMegfigyelo {
    private Cso observed;
    public CsoMegfigyelo(Cso cso, JatekPanel panel) {
        super(cso, new Point(0, 0), panel);
        this.observed = cso;
    }

    @Override
    public void draw(Graphics g) {
        ArrayList<Mezo> szomszedok = observed.getSzomszedok();
        if(szomszedok.size() == 2) {
            Point coordinate1 = panel.getObservedCoordinate(szomszedok.get(0));
            Point coordinate2 = panel.getObservedCoordinate(szomszedok.get(1));
            Graphics2D g2 = (Graphics2D)g;
            g2.setStroke(new BasicStroke(30));
            if(selected) {
                g2.setColor(Color.ORANGE);
                g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
            }
            else if(observed.isLyukas()){
                g2.setColor(Color.RED);
                g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
            }
            else if (observed.getTelitett()) {
                g2.setColor(Color.BLUE);
                g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
            } else {
                g2.setColor(Color.BLACK);
                g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
            }
        }
    }

    @Override
    public boolean intersect(int x, int y) {
        ArrayList<Mezo> szomszedok = observed.getSzomszedok();
        if (szomszedok.size() == 2) {
            Point coordinate1 = panel.getObservedCoordinate(szomszedok.get(0));
            Point coordinate2 = panel.getObservedCoordinate(szomszedok.get(1));
            int a = coordinate1.y - coordinate2.y;
            int b = coordinate2.x - coordinate1.x;
            int c = -(a * coordinate1.x + b * coordinate1.y);
            double d = (double)Math.abs(a * x + b * y + c) / Math.sqrt(a * a + b * b);
            if(d < 30) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    @Override
    public Point getCoordinate() {
        ArrayList<Mezo> szomszedok = observed.getSzomszedok();
        if (szomszedok.size() == 2) {
            Point coordinate1 = panel.getObservedCoordinate(szomszedok.get(0));
            Point coordinate2 = panel.getObservedCoordinate(szomszedok.get(1));
            return new Point(coordinate2.x + (coordinate1.x - coordinate2.x / 2), coordinate2.y + (coordinate1.y - coordinate2.y / 2));
        }
        return new Point(0, 0);
    }

    public Mezo getObserved(){return observed;}
}
