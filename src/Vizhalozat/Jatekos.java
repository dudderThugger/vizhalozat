package Vizhalozat;
import java.util.ArrayList;

/**
 * A játékot játszó játékosok absztrakt osztálya, definálja a közös akciókat.
 */
public abstract class Jatekos {
    protected Szkeleton szkeleton;
    protected Jatek jatek;
    protected Viheto tart;
    protected Cso csoTart;
    protected Mezo rajtaAll;

    /**
     * A játékos egyetlen konstruktora
     * @param rajtaAll A mező objektum referenciája
     * @param szkeleton A szkeleton, tesztelő osztály konstruktora
     */
    public Jatekos(Mezo rajtaAll, Szkeleton szkeleton) {
        this.rajtaAll = rajtaAll;
        this.szkeleton = szkeleton;
    }

    public void lerak_cso(){
        szkeleton.hivas(this,"lerak_cso");
        rajtaAll.csoLehelyezes(csoTart);
        szkeleton.visszateres(this,"lerak_cso");

    }
    public void felvesz_cso(Cso felvesz){
        szkeleton.hivas(this,"felvesz_cso");

        // itt at lehetne adni a Pumpat, amin a jatekos all, es akkor mehetne
        if(felvesz.felveszik()) {
            // remove jatekos.felvesz_cso()-ben van vagy a cso.felveszik()-ben
            rajtaAll.removeSzomszed(felvesz);
        }
        szkeleton.visszateres(this,"felvesz_cso");
    }
    public abstract void lerak_pumpa();

    public void add_Kezebe(Viheto t){
        this.tart = t;
    }

   abstract Pumpa get_PumpaTart();
}
