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

        rajtaAllnak.remove(j);
    }

    /**
     * megpróbálnak rálépni a mezőre
     * @param j Jatekos próbál rálépni a mezőre
     * @return igazzal tér vissza,
     *      ha sikeres és hozzáadja a játékost a rajtaÁllók
     *      attribútumhoz egyébként hamissal tér vissza
     */
    public boolean ralep(Jatekos j) {
        rajtaAllnak.add(j);
        return true;
    }

    /**
     * Visszaadja a mezővel szomszédos mezők referenciáit
     * @return szomszédos mezők listája
     */
    public ArrayList<Mezo> getSzomszedok() {
        return szomszedok;
    }

    /**
     * Hozzáadja a kapott mezőt a szomszédok tömbjéhez
     * @param m a hozzáadandó Mező
     */
    public void addSzomszed(Mezo m) {
        szomszedok.add(m);
    }

    /**
     * eltávolítja a kapott mezőt a szomszédok listájából
     * @param m eltávolítandó Mezo
     */
    public void removeSzomszed(Mezo m) {
        szomszedok.remove(m);
    }

    /**
     * Egy mező elem felvevését megkísérlő absztrakt metódus
     * @return igaz, ha sikerült felvenni
     */
    public abstract boolean felveszik();

    /**
     * absztrakt függvény, ha egy szomszéd vizet szállít az adott mezőbe,
     * akkor ezt a függvényt hívja meg
     */
    public abstract void befolyik();

    /**
     * absztrakt függvény, ezt a függvényt hívja meg a Játékos a  lerakPumpa akciójakor
     * @param p lehelyezendo pumpa
     * @return
     */
    public abstract boolean pumpaLehelyez(Pumpa p);

    /**
     * absztrakt függvény, ez a függvény hívódik meg,
     * amikor a Szerelő meg akar javítani egy csövet,
     * csak csövön sikeres. A cső állapota nem lyukas lesz.
     * @return csövön igaz, máshol hamis
     */
    public abstract boolean foltoz();

    /**
     * absztrakt függvény, ez a függvény hívódik meg,
     * amikor a Játékos ki akar lyukasztani egy csövet.A cső állapota lyukas lesz.
     * @return csövön igaz, máshol hamis
     */
    public abstract boolean lyukaszt();

    /**
     * absztrakt függvény, ez a függvény hívódik meg,
     * amikor a Szerelő pumpát akar venni. Csak ciszternán érvényes.
     * @return ciszternán igaz, máshol hamis
     */
    public abstract Pumpa pumpaVasarlas();

    /**
     * absztrakt függvény, ez a függvény hívódik meg,
     * amikor a pumpát próbálja meg valaki átállítani. Csak pumpán érvényes.
     * @param be
     * @param ki
     * @return pumpán igaz, máshol hamis
     */
    public abstract boolean atAllit(Cso be, Cso ki);

    /**
     * absztrakt függvény, ez a függvény hívódik meg,
     * amikor a pumpát próbálja meg egy Szerelő javítani. Csak pumpán érvényes.
     * @return pumpán igaz, máshol hamis
     */
    public abstract boolean javitjak();

    /**
     * absztrakt függvénye a cső lehelyezésének
     * @param cs a lehelyezendő cső
     * @return igaz ha sikerült lehelyezni a csövet
     */
    public abstract boolean csoLehelyezes(Cso cs);

    /**
     * absztrakt függvény, ami ragadóssá teszi a mezőt.
     * Egy külső játékos hívja a mezőre. Akkor sikeres, ha csőről van szó.
     * @return csőn igaz, máshol hamis
     */
    public abstract boolean ragaszt();


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

    /**
     * megcsuszik metódus absztrakt függvénye
     * @return
     */
    public  abstract Mezo megcsuszik();

    /**
     * absztrakt függvény, ami csúszóssá teszi a mezőt.
     * Egy szabotőr hívhatja a mezőre. Akkor sikeres, ha csőről van szó
     * @return csőn igaz, máshol hamis
     */
    public abstract boolean csuszik();

    /**
     * sima gettere a rajtaAll tagváltozónak
     * @return
     */

    public ArrayList<Jatekos> getRajtaAllnak() {
        return rajtaAllnak;
    }
    public boolean getTelitett() { return telitett;}
}
