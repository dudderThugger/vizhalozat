package Vizhalozat;

/**
 * Létrehozza a játék objektumot és elindítja a játékot.
 */
public class App {
    /**
     * A main függvény, létrehozza a játék objektumot
     * @param args a program argumentumai
     */
    public static void main(String[] args) {
        Szkeleton szkeleton = new Szkeleton();

        szkeleton.kezdoFelulet();
    }
}
