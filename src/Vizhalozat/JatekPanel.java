package Vizhalozat;

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
