package Vizhalozat;

/**
 * Létrehozza a játék objektumot és elindítja a játékot.
 */
public class App {
    private static Szkeleton szkeleton;
    /**
     * A main függvény, létrehozza a játék objektumot
     * @param args a program argumentumai
     */
    public static void main(String[] args) {
        Proto proto = new Proto();
        proto.parancsIndito();
    }

    /**
     * A rendes játékban létező main függvény, ami legenerálja a mapot és elindítja a játékot
     */
    public void main(){
        Jatek j = new Jatek();
        j.init();
    }

}
