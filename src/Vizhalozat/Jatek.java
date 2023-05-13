package Vizhalozat;

import java.util.ArrayList;
import java.util.Timer;

/**
 * A játék belső szerkezetéért felelős osztály. A játék ciklusának futtatásáért, játékosok és mezők létrehozasaért
 * és az aktuális állás számontartásáért felelős
 */
public class Jatek {
    private ArrayList<Jatekos> jatekosok = new ArrayList<>();
    private ArrayList<Szerelo> szerelok = new ArrayList<>();
    private ArrayList<Szabotor> szabotorok = new ArrayList<>();
    private ArrayList<Mezo> mezok = new ArrayList<>();
    private ArrayList<Ciszterna> ciszternak = new ArrayList<>();
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

    /**
     * A játék osztály egyetlen konstruktora
     */
    public Jatek() {
        pumpak = new ArrayList<>();
        csovek = new ArrayList<>();
    }

    public void addJatekos(Szerelo jatekos) {
        jatekosok.add(jatekos);
        szerelok.add(jatekos);
    }
    public void addJatekos(Szabotor jatekos) {
        jatekosok.add(jatekos);
        szabotorok.add(jatekos);
    }

    public void addMezo(Ciszterna mezo) {
        mezok.add(mezo);
        ciszternak.add(mezo);
    }
    public void addMezo(Cso mezo) {
        mezok.add(mezo);
    }

    public void addMezo(Forras mezo) {
        mezok.add(mezo);
        forrasok.add(mezo);
    }

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
    public void pumpaElRomlik(boolean randomKi) {
//        for (Pumpa pumpa : pumpak) {
//            if(ertek < 2) {
//                pumpa.elromlik();
//            }
//        }

        if(randomKi) {
            for (Pumpa p: pumpak) {
                p.elromlik();
            }
        }
    }

    public void vizFolyas(boolean randomKi){
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

    /**
     * A szerelők pontját növelő függvény
     */
    public void szereloPontSzerzes(){
//        szkeleton.hivas(this, "szereloPontSzerzes");
//        szereloPont++;
//        szkeleton.visszateres(this, "szereloPontSzerzes");
        szereloPont++;
    }

    /**
     * A szabotőrök pontját növelő függvény
     */
    public void szabotorPontSzerzes(){
//        szkeleton.hivas(this, "szabotorPontSzerzes");
//        szabotorPont++;
//        szkeleton.visszateres(this, "szabotorPontSzerzes");
        szabotorPont++;
    }

    /**
     *A játék indulásakor hívódik meg
     * Legenerálja az alap pályát és beállítja az elemeket szomszédoknak
     */
    public void init(){
//        szkeleton.hivas(this, "init");
//
//        Forras f1 = new Forras(this, szkeleton);
//        szkeleton.ujObjektum(f1, "f1");
//        szkeleton.hivas(f1, "<<create>>");
//        szkeleton.visszateres(f1, "<<create>>");
//
//        Cso cs1 = new Cso(this, szkeleton);
//        szkeleton.ujObjektum(cs1, "cs1");
//        szkeleton.hivas(cs1, "<<create>>");
//        szkeleton.visszateres(cs1, "<<create>>");
//
//        Pumpa p1 = new Pumpa(this, szkeleton);
//        szkeleton.ujObjektum(p1, "p1");
//        szkeleton.hivas(p1, "<<create>>");
//        szkeleton.visszateres(p1, "<<create>>");
//
//        Cso cs2 = new Cso(this, szkeleton);
//        szkeleton.ujObjektum(cs2, "cs2");
//        szkeleton.hivas(cs2, "<<create>>");
//        szkeleton.visszateres(cs2, "<<create>>");
//
//        Ciszterna c1 = new Ciszterna(this, szkeleton);
//        szkeleton.ujObjektum(c1, "c1");
//        szkeleton.hivas(c1, "<<create>>");
//        szkeleton.visszateres(c1, "<<create>>");
//
//        cs1.addSzomszed(f1);
//        f1.addSzomszed(cs1);
//
//        p1.addSzomszed(cs1);
//        cs1.addSzomszed(p1);
//
//        cs2.addSzomszed(p1);
//        p1.addSzomszed(cs2);
//
//        c1.addSzomszed(cs2);
//        cs2.addSzomszed(c1);
//
//        szkeleton.visszateres(this, "init");

        timer.notify();
        szabotorPont = 0;
        szereloPont = 0;

        Szabotor szab1 = new Szabotor();
        Szabotor szab2 = new Szabotor();
        szabotorok.add(szab1); szabotorok.add(szab2);

        Szerelo szer1 = new Szerelo();
        Szerelo szer2 = new Szerelo();
        szerelok.add(szer1); szerelok.add(szer2);

        Forras f1 = new Forras(this);
        Forras f2 = new Forras(this);
        forrasok.add(f1); forrasok.add(f2);

        Ciszterna c1 = new Ciszterna(this);
        Ciszterna c2 = new Ciszterna(this);
        ciszternak.add(c1); ciszternak.add(c2);
    }
}
