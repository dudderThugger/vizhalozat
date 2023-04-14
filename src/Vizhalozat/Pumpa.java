package Vizhalozat;

public class Pumpa extends AktivElemek{
    private boolean mukodik;
    public Pumpa(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
        mukodik = true;
    }

    public void elromlik() {
        szkeleton.hivas(this, "elromlik");
        mukodik = false;
        szkeleton.visszateres(this, "elromlik");
    }
}
