package GUI;

import Vizhalozat.AktivElemek;
import Vizhalozat.Mezo;

public abstract class MezoMegfigyelo extends Megfigyelo{
    Mezo observed;
    public MezoMegfigyelo(Mezo mezo, Point coordinate, JatekPanel panel) {
        super(panel);
        observed = mezo;
        this.coordinate = coordinate;
    }
    public Mezo getObserved() {
        return observed;
    }
}
