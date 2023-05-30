package GUI;

import Vizhalozat.Pumpa;
import Vizhalozat.Szerelo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PumpaMegfigyelo extends MezoMegfigyelo {

    Pumpa observed;
    public PumpaMegfigyelo(Pumpa pumpa, Point hova, JatekPanel panel) {
        super(pumpa, hova, panel);
        observed = pumpa;
        Vizhalozat.Szerelo akiLerakata = (Szerelo) pumpa.getRajtaAllnak().get(0);
        coordinate = panel.getObservedCoordinate(akiLerakata);
        System.out.println(coordinate.x);
    }

    @Override
    public void draw(Graphics g) {
        try{
            if(selected){
                File file = new File("src/images/pumpa_kijelolt.png");                      ///sarga
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
            } else if (!observed.isMukodik()) {
                File file = new File("src/images/pumpa_elromlott.png");                      ///piros
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
            }else if (observed.getTelitett()) {
                File file = new File("src/images/pumpa_nedves.png");                      ///kék
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
            } else{
                File file = new File("src/images/pumpa_sima.png");                  ///fekete
                BufferedImage img = ImageIO.read(file);
                g.drawImage(img, coordinate.x - 25, coordinate.y - 25, 50, 50, null);
            }
        }
        catch(IOException e){
            System.out.println("File not found!");
        }
    }

    @Override
    public boolean intersect(int x, int y) {
        if((x >= coordinate.x - 50 && x <= coordinate.x + 50) && (y >= coordinate.y - 50 && y <= coordinate.y + 50))  return true;
        else return false;
    }
}
