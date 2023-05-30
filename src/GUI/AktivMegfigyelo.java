package GUI;

import Vizhalozat.AktivElemek;

import java.awt.*;

public abstract class AktivMegfigyelo extends Megfigyelo{
    protected Point coordinate;
    AktivElemek observed;
    public AktivMegfigyelo(AktivElemek aktiv, Point coordinate, JatekPanel panel) {
        super(panel);
        observed = aktiv;
        this.coordinate = coordinate;
    }
    public AktivElemek getObserved() {
        return observed;
    }
    public Point getCoordinate() {
        return coordinate;
    }
}
