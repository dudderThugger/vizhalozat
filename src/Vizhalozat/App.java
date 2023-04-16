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
        szkeleton = new Szkeleton();

        szkeleton.kezdoFelulet();
    }

    /**
     * A rendes játékban létező main függvény, ami legenerálja a mapot és elindítja a játékot
     */
    public void main(){
        szkeleton.hivas(this, "main");
        Jatek j = new Jatek(szkeleton);
        szkeleton.ujObjektum(j, "j");
        j.init();
        szkeleton.visszateres(this, "main");
    }

}
