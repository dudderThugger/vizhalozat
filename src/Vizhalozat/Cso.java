package Vizhalozat;
import java.util.ArrayList;
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
    private int csuszasIdo;
    private int ragasztasiIdo;
    private boolean felvettek =false;
    protected Jatekos ragasztotta;
    private boolean log;
    private ArrayList<Jatekos> tartjak = new ArrayList<>();
    public ArrayList<Jatekos> getTarto() {
        return tartjak;
    }
    public boolean felveszik(Jatekos j) {
        if(rajtaAllnak.size()==0) {
            tartjak.add(j);
            log = false;
            return true;
        }
        return false;
    }
    public void lerakjak(Jatekos lerako) {
        tartjak.remove(lerako);
    }
    public void tick() {
        if(lyukasztasiIdo > 0) lyukasztasiIdo--;
        if(csuszasIdo > 0) csuszasIdo--;
        if (csuszasIdo == 0) csuszik = false;
        if(ragasztasiIdo > 0) ragasztasiIdo--;
        if (ragasztasiIdo == 0) ragad = false;
    }

    public Cso(Jatek jatek) {
        super(jatek);
        lyukas = false; ragad = false; csuszik = false;
        lyukasztasiIdo = 0;
        csuszasIdo = 0;
        ragasztasiIdo = 0;
        log = false;
    }

    /**
     *  Visszaadja, hogy az adott cső telített-e
     * @return true, ha telitett
     */
    public boolean getTelitett() {
        return telitett;
    }
    /**
     * Telitett lesz,ha nem volt az, es meghivja az osszes szomszedjara a
     * befolyik() fuggvenyt.
     */
    @Override
    public void befolyik() {
        if (!telitett && !lyukas) {
            telitett = true;
            for(Mezo m : szomszedok) {
                m.befolyik();
            }
        }
        if(lyukas) jatek.szabotorPontSzerzes();
    }

    /**
     * @param j a Jatekos, aki megprobal ralepni
     * @return true, ha senki nem all meg rajta
     */
    @Override
    public Mezo ralep(Jatekos j){
        if(rajtaAllnak.size() == 0) {
            rajtaAllnak.add(j);
            if(j != ragasztotta && ragad){
                j.setRagadasiIdo(15);
            }

            if(csuszik){
                Mezo m = megcsuszik();
                rajtaAllnak.remove(j);
                return m;
            }
            return this;
        }
        return null;
    }

    public Mezo megcsuszik(){
        Random r = new Random();
        int randszomsz = r.nextInt(szomszedok.size());
        return szomszedok.get(randszomsz);

    }



    /**
     * @param p Pumpat var
     * @return true, ha nem allnak a csövön
     */
    @Override
    public boolean pumpaLehelyez(Pumpa p) {
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
    public boolean csoLehelyezes(Cso cs, Jatekos lerakja) {
        return false;
    }

    /**
     * ha ragadossa akarja egy jatekos tenni a csovet akkor ezt hivja meg
     * @return igaz/hamis ertek attol fuggoen, hogy sikerult e a ragasztas vagy sem
     */
    public boolean ragaszt() {
        if(!ragad){
            ragad = true;
            ragasztasiIdo = 20;
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
            csuszasIdo = 10;
            return true;
        }
        return false;
    }

    public boolean isLyukas() {
        return lyukas;
    }
    public void setLog() { this.log = true; }
    public boolean getLog() { return log; }
}
