package Megfigyelok;

import Vizhalozat.Forras;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A forrás megfigyelőjét reprezentálja. Ez a forrás kirajzolásáért felelős.
 */
public class ForrasMegfigyelo extends Megfigyelo{
    private Forras observed; /**Az osztály által reprezentált forrás osztály egy pédányát tárolja. Ennek az obejktumnak az állapotát figyeli és ennek megfelelően zajlik a kirajzolás.*/
    public ForrasMegfigyelo(Point p, Forras f) {
        super(p); observed = f;
    }

    /**
     * Kirajzol egy forrást reprezentáló alakzatot a képernyőre, a Graphics objektum segítségével
     * @param g a jatekpanel graphics referenciája
     */
    public void draw(Graphics g){
        try {
            File file = new File("src/images/forras.png");
            BufferedImage img = ImageIO.read(file);
            g.drawImage(img, coordinates.x, coordinates.y, 100, 100, null);
        } catch(IOException e) {
            System.out.println("File not found exception!");
        }
    }

    /**
     * a négyzet 4 sarkka közötti résznél eltalálja a négyzetet a pont
     * @param x egérkattintás x koordinátája a képernyőn
     * @param y egérkattintás y koordinátája a képernyőn
     * @return bináris érték, attól függően, hogy a kapott pont benne volt a négyzetben vagy sem
     */
    public boolean intersect(int x, int y){
        if((x >= coordinates.x - 50 && x <= coordinates.x + 50) && (y >= coordinates.y - 50 && y <= coordinates.y + 50))  return true;
        else return false;
    }
}
