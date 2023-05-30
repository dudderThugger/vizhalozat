package GUI;

import Vizhalozat.Jatekos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JatekPanel extends JPanel {


    private int currentPlayersync = 0;
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
    private  JButton elemlerak_pumpa;
    private  JButton pumpajavit;
    private  JButton csocsusztat;
    private  JButton csojavit;
    private JButton csoragaszt;
    private JButton pumpaallit;
    private JButton elemlerak_cso;

    private JButton csolyukaszt2;
    private JButton pumpaallit2;
    private JButton csoragaszt2;

    private ArrayList<GUI.SzabotorMegfigyelo> szabotorok= new ArrayList<>();
    private ArrayList<GUI.SzereloMegfigyelo> szerelok = new ArrayList<>();
    private ArrayList<GUI.CsoMegfigyelo> csovek = new ArrayList<>();
    private ArrayList<GUI.AktivMegfigyelo> elemfigyelok = new ArrayList<>();
    private Vezerlo vezer;
    private boolean vege=false;

    private  JPanel szereloactions;
    private JPanel szabotoractions;
    private JatekTer jatekter = new JatekTer();
    private Jatekos aktualisPlayer;

    JPanel blank = new JPanel();
    public CardLayout c1 = new CardLayout();
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

        buttonadd();

        jatekter.setBounds(0, 100, 1200, height-100);
        jatekter.setBackground(new Color(212, 209, 144));

        this.add(jatekter);
        this.add(szereloactions);

        blank.setLayout(c1);
        blank.add(szereloactions,"szerelo");
        blank.add(szabotoractions,"szabotor");
        actionsav.add(blank);

        this.add(actionsav);

        frissit =false;
    }
    public void buttonadd(){
        szereloactions = new JPanel();
        szabotoractions = new JPanel();

        //csolyukaszt button
        Icon iconlyuk = new ImageIcon("src/images/crack_cso.png");
        csolyuksztas = new JButton(iconlyuk);
        csolyuksztas.setBackground(Color.darkGray);
        csolyuksztas.setBorder(BorderFactory.createEmptyBorder());

        //csolyukaszt2
        csolyukaszt2 = new JButton(iconlyuk);
        csolyukaszt2.setBackground(Color.darkGray);


        //csojavit button
        Icon iconjavit = new ImageIcon("src/images/tape_cso.png");
        csojavit= new JButton(iconjavit);
        csojavit.setBackground(Color.darkGray);
        csojavit.setBorder(BorderFactory.createEmptyBorder());

        //csoragaszt
        Icon iconragaszt = new ImageIcon("src/images/glue_cso.png");
        csoragaszt= new JButton(iconragaszt);
        csoragaszt.setBackground(Color.darkGray);
        csoragaszt.setBorder(BorderFactory.createEmptyBorder());

        csoragaszt2= new JButton(iconragaszt);
        csoragaszt2.setBackground(Color.darkGray);
        csoragaszt2.setBorder(BorderFactory.createEmptyBorder());



        //lerak-pumpa
        Icon elemlerakcion = new ImageIcon("src/images/putdown_csopumpa.png");
        elemlerak_pumpa = new JButton(elemlerakcion);
        elemlerak_pumpa.setBackground(Color.darkGray);
        elemlerak_pumpa.setBorder(BorderFactory.createEmptyBorder());

        //lerak-cso
        elemlerak_cso = new JButton(elemlerakcion);
        elemlerak_cso.setBackground(Color.darkGray);
        elemlerak_cso.setBorder(BorderFactory.createEmptyBorder());

        // felveszcso
        Icon felveszcso = new ImageIcon("src/images/pickup_cso.png");
        csofelvesz = new JButton(felveszcso);
        csofelvesz.setBackground(Color.darkGray);
        csofelvesz.setBorder(BorderFactory.createEmptyBorder());

        //pumpaatallit
        Icon pumpaset = new ImageIcon("src/images/set_pumpa.png");
        pumpaallit = new JButton(pumpaset);
        pumpaallit.setBackground(Color.darkGray);
        pumpaallit.setBorder(BorderFactory.createEmptyBorder());

        pumpaallit2=new JButton(pumpaset);
        pumpaallit2.setBackground(Color.darkGray);
        pumpaallit2.setBorder(BorderFactory.createEmptyBorder());


        //pumpavesz
        Icon pumpavesz = new ImageIcon("src/images/buy_pumpa.png");
        pumpavetel = new JButton(pumpavesz);
        pumpavetel.setSize(5,5);
        pumpavetel.setBackground(Color.darkGray);
        pumpavetel.setBorder(BorderFactory.createEmptyBorder());

        //pumpaszerel
        Icon pumpajav = new ImageIcon("src/images/repair_pumpa .png");
        pumpajavit = new JButton(pumpajav);
        pumpajavit.setSize(5,5);
        pumpajavit.setBackground(Color.darkGray);
        pumpajavit.setBorder(BorderFactory.createEmptyBorder());

        //csocsuzik
        Icon csuszik = new ImageIcon("src/images/slip_cso.png");
        csocsusztat = new JButton(csuszik);
        csocsusztat.setSize(5,5);
        csocsusztat.setBackground(Color.darkGray);
        csocsusztat.setBorder(BorderFactory.createEmptyBorder());

        szereloactions.setSize(300,100);
        szabotoractions.setSize(300,100);

        szereloactions.setBounds(600,50,300,50);
        szabotoractions.setBounds(600,50,300,50);

        szereloactions.setLayout(new GridLayout(2,5));
        szereloactions.add(csolyuksztas);
        szereloactions.add(csojavit);
        szereloactions.add(elemlerak_pumpa);
        szereloactions.add(elemlerak_cso);
        szereloactions.add(csofelvesz);
        szereloactions.add(pumpaallit);
        szereloactions.add(pumpavetel);
        szereloactions.add(pumpajavit);
        szereloactions.add(csoragaszt);
        szereloactions.setBackground(Color.darkGray);

        szabotoractions.setLayout(new GridLayout(2,3));
        szabotoractions.add(csolyukaszt2);
        szabotoractions.add(csofelvesz);
        szabotoractions.add(csoragaszt2);
        szabotoractions.add(elemlerak_cso);
        szabotoractions.add(csocsusztat);
        szabotoractions.add(pumpaallit2);

        //szerelo = javit,lyukaszt,ragaszt,lerak cso/pumpa ,felvesz cso,szerel,pumpatvesz,pumpaallitas
    }



    public void KattGomboknak(){
        csolyuksztas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.LYUKASZT);
            }
        });

        csolyukaszt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.LYUKASZT);
            }
        });
        csojavit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.FOLTOZ);
            }
        });
        csoragaszt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.RAGASZT);
            }
        });
        csoragaszt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.RAGASZT);
            }
        });
        elemlerak_pumpa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.PUMPALERAKAS);
            }
        });
        elemlerak_cso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.CSOLERAKAS);
            }
        });
        csofelvesz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.CSOFELVEVES);
            }
        });
        pumpaallit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.PUMPATALLIT);
            }
        });
        pumpaallit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.PUMPATALLIT);
            }
        });
        pumpavetel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.PUMPAVASARLAS);
            }
        });
        pumpajavit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.JAVIT);
            }
        });
        csocsusztat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.VAZELINEZ);
            }
        });


    }
    private class JatekTer extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawAll(g);
        }
    }
    public void vezer(Vezerlo v){vezer=v;}
    public void frissit(String jatekosnev, int ido,int i){
        playername.setText(jatekosnev);
        actionTime.setText(Integer.toString(ido));
        if(i<2){
           c1.show(blank,"szerelo");
        }
        else{
            c1.show(blank,"szabotor");
        }

        if(ido == 2)
        {
            switch(currentPlayersync) {
                case 0: {
                    szerelok.get(0).setSelected(false);
                    szerelok.get(1).setSelected(true);
                    break;
                }
                case 1:{
                    szerelok.get(1).setSelected(false);
                    szabotorok.get(0).setSelected(true);
                    break;
                }
                case 2:{
                    szabotorok.get(0).setSelected(false);
                    szabotorok.get(1).setSelected(true);
                    break;
                }
                case 3:{
                    szabotorok.get(1).setSelected(false);
                    szerelok.get(0).setSelected(true);
                    break;
                }
            }
            currentPlayersync++;
            if(currentPlayersync == 4) currentPlayersync = 0;

        }

        this.invalidate();
        this.revalidate();
        this.repaint();

        frissit = true;
    }
    public void drawAll(Graphics g) {
        for(GUI.Megfigyelo m : csovek){m.draw(g);}
        for(GUI.Megfigyelo m : elemfigyelok){m.draw(g);}
        for(GUI.SzabotorMegfigyelo m:szabotorok){m.draw(g);}
        for(GUI.SzereloMegfigyelo m:szerelok){m.draw(g);}
    }

    public GUI.Point getObservedCoordinate(Object object) {
        for(AktivMegfigyelo mf : elemfigyelok) {
            if(mf.getObserved() == object) {
                return mf.getCoordinate();
            }
        }
        return null;
    }

    public void addElemMegfigyelo(GUI.AktivMegfigyelo megfigyelo) {
        elemfigyelok.add(megfigyelo);
    }
    public void addCsomegfigyelo(GUI.CsoMegfigyelo megfigyelo) { csovek.add(megfigyelo); }
    public void addSzereloMegfigyelo(GUI.SzereloMegfigyelo sz){
        szerelok.add(sz);
        szerelok.get(0).setSelected(true);
    }
    public void addSzabotorMegfigyelok(GUI.SzabotorMegfigyelo sz){
        szabotorok.add(sz);
    }
    public void jatekVege(String nyertesCsapat) {
        vege = true;
    }
}
