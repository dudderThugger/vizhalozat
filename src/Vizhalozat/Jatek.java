package Vizhalozat;

import GUI.Point;
import GUI.Vezerlo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

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
    Vezerlo vezerlo;

    /**
     * A játék osztály egyetlen konstruktora
     */
    public Jatek(Vezerlo vezerlo) {
        randomKi = false;
        timer = new Timer();
        pumpak = new ArrayList<>();
        csovek = new ArrayList<>();
        this.vezerlo = vezerlo;
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
        Szerelo szerelo1 = new Szerelo();
        Szerelo szerelo2 = new Szerelo();
        Szabotor szabotor1 = new Szabotor();
        Szabotor szabotor2 = new Szabotor();
        Forras forras1 = new Forras(this);
        Forras forras2 = new Forras(this);
        Ciszterna ciszterna1 = new Ciszterna(this);
        Ciszterna ciszterna2 = new Ciszterna(this);
        Cso cso1 = new Cso(this);
        Cso cso2 = new Cso(this);

        jatekosok.add(szerelo1);
        szerelok.add(szerelo1);
        vezerlo.addSzerelo(szerelo1);
        jatekosok.add(szerelo2);
        szerelok.add(szerelo2);
        vezerlo.addSzerelo(szerelo2);
        jatekosok.add(szabotor1);
        szabotorok.add(szabotor1);
        vezerlo.addSzabotor(szabotor1);
        jatekosok.add(szabotor2);
        szabotorok.add(szabotor2);
        vezerlo.addSzabotor(szabotor2);

        mezok.add(forras1);
        forrasok.add(forras1);
        vezerlo.addForras(forras1, new Point(50, 50));
        mezok.add(forras2);
        forrasok.add(forras2);
        vezerlo.addForras(forras2, new Point(50, 450));
        mezok.add(ciszterna1);
        ciszternak.add(ciszterna1);
        vezerlo.addCiszterna(ciszterna1, new Point(1000, 50));
        mezok.add(ciszterna2);
        ciszternak.add(ciszterna2);
        vezerlo.addCiszterna(ciszterna2, new Point(1000, 450));
        mezok.add(cso1);
        csovek.add(cso1);
        vezerlo.addCso(cso1);
        mezok.add(cso2);
        csovek.add(cso2);
        vezerlo.addCso(cso2);

        cso1.setSzomszedok(new ArrayList<Mezo>( List.of(forras1, ciszterna1)));
        cso2.setSzomszedok(new ArrayList<Mezo>( List.of(forras2, ciszterna2)));
        szerelo1.raAllit(ciszterna1);
        szerelo2.raAllit(ciszterna2);
        szabotor1.raAllit(forras1);
        szabotor2.raAllit(forras2);
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