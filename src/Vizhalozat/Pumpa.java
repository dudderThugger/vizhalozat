package Vizhalozat;

/**
 * Legalább két csövet csatlakoztató mező típus a bemenetéből a kimenetébe pumpálja a vizet, ha működik.
 */
public class Pumpa extends AktivElemek implements Viheto{
    /**
     * Azt jelöli, hogy a pumpa rossz-e vagy működik
     */
    private boolean mukodik;
    /**
     * A bemeneti cső referenciája
     */
    private Cso bemenet;
    /**
     * A kimeneti cső referenciája
     */
    private Cso kimenet;

    /**
     * A Pumpa egyetlen konstruktora
     * @param jatek A játék objektum referenciája
     */
    public Pumpa(Jatek jatek) {
        super(jatek);
        mukodik = true;
    }

    /**
     *  ha a függvény hívásakor a pumpa nem vízzel telített
     *  és a bemenete vízzel telített, vízzel telítetté válik a pumpa is,
     *  meghívja a kimenetének a befolyik függvényét
     */
    @Override
    public void befolyik() {
//        szkeleton.hivas(this, "befolyik");
//        if(mukodik && bemenet.getTelitett() && !this.telitett) {
//            telitett = true;
//            kimenet.befolyik();
//        }
//        szkeleton.visszateres(this, "befolyik");
    }

    /**
     * Átállítja a pumpa be- és kimenetét a megadott csövekre
     * @param be A pumpa új bemenete
     * @param ki A pumpa új kimenete
     * @return Mindig true-val tér vissza
     */
    @Override
    public boolean atAllit(Cso be, Cso ki) {
//        szkeleton.hivas(this, "atAllit");
//        szkeleton.visszateres(this, "atAllit", "true");
        return true;
    }

    /**
     * ha a pumpa eddig rossz volt megjavítódik
     * @return ha pumpa rossz volt true-val tér vissza, ha nem akkor false-al
     */
    @Override
    public boolean javitjak() {
//        szkeleton.hivas(this, "javitjak");
//        if(szkeleton.kerdes(this, "Javításra van szükség? (Igen, Nem)").equalsIgnoreCase("igen")){
//            mukodik = true;
//            szkeleton.visszateres(this, "javitjak", "true");
//            return true;
//        }
//        else {
//            szkeleton.visszateres(this, "javitjak", "false");
            return false;
//        }
    }

    /**
     * minden körben lefut a függvény és randomizált folyamat végén eldől,
     * hogy elromlik az adott pumpa vagy sem
     */
    public void elromlik() {
//        szkeleton.hivas(this, "elromlik");
//        mukodik = false;
//        szkeleton.visszateres(this, "elromlik");
    }

    /**
     * meghívja a tartó játékos lerak_pumpa metódusát
     * @param lerako az a jatekos, akinek meghivja a metodusat
     */
    @Override
    public void lerakjak(Jatekos lerako) {
//        szkeleton.hivas(this, "lerakjak");
//        szkeleton.visszateres(this, "lerakjak");
    }

    /**
     * setter
     * @param cs lesz az új bemenet
     */
    public void setBemenet(Cso cs){
        this.bemenet = cs;
    }
    /**
     * setter
     * @param cs lesz az új kimenet
     */
    public void setKimenet(Cso cs){
        this.kimenet = cs;
    }
}
