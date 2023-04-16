package Vizhalozat;

public class Pumpa extends AktivElemek implements Viheto{
    private boolean mukodik;
    private Cso bemenet;
    private Cso kimenet;

    /**
     * A Pumpa egyetlen konstruktora
     * @param jatek A játék objektum referenciája
     * @param szkeleton A szkeleton, tesztelő osztály konstruktora
     */
    public Pumpa(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
        mukodik = true;
    }

    /**
     *  ha a függvény hívásakor a pumpa nem vízzel telített
     *  és a bemenete vízzel telített, vízzel telítetté válik a pumpa is,
     *  meghívja a kimenetének a befolyik függvényét
     */
    @Override
    public void befolyik() {
        szkeleton.hivas(this, "befolyik");
        if(bemenet.getTelitett() && this.telitett==false) {
            telitett = true;
            kimenet.befolyik();
        }
        szkeleton.visszateres(this, "befolyik");
    }

    /**
     * Átállítja a pumpa be- és kimenetét a megadott csövekre
     * @param be A pumpa új bemenete
     * @param ki A pumpa új kimenete
     * @return Mindig true-val tér vissza
     */
    @Override
    public boolean atAllit(Cso be, Cso ki) {
        szkeleton.hivas(this, "atAllit");
        szkeleton.visszateres(this, "atAllit");
        return true;
    }

    /**
     * ha a pumpa eddig rossz volt megjavítódik
     * @return ha pumpa rossz volt true-val tér vissza, ha nem akkor false-al
     */
    @Override
    public boolean javitjak() {
        szkeleton.hivas(this, "javitjak");
        szkeleton.visszateres(this, "javitjak");
        return false;
    }

    /**
     * minden körben lefut a függvény és randomizált folyamat végén eldől,
     * hogy elromlik az adott pumpa vagy sem
     */
    public void elromlik() {
        szkeleton.hivas(this, "elromlik");
        mukodik = false;
        szkeleton.visszateres(this, "elromlik");
    }
    public void setBemenet(Cso cs){
        this.bemenet = cs;
    }

    public void setKimenet(Cso cs){
        this.kimenet = cs;
    }

    /**
     * meghívja a tartó játékos lerak_pumpa metódusát
     * @param lerako az a jatekos, akinek meghivja a metodusat
     */
    @Override
    public void lerakjak(Jatekos lerako) {
        szkeleton.hivas(this, "lerakjak");
        lerako.lerak_pumpa();
        szkeleton.visszateres(this, "lerakjak");
    }
}
