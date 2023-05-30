package Vizhalozat;

/**
 * A szabotőröket reprezentáló osztály, a közös akciókon felül képesek csöveket lyukasztani.
 */
public class Szabotor extends Jatekos{
    public Szabotor(Jatek jatek, Mezo mezo){
        super(jatek, mezo);
    }

    /**
     * Amennyiben nem lyukas az adott cső amin a Szabotőr áll
     * egy akciójával képes azt kilyukasztani, amivel a csőben lévő víz elfolyik a sivatagban
     */
    public void lyukaszt(){
        if (akcioIdo == 0) {
            if(rajtaAll.lyukaszt()) akcioIdo = 5;
        }
    }

    /**
     * Meprrbalja csuszossa tenni a mezot
     */
    public void  csuszik(){
            rajtaAll.csuszik();
    }


}
