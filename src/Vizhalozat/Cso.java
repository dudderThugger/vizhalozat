package Vizhalozat;
import java.util.Scanner;

/**
 * Két mezőt csatlakoztató mezőtípus, a vízhálózat építőeleme.
 */
public class Cso extends Mezo implements Viheto {
    /** Azt jelzi, hogy lyukas-e a cső */
    protected boolean lyukas;
    public Cso(Jatek jatek) {
        super(jatek);
    }

    /**
     *  Visszaadja, hogy az adott cső telített-e
     * @return true, ha telitett
     */
    public boolean getTelitett() {
//        if(ertek.equals("Igen") ){
//            return true;
//        }
        return false;
    }

    @Override
    public boolean felveszik() {
//        if(ertek.equals("Nem") ){
//            return true;
//        }
        return false;
    }
    /**
     * Telitett lesz,ha nem volt az, es meghivja az osszes szomszedjara a
     * befolyik() fuggvenyt.
     */
    @Override
    public void befolyik() {
//        if(ertek.equals("Igen")){
//            jatek.szabotorPontSzerzes();
//        }
//        else if(!telitett){
//            telitett = true;
//            for(Mezo szomszed : szomszedok) {
//                szomszed.befolyik();
//            }
//        }
//        szkeleton.visszateres(this, "befolyik");
    }

    /**
     * @param j a Jatekos, aki megprobal ralepni
     * @return true, ha senki nem all meg rajta
     */
    @Override
    public boolean ralep(Jatekos j){
//        szkeleton.hivas(this, "ralep");
//        if(rajtaAllnak.size()==0){
//            rajtaAllnak.add(j);
//            szkeleton.visszateres(this, "ralep", "true");
//            return true;
//        }
//        szkeleton.visszateres(this, "ralep", "false");
        return false;
    }

    /**
     * @param p Pumpat var
     * @return true, ha nem allnak a csövön
     */
    @Override
    public boolean pumpaLehelyez(Pumpa p) {
//        szkeleton.hivas(this, "pumpaLehelyez");
//        szkeleton.kerdes(this, "Allnak rajtam (Igen/Nem)");
//        Scanner scanner = new Scanner(System.in);
//        String answer = scanner.nextLine();
//        if(answer.equals("Igen")) {
//            szkeleton.visszateres(this, "pumpaLehelyez", "false");
//            return false;
//        } else if(answer.equals("Nem")) {
//            szkeleton.visszateres(this, "pumpaLehelyez", "true");
//            szomszedok.add(p);
//            return true;
//        } else {
//            szkeleton.visszateres(this, "pumpaLehelyez", "false");
            return false;
//        }
    }

    /**
     * Cso foltozasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean foltoz()
    {
//        szkeleton.hivas(this, "foltoz");
//        String answer = szkeleton.kerdes(this, "Lyukas vagyok (Igen/Nem)");
//        if(answer.equals("Igen")){
//          lyukas = false;
//          szkeleton.visszateres(this, "foltoz","true");
//          return true;
//        }
//        lyukas = false;
//        szkeleton.visszateres(this, "foltoz","false");
        return false;
    }
    /**
     * Cso lyukasztasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean lyukaszt() {
//        szkeleton.hivas(this, "lyukaszt");
//        String answer = szkeleton.kerdes(this, "Lyukas vagyok(Igen/Nem)");
//        if(answer.equals("Nem")){
//            lyukas = true;
//            szkeleton.visszateres(this, "lyukaszt", "true");
//            return true;
//        }
//        lyukas = true;
//        szkeleton.visszateres(this, "lyukaszt", "false");
        return false;
    }

    /**
     * Szerelő megkísérli egy pumpa vásárlását a csövön
     * @return Mindig null
     */
    @Override
    public Pumpa pumpaVasarlas() {
//        szkeleton.hivas(this, "pumpaVasarlas");
//        szkeleton.visszateres(this, "pumpaVasarlas", "null");
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
//        szkeleton.hivas(this, "atAllit");
//        szkeleton.visszateres(this, "atAllit", "false");
        return false;
    }

    /**
     * Szerelő megkísérli a cső javítását
     * @return Mindig false
     */
    @Override
    public boolean javitjak() {
//        szkeleton.hivas(this, "javitjak");
//        szkeleton.visszateres(this, "javitjak", "false");
        return false;
    }

    /**
     * Játékos megpróbál csövet lehelyezni a csőre
     * @param cs A lehelyezendő cső
     * @return Mindig false
     */
    @Override
    public boolean csoLehelyezes(Cso cs) {
//        szkeleton.hivas(this, "csoLehelyezes");
//        szkeleton.visszateres(this, "csoLehelyezes", "false");
        return false;
    }

    /**
     * Lerakják a csövet
     * @param lerako a Jatekos, aki lerakja a az adott objektumot
     */
    @Override
    public void lerakjak(Jatekos lerako) {
//        szkeleton.hivas(this, "lerakjak");
//        rajtaAllnak.add(lerako);
//        szkeleton.visszateres(this, "lerakjak");
    }
}
