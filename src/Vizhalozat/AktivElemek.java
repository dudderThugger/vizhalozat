package Vizhalozat;

/**
 * Az aktív elemeket reprezentáló absztrakt osztály, ezekhez az elemekhez csatlakoztatható cső
 * és egyszerre több ember is állhat egy ilyen elemen
 */
public abstract class AktivElemek extends Mezo{
    /**
     * Az osztály egyetlen konstruktora
     * @param jatek A játék objektumára mutató referencia
     */
    public AktivElemek(Jatek jatek) {
        super(jatek);
    }

    /**
     * Megkísérlik az aktív elem felvételét
     * @return Mindig false
     */
    public boolean felveszik() {
        return false;
    }

    /**
     * Megkísérelik egy pumpa lehelyezését az aktív elemen
     * @param p A lehelyezendő pumpa
     * @return Mindig false
     */
    @Override
    public boolean pumpaLehelyez(Pumpa p) {
        return false;
    }

    /**
     * Megkísérlik az aktív elem foltozását
     * @return Mindig false
     */
    @Override
    public boolean foltoz() {
        return false;
    }

    /**
     * Megkísérlik az aktív elem lyukasztását
     * @return Mindig false
     */
    @Override
    public boolean lyukaszt() {
        return false;
    }

    /**
     * Megkísérelnek egy pumpát venni az aktív elemen
     * @return null, ha nincs override-olva
     */
    @Override
    public Pumpa pumpaVasarlas() {
        return null;
    }

    /**
     * Megkísérelnek pumpát állítani az aktív elemen
     * @param be A pumpa új bemenete
     * @param ki A pumpa új kimenete
     * @return Sikeres-e a pumpa állítása
     */
    public abstract boolean atAllit(Cso be, Cso ki);

    /**
     * Megkísérlik megjavítani az aktív elemet
     * @return Sikeres-e a javítás
     */
    public abstract boolean javitjak();

    /**
     * Egy cső lehelyezése az aktív elemen
     * @param cs a lehelyezendő cső
     * @return Mindig true
     */
    @Override
    public boolean csoLehelyezes(Cso cs) {
        cs.addSzomszed(this);
        return false;
    }
}
