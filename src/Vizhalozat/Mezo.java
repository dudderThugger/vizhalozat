package Vizhalozat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Mezo {
    protected Szkeleton szkeleton;
    protected ArrayList<Mezo> szomszedok;
    protected Jatek jatek;
    protected ArrayList<Jatekos> rajtaAllnak;
    protected boolean telitett;

    public Mezo(Jatek jatek, Szkeleton szkeleton) {
        this.jatek = jatek;
        this.telitett = false;
        szomszedok = new ArrayList<Mezo>();
        this.szkeleton = szkeleton;
    }
    public void lelep(Jatekos j) {}
    public boolean ralep(Jatekos j) { return false;}
    public ArrayList<Mezo> getSzomszedok() {
        szkeleton.hivas(this, "getSzomszedok");
        szkeleton.visszateres(this, "getSzomszedok", "szomszedok");
        return szomszedok;
    }
    public void addSzomszed(Mezo m) {
        szkeleton.hivas(this, "addSzomszed");
        szkeleton.visszateres(this, "addSzomszed");
        szomszedok.add(m);
    }
    public void removeSzomszed(Mezo m) {
        szkeleton.hivas(this, "removeSzomszed");
        szkeleton.visszateres(this, "removeSzomszed");
        szomszedok.remove(m);
    }
    public abstract boolean felveszik();
    public abstract void befolyik();
    public abstract boolean pumpaLehelyez(Pumpa p);
    public abstract boolean foltoz();
    public abstract boolean lyukaszt();
    public abstract Pumpa pumpaVasarlas();
    public abstract boolean atAllit(Cso be, Cso ki);
    public abstract boolean javitjak();
    public abstract boolean csoLehelyezes(Cso cs);
}
