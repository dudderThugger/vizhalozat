package Vizhalozat;

/**
 * A szabotőröket reprezentáló osztály, a közös akciókon felül képesek csöveket lyukasztani.
 */
public class Szabotor extends Jatekos{
    public Szabotor(Mezo rajtaAll, Szkeleton szkeleton) {
        super(rajtaAll, szkeleton);
    }

    /**
     * Amennyiben van a szabotőr kezében pumpa, "kettévágja" a csövet amin áll
     * és a régi és a létrejött cső közé beköti a pumpát
     * a Vihető függvényét valósítja meg
     */
    @Override
    public void lerak_pumpa() {

    }

    /**
     * Lekéri a szabotőrnél lévő pumpát
     * @return kézben tartott pumpa referenciája
     */
    @Override
    Pumpa get_PumpaTart() {
        return null;
    }

    /**
     * Amennyiben nem lyukas az adott cső amin a Szabotőr áll
     * egy akciójával képes azt kilyukasztani, amivel a csőben lévő víz elfolyik a sivatagban
     */
    public void lyukaszt(){
        szkeleton.hivas(this, "lyukaszt");
        rajtaAll.lyukaszt();
        szkeleton.visszateres(this, "lyukaszt");
    }
}
