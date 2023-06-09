package Vizhalozat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A szerelőket reprezentáló osztály, a közös akciókon felül képesek foltozni, pumpát szerelni és
 * pumpát venni
 */
public class Szerelo extends Jatekos{
    private Pumpa pumpaTart;
    public Szerelo(Jatek jatek, Mezo mezo) {
        super(jatek, mezo);
    }

    /**
     * Amennyiben van a szerelő kezében pumpa, "kettévágja" a csövet amin áll
     * és a régi és a létrejött cső közé beköti a pumpát
     * a Vihető függvényét valósítja meg
     */
    public void lerak_pumpa() {
        if (pumpaTart != null) {
            if (rajtaAll.pumpaLehelyez(pumpaTart)) {
                Cso uj = new Cso(jatek); // uj cso
                ArrayList<Mezo> szomszedok = rajtaAll.getSzomszedok();
                Mezo szomszed1 = szomszedok.get(0); // ciszterna
                rajtaAll.removeSzomszed(szomszed1);
                rajtaAll.lelep(this);
                uj.addSzomszed(pumpaTart);
                uj.addSzomszed(szomszed1);
                szomszed1.removeSzomszed(rajtaAll);
                szomszed1.addSzomszed(uj);
                pumpaTart.addSzomszed(uj);
                pumpaTart.lerakjak(this);
                rajtaAll = pumpaTart;
                jatek.addMezo(pumpaTart);
                jatek.addMezo(uj);
                pumpaTart = null;
            }
        }
    }

    /**
     * A szerelő a Forrásoknál képes "venni" pumpát
     * ilyenkor lényegében a Forrás amin áll a Szerelő, legenerál egy új pumpát beleteszi a Szerelő kezébe
     */
    public void pumpatvesz(){
        Pumpa p = rajtaAll.pumpaVasarlas();
        if(pumpaTart == null){
            pumpaTart = p;
        }
    }

    /**
     * a Szerelőnek a "kezébe nyomja" az adott pumpát
     * @param t, amit a szerelő megkap a kezébe
     */
    public void add_PumpaTart(Pumpa t){
        pumpaTart = t;
        tart = t;
    }

    /**
     * Lekéri a szerelőnél lévő pumpát
     * @return kézben tartott pumpa referenciája
     */
    public Pumpa get_PumpaTart(){
        return pumpaTart;
    }

    /**
     * Amennyiben lyukas az adott cső amin a Szerelő áll, azt ezzel a függvénnyel befoltozza
     */
    public void foltoz() {
        if (akcioIdo == 0) {
            if(rajtaAll.foltoz()) akcioIdo = 5;
        }
    }

    /**
     * Amennyiben nem mukodik a,a szerelo megjavitja
     */
    public void szerel(){
        rajtaAll.javitjak();
    }
}
