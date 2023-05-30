package GUI;

import GUI.ForrasMegfigyelo;
import GUI.Point;
import Vizhalozat.Vezerlo;

import javax.swing.*;
import java.awt.*;
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
    private  JButton csolyuksztas;

    private  JButton pumpavetel;
    private  JButton csofelvesz;
    private  JButton elemlerak;
    private  JButton pumpajavit;
    private  JButton csocsusztat;
    private  JButton csojavit;
    private JButton csoragaszt;
    private JButton pumpaallit;

    private ArrayList<GUI.SzabotorMegfigyelo> szabotorok=new ArrayList<>();
    private ArrayList<GUI.SzereloMegfigyelo> szerelok=new ArrayList<>();
    private ArrayList<GUI.Megfigyelo> elemfigyelok = new ArrayList<>();
    private Vezerlo vezer;
    private boolean vege=false;

    private  JPanel szereloactions;
    private JPanel szabotoractions;
    private JatekTer jatekter = new JatekTer();
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

        actionsav.setBounds(0,0,1200,100);
        actionsav.setLayout(new GridLayout(2,7));
        actionsav.setBackground(Color.darkGray);

        actionsav.add(playerText);
        actionsav.add(timeText);
        actionsav.add(actionText);
        actionsav.add(cooldownText);

        actionsav.add(playername);
        actionsav.add(actionTime);

        szereloaction();

        jatekter.setBounds(0, 100, 1200, height-100);
        jatekter.setBackground(new Color(212, 209, 144));

        this.add(jatekter);
        this.add(szabotoractions);
        JPanel blank = new JPanel();
        actionsav.add(blank);

        this.add(actionsav);

        frissit =false;
    }
    public void szereloaction(){
        szereloactions = new JPanel();
        szabotoractions = new JPanel();

        //csolyukaszt button
        Icon iconlyuk = new ImageIcon("src/images/szereloimages/crack_cso.png");
        csolyuksztas = new JButton(iconlyuk);
        csolyuksztas.setSize(new Dimension(5,5));
        csolyuksztas.setBackground(Color.darkGray);
        csolyuksztas.setBorder(BorderFactory.createEmptyBorder());

        //csojavit button
        Icon iconjavit = new ImageIcon("src/images/szereloimages/tape_cso.png");
        csojavit= new JButton(iconjavit);
        csojavit.setSize(new Dimension(5,5));
        csojavit.setBackground(Color.darkGray);
        csojavit.setBorder(BorderFactory.createEmptyBorder());

        //csoragaszt
        Icon iconragaszt = new ImageIcon("src/images/szereloimages/glue_cso.png");
        csoragaszt= new JButton(iconragaszt);
        csoragaszt.setSize(new Dimension(5,5));
        csoragaszt.setBackground(Color.darkGray);
        csoragaszt.setBorder(BorderFactory.createEmptyBorder());

        //lerak-cso-pumpa
        Icon elemlerakcion = new ImageIcon("src/images/szereloimages/putdown_csopumpa.png");
        elemlerak = new JButton(elemlerakcion);
        elemlerak.setSize(new Dimension(5,5));
        elemlerak.setBackground(Color.darkGray);
        elemlerak.setBorder(BorderFactory.createEmptyBorder());

        // felveszcso
        Icon felveszcso = new ImageIcon("src/images/szereloimages/pickup_cso.png");
        csofelvesz = new JButton(felveszcso);
        csofelvesz.setSize(new Dimension(5,5));
        csofelvesz.setBackground(Color.darkGray);
        csofelvesz.setBorder(BorderFactory.createEmptyBorder());

        //pumpaatallit
        Icon pumpaset = new ImageIcon("src/images/szereloimages/set_pumpa.png");
        pumpaallit = new JButton(pumpaset);
        pumpaallit.setSize(new Dimension(5,5));
        pumpaallit.setBackground(Color.darkGray);
        pumpaallit.setBorder(BorderFactory.createEmptyBorder());

        //pumpavesz
        Icon pumpavesz = new ImageIcon("src/images/szereloimages/buy_pumpa.png");
        pumpavetel = new JButton(pumpavesz);
        pumpavetel.setSize(5,5);
        pumpavetel.setBackground(Color.darkGray);
        pumpavetel.setBorder(BorderFactory.createEmptyBorder());

        //pumpaszerel
        Icon pumpajav = new ImageIcon("src/images/szereloimages/repair_pumpa .png");
        pumpajavit = new JButton(pumpajav);
        pumpajavit.setSize(5,5);
        pumpajavit.setBackground(Color.darkGray);
        pumpajavit.setBorder(BorderFactory.createEmptyBorder());

        //csocsuzik
        Icon csuszik = new ImageIcon("src/images/szabotor/slip_cso.png");
        csocsusztat = new JButton(csuszik);
        csocsusztat.setSize(5,5);
        csocsusztat.setBackground(Color.darkGray);
        csocsusztat.setBorder(BorderFactory.createEmptyBorder());

        szereloactions.setSize(300,100);
        szabotoractions.setSize(300,100);

        szereloactions.setBounds(600,50,300,50);
        szabotoractions.setBounds(600,50,300,50);

        szereloactions.setLayout(new GridLayout(2,4));
        szereloactions.add(csolyuksztas);
        szereloactions.add(csojavit);
        szereloactions.add(csoragaszt);
        szereloactions.add(elemlerak);
        szereloactions.add(csofelvesz);
        szereloactions.add(pumpaallit);
        szereloactions.add(pumpavetel);
        szereloactions.add(pumpajavit);
        szereloactions.add(csoragaszt);
        szereloactions.setBackground(Color.darkGray);

        szabotoractions.setLayout(new GridLayout(2,3));
        szabotoractions.add(csolyuksztas);
        szabotoractions.add(csofelvesz);
        szabotoractions.add(csoragaszt);
        szabotoractions.add(elemlerak);
        szabotoractions.add(csocsusztat);
        szabotoractions.add(pumpaallit);

        //szerelo = javit,lyukaszt,ragaszt,lerak cso/pumpa ,felvesz cso,szerel,pumpatvesz,pumpaallitas
    }

    private class JatekTer extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawAll(g);
        }
    }
    public void vezer(Vezerlo v){vezer=v;}
    public void frissit(String jatekosnev, int ido){
        playername.setText(jatekosnev);
        actionTime.setText(Integer.toString(ido));
        frissit = true;
    }
    public void drawAll(Graphics g) {
        for(GUI.Megfigyelo m : elemfigyelok){m.draw(g);}
        for(GUI.SzabotorMegfigyelo m:szabotorok){m.draw(g);}
        for(GUI.SzereloMegfigyelo m:szerelok){m.draw(g);}
    }

    public void addElemMegfigyelo(GUI.Megfigyelo megfigyelo) {
        elemfigyelok.add(megfigyelo);
    }
    public void addSzereloMegfigyelo(GUI.SzereloMegfigyelo sz){
        szerelok.add(sz);
    }
    public void addSzabotorMegfigyelok(GUI.SzabotorMegfigyelo sz){
        szabotorok.add(sz);
    }
    public void jatekVege(String nyertesCsapat) {
        vege = true;
    }
}
