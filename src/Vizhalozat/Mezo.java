package Vizhalozat;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Közös őse a különböző mezőfajtáknak. Közös interfészt nyújt,
 * hogy a Játékos és Játék objektumok heterogénen tudják kezelni a mezőket.
 */
public abstract class Mezo {
    protected ArrayList<Mezo> szomszedok;
    protected Jatek jatek;
    protected ArrayList<Jatekos> rajtaAllnak;
    protected boolean telitett;

    /**
     * A mező egyetlen konstruktora
     * @param jatek A játék objektum referenciája
     */

    public Mezo(Jatek jatek) {
        this.jatek = jatek;
        this.telitett = false;
        szomszedok = new ArrayList<Mezo>();
        rajtaAllnak = new ArrayList<Jatekos>();
    }

    /**
     *  ha egy játékos lelép az objektumról ezt a függvényt hívja meg,
     *  ilyenkor a mező kiveszi a paraméterként megkapott j játékost a rajtaÁlló játékosok közül
     * @param j Jatekos próbál lelépni a mezőről
     */
    public void lelep(Jatekos j) {
//        szkeleton.hivas(this, "lelep");
//        szkeleton.visszateres(this, "lelep");
    }

    /**
     * megpróbálnak rálépni a mezőre
     * @param j Jatekos próbál rálépni a mezőre
     * @return igazzal tér vissza,
     *      ha sikeres és hozzáadja a játékost a rajtaÁllók
     *      attribútumhoz egyébként hamissal tér vissza
     */
    public boolean ralep(Jatekos j) {
//        szkeleton.hivas(this, "ralep");
//        szkeleton.visszateres(this, "lelralepep");
        return false;
    }

    /**
     * Visszaadja a mezővel szomszédos mezők referenciáit
     * @return szomszédos mezők listája
     */
    public ArrayList<Mezo> getSzomszedok() {
//        szkeleton.hivas(this, "getSzomszedok");
//        szkeleton.visszateres(this, "getSzomszedok", "szomszedok");
        return szomszedok;
    }

    /**
     * Hozzáadja a kapott mezőt a szomszédok tömbjéhez
     * @param m a hozzáadandó Mező
     */
    public void addSzomszed(Mezo m) {
//        szkeleton.hivas(this, "addSzomszed");
//        szkeleton.visszateres(this, "addSzomszed");
        szomszedok.add(m);
    }

    /**
     * eltávolítja a kapott mezőt a szomszédok listájából
     * @param m eltávolítandó Mezo
     */
    public void removeSzomszed(Mezo m) {
//        szkeleton.hivas(this, "removeSzomszed");
//        szkeleton.visszateres(this, "removeSzomszed");
        szomszedok.remove(m);
    }

    /**
     *
     * @return
     */
    public abstract boolean felveszik();
    public abstract void befolyik();
    public abstract boolean pumpaLehelyez(Pumpa p);
    public abstract boolean foltoz();
    public abstract boolean lyukaszt();
    public abstract Pumpa pumpaVasarlas();
    public abstract boolean atAllit(Cso be, Cso ki);
    public abstract boolean javitjak();
    public abstract boolean csoLehelyezes(Cso cs);

    /**
     * ra állít egy mezőre egy játékost
     * @param ra Mezore helyezendo Jatekos
     */
    public void raAllit(Jatekos ra) { rajtaAllnak.add(ra); }

    /**
     * szomszedok beállítása egy komplett listával
     * @param szomszedok a beállítanó lista
     */
    public void setSzomszedok(ArrayList<Mezo> szomszedok) {
        this.szomszedok = szomszedok;
    }

    public void setTelitett(boolean x) {telitett = x;}
}
