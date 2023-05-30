package Vizhalozat;

/**
 * Forrás osztály felelős a víz elindításáért (folyatásáért) a szomszédos mezőkbe
 */
public class Forras extends AktivElemek{
    public Forras(Jatek jatek) { super(jatek); }

    /**
     * Biztosan false-al tér vissza, mivel nem felet felvenni
     * @return mindig false
     */
    @Override
    public boolean felveszik() {
        return false;
    }

    /**
     * Víz folyatás szomszédos mezőkbe
     */
    public void vizTermeles() {
        telitett = true;
        for (Mezo m: szomszedok) {
            m.befolyik();
        }
    }

    /**
     * Override-olja az ősosztály függvényét
     */
    @Override
    public void befolyik() {
        if (!telitett) {
            telitett = true;
            for (Mezo szomszed : szomszedok) {
                    szomszed.befolyik();
            }
        }
    }

    /**
     * Mindig false-al tér vissza, mivel a forrást nem lehet átállítani
     * @param be A forrás új bemenete
     * @param ki A forrás új kimenete
     * @return Mindig false
     */
    @Override
    public boolean atAllit(Cso be, Cso ki) {
        return false;
    }

    /**
     * Mindig false-al tér vissza, mivel a forrást nem lehet javítani
     * @return Mindig false
     */
    @Override
    public boolean javitjak() {
        return false;
    }

    @Override
    public Mezo megcsuszik() {
        return null;
    }

    @Override
    public boolean ragaszt() {
        return false;
    }

    @Override
    public boolean csuszik() {
        return false;
    }
}
