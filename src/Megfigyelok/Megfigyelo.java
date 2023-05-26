package Megfigyelok;

import javax.swing.*;
import java.awt.*;

/**
 * A Megfigyelő a rajzoláshoz elengedhetetlen  absztrakt osztály. Definiál egy  absztrakt draw függvényt, melyet minden leszármazott osztálynak meg kell valósítania.
 */
public abstract class Megfigyelo {

    protected Point coordinates; /**a megfigyelt objektum pozíciója*/
    protected boolean selected = false; /**azt jelöli, hogy az adott megfigyelő éppen ki van jelölve vagy nincs, alapból hamis*/

    public Megfigyelo( Point p) {
        coordinates = p;
    }

    public abstract  void draw(Graphics g); /**A rajzolásért felelős absztrakt metódus. Egy Graphics paramétert kap, amely lehetővé teszi a rajzolási műveletek végrehajtását.*/
    public abstract boolean intersect(int x, int y); /**Eldönti, hogy az adott pont benne van-e a megfigyelt alakzatban.*/
}
