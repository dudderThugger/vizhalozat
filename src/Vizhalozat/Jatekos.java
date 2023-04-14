package Vizhalozat;

public abstract class Jatekos {
    protected Szkeleton szkeleton;
    protected Jatek jatek;
    protected Viheto tart;
    protected Cso csoTart;
    protected Mezo rajtaAll;

    public Jatekos(Mezo rajtaAll, Szkeleton szkeleton) {
        this.rajtaAll = rajtaAll;
        this.szkeleton = szkeleton;
    }

    public abstract void lerak_pumpa();
}
