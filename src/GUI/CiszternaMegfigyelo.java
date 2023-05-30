package GUI;

import Vizhalozat.Ciszterna;

import java.awt.*;

public class CiszternaMegfigyelo extends AktivMegfigyelo {
    public CiszternaMegfigyelo(Ciszterna ciszterna, Point hova, JatekPanel panel) {
        super(ciszterna, hova, panel);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public boolean intersect(int x, int y) {
        return false;
    }
}
