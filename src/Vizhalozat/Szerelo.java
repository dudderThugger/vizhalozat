package Vizhalozat;

import java.util.ArrayList;
import java.util.Scanner;

public class Szerelo extends Jatekos{
    private Pumpa pumpaTart;
    public Szerelo(Mezo rajtaAll, Szkeleton szkeleton) {
        super(rajtaAll, szkeleton);
    }
    @Override
    public void lerak_pumpa() {
        szkeleton.hivas(this, "lerak_pumpa");
        if(pumpaTart != null) {
            rajtaAll.pumpaLehelyez(pumpaTart);
            Cso uj = new Cso(jatek, szkeleton);
            szkeleton.ujObjektum(uj, "uj");
            ArrayList<Mezo> szomszedok = rajtaAll.getSzomszedok();
            Mezo szomszed = szomszedok.get(0);
            rajtaAll.removeSzomszed(szomszed);
            uj.addSzomszed(szomszed);
            uj.addSzomszed(pumpaTart);
            tart.lerakjak(this);
            pumpaTart.addSzomszed(uj);
            pumpaTart.addSzomszed(rajtaAll);
            szomszed.removeSzomszed(rajtaAll);
            szomszed.addSzomszed(uj);
        }
        szkeleton.visszateres(this, "lerak_pumpa");
    }
}
