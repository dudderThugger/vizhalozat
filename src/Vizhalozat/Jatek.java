package Vizhalozat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Jatek {
    private Szkeleton szkeleton;
    private ArrayList<Mezo> mezok;
    private ArrayList<Pumpa> pumpak;
    private int szabotorPont;
    private int szereloPont;

    public Jatek(Szkeleton sz) {
        mezok = new ArrayList<Mezo>();
        pumpak = new ArrayList<Pumpa>();
        szkeleton = sz;
        szabotorPont = 0;
        szereloPont = 0;
    }

    public void addPumpa(Pumpa pumpa) {
        pumpak.add(pumpa);
    }

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

    public void szereloPontSzerzes(){
        szkeleton.hivas(this, "szereloPontSzerzes");
        szkeleton.visszateres(this, "szereloPontSzerzes");
    }
}
