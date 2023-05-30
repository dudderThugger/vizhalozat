package GUI;

import Vizhalozat.Pumpa;

import java.awt.*;

public class PumpaMegfigyelo extends Megfigyelo {
    public PumpaMegfigyelo(Pumpa pumpa, Point hova) {
        super(hova);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public boolean intersect(int x, int y) {
        return false;
    }
}
