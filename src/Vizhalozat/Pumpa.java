package Vizhalozat;

public class Pumpa extends AktivElemek{
    private boolean mukodik;
    public Pumpa(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
        mukodik = true;
    }

    @Override
    public boolean felveszik() {
        return false;
    }

    @Override
    public void befolyik() {

    }

    @Override
    public boolean atAllit(Cso be, Cso ki) {
        return false;
    }

    @Override
    public boolean javitjak() {
        return false;
    }

    public void elromlik() {
        szkeleton.hivas(this, "elromlik");
        mukodik = false;
        szkeleton.visszateres(this, "elromlik");
    }
}
