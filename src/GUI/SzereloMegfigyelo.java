package GUI;

import Vizhalozat.Szerelo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SzereloMegfigyelo extends JatekosMegfigyelo {
    /**
     * Az osztály által reprezentált szerelo osztály egy pédányát tárolja.
     * Ennek az obejktumnak az állapotát figyeli és ennek megfelelően zajlik a kirajzolás.
     */
    Szerelo observed;
    public SzereloMegfigyelo(Szerelo szerelo, JatekPanel panel) {
        super(panel, szerelo);
        observed = szerelo;
        coordinate = panel.getObservedCoordinate(observed.getRajtaAll());
    }


    @Override
    public void draw(Graphics g) {
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

    @Override
    public boolean intersect(int x, int y) {
        return false;
    }
}
