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

    public void szabotorPontSzerzes(){
        szkeleton.hivas(this, "szabotorPontSzerzes");
        szkeleton.visszateres(this, "szabotorPontSzerzes");
    }

    /**
     *A játék indulásakor hívódik meg
     * Legenerálja az alap pályát és beállítja az elemeket szomszédoknak
     */
    public void init(){
        szkeleton.hivas(this, "init");

        Forras f1 = new Forras(this, szkeleton);
        szkeleton.ujObjektum(f1, "f1");
        szkeleton.hivas(f1, "<<create>>");
        szkeleton.visszateres(f1, "<<create>>");

        Cso cs1 = new Cso(this, szkeleton);
        szkeleton.ujObjektum(cs1, "cs1");
        szkeleton.hivas(cs1, "<<create>>");
        szkeleton.visszateres(cs1, "<<create>>");

        Pumpa p1 = new Pumpa(this, szkeleton);
        szkeleton.ujObjektum(p1, "p1");
        szkeleton.hivas(p1, "<<create>>");
        szkeleton.visszateres(p1, "<<create>>");

        Cso cs2 = new Cso(this, szkeleton);
        szkeleton.ujObjektum(cs2, "cs2");
        szkeleton.hivas(cs2, "<<create>>");
        szkeleton.visszateres(cs2, "<<create>>");

        Ciszterna c1 = new Ciszterna(this, szkeleton);
        szkeleton.ujObjektum(c1, "c1");
        szkeleton.hivas(c1, "<<create>>");
        szkeleton.visszateres(c1, "<<create>>");

        cs1.addSzomszed(f1);
        f1.addSzomszed(cs1);

        p1.addSzomszed(cs1);
        cs1.addSzomszed(p1);

        cs2.addSzomszed(p1);
        p1.addSzomszed(cs2);

        c1.addSzomszed(cs2);
        cs2.addSzomszed(c1);

        szkeleton.visszateres(this, "init");
    }
}
