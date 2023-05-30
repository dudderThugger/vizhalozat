package GUI;

import Vizhalozat.Ciszterna;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CiszternaMegfigyelo extends AktivMegfigyelo {

    Ciszterna observed;
    public CiszternaMegfigyelo(Ciszterna ciszterna, Point hova, JatekPanel panel) {
        super(ciszterna, hova, panel);
        observed = ciszterna;
    }

    @Override
    public void draw(Graphics g) {
        try{
            if(!selected) {
                File file = new File("src/images/ciszterna.png");
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x, coordinate.y, 50, 50, null);
            }
            else{
                File file = new File("src/images/ciszterna_kijelolt.png");
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x, coordinate.y, 50, 50, null);
            }
        }
        catch (IOException e){
            System.out.println("File not found!");
        }

    }

    @Override
    public boolean intersect(int x, int y) {
        return false;
    }
}
