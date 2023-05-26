package Vizhalozat;
import java.util.ArrayList;
import java.util.List;

/**
 * A játékot játszó játékosok absztrakt osztálya, definálja a közös akciókat.
 */
public abstract class Jatekos {
    protected Jatek jatek;  // Jatekot irányító osztály referenciája
    protected Viheto tart; //referencia a tárgyra, amit a játékos tart
    protected Cso csoTart; //a játékos kezében lévő cső referenciája
    protected Mezo rajtaAll; // referencia a mezőre, amin a játékos áll
    protected int ragadasiIdo;
    protected int akcioIdo;

    /**
     * A játékos egyetlen konstruktora
     */
    public Jatekos() {
        ragadasiIdo = 0;
        akcioIdo = 0;
    }

    public void tick() {
        if(ragadasiIdo > 0) ragadasiIdo--;
        if(akcioIdo > 0) akcioIdo--;
    }

    public void raAllit(Mezo m) {
        rajtaAll = m;
        m.ralep(this);
    }

    /**
     * Amikor a játékos csőre lép, ekkor hívja ezt a függvényt
     * lekéri a pozíciója szomszédjait és ha nem állnak a lépni kívánt csövön átlép rá és lelép az aktuálísról
     * @param szomszed a cso típusú objektum amire lép a játékos
     */
    public void lepes(Cso szomszed){
        if(rajtaAll.getSzomszedok().contains(szomszed) && szomszed.getRajtaAllnak().isEmpty()){
            szomszed.ralep(this);
            rajtaAll.lelep(this);
        }
    }

    public void setRagadasiIdo(int x) { ragadasiIdo = x; }

    /**
     * Amikor a játékos NEM csőre lép, ekkor hívja ezt a függvényt
     * lekéri a pozíciója szomszédjait és ha a visszakapott szomszédok között van a lépni kívánt AktívElem, rálép
     * @param szomszed a AktivElemek típusú objektum amire lép a játékos
     */
    public void lepes(AktivElemek szomszed){
        if(rajtaAll.getSzomszedok().contains(szomszed)){
            szomszed.ralep(this);
            rajtaAll.lelep(this);
        }
    }

    /**
     * megkísérli átállítani a mezőt, amin áll, csak pumpa mezőn hatásos
     * @param be bemenet
     * @param ki kimenete
     */
    public void pumpaAllitas(Cso be, Cso ki){
        List<Mezo> szomszedok = rajtaAll.getSzomszedok();
        if(szomszedok.contains(be) && szomszedok.contains(ki))
            rajtaAll.atAllit(be, ki);
    }

    /**
     * Megkísérli a cső lehelyézést a mezőn amin áll a
     * csoLehelyez függvény meghívásával,
     * ha sikeres lerakja a csövet az aktuális és az m: Mező közé
     */
    public void lerak_cso(){
        if(csoTart != null){
            boolean siker = rajtaAll.csoLehelyezes(csoTart);
            if(siker){
                csoTart = null;
            }
        }

    }

    /**
     * Megkísérel felvenni egy csövet a megadott mezőről
     * @param felvesz annak csőnek a referenciája, amit felvesz
     */
    public void felvesz_cso(Cso felvesz){
        if(rajtaAll.getSzomszedok().contains(felvesz) && csoTart==null){
            boolean siker = felvesz.felveszik();
            if(siker){
                csoTart = felvesz;
                felvesz.removeSzomszed(rajtaAll);
            }
        }
    }

    /**
     * A Jatekos kezebe teszi valamilyen Vihető objektum referenciáját
     * @param t
     */
    public void add_Kezebe(Viheto t){
        this.tart = t;
    }
    /**
     *  Megprobalja leragasztani a mezot
     */
    public void ragaszt(){
        if (akcioIdo == 0) {
            if(rajtaAll.ragaszt()) akcioIdo = 5;
        }
    }

    public void lyukaszt(){
        if (akcioIdo == 0) {
            if(rajtaAll.lyukaszt()) akcioIdo = 5;
        }
    }

    public Mezo getRajtaAll() {
        return rajtaAll;
    }

    public Viheto getTart() {
        return tart;
    }
}