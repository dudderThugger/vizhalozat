package GUI;

import Vizhalozat.Szabotor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SzabotorMegfigyelo extends Megfigyelo{
    Szabotor observed;
    public SzabotorMegfigyelo(Szabotor observed, JatekPanel panel) {
        super(panel);
        this.observed = observed;
    }
    @Override
    public void draw(Graphics g) {
        Point coordinate = panel.getObservedCoordinate(observed.getRajtaAll());
        if(coordinate != null) {
            try {
                if (!selected) {
                    File file = new File("src/images/szabotor_sima.png");
                    BufferedImage img = ImageIO.read(file);
                    g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
                } else {
                    File file = new File("src/images/szabotor_kijelolt.png");
                    BufferedImage img = ImageIO.read(file);
                    g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
                }
            } catch (IOException e) {
                System.out.println("File not found exception szabotor!");
            }
        } else {
            System.out.println("fasz\n");
        }
    }

    @Override
    public boolean intersect(int x, int y) {
        return false;
    }
}
