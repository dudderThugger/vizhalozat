package Vizhalozat;

import java.util.Random;

/**
 * A ciszterna a bele folyó víz (azaz a szerelők pontjainak) számlálásáért felelős, illetve a szerelők itt
 * tudnak felvenni további pumpákat.
 */
public class Ciszterna extends AktivElemek{
    /**
     * A ciszterna egyetlen konstruktora, meghívja az ős konstruktorát
     * @param jatek A játék objektum referenciája
     */
    public Ciszterna(Jatek jatek) {
        super(jatek);
    }

    /**
     * Befolyik a víz a ciszternába, nincs semmilyen hatása
     */
    @Override
    public void befolyik() {
        telitett = true;
        jatek.szereloPontSzerzes();
    }

    /**
     * Megpróbálják a ciszternábak be- és kimenetét állítani, ami nyilván sikertelen
     * @param be Az új bemenet
     * @param ki Az új kimenet
     * @return Mindig false
     */
    @Override
    public boolean atAllit(Cso be, Cso ki) {
        return false;
    }

    /**
     * Megpróbálják a ciszternát javítani, ami nyilván sikertelen
     * @return Mindig false
     */
    @Override
    public boolean javitjak() {
        return false;
    }

    /**
     * Ciszternan nem lehet megcsuszni
     * @return null
     */
    @Override
    public Mezo megcsuszik() {
        return null;
    }

    /**
     * Megpróbálnak pumpát venni a ciszternán, ekkor a ciszterna létrehoz egy új pumpát
     * @return Az új pumpa
     */
    @Override
    public Pumpa pumpaVasarlas() {
        Pumpa ret = new Pumpa(jatek);
        return ret;
    }

    /**
     * Random időközönként hívja a Játék
     * Ez hozza létre az új csöveket, amik az egyes ciszternákhoz kapcsolódnak létrejöttükkor
     */
    public void csoKeszul(){
        Random random = new Random();
        if (random.nextInt() % 4 == 0) {
            Cso cs = new Cso(jatek);
            cs.setLog();
            cs.addSzomszed(this);
            addSzomszed(cs);
            jatek.addMezo(cs);
        }
    }

    /**
     * Ciszterma nem lehet csuszos
     * @return FALSE
     */
    public boolean csuszik(){return false;}

    /**
     * Ciszterna nem ragadhat
     * @return FALSE
     */
    public boolean ragaszt(){return false;}
}
