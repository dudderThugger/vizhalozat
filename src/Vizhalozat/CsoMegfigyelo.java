package Vizhalozat;

import java.awt.*;

public class CsoMegfigyelo extends Megfigyelo {
    public CsoMegfigyelo(Cso cso, Point hova) {
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
