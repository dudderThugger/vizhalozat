package Vizhalozat;

import Megfigyelok.ForrasMegfigyelo;

import javax.swing.*;
import java.awt.*;

public class JatekPanel extends JPanel {



    private final JPanel actionsav = new JPanel();
    private final JLabel playerText = new JLabel("Current Player");
    private final JLabel playername = new JLabel("aktualis jatekos neve");
    private final JLabel timeText = new JLabel("Remaining time:");

    private final JLabel actionTime =  new JLabel("hatralevoido");
    private final JLabel actionText = new JLabel("Actions:");
    private final JLabel cooldownText = new JLabel("Cooldown:");
    private final JLabel cooldownTime = new JLabel("hatralevo cooldown ido");

    private final JButton csolyuksztas;
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
        actionsav.add(cooldownTime);

        Icon icon = new ImageIcon("src/images/crack_cso.png");
        csolyuksztas = new JButton(icon);
        csolyuksztas.setBackground(Color.darkGray);
        csolyuksztas.setBorder(BorderFactory.createEmptyBorder());
        actionsav.add(csolyuksztas);
        this.add(actionsav);

    }

    @Override
    protected void paintComponent(Graphics g) // a törzse effektive csak teszteloi celzattal van, de magat a paintcomponentet szerintem kell majd hasznalni
    {
        super.paintComponent(g);
        Jatek j = new Jatek();
        Forras f1 = new Forras(j);
        ForrasMegfigyelo fm = new ForrasMegfigyelo(new Point(30, 450), f1);
        Forras f2 = new Forras(j);
        ForrasMegfigyelo fm2 = new ForrasMegfigyelo(new Point(15, 50), f2);
        fm.draw(g);
        fm2.draw(g);
    }

    public void frissit() {
        // TODO
    }

    public void addMegfigyelo(Megfigyelo megfigyelo) {
        // TODO
    }

    public void jatekVege(String nyertesCsapat) {
        // TODO
    }
}
