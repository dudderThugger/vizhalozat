package Vizhalozat;

import java.util.Random;

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

        if(!telitett && bemenet.getTelitett()){
            telitett = true;
            kimenet.befolyik();
        }
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

        bemenet = be;
        kimenet = ki;
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
//            return false;
//        }

        if(!mukodik){
            mukodik = true;
            return true;
        }
        else
            return false;
    }



    @Override
    public Mezo megcsuszik() {
        return null;
    }

    @Override
    public boolean ragaszt() {
        return false;
    }

    @Override
    public boolean csuszik() {
        return false;
    }

    /**
     * minden körben lefut a függvény és randomizált folyamat végén eldől,
     * hogy elromlik az adott pumpa vagy sem
     */
    public void elromlik() {
//        szkeleton.hivas(this, "elromlik");
//        mukodik = false;
//        szkeleton.visszateres(this, "elromlik");

        Random rnd = new Random();
        int hatar = rnd.nextInt(10) + 1;
        if(hatar == 10){
            mukodik = false;
        }
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

    @Override
    public boolean felveszik() {
        return super.felveszik();
    }

    /**
     * egy szerelő megpróbálja letenni a pumpát a kezéből a pumpára amin áll
     * @param p A lehelyezendő pumpa
     * @return Mindig hamissal tér vissza és nem történik semmi
     */
    @Override
    public boolean pumpaLehelyez(Pumpa p) {
        return false;
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
