package Vizhalozat;

import java.util.ArrayList;

public class Mezo {
    protected Szkeleton szkeleton;
    protected ArrayList<Mezo> szomszedok;
    protected Jatek jatek;
    protected Jatekos rajtaAllnak;
    protected boolean telitett;

    public Mezo(Jatek jatek, Szkeleton szkeleton) {
        this.jatek = jatek;
        this.telitett = false;
        szomszedok = new ArrayList<Mezo>();
        this.szkeleton = szkeleton;
    }
}
