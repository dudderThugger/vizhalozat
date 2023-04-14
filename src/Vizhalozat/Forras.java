package Vizhalozat;

/**
 *
 */
public class Forras extends AktivElemek{
    public Forras(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
    }

    @Override
    public boolean felveszik() {
        szkeleton.hivas(this, "felveszik");
        szkeleton.visszateres(this, "felveszik");
        return false;
    }

    public void vizTermeles() {
        szkeleton.hivas(this, "vizTermeles");
        for(Mezo szomszed : szomszedok) {
            szomszed.befolyik();
        }
        szkeleton.visszateres(this, "vizTermeles");
    }

    @Override
    public void befolyik() {
        szkeleton.hivas(this, "befolyik");
        szkeleton.visszateres(this, "befolyik");
    }

    @Override
    public boolean atAllit(Cso be, Cso ki) {
        szkeleton.hivas(this, "atAllit");
        szkeleton.visszateres(this, "atAllit");
        return false;
    }

    @Override
    public boolean javitjak() {
        szkeleton.hivas(this, "javitjak");
        szkeleton.visszateres(this, "javitjak");
        return false;
    }
}
