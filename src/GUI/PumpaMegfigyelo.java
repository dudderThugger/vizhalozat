package GUI;

import Vizhalozat.Pumpa;

import java.awt.*;

public class PumpaMegfigyelo extends AktivMegfigyelo {
    public PumpaMegfigyelo(Pumpa pumpa, Point hova, JatekPanel panel) {
        super(pumpa, hova, panel);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public boolean intersect(int x, int y) {
        return false;
    }
}
