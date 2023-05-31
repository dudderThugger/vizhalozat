package GUI;

import Vizhalozat.Jatek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private final int height = 675;
    private final int width = 1200;
    private final boolean resizeable = false;

    private final JButton start;
    private final JButton exit;

    private final JLabel szerelo1;
    private final JLabel szerelo2;

    private final JLabel szabotor1;
    private final JLabel szabotor2;


    private final JTextField szerelo1Text;
    private final JTextField szerelo2Text;

    private final JTextField szabotor1Text;
    private final JTextField szabotor2Text;

    private final JLabel menu;
    private final ImageIcon background;

    private final JPanel cardPanel = new JPanel();
    private final JPanel menuPanel = new JPanel();
    private  JatekPanel jatekpanel;
    private final JPanel vegePanel = new JPanel();

    private JLabel winnerwinerchicekndinner = new JLabel();
    public CardLayout c1 = new CardLayout();

    private Jatek jatek;
    public MainFrame(){

        super("Sivatagi Vizhalozat");

        background =  new ImageIcon("src/images/bg.jpg");
        menu = new JLabel(background);
        menu.setSize(width,height);

        start = new JButton("Inditas");
        start.setFont(new Font("Times New Roman", Font.BOLD, 25));
        start.setBounds(500,180,150,50);
        start.setBackground(Color.lightGray);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jatekpanel =  new JatekPanel(height,width,MainFrame.this);
                cardPanel.add(jatekpanel,"jatek");

                String szerelo1 = szerelo1Text.getText();
                String szerelo2 = szerelo2Text.getText();
                String szabotor1 = szabotor1Text.getText();
                String szabotor2 = szabotor2Text.getText();

                Vezerlo vezer = new Vezerlo(szerelo1, szerelo2,szabotor1,szabotor2);
                jatekpanel.vezer(vezer);
                vezer.panel(jatekpanel);

                jatekpanel.KattGomboknak();
                vezer.init();
                c1.show(cardPanel,"jatek");
            }
        });

        szerelo1 = new JLabel("1.szerelő játékos neve:");
        szerelo1.setForeground(Color.black);
        szerelo1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        szerelo1.setBounds(10,150,300,50);

        szerelo1Text = new JTextField("Szerelo1");
        szerelo1Text.setBounds(300,165,150,30);
        szerelo1Text.setFont(new Font("Times New Roman", Font.BOLD, 30));

        szerelo2 = new JLabel("2.szerelő játékos neve:");
        szerelo2.setForeground(Color.black);
        szerelo2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        szerelo2.setBounds(10,200,300,50);

        szerelo2Text = new JTextField("Szerelo2");
        szerelo2Text.setBounds(300,215,150,30);
        szerelo2Text.setFont(new Font("Times New Roman", Font.BOLD, 30));

        szabotor1 = new JLabel("1.szabotőr játékos neve:");
        szabotor1.setForeground(Color.black);
        szabotor1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        szabotor1.setBounds(675,150,310,50);

        szabotor1Text = new JTextField("Szabotor1");
        szabotor1Text.setBounds(985,165,150,30);
        szabotor1Text.setFont(new Font("Times New Roman", Font.BOLD, 30));


        szabotor2 = new JLabel("2.szabotőr játékos neve:");
        szabotor2.setForeground(Color.black);
        szabotor2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        szabotor2.setBounds(675,200,310,50);

        szabotor2Text = new JTextField("Szabotor2");
        szabotor2Text.setBounds(985,215,150,30);
        szabotor2Text.setFont(new Font("Times New Roman", Font.BOLD, 30));


        vegePanel.setLayout(new GridLayout(2,1));
        vegePanel.setBackground(Color.darkGray);
        winnerwinerchicekndinner.setForeground(Color.orange);
        winnerwinerchicekndinner.setFont(new Font("Times New Roman", Font.BOLD, 50));
        winnerwinerchicekndinner.setHorizontalAlignment(0);
        winnerwinerchicekndinner.setBackground(Color.black);
        winnerwinerchicekndinner.setBounds(100,10,400,400);

        menuPanel.setBounds(0,0,width,height);
        menuPanel.setLayout(null);

        exit = new JButton("exit");
        exit.setBackground(Color.lightGray);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(cardPanel,"menu");
                MainFrame.this.dispose();
                System.exit(0);
            }
        });
        menuPanel.add(start);
        menuPanel.add(szerelo1);
        menuPanel.add(szerelo1Text);
        menuPanel.add(szerelo2);
        menuPanel.add(szerelo2Text);
        menuPanel.add(szabotor1);
        menuPanel.add(szabotor1Text);
        menuPanel.add(szabotor2);
        menuPanel.add(szabotor2Text);
        menuPanel.add(menu);

        vegePanel.add(winnerwinerchicekndinner);
        vegePanel.add(exit);
        cardPanel.setLayout(c1);
        cardPanel.add(menuPanel,"menu");
        cardPanel.add(vegePanel,"vege");
        c1.show(cardPanel,"menu");


        this.add(cardPanel);
        this.setSize(width,height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(resizeable);
        this.setVisible(true);
    }

    public void vege(String n){
        winnerwinerchicekndinner.setText("Gratulálunk,a "+ n + " megnyerték a játékot");
        vegePanel.add(winnerwinerchicekndinner);
        c1.show(cardPanel,"vege");
    }
}
