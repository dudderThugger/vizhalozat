package Vizhalozat;
import java.util.Random;
import java.util.Scanner;

/**
 * Két mezőt csatlakoztató mezőtípus, a vízhálózat építőeleme.
 */
public class Cso extends Mezo implements Viheto {
    /** Azt jelzi, hogy lyukas-e a cső */
    protected boolean lyukas;
    /** Azt jelzi, hogy ragados-e a cso vagy sem*/
    protected boolean ragad;
    /** Azt jelzi, hogy csuszik-e a cso vagy sem*/
    protected boolean csuszik;
    /** Azt jelzi, hogy milyen reg lyukasztottak ki a csovet */
    protected int lyukasztasiIdo;
    /** Annak a jatekosnak a referenciaja, aki ragadossa tette a csovet*/
    protected Jatekos ragasztotta;

    public Cso(Jatek jatek) {
        super(jatek);
        lyukas = false; ragad = false; csuszik = false;
    }

    /**
     *  Visszaadja, hogy az adott cső telített-e
     * @return true, ha telitett
     */
    public boolean getTelitett() {
//        if(ertek.equals("Igen") ){
//            return true;
//        }
        return telitett;
    }

    @Override
    public boolean felveszik() {
//        if(ertek.equals("Nem") ){
//            return true;
//        }
        if(rajtaAllnak.size()==0) return true;

        return false;
    }
    /**
     * Telitett lesz,ha nem volt az, es meghivja az osszes szomszedjara a
     * befolyik() fuggvenyt.
     */
    @Override
    public void befolyik() {
        if(!telitett)  telitett = true;
        for (Mezo szomszed : szomszedok) {
            if(szomszed != null) {
                szomszed.removeSzomszed(this);
                szomszed.befolyik();
                szomszed.addSzomszed(this);
            }
        }
    }

    /**
     * @param j a Jatekos, aki megprobal ralepni
     * @return true, ha senki nem all meg rajta
     */
    @Override
    public boolean ralep(Jatekos j){
//        if(rajtaAllnak.size()==0){
//            rajtaAllnak.add(j);
//            return true;
//        }

        if(rajtaAllnak.size() == 0) {
            rajtaAllnak.add(j);
            if(j != ragasztotta && ragad){
                j.setRagadasiIdo(30);
            }

            if(csuszik){
                megcsuszik().ralep(j);
                rajtaAllnak.remove(j);
            }

            return true;
        }
        return false;
    }

    public Mezo megcsuszik(){
        if(csuszik){
            Random r = new Random();
            int randszomsz = r.nextInt(szomszedok.size());
            return szomszedok.get(randszomsz);
        } else {
            return null;
        }

    }



    /**
     * @param p Pumpat var
     * @return true, ha nem allnak a csövön
     */
    @Override
    public boolean pumpaLehelyez(Pumpa p) {
        Cso ujCso = new Cso(jatek);
        ujCso.addSzomszed(szomszedok.get(0));
        removeSzomszed(szomszedok.get(0));

        ujCso.addSzomszed(p);
        p.addSzomszed(ujCso);

        p.addSzomszed(this);
        addSzomszed(p);
        return true;
    }

    /**
     * Cso foltozasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean foltoz()
    {
        if(lyukas){
            lyukas = false;
            return true;
        }

        return false;
    }
    /**
     * Cso lyukasztasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean lyukaszt() {
//        String answer = szkeleton.kerdes(this, "Lyukas vagyok(Igen/Nem)");
//        if(answer.equals("Nem")){
//            lyukas = true;
//            return true;
//        }
//        lyukas = true;

        if(!lyukas){
            lyukas = true;
            return true;
        }

        return false;
    }

    /**
     * Szerelő megkísérli egy pumpa vásárlását a csövön
     * @return Mindig null
     */
    @Override
    public Pumpa pumpaVasarlas() {
        return null;
    }

    /**
     * Játékos megkísérli a cső átállítását
     * @param be Az új bemenet
     * @param ki Az új kimenet
     * @return Mindig false
     */
    @Override
    public boolean atAllit(Cso be, Cso ki) {
        return false;
    }

    /**
     * Szerelő megkísérli a cső javítását
     * @return Mindig false
     */
    @Override
    public boolean javitjak() {
        return false;
    }

    /**
     * Játékos megpróbál csövet lehelyezni a csőre
     * @param cs A lehelyezendő cső
     * @return Mindig false
     */
    @Override
    public boolean csoLehelyezes(Cso cs) {
        return false;
    }

    /**
     * Lerakják a csövet
     * @param lerako a Jatekos, aki lerakja a az adott objektumot
     */
    @Override
    public void lerakjak(Jatekos lerako) {
//        rajtaAllnak.add(lerako);
    }

    /**
     * ha ragadossa akarja egy jatekos tenni a csovet akkor ezt hivja meg
     * @return igaz/hamis ertek attol fuggoen, hogy sikerult e a ragasztas vagy sem
     */
    public boolean ragaszt() {
        if(!ragad){
            ragad = true;
            return true;
        }
        return false;
    }

    /**
     * ha csuszossa akarja egy szabotor tenni a csovet akkor ezt hivja meg
     * @return igaz/hamis ertek attol fuggoen, hogy sikerult e a csusztatas vagy sem
     */
    public boolean csuszik() {
        if(!csuszik){
            csuszik = true;
            return true;
        }
        return false;
    }
}
