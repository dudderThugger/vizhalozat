package Vizhalozat;

/**
 * Forrás osztály felelős a víz elindításáért (folyatásáért) a szomszédos mezőkbe
 */
public class Forras extends AktivElemek{
    public Forras(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
    }

    /**
     * Biztosan false-al tér vissza, mivel nem felet felvenni
     * @return mindig false
     */
    @Override
    public boolean felveszik() {
        szkeleton.hivas(this, "felveszik");
        szkeleton.visszateres(this, "felveszik");
        return false;
    }

    /**
     * Víz folyatás szomszédos mezőkbe
     */
    public void vizTermeles() {
        szkeleton.hivas(this, "vizTermeles");
        for(Mezo szomszed : szomszedok) {
            szomszed.befolyik();
        }
        szkeleton.visszateres(this, "vizTermeles");
    }

    /**
     * Override-olja az ősosztály függvényét
     */
    @Override
    public void befolyik() {
        szkeleton.hivas(this, "befolyik");
        szkeleton.visszateres(this, "befolyik");
    }

    /**
     * Mindig false-al tér vissza, mivel a forrást nem lehet átállítani
     * @param be A forrás új bemenete
     * @param ki A forrás új kimenete
     * @return Mindig false
     */
    @Override
    public boolean atAllit(Cso be, Cso ki) {
        szkeleton.hivas(this, "atAllit");
        szkeleton.visszateres(this, "atAllit");
        return false;
    }

    /**
     * Mindig false-al tér vissza, mivel a forrást nem lehet javítani
     * @return Mindig false
     */
    @Override
    public boolean javitjak() {
        szkeleton.hivas(this, "javitjak");
        szkeleton.visszateres(this, "javitjak");
        return false;
    }
}
