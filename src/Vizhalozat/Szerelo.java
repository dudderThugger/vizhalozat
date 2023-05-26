package Vizhalozat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A szerelőket reprezentáló osztály, a közös akciókon felül képesek foltozni, pumpát szerelni és
 * pumpát venni
 */
public class Szerelo extends Jatekos{
    private Pumpa pumpaTart;
    public Szerelo() {

    }

    /**
     * Amennyiben van a szerelő kezében pumpa, "kettévágja" a csövet amin áll
     * és a régi és a létrejött cső közé beköti a pumpát
     * a Vihető függvényét valósítja meg
     */
    public void lerak_pumpa() {
        if (pumpaTart != null) {
            if (rajtaAll.pumpaLehelyez(pumpaTart)) {
                Cso uj = new Cso(jatek);
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
    }

    /**
     * A szerelő a Forrásoknál képes "venni" pumpát
     * ilyenkor lényegében a Forrás amin áll a Szerelő, legenerál egy új pumpát beleteszi a Szerelő kezébe
     */
    public void pumpatvesz(){
        Pumpa p = rajtaAll.pumpaVasarlas();
        if(tart == null){
            tart =p;
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
