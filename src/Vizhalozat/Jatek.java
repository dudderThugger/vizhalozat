package Vizhalozat;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A játék belső szerkezetéért felelős osztály. A játék ciklusának futtatásáért, játékosok és mezők létrehozasaért
 * és az aktuális állás számontartásáért felelős
 */
public class Jatek {
    /** A játékosokat tartalmazó lista */
    private ArrayList<Jatekos> jatekosok = new ArrayList<>();
    /** A szerelőket tartalmazó lista */
    private ArrayList<Szerelo> szerelok = new ArrayList<>();
    /** A szabotőröket tartalmazó lista */
    private ArrayList<Szabotor> szabotorok = new ArrayList<>();
    /** A mezőket tartalmazó lista */
    private ArrayList<Mezo> mezok = new ArrayList<>();
    /** A ciszternákat tartalmazó lista */
    private ArrayList<Ciszterna> ciszternak = new ArrayList<>();
    /** A forrásokat tartalmazó lista */
    private ArrayList<Forras> forrasok = new ArrayList<>();
    /** A pumpákat tartalmazó lista */
    private final ArrayList<Pumpa> pumpak;
    /** A szabotőrök pontjait jelző egész érték */
    int szabotorPont;
    /** A szerelők pontjait jelző egész érték */
    int szereloPont;
    /** időzítő, ami a vizFolyas és pumpaElromlik metódus időközönkénti meghívásáért felelős*/
    private Timer timer;
    /** A csöveket tartalmazó lista */
    private final ArrayList<Cso> csovek;
    private boolean randomKi;
    private boolean gameOver;

    /**
     * A játék osztály egyetlen konstruktora
     */
    public Jatek() {
        randomKi = false;
        timer = new Timer();
        pumpak = new ArrayList<>();
        csovek = new ArrayList<>();
    }

    public void setRandomKi(boolean randomKi) {
        this.randomKi = randomKi;
    }

    /**
     * A játék Játékosok listájához ad hozzá egy szerelőt
     * @param jatekos Szerelo tipust ad a listához
     */
    public void addJatekos(Szerelo jatekos) {
        jatekosok.add(jatekos);
        szerelok.add(jatekos);
    }
    /**
     * A játék Játékosok listájához ad hozzá egy szabotőrt
     * @param jatekos Szabotor tipust ad a listához
     */
    public void addJatekos(Szabotor jatekos) {
        jatekosok.add(jatekos);
        szabotorok.add(jatekos);
    }
    /**
     * A játék Mezők listájához ad hozzá egy ciszternát
     * @param mezo Ciszterna tipust ad a listához
     */
    public void addMezo(Ciszterna mezo) {
        mezok.add(mezo);
        ciszternak.add(mezo);
    }
    /**
     * A játék Mezők listájához ad hozzá egy csövet
     * @param mezo Cso tipust ad a listához
     */
    public void addMezo(Cso mezo) {
        mezok.add(mezo);
        csovek.add(mezo);
    }
    /**
     * A játék Mezők listájához ad hozzá egy forást
     * @param mezo Forras tipust ad a listához
     */
    public void addMezo(Forras mezo) {
        mezok.add(mezo);
        forrasok.add(mezo);
    }
    /**
     * A játék Mezők listájához ad hozzá egy pumpát
     * @param mezo Pumpa tipust ad a listához
     */
    public void addMezo(Pumpa mezo) {
        mezok.add(mezo);
        pumpak.add(mezo);
    }

    /**
     * A játék folyamán használatban lévő pumpák listájához ad hozzá egy új elemet
     * @param pumpa Az új elem amit hozzáfűz a listához
     */
    public void addPumpa(Pumpa pumpa) {
        pumpak.add(pumpa);
    }

    /**
     * Minden pumpára kisorsolja, hogy elromlik-e vagy sem
     */
    public void pumpaElRomlik() {
        for (Pumpa p: pumpak) {
            p.elromlik();
        }
    }

    public void vizFolyas(){
        if(randomKi){
            for (Pumpa p : pumpak) {
                p.setTelitett(false);
            }
            for (Mezo m : mezok) {
                m.setTelitett(false);
            }
            for (Cso cs : csovek) {
                cs.setTelitett(false);
            }
            for (Forras f : forrasok) {
                f.setTelitett(false);
            }
            for (Ciszterna c : ciszternak) {
                c.setTelitett(false);
            }

            for (Forras f : forrasok) {
                f.vizTermeles();
            }
        }
    }


    public ArrayList<Jatekos> getJatekosok() { return jatekosok; }
    public ArrayList<Szerelo> getSzerelok() { return szerelok; }
    public ArrayList<Szabotor> getSzabotorok() { return szabotorok; }
    public ArrayList<Mezo> getMezok() { return mezok; }
    public ArrayList<Forras> getForrasok() { return forrasok; }
    public ArrayList<Ciszterna> getCiszternak() { return ciszternak; }
    public ArrayList<Pumpa> getPumpak() { return pumpak; }
    public ArrayList<Cso> getCsovek() { return csovek; }


    /**
     * A szerelők pontját növelő függvény
     */
    public void szereloPontSzerzes(){
        szereloPont++;
    }

    /**
     * A szabotőrök pontját növelő függvény
     */
    public void szabotorPontSzerzes(){
        szabotorPont++;
    }

    /**
     *A játék indulásakor hívódik meg
     * Legenerálja az alap pályát és beállítja az elemeket szomszédoknak
     */
    public void init(){
        szabotorPont = 0;
        szereloPont = 0;
    }

    public void tick() {
        for(Jatekos jatekos : jatekosok ) {
            jatekos.tick();
        }
        for(Cso cso : csovek) {
            cso.tick();
        }
    }
}
