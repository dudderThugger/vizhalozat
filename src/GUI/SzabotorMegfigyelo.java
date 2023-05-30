package GUI;

import Vizhalozat.Szabotor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SzabotorMegfigyelo extends Megfigyelo{
    public SzabotorMegfigyelo(Szabotor observed, Point hova) {
        super(hova);
    }
    @Override
    public void draw(Graphics g) {
        try {
            if(!selected) {
                File file = new File("src/images/szabotor_sima.png");
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinates.x, coordinates.y, 50, 50, null);
            }
            else{
                File file = new File("src/images/szabotor_kijelolt.png");
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinates.x, coordinates.y, 50, 50, null);
            }
        } catch(IOException e) {
            System.out.println("File not found exception!");
        }
    }

    @Override
    public boolean intersect(int x, int y) {
        return false;
    }
}