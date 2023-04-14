package Vizhalozat;
import java.util.Scanner;

public class Cso extends Mezo implements Viheto {
    protected boolean lyukas;
    public Cso(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
    }

    @Override
    public boolean felveszik() {
        Scanner scanner = new Scanner(System.in);

        szkeleton.hivas(this, "felveszik");
        szkeleton.kerdes(this, "Allnak rajtam?(Igen/Nem)");
        String ertek = scanner.nextLine();
        if(ertek.equals("Nem") ){
            szkeleton.visszateres(this, "felveszik", "True");
            return true;
        }
            szkeleton.visszateres(this, "felveszik", "False");
            return false;
    }
    /**
    Telitett lesz,ha nem volt az,
    es meghivja az osszes szomszedjara a
    befolyik() fuggvenyt.
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
            szkeleton.visszateres(this, "ralep", "True");
            return true;
        }
        szkeleton.visszateres(this, "ralep", "False");
        return false;
    }

    /**
     * @param p Pumpat var
     * @return mindig false
     */
    @Override
    public boolean pumpaLehelyez(Pumpa p) {
        szkeleton.kerdes(this, "Allnak rajtam (Igen/Nem)");
        szkeleton.visszateres(this, "pumpaLehelyez", "True");
        return true;
    }

    /**
     * Cso foltozasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean foltoz()
    {
        szkeleton.hivas(this, "foltoz");
        if(lyukas){
          lyukas = false;
            szkeleton.visszateres(this, "foltoz","True");
          return true;
        }
        szkeleton.visszateres(this, "foltoz","False");
        return false;
    }
    /**
     * Cso lyukasztasa
     * @return true, ha sikeres volt, false ha nem
     */
    @Override
    public boolean lyukaszt() {
        szkeleton.hivas(this, "lyukaszt");
        if(!lyukas){
            lyukas = true;
            szkeleton.visszateres(this, "lyukaszt", "True");
            return true;
        }
        szkeleton.visszateres(this, "lyukaszt", "False");
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
        szkeleton.visszateres(this, "atAllit", "False");
        return false;
    }

    @Override
    public boolean javitjak() {
        szkeleton.hivas(this, "javitjak");
        szkeleton.visszateres(this, "javitjak", "False");
        return false;
    }

    @Override
    public boolean csoLehelyezes(Cso cs) {
        szkeleton.hivas(this, "csoLehelyezes");
        szkeleton.visszateres(this, "csoLehelyezes", "False");
        return false;
    }

    @Override
    public void lerakjak(Jatekos lerako) {
        szkeleton.hivas(this, "lerakjak");
        rajtaAllnak.add(lerako);
        szkeleton.visszateres(this, "lerakjak");
    }
}
