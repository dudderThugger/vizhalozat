package Vizhalozat;

import java.awt.*;

public class SzabotorMegfigyelo extends Megfigyelo {
    public SzabotorMegfigyelo(Szabotor szabotor, Point hova) {
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
