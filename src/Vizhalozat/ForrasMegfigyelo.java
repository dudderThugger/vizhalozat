package Vizhalozat;

import java.awt.*;

public class ForrasMegfigyelo extends Megfigyelo {
    public ForrasMegfigyelo(Forras forras, Point hova) {
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
