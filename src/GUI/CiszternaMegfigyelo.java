package GUI;

import Vizhalozat.Ciszterna;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A ciszterna megfigyelőjét reprezentálja. Ez az osztály a ciszternák kirajzolásáért felelős.
 */
public class CiszternaMegfigyelo extends MezoMegfigyelo {
    /**
     * A példány amely állapotai alapján rajzolja ki a megfigyelő
     */
    Ciszterna observed;
    /**
     * A ciszterna megfigyelő konstruktora
     * @param ciszterna Az objektum amit megjelenítünk
     * @param hova  A koordináta ahol megjelenítjük
     * @param panel A Játékpanel amin megjelenítjük az objektumot
     */
    public CiszternaMegfigyelo(Ciszterna ciszterna, Point hova, JatekPanel panel) {
        super(ciszterna, hova, panel);
        observed = ciszterna;
    }
    /**
     * Kirajzol egy ciszternát reprezentáló alakzatot a képernyőre, a Graphics objektum segítségével
     * @param g a jatekpanel graphics referenciája
     */
    @Override
    public void draw(Graphics g) {
        try{
            if(!selected) {
                File file = new File("src/images/ciszterna.png");
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x - 50, coordinate.y - 50, 100, 100, null);
            }
            else{
                File file = new File("src/images/ciszterna_kijelolt.png");
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x - 50, coordinate.y - 50, 100, 100, null);
            }
        }
        catch (IOException e){
            System.out.println("File not found!");
        }

    }
    /**
     * a négyzet 4 sarkka közötti résznél eltalálja a négyzetet a pont
     * @param x egérkattintás x koordinátája a képernyőn
     * @param y egérkattintás y koordinátája a képernyőn
     * @return bináris érték, attól függően, hogy a kapott pont benne volt a négyzetben vagy sem
     */
    @Override
    public boolean intersect(int x, int y) {
        if((x >= coordinate.x - 50 && x <= coordinate.x + 50) && (y >= coordinate.y - 50 && y <= coordinate.y + 50))  return true;
        else return false;
    }
}
