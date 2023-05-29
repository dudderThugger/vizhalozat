package Vizhalozat;

import Megfigyelok.ForrasMegfigyelo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

public class JatekPanel extends JPanel {



    private final JPanel actionsav = new JPanel();
    private final JLabel playerText = new JLabel("Current Player");
    private final JLabel playername = new JLabel();
    private final JLabel timeText = new JLabel("Remaining time:");

    private final JLabel actionTime =  new JLabel();
    private final JLabel actionText = new JLabel("Actions:");
    private final JLabel cooldownText = new JLabel("Cooldown:");
    private final JLabel cooldownTime = new JLabel("hatralevo cooldown ido");

    private boolean frissit;
    private final JButton csolyuksztas;
    private  JButton pumpavetel;
    private  JButton csofelveves;
    private  JButton csolerak;
    private  JButton pumpajavit;
    private  JButton csocsusztat;
    private  JButton csojavit;
    private ArrayList<SzabotorMegfigyelo> szabotorok=new ArrayList<>();
    private ArrayList<SzereloMegfigyelo> szerelok=new ArrayList<>();
    private ArrayList<Megfigyelo> elemfigyelok = new ArrayList<>();
    private  Vezerlo vezer;
    private boolean vege=false;

    private  JPanel szereloactions;
    private JPanel szabotoractions;
    public JatekPanel(int height,int width){


        this.setBounds(0,0,width,height);
        this.setBackground(Color.white);
        this.setLayout(null);

        playerText.setForeground(Color.white);
        timeText.setForeground(Color.white);
        actionText.setForeground(Color.white);
        cooldownText.setForeground(Color.white);

        playername.setForeground(Color.orange);
        actionTime.setForeground(Color.orange);
        cooldownTime.setForeground(Color.orange);

        actionsav.setBounds(0,0,1200,50);
        actionsav.setLayout(new GridLayout(2,7));
        actionsav.setBackground(Color.darkGray);

        actionsav.add(playerText);
        actionsav.add(timeText);
        actionsav.add(actionText);
        actionsav.add(cooldownText);

        actionsav.add(playername);
        actionsav.add(actionTime);
        Icon icon = new ImageIcon("src/images/crack_cso.png");
        csolyuksztas = new JButton(icon);
        csolyuksztas.setBackground(Color.darkGray);
        csolyuksztas.setBorder(BorderFactory.createEmptyBorder());
        actionsav.add(csolyuksztas);
        actionsav.add(cooldownTime);
        this.add(actionsav);

        frissit =false;
    }
    public void szereloaction(){
        szereloactions = new JPanel();
        //szerelo = javit
    }
    @Override
    protected void paintComponent(Graphics g) // a törzse effektive csak teszteloi celzattal van, de magat a paintcomponentet szerintem kell majd hasznalni
    {
        super.paintComponent(g);
        drawAll(g);
        Jatek j = new Jatek(vezer);
        Forras f1 = new Forras(j);
        ForrasMegfigyelo fm = new ForrasMegfigyelo(new Point(30, 450), f1);
        Forras f2 = new Forras(j);
        ForrasMegfigyelo fm2 = new ForrasMegfigyelo(new Point(15, 50), f2);
        fm.draw(g);
        fm2.draw(g);
    }
    public void vezer(Vezerlo v){vezer=v;}
    public void frissit(String jatekosnev, int ido){
        playername.setText(jatekosnev);
        actionTime.setText(Integer.toString(ido));
        frissit = true;

    }
    public void drawAll(Graphics g) {
        for(Megfigyelo m : elemfigyelok){m.draw(g);}
        for(SzabotorMegfigyelo m:szabotorok){m.draw(g);}
        for(SzereloMegfigyelo m:szerelok){m.draw(g);}
    }

    public void addElemMegfigyelo(Megfigyelo megfigyelo) {
        elemfigyelok.add(megfigyelo);
    }
    public void addSzereloMegfigyelo(SzereloMegfigyelo sz){
        szerelok.add(sz);
    }
    public void addSzabotorMegfigyelok(SzabotorMegfigyelo sz){
        szabotorok.add(sz);
    }
    public void jatekVege(String nyertesCsapat) {
      vege = true;
    }
}
