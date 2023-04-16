package Vizhalozat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

/**
 * A játék belső szerkezetéért felelős osztály. A játék ciklusának futtatásáért, játékosok és mezők létrehozasaért
 * és az aktuális állás számontartásáért felelős
 */
public class Jatek {
    private Szkeleton szkeleton;

    private ArrayList<Mezo> mezok;
    private ArrayList<Pumpa> pumpak;
    private int szabotorPont;
    private int szereloPont;

    /**
     * A játék osztály egyetlen konstruktora
     * @param sz A szkeleton, tesztelő osztály konstruktora
     */
    public Jatek(Szkeleton sz) {
        mezok = new ArrayList<Mezo>();
        pumpak = new ArrayList<Pumpa>();
        szkeleton = sz;
        szabotorPont = 0;
        szereloPont = 0;
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
        szkeleton.hivas(this, "pumpaElromlik");
        Random random = new Random();
        for (Pumpa pumpa : pumpak) {
            int ertek = Integer.parseInt(szkeleton.kerdes(this, "Mi a random ertek?"));
            if(ertek < 2) {
                pumpa.elromlik();
            }
        }
        szkeleton.visszateres(this, "pumpaElromlik");
    }

    /**
     * A szerelők pontját növelő függvény
     */
    public void szereloPontSzerzes(){
        szkeleton.hivas(this, "szereloPontSzerzes");
        szereloPont++;
        szkeleton.visszateres(this, "szereloPontSzerzes");
    }

    /**
     * A szabotőrök pontját növelő függvény
     */
    public void szabotorPontSzerzes(){
        szkeleton.hivas(this, "szabotorPontSzerzes");
        szabotorPont++;
        szkeleton.visszateres(this, "szabotorPontSzerzes");
    }
}
