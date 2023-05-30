package GUI;

import Vizhalozat.Cso;
import Vizhalozat.Mezo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CsoMegfigyelo extends Megfigyelo {
    private Cso observed;
    public CsoMegfigyelo(Cso cso, JatekPanel panel) {
        super(panel);
        this.observed = cso;
    }

    @Override
    public void draw(Graphics g) {
        ArrayList<Mezo> szomszedok = observed.getSzomszedok();
        Point coordinate1 = panel.getObservedCoordinate(szomszedok.get(0));
        Point coordinate2 = panel.getObservedCoordinate(szomszedok.get(1));
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(30));
        if(!selected) {
            g2.setColor(Color.BLACK);
            g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
        }
        else if(observed.isLyukas()){
            g2.setColor(Color.RED);
            g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
        }
        else if (observed.getTelitett()) {
            g2.setColor(Color.BLUE);
            g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
        } else if(selected){
            g2.setColor(Color.ORANGE);
            g2.drawLine(coordinate1.x, coordinate1.y, coordinate2.x, coordinate2.y);
        }
    }

    @Override
    public boolean intersect(int x, int y) {
        ArrayList<Mezo> szomszedok = observed.getSzomszedok();
        Point coordinate1 = panel.getObservedCoordinate(szomszedok.get(0));
        Point coordinate2 = panel.getObservedCoordinate(szomszedok.get(1));
        int minX = Math.min(coordinate1.x, coordinate2.x);
        int maxX = Math.max(coordinate1.x, coordinate2.x);
        int minY = Math.min(coordinate1.y, coordinate2.y);
        int maxY = Math.max(coordinate1.y, coordinate2.y);

        boolean isXInRange = (x >= minX && x <= maxX);

        boolean isYInRange = (y >= minY && y <= maxY);
        
        return isXInRange && isYInRange;
    }
}
