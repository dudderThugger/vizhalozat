package Vizhalozat;

import java.util.Scanner;

public class Cso extends Mezo implements Viheto {
    public Cso(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
    }

    @Override
    public boolean felveszik() {
        return false;
    }

    @Override
    public void befolyik() {

    }

    @Override
    public boolean pumpaLehelyez(Pumpa p) {
        szkeleton.kerdes(this, "Allnak rajtam (Igen/Nem)");
        szkeleton.visszateres(this, "pumpaLehelyez", "True");
        return true;
    }

    @Override
    public boolean foltoz() {
        return false;
    }

    @Override
    public boolean lyukaszt() {
        return false;
    }

    @Override
    public Pumpa pumpaVasarlas() {
        return null;
    }

    @Override
    public boolean atAllit(Cso be, Cso ki) {
        return false;
    }

    @Override
    public boolean javitjak() {
        return false;
    }

    @Override
    public boolean csoLehelyezes(Cso cs) {
        return false;
    }

    @Override
    public void lerakjak(Jatekos lerako) {
        szkeleton.hivas(this, "lerakjak");
        rajtaAllnak.add(lerako);
        szkeleton.visszateres(this, "lerakjak");
    }
}
