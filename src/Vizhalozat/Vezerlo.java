package Vizhalozat;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Vezerlo {
    private Jatek jatek;
    private ArrayList<Forras> forrasok;
    private ArrayList<Cso> csovek;
    private ArrayList<Ciszterna> ciszternak;
    private ArrayList<Pumpa> pumpak;
    private ArrayList<Szerelo> szerelok;
    private ArrayList<Szabotor> szabotorok;
    private ArrayList<Jatekos> jatekosok;
    private ArrayList<String> jatekosNevek;
    private Timer timer;
    private int roundTime;
    private Akcio akcio;
    private int actualJatekosIndex;
    private int korIdo;
    private Cso selected;
    private JatekPanel panel;

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

    public Vezerlo(String szerelo1name, String szerelo2name, String szabotor1name, String szabotor2name) {
        jatekosNevek.add(szerelo1name);
        Szerelo szerelo1 = new Szerelo();
        szerelok.add(szerelo1);
        jatekosok.add(szerelo1);
        Szerelo szerelo2 = new Szerelo();
        jatekosNevek.add(szerelo2name);
        szerelok.add(szerelo2);
        jatekosok.add(szerelo2);
        Szabotor szabotor1 = new Szabotor();
        jatekosNevek.add(szabotor1name);
        szabotorok.add(szabotor1);
        jatekosok.add(szabotor1);
        Szabotor szabotor2 = new Szabotor();
        jatekosNevek.add(szabotor2name);
        szabotorok.add(szabotor2);
        jatekosok.add(szabotor2);
        jatek = new Jatek();
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

    public void kattintas(Mezo mezo) {
        Jatekos jatekos = jatekosok.get(actualJatekosIndex);
        switch(akcio){
            case LEP: {
                if(csovek.contains(mezo)) jatekos.lepes((Cso)mezo);
                else jatekos.lepes((AktivElemek)mezo);
            }break;
            case PUMPATALLIT: {
                if(selected != null && csovek.contains(mezo)) {
                    jatekos.pumpaAllitas(selected, (Cso)mezo);
                } if(selected == null && csovek.contains(mezo)) {
                    selected = (Cso)mezo;
                }
            } break;
            case CSOFELVEVES: {
                if(csovek.contains(mezo)) {
                    jatekos.felvesz_cso((Cso)mezo);
                }
            } break;
            default: break;
        }
    }

    public void gombLenyomas(Akcio akcio) {
        Jatekos jatekos = jatekosok.get(actualJatekosIndex);
        selected = null;
        switch(akcio) {
            case LEP: {
                akcio = Akcio.LEP;
            } break;
            case PUMPATALLIT: {
                akcio = Akcio.PUMPATALLIT;
            } break;
            case CSOFELVEVES: {
                akcio = Akcio.CSOFELVEVES;
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
    }

    public void tickeles() {
        --korIdo;
        if(korIdo >= 0) {
            jatek.tick();
        } else {
            jatekosValtas();
        }
        panel.frissit();
    }

    public void jatekosValtas() {
        korIdo = 15;
        if(actualJatekosIndex == 3) { actualJatekosIndex = 0; }
        else ++actualJatekosIndex;
        jatek.vizFolyas();
        jatek.pumpaElRomlik();
        jatek.tick();
    }

    public void jatekVege(String nyertesCsapat) {
        panel.jatekVege(nyertesCsapat);
    }

    public void addCso(Cso cso, Point hova) {
        csovek.add(cso);
        panel.addMegfigyelo(new CsoMegfigyelo(cso, hova));
    }

    public void addPumpa(Pumpa pumpa, Point hova) {
        pumpak.add(pumpa);
        panel.addMegfigyelo(new PumpaMegfigyelo(pumpa, hova));
    }

    public void addForras(Forras forras, Point hova) {
        forrasok.add(forras);
        panel.addMegfigyelo(new ForrasMegfigyelo(forras, hova));
    }

    public void addCiszterna(Ciszterna ciszterna, Point hova) {
        ciszternak.add(ciszterna);
        panel.addMegfigyelo(new CiszternaMegfigyelo(ciszterna, hova));
    }

    public void addSzerelo(Szerelo szerelo, Point hova) {
        szerelok.add(szerelo);
        panel.addMegfigyelo(new SzereloMegfigyelo(szerelo, hova));
    }

    public void addSzabotor(Szabotor szabotor, Point hova) {
        szabotorok.add(szabotor);
        panel.addMegfigyelo(new SzabotorMegfigyelo(szabotor, hova));
    }
}