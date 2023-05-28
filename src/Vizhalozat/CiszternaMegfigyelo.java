package Vizhalozat;

import java.awt.*;

public class CiszternaMegfigyelo extends Megfigyelo {
    public CiszternaMegfigyelo(Ciszterna ciszterna, Point hova) {
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
