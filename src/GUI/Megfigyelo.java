package GUI;


import java.awt.*;

/**
 * A Megfigyelő a rajzoláshoz elengedhetetlen  absztrakt osztály. Definiál egy  absztrakt draw függvényt, melyet minden
 * leszármazott osztálynak meg kell valósítania.
 */
public abstract class Megfigyelo {
    protected Point coordinate;
    JatekPanel panel;
    protected boolean selected = false; /**azt jelöli, hogy az adott megfigyelő éppen ki van jelölve vagy nincs, alapból hamis*/
    public Megfigyelo(JatekPanel panel) {
        this.panel = panel;
    }

    public abstract  void draw(Graphics g); /**A rajzolásért felelős absztrakt metódus. Egy Graphics paramétert kap,
     amely lehetővé teszi a rajzolási műveletek végrehajtását.*/
    public abstract boolean intersect(int x, int y); /**Eldönti, hogy az adott pont benne van-e a megfigyelt alakzatban.*/

    protected void setSelected(boolean b) {selected = b;}
    public Point getCoordinate() {
        return coordinate;
    }
    public abstract Object getObserved();
}
