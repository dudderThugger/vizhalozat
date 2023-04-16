package Vizhalozat;

/**
 * A szabotőröket reprezentáló osztály, a közös akciókon felül képesek csöveket lyukasztani.
 */
public class Szabotor extends Jatekos{
    public Szabotor(Mezo rajtaAll, Szkeleton szkeleton) {
        super(rajtaAll, szkeleton);
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