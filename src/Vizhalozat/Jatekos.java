package Vizhalozat;
import java.util.ArrayList;

/**
 * A játékot játszó játékosok absztrakt osztálya, definálja a közös akciókat.
 */
public abstract class Jatekos {
    protected Szkeleton szkeleton;  // a figyelő és hívásszámontartó osztály referenciája
    protected Jatek jatek;  // Jatekot irányító osztály referenciája
    protected Viheto tart; //referencia a tárgyra, amit a játékos tart
    protected Cso csoTart; //a játékos kezében lévő cső referenciája
    protected Mezo rajtaAll; // referencia a mezőre, amin a játékos áll
    protected int varakozasiIdo; // a játékosnak mennyi időt kell várnia a következő aktív akciójáig
    protected int ragadasiIdo;

    /**
     * A játékos egyetlen konstruktora
     */
    public Jatekos() {
    }

    /**
     * Amikor a játékos csőre lép, ekkor hívja ezt a függvényt
     * lekéri a pozíciója szomszédjait és ha nem állnak a lépni kívánt csövön átlép rá és lelép az aktuálísról
     * @param szomszed a cso típusú objektum amire lép a játékos
     */
    public void lepes(Cso szomszed){
//        szkeleton.ujObjektum(szomszed, "szomszed");
//
//        szkeleton.hivas(this, "lepes");
//        ArrayList<Mezo> szomszedok = rajtaAll.getSzomszedok();
//
//        szomszedok.add(szomszed);
//
//        if(szomszedok.contains(szomszed)){
//            szkeleton.hivas(szomszed, "ralep");
//
//            String valasz = szkeleton.kerdes(szomszed, "Áll játékos éppen a kiválasztott csövön? (igen/nem)");
//
//            if(valasz.equals("igen")){
//                szkeleton.visszateres(szomszed, "ralep", "false");
//            } else if (valasz.equals("nem")) {
//                szkeleton.visszateres(szomszed, "ralep", "true");
//
//                szkeleton.hivas(rajtaAll, "lelep");
//                szkeleton.visszateres(rajtaAll, "lelep");
//            }
//        }
//
//        szkeleton.visszateres(this, "lepes");
    }

    public void setRagadasiIdo(int x) { ragadasiIdo = x; }

    /**
     * Amikor a játékos NEM csőre lép, ekkor hívja ezt a függvényt
     * lekéri a pozíciója szomszédjait és ha a visszakapott szomszédok között van a lépni kívánt AktívElem, rálép
     * @param szomszed a AktivElemek típusú objektum amire lép a játékos
     */
    public void lepes(AktivElemek szomszed){
//        szkeleton.ujObjektum(szomszed, "szomszed");
//
//        szkeleton.hivas(this, "lepes");
//        ArrayList<Mezo> szomszedok = rajtaAll.getSzomszedok();
//
//        szomszedok.add(szomszed);
//
//        if(szomszedok.contains(szomszed)){
//            szkeleton.hivas(szomszed, "ralep");
//            szkeleton.visszateres(szomszed, "ralep", "true");
//
//            szkeleton.hivas(rajtaAll, "lelep");
//            szkeleton.visszateres(rajtaAll, "lelep");
//
//        }else{
//            szkeleton.visszateres(szomszed, "ralep", "false");
//        }
//
//        szkeleton.visszateres(this, "lepes");
    }

    /**
     * megkísérli átállítani a mezőt, amin áll, csak pumpa mezőn hatásos
     */
    public void pumpaAllitas(){
//        szkeleton.hivas(this, "pumpaAllitas");
//
//        ArrayList<Mezo> szomszedok = rajtaAll.getSzomszedok();
//        Cso[] csovek = new Cso[2];
//        if(szomszedok.size() > 0) {
//            for (int i = 0; i < 2; i++) {
//                for (int j = 1; j <= szomszedok.size(); j++) {
//                    szkeleton.uzenet("Cső " + j);
//                }
//                int valasz = Integer.parseInt(szkeleton.kerdes(this, "Az " + (i + 1) + ". cső kiválasztása: (A fentiek közül)"));
//                if (valasz > 0 && valasz <= szomszedok.size()) csovek[i] = (Cso) szomszedok.remove(valasz - 1);
//                else {
//                    System.out.println("Nem megfelelő válasz!");
//                    i--;
//                }
//            }
//        }
//
//        rajtaAll.atAllit(csovek[0], csovek[1]);
//
//        szkeleton.visszateres(this, "pumpaAllitas");
    }

    /**
     * Megkísérli a cső lehelyézést a mezőn amin áll a
     * csoLehelyez függvény meghívásával,
     * ha sikeres lerakja a csövet az aktuális és az m: Mező közé
     */
    public void lerak_cso(){
//        szkeleton.hivas(this,"lerak_cso");
//        rajtaAll.csoLehelyezes(csoTart);
//        szkeleton.visszateres(this,"lerak_cso");

    }

    /**
     * Megkísérel felvenni egy csövet a megadott mezőről
     * @param felvesz annak csőnek a referenciája, amit felvesz
     */
    public void felvesz_cso(Cso felvesz){
//        szkeleton.hivas(this,"felvesz_cso");
//
//        // itt at lehetne adni a Pumpat, amin a jatekos all, es akkor mehetne
//        if(felvesz.felveszik()) {
//            // remove jatekos.felvesz_cso()-ben van vagy a cso.felveszik()-ben
//            rajtaAll.removeSzomszed(felvesz);
//        }
//        szkeleton.visszateres(this,"felvesz_cso");
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
        rajtaAll.ragaszt();
    }
}
