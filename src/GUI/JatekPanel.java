package GUI;

import Vizhalozat.AktivElemek;
import Vizhalozat.Jatekos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JatekPanel extends JPanel implements MouseListener {


    private int currentPlayersync = 0;
    private final JPanel actionsav = new JPanel();
    private final JLabel playerText = new JLabel("Current Player");
    private final JLabel playername = new JLabel();
    private final JLabel timeText = new JLabel("Remaining time:");

    private final JLabel actionTime =  new JLabel();
    private final JLabel actionText = new JLabel("Actions:");
    private final JLabel cooldownText = new JLabel("Cooldown:");
    private final JLabel cooldownTime = new JLabel("hatralevo cooldown ido");

    private final JLabel szereloText = new JLabel("Szerelopontok");
    private final JLabel szabotorText = new JLabel("Szabotorpont");

    private final JLabel szabotorPont = new JLabel();
    private final JLabel szereloPont = new JLabel();
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
    private JButton move;

    private JButton move2;
    private JButton csolyukaszt2;
    private JButton pumpaallit2;
    private JButton csoragaszt2;
    private JButton elemfelvesz_cso1;
    private JButton csolerak1;

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
        szereloText.setForeground(Color.white);
        szabotorText.setForeground(Color.white);

        playername.setForeground(Color.orange);
        actionTime.setForeground(Color.orange);
        cooldownTime.setForeground(Color.orange);
        szereloPont.setForeground(Color.orange);
        szabotorPont.setForeground(Color.orange);

        actionsav.setBounds(0,0,1200,100);
        actionsav.setLayout(new GridLayout(2,7));
        actionsav.setBackground(Color.darkGray);

        actionsav.add(playerText);
        actionsav.add(timeText);
        actionsav.add(actionText);
        actionsav.add(cooldownText);
        actionsav.add(szereloText);
        actionsav.add(szabotorText);

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
        actionsav.add(cooldownTime);
        actionsav.add(szereloPont);
        actionsav.add(szabotorPont);
        this.add(actionsav);

        frissit =false;
    }
    public void buttonadd(){
        szereloactions = new JPanel();
        szabotoractions = new JPanel();

        Icon move1= new ImageIcon("src/images/move.png");
        move = new JButton(move1);
        move.setBackground(Color.darkGray);
        move.setBorder(BorderFactory.createEmptyBorder());

        move2 = new JButton(move1);
        move2.setBackground(Color.darkGray);
        move2.setBorder(BorderFactory.createEmptyBorder());


        //csolyukaszt button
        Icon iconlyuk = new ImageIcon("src/images/crack_cso.png");
        csolyuksztas = new JButton(iconlyuk);
        csolyuksztas.setBackground(Color.darkGray);
        csolyuksztas.setBorder(BorderFactory.createEmptyBorder());

        //csolyukaszt2
        csolyukaszt2 = new JButton(iconlyuk);
        csolyukaszt2.setBackground(Color.darkGray);
        csolyukaszt2.setBorder(BorderFactory.createEmptyBorder());

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

        csolerak1 = new JButton(elemlerakcion);
        csolerak1.setBackground(Color.darkGray);
        csolerak1.setBorder(BorderFactory.createEmptyBorder());

        // felveszcso
        Icon felveszcso = new ImageIcon("src/images/pickup_cso.png");
        csofelvesz = new JButton(felveszcso);
        csofelvesz.setBackground(Color.darkGray);
        csofelvesz.setBorder(BorderFactory.createEmptyBorder());

        elemfelvesz_cso1 = new JButton(felveszcso);
        elemfelvesz_cso1.setBackground(Color.darkGray);
        elemfelvesz_cso1.setBorder(BorderFactory.createEmptyBorder());

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
        szereloactions.add(move);
        szereloactions.setBackground(Color.darkGray);

        szabotoractions.setLayout(new GridLayout(2,4));
        szabotoractions.add(csolyukaszt2);
        szabotoractions.add(elemfelvesz_cso1);
        szabotoractions.add(csoragaszt2);
        szabotoractions.add(csolerak1);
        szabotoractions.add(csocsusztat);
        szabotoractions.add(pumpaallit2);
        szabotoractions.add(move2);
        szabotoractions.setBackground(Color.darkGray);
    }



    public void KattGomboknak(){

        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.LEP);
            }
        });
        move2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.LEP);
            }
        });
        csolerak1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.CSOLERAKAS);
            }
        });
        pumpaallit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.CSOLERAKAS);
            }
        });
        csoragaszt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.RAGASZT);
            }
        });
        elemfelvesz_cso1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezer.gombLenyomas(Vezerlo.Akcio.CSOFELVEVES);
            }
        });
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int X = e.getX();
        int Y = e.getY();

        for(CsoMegfigyelo m: csovek){
            if( m.intersect(X,Y)){
                vezer.kattintas(m.getObserved());
            }
        }
        for(AktivMegfigyelo m:elemfigyelok){
            if(m.intersect(X,Y)){
                vezer.kattintas(m.getObserved());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private class JatekTer extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawAll(g);
        }
    }
    public void vezer(Vezerlo v){vezer=v;}
    public void frissit(String jatekosnev, int ido,int i,int cooldown){
        playername.setText(jatekosnev);
        actionTime.setText(Integer.toString(ido));
        cooldownTime.setText(Integer.toString(cooldown));
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
        this.setVisible(false);
    }
}
