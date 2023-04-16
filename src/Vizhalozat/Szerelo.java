package Vizhalozat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A szerelőket reprezentáló osztály, a közös akciókon felül képesek foltozni, pumpát szerelni és
 * pumpát venni
 */
public class Szerelo extends Jatekos{
    private Pumpa pumpaTart;
    public Szerelo(Mezo rajtaAll, Szkeleton szkeleton) {
        super(rajtaAll, szkeleton);
    }

    /**
     * Amennyiben van a szerelő kezében pumpa, "kettévágja" a csövet amin áll
     * és a régi és a létrejött cső közé beköti a pumpát
     * a Vihető függvényét valósítja meg
     */
    @Override
    public void lerak_pumpa() {
        szkeleton.hivas(this, "lerak_pumpa");
        if(pumpaTart != null) {
            if(rajtaAll.pumpaLehelyez(pumpaTart)) {
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
        }
        szkeleton.visszateres(this, "lerak_pumpa");
    }

    /**
     * A szerelő a Forrásoknál képes "venni" pumpát
     * ilyenkor lényegében a Forrás amin áll a Szerelő, legenerál egy új pumpát beleteszi a Szerelő kezébe
     */
    public void pumpatvesz(){
        szkeleton.hivas(this, "pumpatvesz");

        Pumpa p = rajtaAll.pumpaVasarlas();
        if(tart==null){
            pumpaTart = p;
        }
        szkeleton.visszateres(this, "pumpatvesz");
    }

    /**
     * a Szerelőnek a "kezébe nyomja" az adott pumpát
     * @param t, amit a szerelő megkap a kezébe
     */
    public void add_PumpaTart(Pumpa t){
        // szkeleton.hivas(this, "add_PumpaTart");
        pumpaTart = t;
        tart = t;
        // szkeleton.visszateres(this, "add_PumpaTart");
    }

    /**
     * Lekéri a szerelőnél lévő pumpát
     * @return kézben tartott pumpa referenciája
     */
    @Override
    public Pumpa get_PumpaTart(){
        return pumpaTart;
    }

    /**
     * Amennyiben lyukas az adott cső amin a Szerelő áll, azt ezzel a függvénnyel befoltozza
     */
    public void foltoz() {
        szkeleton.hivas(this, "foltoz");
        rajtaAll.foltoz();
        szkeleton.visszateres(this, "foltoz");
    }

    public void szerel(){
        szkeleton.hivas(this, "szerel");
        rajtaAll.javitjak();
        szkeleton.visszateres(this, "szerel");
    }
}
