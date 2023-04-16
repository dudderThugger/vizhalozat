package Vizhalozat;
import java.util.Scanner;

public class Cso extends Mezo implements Viheto {
    protected boolean lyukas;
    public Cso(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
    }

    /**
     *  Visszaadja, hogy az adott cső telített-e
     * @return true, ha telitett
     */
    public boolean getTelitett() {
        szkeleton.hivas(this, "getTelitett");
        String ertek = szkeleton.kerdes(this, "Van bennem víz?(Igen/Nem)");
        if(ertek.equals("Igen") ){
            szkeleton.visszateres(this, "getTelitett", "true");
            return true;
        }
        szkeleton.visszateres(this, "getTelitett", "false");
        return false;
    }

    @Override
    public boolean felveszik() {
        szkeleton.hivas(this, "felveszik");
        String ertek = szkeleton.kerdes(this, "Allnak rajtam?(Igen/Nem)");
        if(ertek.equals("Nem") ){
            szkeleton.visszateres(this, "felveszik", "true");
            return true;
        }
        szkeleton.visszateres(this, "felveszik", "false");
        return false;
    }
    /**
     * Telitett lesz,ha nem volt az, es meghivja az osszes szomszedjara a
     * befolyik() fuggvenyt.
     */
    @Override
    public void befolyik() {
        szkeleton.hivas(this, "befolyik");
        if(!telitett){
            telitett = true;
            for(Mezo szomszed : szomszedok) {
                szomszed.befolyik();
            }
        }
        szkeleton.visszateres(this, "befolyik");
    }

    /**
     * @param j a Jatekos, aki megprobal ralepni
     * @return true, ha senki nem all meg rajta
     */
    @Override
    public boolean ralep(Jatekos j){
        szkeleton.hivas(this, "ralep");
        if(rajtaAllnak.size()==0){
            rajtaAllnak.add(j);
            szkeleton.visszateres(this, "ralep", "true");
            return true;
        }
        szkeleton.visszateres(this, "ralep", "false");
        return false;
    }

    /**
     * @param p Pumpat var
     * @return true, ha nem allnak a csövön
     */
    @Override
    public boolean pumpaLehelyez(Pumpa p) {
        szkeleton.hivas(this, "pumpaLehelyez");
        szkeleton.kerdes(this, "Allnak rajtam (Igen/Nem)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equals("Igen")) {
            szkeleton.visszateres(this, "pumpaLehelyez", "false");
            return false;
        } else if(answer.equals("Nem")) {
            szkeleton.visszateres(this, "pumpaLehelyez", "true");
            szomszedok.add(p);
            return true;
        } else {
            szkeleton.visszateres(this, "pumpaLehelyez", "false");
            return false;
        }
    }

    /**
     * Cso foltozasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean foltoz()
    {
        szkeleton.hivas(this, "foltoz");
        String answer = szkeleton.kerdes(this, "Lyukas vagyok (Igen/Nem)");
        if(answer.equals("Igen")){
          lyukas = false;
          szkeleton.visszateres(this, "foltoz","true");
          return true;
        }
        lyukas = false;
        szkeleton.visszateres(this, "foltoz","false");
        return false;
    }
    /**
     * Cso lyukasztasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean lyukaszt() {
        szkeleton.hivas(this, "lyukaszt");
        String answer = szkeleton.kerdes(this, "Lyukas vagyok(Igen/Nem)");
        if(answer.equals("Nem")){
            lyukas = true;
            szkeleton.visszateres(this, "lyukaszt", "true");
            return true;
        }
        lyukas = true;
        szkeleton.visszateres(this, "lyukaszt", "false");
        return false;
    }

    @Override
    public Pumpa pumpaVasarlas() {
        szkeleton.hivas(this, "pumpaVasarlas");
        szkeleton.visszateres(this, "pumpaVasarlas", "null");
        return null;
    }

    @Override
    public boolean atAllit(Cso be, Cso ki) {
        szkeleton.hivas(this, "atAllit");
        szkeleton.visszateres(this, "atAllit", "false");
        return false;
    }

    @Override
    public boolean javitjak() {
        szkeleton.hivas(this, "javitjak");
        szkeleton.visszateres(this, "javitjak", "false");
        return false;
    }

    @Override
    public boolean csoLehelyezes(Cso cs) {
        szkeleton.hivas(this, "csoLehelyezes");
        szkeleton.visszateres(this, "csoLehelyezes", "false");
        return false;
    }

    @Override
    public void lerakjak(Jatekos lerako) {
        szkeleton.hivas(this, "lerakjak");
        rajtaAllnak.add(lerako);
        szkeleton.visszateres(this, "lerakjak");
    }
}
