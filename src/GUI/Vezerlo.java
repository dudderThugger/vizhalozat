package GUI;

import GUI.JatekPanel;
import GUI.Point;
import Vizhalozat.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
/**
 * A játék megejelítését vezérlő osztály
 */
public class Vezerlo {
    private Jatek jatek;
    ArrayList<Mezo> mezok = new ArrayList<>();
    private ArrayList<Forras> forrasok=new ArrayList<>();
    private ArrayList<Cso> csovek=new ArrayList<>();
    private ArrayList<Ciszterna> ciszternak=new ArrayList<>();
    private ArrayList<Pumpa> pumpak=new ArrayList<>();
    private ArrayList<Szerelo> szerelok=new ArrayList<>();
    private ArrayList<Szabotor> szabotorok=new ArrayList<>();
    private ArrayList<Jatekos> jatekosok=new ArrayList<>();
    private ArrayList<String> jatekosNevek = new ArrayList<>();
    private Timer timer;
    private Akcio akcio;
    private int actualJatekosIndex;
    private int korIdo;
    private Cso selected;
    private JatekPanel panel;
    private int ciszternaCounter = 0;

    /**
     * Akcio tipusok
     */
    enum Akcio {
        LEP,
        LYUKASZT,
        JAVIT,
        FOLTOZ,
        RAGASZT,
        VAZELINEZ,
        PUMPATALLIT,
        PUMPALERAKAS,
        CSOLERAKAS,
        PUMPAVASARLAS,
        CSOFELVEVES
    }

