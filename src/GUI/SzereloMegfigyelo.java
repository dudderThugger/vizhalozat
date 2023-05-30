package GUI;

import Vizhalozat.Szerelo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A szerelő megfigyelőjét reprezentálja. Ez a szerelő kirajzolásáért felelős.
 */
public class SzereloMegfigyelo extends JatekosMegfigyelo {
    /**
     * Az osztály által reprezentált szerelo osztály egy pédányát tárolja.
     * Ennek az obejktumnak az állapotát figyeli és ennek megfelelően zajlik a kirajzolás.
     */
    Szerelo observed;

    /**
     * Beállítja a megfigyelt csövet és a panelt
     * @param szerelo
     * @param panel
     */
    public SzereloMegfigyelo(Szerelo szerelo, JatekPanel panel) {
        super(panel, szerelo);
        observed = szerelo;
        coordinate = panel.getObservedCoordinate(observed.getRajtaAll());
    }


    /**
     * Kirajzol egy szerelőt reprezentáló alakzatot a képernyőre, a Graphics objektum segítségével.
     * @param g Graphics objektum
     */
    @Override
    public void draw(Graphics g) {
        //lekéri a koordinátákat
        Point coordinate = panel.getObservedCoordinate(observed.getRajtaAll());
        if (coordinate != null) {
            try {
                if(!selected) {
                    File file = new File("src/images/szerelo_sima.png");
                    BufferedImage img = ImageIO.read(file);
                    g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
                }
                else{
                    File file = new File("src/images/szerelo_kijelolt.png");
                    BufferedImage img = ImageIO.read(file);
                    g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
                }
            } catch(IOException e) {
                System.out.println("File not found exception!");
            }
        }
    }


    /**
     * Eldönti, hogy az adott pont benne van-e a megfigyelt alakzatban.
     * @param x kapott x koordináta
     * @param y kapott y koordináta
     * @return iagz, ha benne volt különben hamis
     */
    @Override
    public boolean intersect(int x, int y) {
        /*if(x >= coordinates.x && x <=coordinates.x + 50 && y <= coordinates.y && y >= coordinates.y - 50){
            return true;
        }*/
        return false;
    }
}
