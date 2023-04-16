package Vizhalozat;

/**
 * A vihető tárgyakat reprezentáló interfész, az interfészt megvalósító osztályok lerakhatóak
 */
public interface Viheto {
    /**
     * Ezt a függvényt implementálják a Cső és Pumpa osztályok annak érdekében, hogy le lehessen őket rakni egy helyre
     * @param lerako a Jatekos, aki lerakja a az adott objektumot
     */
    public void lerakjak(Jatekos lerako);
}
