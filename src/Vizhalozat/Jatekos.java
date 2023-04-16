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
    protected int varakozasiIdo;

    /**
     * A játékos egyetlen konstruktora
     * @param rajtaAll A mező objektum referenciája
     * @param szkeleton A szkeleton, tesztelő osztály konstruktora
     */
    public Jatekos(Mezo rajtaAll, Szkeleton szkeleton) {
        this.rajtaAll = rajtaAll;
        this.szkeleton = szkeleton;
    }

    /**
     *  Megkísérli a lépést a paraméterként megadott mezőre,
     *  ha sikeres átáll arra a mezőre
     * @param m annak a Mezo-nek a referencuiája, ahova lépni akar
     */
    public void lepes(Mezo m){
        szkeleton.hivas(this, "lepes");
        szkeleton.visszateres(this, "lepes");
    }

    /**
     * megkísérli átállítani a mezőt, amin áll, csak pumpa mezőn hatásos
     */
    public void pumpaAllitas(){
        szkeleton.hivas(this, "pumpaAllitas");

        ArrayList<Mezo> szomszedok = rajtaAll.getSzomszedok();
        Cso[] csovek = new Cso[2];
        if(szomszedok.size() > 0) {
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= szomszedok.size(); j++) {
                    szkeleton.uzenet("Cső " + j);
                }
                int valasz = Integer.parseInt(szkeleton.kerdes(this, "Az " + (i + 1) + ". cső kiválasztása: (A fentiek közül)"));
                if (valasz > 0 && valasz <= szomszedok.size()) csovek[i] = (Cso) szomszedok.remove(valasz - 1);
                else {
                    System.out.println("Nem megfelelő válasz!");
                    i--;
                }
            }
        }

        rajtaAll.atAllit(csovek[0], csovek[1]);

        szkeleton.visszateres(this, "pumpaAllitas");
    }

    /**
     * Megkísérli a cső lehelyézést a mezőn amin áll a
     * csoLehelyez függvény meghívásával,
     * ha sikeres lerakja a csövet az aktuális és az m: Mező közé
     */
    public void lerak_cso(){
        szkeleton.hivas(this,"lerak_cso");
        rajtaAll.csoLehelyezes(csoTart);
        szkeleton.visszateres(this,"lerak_cso");

    }

    /**
     * Megkísérel felvenni egy csövet a megadott mezőről
     * @param felvesz annak csőnek a referenciája, amit felvesz
     */
    public void felvesz_cso(Cso felvesz){
        szkeleton.hivas(this,"felvesz_cso");

        // itt at lehetne adni a Pumpat, amin a jatekos all, es akkor mehetne
        if(felvesz.felveszik()) {
            // remove jatekos.felvesz_cso()-ben van vagy a cso.felveszik()-ben
            rajtaAll.removeSzomszed(felvesz);
        }
        szkeleton.visszateres(this,"felvesz_cso");
    }

    public void add_Kezebe(Viheto t){
        this.tart = t;
    }

    abstract Pumpa get_PumpaTart();
    public abstract void lerak_pumpa();
}
