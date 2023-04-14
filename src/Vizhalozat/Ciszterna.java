package Vizhalozat;

/**
 * A ciszterna a bele folyó víz (azaz a szerelők pontjainak) számlálásáért felelős, illetve a szerelők itt
 * tudnak felvenni további pumpákat.
 */
public class Ciszterna extends AktivElemek{
    /**
     * A ciszterna egyetlen konstruktora, meghívja az ős konstruktorát
     * @param jatek A játék objektum referenciája
     * @param szkeleton A szkeleton, tesztelő osztály konstruktora
     */
    public Ciszterna(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
    }

    /**
     * Befolyik a víz a ciszternába, nincs semmilyen hatása
     */
    @Override
    public void befolyik() {
        szkeleton.hivas(this, "befolyik");
        szkeleton.visszateres(this, "befolyik");
    }

    /**
     * Megpróbálják a ciszternábak be- és kimenetét állítani, ami nyilván sikertelen
     * @param be Az új bemenet
     * @param ki Az új kimenet
     * @return Mindig false
     */
    @Override
    public boolean atAllit(Cso be, Cso ki) {
        szkeleton.hivas(this, "atAlllit");
        szkeleton.visszateres(this, "atAllit", "false");
        return false;
    }

    /**
     * Megpróbálják a ciszternát javítani, ami nyilván sikertelen
     * @return Mindig false
     */
    @Override
    public boolean javitjak() {
        szkeleton.hivas(this, "javitjak");
        szkeleton.visszateres(this, "javitjak", "false");
        return false;
    }

    /**
     * Megpróbálnak pumpát venni a ciszternán, ekkor a ciszterna létrehoz egy új pumpát
     * @return Az új pumpa
     */
    @Override
    public Pumpa pumpaVasarlas() {
        szkeleton.hivas(this, "pumpaVasarlas");
        Pumpa ret = new Pumpa(jatek, szkeleton);
        szkeleton.ujObjektum(ret, "p");
        szkeleton.visszateres(this, "pumpaVasarlas", ret);
        return null;
    }
}
