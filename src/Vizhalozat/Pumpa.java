package Vizhalozat;

public class Pumpa extends AktivElemek implements Viheto{
    private boolean mukodik;
    private Cso bemenet;
    private Cso kimenet;
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
    public void set_Be(Cso cs){
        this.bemenet = cs;
    }
    @Override
    public boolean csoLehelyezes(Cso cs) {
        szkeleton.hivas(this, "csoLehelyezes");
        this.addSzomszed(cs);
        szkeleton.visszateres(this, "csoLehelyezes", "true");
        return true;
    }

    @Override
    public void lerakjak(Jatekos lerako) {
        szkeleton.hivas(this, "lerakjak");
        szkeleton.visszateres(this, "lerakjak");
    }
}
