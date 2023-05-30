package GUI;

import Vizhalozat.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Vezerlo {
    private Jatek jatek;
    private ArrayList<Forras> forrasok=new ArrayList<>();
    private ArrayList<Cso> csovek=new ArrayList<>();
    private ArrayList<Ciszterna> ciszternak=new ArrayList<>();
    private ArrayList<Pumpa> pumpak=new ArrayList<>();
    private ArrayList<Szerelo> szerelok=new ArrayList<>();
    private ArrayList<Szabotor> szabotorok=new ArrayList<>();
    private ArrayList<Jatekos> jatekosok=new ArrayList<>();
    private ArrayList<String> jatekosNevek = new ArrayList<>();
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
    public void kattintas(Mezo mezo) {
        Jatekos jatekos = jatekosok.get(actualJatekosIndex);
        if(akcio != null) {
            switch (akcio) {
                case LEP: {
                    if (csovek.contains(mezo)) {jatekos.lepes((Cso) mezo);}
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
                }
                break;
                default:
                    break;
            }
        }
    }

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
    }

    public void tickeles() {
        --korIdo;
        if(korIdo >= 0) {
            jatek.tick();
        } else {
            jatekosValtas();
        }
        int i = 0;
        panel.frissit(jatekosNevek.get(actualJatekosIndex),korIdo,actualJatekosIndex,i);
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

    public void addCso(Cso cso) {
        csovek.add(cso);
        panel.addElemMegfigyelo(new GUI.CsoMegfigyelo(cso, panel));
    }

    public void addPumpa(Pumpa pumpa, Point hova) {
        pumpak.add(pumpa);
        panel.addElemMegfigyelo(new GUI.PumpaMegfigyelo(pumpa, hova, panel));
    }

    public void addForras(Forras forras, Point hova) {
        forrasok.add(forras);
        panel.addElemMegfigyelo(new GUI.ForrasMegfigyelo(forras, hova, panel));
    }

    public void addCiszterna(Ciszterna ciszterna, Point hova) {
        ciszternak.add(ciszterna);
        panel.addElemMegfigyelo(new GUI.CiszternaMegfigyelo(ciszterna, hova, panel));
    }

    public void addSzerelo(Szerelo szerelo) {
        jatekosok.add(szerelo);
        szerelok.add(szerelo);
        panel.addSzereloMegfigyelo(new GUI.SzereloMegfigyelo(szerelo, panel));
    }

    public void addSzabotor(Szabotor szabotor) {
        jatekosok.add(szabotor);
        szabotorok.add(szabotor);
        panel.addSzabotorMegfigyelok(new GUI.SzabotorMegfigyelo(szabotor, panel));
    }

    public int getCooldown() {
        return jatekosok.get(actualJatekosIndex).getAkcioIdo();
    }

    public int getStickTime() {
        return jatekosok.get(actualJatekosIndex).getRagadasiIdo();
    }
}