    /**
     *
     * Vezérlő osztály konstruktora
     * @param szerelo1name 1. szerelo neve
     * @param szerelo2name 2. szerelo neve
     * @param szabotor1name 1. szabotor neve
     * @param szabotor2name 2. szabotor neve
     */
    public Vezerlo(String szerelo1name, String szerelo2name, String szabotor1name, String szabotor2name) {
        jatekosNevek.add(szerelo1name); jatekosNevek.add(szerelo2name); jatekosNevek.add(szabotor1name); jatekosNevek.add(szabotor2name);
        jatekosNevek.add(szerelo2name);
        jatekosNevek.add(szabotor1name);
        jatekosNevek.add(szabotor2name);
        jatek = new Jatek(this);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tickeles();
            }
        }, 1000, 1000);
        actualJatekosIndex = 0;
        selected = null;
        korIdo = 15;
    }

    public void init(){
        jatek.init();
    }

    public void panel(JatekPanel p){panel=p;}

    /**
     * Egér kattintásra reeagáló függvény
     * @param mezo A mező amire kattintunk
     */
    public void kattintas(Mezo mezo) {
        Jatekos jatekos = jatekosok.get(actualJatekosIndex);
        if(akcio != null) {
            switch (akcio) {
                case LEP: {
                    if (mezok.contains(mezo)) {
                        jatekos.lepes(mezo);
                        panel.jatekosLep(jatekos);
                        System.out.println(jatekos.getRajtaAll());
                    }
                    else jatekos.lepes((AktivElemek) mezo);
                }
                break;
                case PUMPATALLIT: {
                    if (selected != null && csovek.contains(mezo)) {
                        jatekos.pumpaAllitas(selected, (Cso) mezo);
                    }
                    if (selected == null && csovek.contains(mezo)) {
                        selected = (Cso) mezo;
                    }
                }
                break;
                case CSOFELVEVES: {
                    if (csovek.contains(mezo)) {
                        jatekos.felvesz_cso((Cso) mezo);
                    }
                } break;
                default:
                    break;
            }
        }
        panel.frissit2();
    }

    /**
     * Gomblenyomásra reagáló függvény
     * @param akcio Az akció amit kiválasztottunk
     */
    public void gombLenyomas(Akcio akcio) {
        Jatekos jatekos = jatekosok.get(actualJatekosIndex);
        selected = null;
        switch(akcio) {
            case LEP: {
                this.akcio = Akcio.LEP;
            } break;
            case PUMPATALLIT: {
                this.akcio = Akcio.PUMPATALLIT;
            } break;
            case CSOFELVEVES: {
                this.akcio = Akcio.CSOFELVEVES;
            } break;
            case PUMPAVASARLAS: {
                if(szerelok.contains(jatekos)) {
                    Szerelo szerelo = (Szerelo)jatekos;
                    szerelo.pumpatvesz();
                }
            } break;
            case LYUKASZT: {
                jatekos.lyukaszt();
            }break;
            case JAVIT: {
                if(szerelok.contains(jatekos)) {
                    Szerelo szerelo = (Szerelo)jatekos;
                    szerelo.szerel();
                }
            } break;
            case FOLTOZ: {
                if(szerelok.contains(jatekos)) {
                    Szerelo szerelo = (Szerelo)jatekos;
                    szerelo.foltoz();
                }
            } break;
            case RAGASZT: {
                jatekos.ragaszt();
            } break;
            case VAZELINEZ: {
                if(szabotorok.contains(jatekos)) {
                    Szabotor szabotor = (Szabotor) jatekos;
                    szabotor.csuszik();
                }
            } break;
            case PUMPALERAKAS: {
                if(szerelok.contains(jatekos)) {
                    Szerelo szerelo = (Szerelo)jatekos;
                    szerelo.lerak_pumpa();
                }
            } break;
            case CSOLERAKAS: {
                jatekos.lerak_cso();
            } break;
            default: break;
        }
        panel.frissit2();
    }

    /**
     * A másodpercenkénti köridő számlálást végző függvény
     */
    public void tickeles() {
        --korIdo;
        if(korIdo >= 0) {
            jatek.tick();
        } else {
            jatekosValtas();
            csoGeneralas();
        }
        int i = 0;
        panel.frissit(jatekosNevek.get(actualJatekosIndex),korIdo,actualJatekosIndex,i);
    }

    /**
     * Aktuális játékos váltását végző metódus
     */
    public void jatekosValtas() {
        korIdo = 15;
        if(actualJatekosIndex == 3) { actualJatekosIndex = 0; }
        else ++actualJatekosIndex;
        jatek.vizFolyas();
        jatek.pumpaElRomlik();
        jatek.tick();
    }

    /**
     * Egy cső generálása egy ciszternán
     */
    public void csoGeneralas(){
        Cso ujCso = new Cso(this.jatek);
        mezok.add(ujCso);
        csovek.add(ujCso);

        if(ciszternaCounter >= ciszternak.size()) ciszternaCounter = 0;
        ujCso.addSzomszed(ciszternak.get(ciszternaCounter));
        panel.addElemMegfigyelo(new GUI.CsoMegfigyelo(ujCso, panel));
        System.out.println("cső létrehozva" + ciszternak.get(ciszternaCounter));
        ciszternaCounter++;
    }

    /**
     * Játék végét hívó függvény
     * @param nyertesCsapat A nyertes
     */
    public void jatekVege(String nyertesCsapat) {
        panel.jatekVege(nyertesCsapat);
    }

    /**
     * Egy csövet ad hozzá a vezérlőhöz és a megfigyelőkhöz
     * @param cso A hozzáadni kívánt cső
     */
    public void addCso(Cso cso) {
        mezok.add(cso);
        csovek.add(cso);
        panel.addElemMegfigyelo(new GUI.CsoMegfigyelo(cso, panel));
    }
    /**
     * Egy pumpát ad hozzá a vezérlőhöz és a megfigyelőkhöz
     * @param pumpa A hozzáadni kívánt pumpa
     * @param hova A pumpa koordinátái
     */
    public void addPumpa(Pumpa pumpa, Point hova) {
        mezok.add(pumpa);
        pumpak.add(pumpa);
        panel.addElemMegfigyelo(new GUI.PumpaMegfigyelo(pumpa, hova, panel));
    }
    /**
     * Egy forrást ad hozzá a vezérlőhöz és a megfigyelőkhöz
     * @param forras A hozzáadni kívánt forrás
     * @param hova A forrás koordinátái
     */
    public void addForras(Forras forras, Point hova) {
        mezok.add(forras);
        forrasok.add(forras);
        panel.addElemMegfigyelo(new GUI.ForrasMegfigyelo(forras, hova, panel));
    }
    /**
     * Egy ciszternát ad hozzá a vezérlőhöz és a megfigyelőkhöz
     * @param ciszterna A hozzáadni kívánt ciszterna
     * @param hova A ciszterna koordinátái
     */
    public void addCiszterna(Ciszterna ciszterna, Point hova) {
        mezok.add(ciszterna);
        ciszternak.add(ciszterna);
        panel.addElemMegfigyelo(new GUI.CiszternaMegfigyelo(ciszterna, hova, panel));
    }
    /**
     * Egy szerelőt ad hozzá a vezérlőhöz és a megfigyelőkhöz
     * @param szerelo A hozzáadni kívánt szerelő
     */
    public void addSzerelo(Szerelo szerelo) {
        jatekosok.add(szerelo);
        szerelok.add(szerelo);
        panel.addSzereloMegfigyelo(new SzereloMegfigyelo(szerelo, panel));
    }
    /**
     * Egy szabotőrt ad hozzá a vezérlőhöz és a megfigyelőkhöz
     * @param szabotor A hozzáadni kívánt szabotőr
     */
    public void addSzabotor(Szabotor szabotor) {
        jatekosok.add(szabotor);
        szabotorok.add(szabotor);
        panel.addSzabotorMegfigyelok(new GUI.SzabotorMegfigyelo(szabotor, panel));
    }

    /**
     * Visszaadja a várakozási időt
     * @return várakozási idő
     */
    public int getCooldown() {
        return jatekosok.get(actualJatekosIndex).getAkcioIdo();
    }
    /**
     * Visszaadja a maradék ragasztási időt időt
     * @return maradék ragasztási idő
     */
    public int getStickTime() {
        return jatekosok.get(actualJatekosIndex).getRagadasiIdo();
    }

    public Jatekos getAktualisJatekos(){return jatekosok.get(actualJatekosIndex);}
}
