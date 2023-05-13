package Vizhalozat;

import javax.sound.midi.Soundbank;
import java.awt.print.PrinterException;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Proto {
    private HashMap<String, ProtoJatek> jatekAdatok = new HashMap<String, ProtoJatek>();
    private ProtoJatek jelenlegiJatek = null;

    private class ProtoJatek {
        Jatek jatek = new Jatek();
        boolean randomKi;
        HashMap<String, Jatekos> jatekosok = new HashMap<>();
        HashMap<String, Szerelo> szerelok = new HashMap<>();
        HashMap<String, Szabotor> szabotorok = new HashMap<>();
        HashMap<String, Mezo> mezok = new HashMap<>();
        HashMap<String, Cso> csovek = new HashMap<>();
    }

    private class ProtoException extends RuntimeException {}

    public void parancsIndito() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vizhalozat prototipusa\n\n");
        parancsKezelo(scanner);
    }

    public void parancsKezelo(Scanner scanner) {
        while(scanner.hasNext()) {
            String[] arguments = scanner.nextLine().split(" ");
            switch (arguments[0]) {
                case "JatekLetrehoz":
                    String ujJatekNeve = arguments[1];
                    if (!jatekAdatok.containsKey(ujJatekNeve)) {
                        jatekAdatok.put(ujJatekNeve, new ProtoJatek());
                        System.out.println(ujJatekNeve + " sikeresen letrehozva!");
                    } else {
                        System.out.println("Nem sikerult letrehozni a jatekot!");
                    }
                    break;
                case "JatekKivalaszt":
                    String jatekNeve = arguments[1];
                    if (jatekAdatok.containsKey(jatekNeve)) {
                        jelenlegiJatek = jatekAdatok.get(jatekNeve);
                        System.out.println(jatekNeve + " kivalasztva!");
                    } else {
                        System.out.println("Nem sikerult kivalasztani a jatekot!");
                    }
                    break;
                case "JatekKilep":
                    jelenlegiJatek = null;
                    System.out.println("Kilepes");
                    break;
                case "Futtatas": {
                    File fajl = new File(arguments[1]);
                    try {
                        parancsKezelo(new Scanner(fajl));
                    } catch (FileNotFoundException e) {
                        System.out.println("Nem talalhato a megadott fajl!");
                    }
                    break;
                }
                case "JatekosLetrehoz":
                    String ujJatekosNeve = arguments[1];
                    String jatekosTipus = arguments[2];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.jatekosok.containsKey(ujJatekosNeve)) throw new ProtoException();
                        if (jatekosTipus.equals("szerelo")) {
                            Szerelo ujSzerelo = new Szerelo();
                            jelenlegiJatek.jatek.addJatekos(ujSzerelo);
                            jelenlegiJatek.jatekosok.put(ujJatekosNeve, ujSzerelo);
                            jelenlegiJatek.szerelok.put(ujJatekosNeve, ujSzerelo);
                        } else if (jatekosTipus.equals("szabotor")) {
                            Szabotor ujSzabotor = new Szabotor();
                            jelenlegiJatek.jatek.addJatekos(ujSzabotor);
                            jelenlegiJatek.jatekosok.put(ujJatekosNeve, ujSzabotor);
                            jelenlegiJatek.szabotorok.put(ujJatekosNeve, ujSzabotor);
                        } else {
                            throw new ProtoException();
                        }
                        System.out.println(ujJatekosNeve + " jatekos sikeresen letrehozva!");
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerult letrehozni a jatekost");
                    }
                    break;
                case "MezoLetrehoz": {
                    String mezoNeve = arguments[1];
                    String mezoTipusa = arguments[2];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.mezok.containsKey(mezoNeve)) throw new ProtoException();
                        if (mezoTipusa.equals("ciszterna")) {
                            Ciszterna ujCiszterna = new Ciszterna(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujCiszterna);
                            jelenlegiJatek.mezok.put(mezoNeve, ujCiszterna);
                        } else if (mezoTipusa.equals("cso")) {
                            Cso ujCso = new Cso(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujCso);
                            jelenlegiJatek.mezok.put(mezoNeve, ujCso);
                            jelenlegiJatek.csovek.put(mezoNeve, ujCso);
                        } else if (mezoTipusa.equals("forras")) {
                            Forras ujForras = new Forras(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujForras);
                            jelenlegiJatek.mezok.put(mezoNeve, ujForras);
                        } else if (mezoTipusa.equals("pumpa")) {
                            Pumpa ujPumpa = new Pumpa(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujPumpa);
                            jelenlegiJatek.mezok.put(mezoNeve, ujPumpa);
                        } else {
                            throw new ProtoException();
                        }
                        System.out.println(mezoNeve + " mezo sikeresen letrehozva!");
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerult letrehozni a mezot!");
                    }
                    break;
                }
                case "SzomszedBeallit":{
                    String mezo1Neve = arguments[1];
                    String mezo2Neve = arguments[2];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.mezok.containsKey(mezo1Neve) && jelenlegiJatek.mezok.containsKey(mezo2Neve)) {
                            Mezo mezo1 = jelenlegiJatek.mezok.get(mezo1Neve);
                            Mezo mezo2 = jelenlegiJatek.mezok.get(mezo2Neve);
                            mezo1.addSzomszed(mezo2);
                            mezo2.addSzomszed(mezo1);
                        } else {
                            throw new ProtoException();
                        }
                        System.out.println("Szomszedsag beallitva!");
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerult beallitani a szomszedokat!");
                    }
                    break;
            }
            case "RaAllit": {
                String jatekosNeve = arguments[1];
                String mezoNeve = arguments[2];
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if (jelenlegiJatek.jatekosok.containsKey(jatekosNeve) && jelenlegiJatek.mezok.containsKey(mezoNeve)) {
                        Jatekos j = jelenlegiJatek.jatekosok.get(jatekosNeve);
                        Mezo m = jelenlegiJatek.mezok.get(mezoNeve);
                        m.ralep(j);

                        System.out.println( jatekosNeve + " ráállt a " + mezoNeve + " mezőre!");
                    } else {
                        throw new ProtoException();
                    }
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült ráállítani a mezőre!");
                }
            }
            case "KezebeAd": {
                String jatekosNeve = arguments[1];
                String mezoNeve = arguments[2];
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if (jelenlegiJatek.jatekosok.containsKey(jatekosNeve) && jelenlegiJatek.mezok.containsKey(mezoNeve)) {
                        Jatekos j = jelenlegiJatek.jatekosok.get(jatekosNeve);
                        Mezo m = jelenlegiJatek.mezok.get(mezoNeve);
                        j.add_Kezebe((Viheto)m);

                        System.out.println( jatekosNeve + " kezében " + mezoNeve + " van!");
                    } else {
                        throw new ProtoException();
                    }
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült a kézbe adás!");
                }
            }
            case "Mentes": {
                File fajl = new File(arguments[1]);
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();

                    System.out.println("Saved!");
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült a játék mentése!");
                }
            }
            case "Betoltes": {
                File fajl = new File(arguments[1]);
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();

                    System.out.println("Sikeres betöltés!");
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült betölteni a fájlt!");
                }
            }
            case "Inditas": {
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();

                    System.out.println("Start!");
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült elindítani a játékot!");
                }
            }
            case "Leallit": {
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();

                    System.out.println("Game Over!");
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült leállítani a játékot!");
                }
            }
            case "Init": {
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();
                    jelenlegiJatek.jatek.init();
                    if(jelenlegiJatek.randomKi) {
                        System.out.println("Inicializálás! \n" +
                                "A következő objektumok jöttek létre:\n" +
                                "szerelo1, szerelo2, szabotor1, szabotor2, forras1, forras2, ciszterna1, ciszterna 2\n");
                    } else {
                        System.out.println("Inicializálás! \n" +
                                "A következő objektumok jöttek létre:\n" +
                                "<létrejövő objektumok nevei>\n");
                    }
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült az inicializálás!");
                }
            }
                case "Leptet":
                    String jatekosneve = arguments[1];
                    String mezoneve = arguments[2];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.mezok.containsKey(mezoneve) && jelenlegiJatek.jatekosok.containsKey(jatekosneve)) {
                            Mezo mezo1 = jelenlegiJatek.mezok.get(mezoneve);
                            Jatekos jatekos1 = jelenlegiJatek.jatekosok.get(jatekosneve);

                            mezo1.ralep(jatekos1);
                            System.out.println(jatekosneve + "ralepett a " + mezoneve + "mezore!");
                        } else {
                            throw new ProtoException();
                        }

                    } catch (ProtoException e) {
                        System.out.println("Nem sikerült a lépés!");
                    }
                    break;
                case "lyukaszt":
                    String jatekosnev = arguments[1];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.szabotorok.containsKey(jatekosnev)) {
                            Szabotor szabotor1 = jelenlegiJatek.szabotorok.get(jatekosnev);

                            szabotor1.lyukaszt();
                            System.out.println(jatekosnev + "kilyukasztotta a mezot,amin all");
                        } else {
                            throw new ProtoException();
                        }
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerult a lyukasztas");
                    }
                case "Foltoz":
                    String szerelonev = arguments[1];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.szerelok.containsKey(szerelonev)) {
                            Szerelo szerelo1 = jelenlegiJatek.szerelok.get(szerelonev);

                            szerelo1.foltoz();
                            System.out.println(szerelonev + "befoltozta a mezőt, amin áll!");
                        } else {
                            throw new ProtoException();
                        }
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerult a befoltozas!");
                    }
                case "Ragaszt":
                    String ragasztnev = arguments[1];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.szerelok.containsKey(ragasztnev)) {
                            Jatekos jatekos1 = jelenlegiJatek.jatekosok.get(ragasztnev);

                            jatekos1.ragaszt();
                            System.out.println(ragasztnev + "beragasztotta a mezőt, amin áll!");
                        } else {
                            throw new ProtoException();
                        }
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerult a mezo beragasztasa!");
                    }
                case "Vazelinez":
                    String vazelineznev = arguments[1];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.szerelok.containsKey(vazelineznev)) {
                            Szabotor jatekos1 = jelenlegiJatek.szabotorok.get(vazelineznev);

                            jatekos1.csuszik();
                            System.out.println(vazelineznev + "csuszossa tette a mezőt, amin áll!");
                        } else {
                            throw new ProtoException();
                        }
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerult a vezelinezes!");
                    }
                case "PumpatAllit":
                    String allitonev = arguments[1];
                    String bemeneticso = arguments[2];
                    String kimeneticso = arguments[3];
                    try{
                        if(jelenlegiJatek==null)throw new ProtoException();
                        if(jelenlegiJatek.szerelok.containsKey(allitonev)&& jelenlegiJatek.csovek.containsKey(bemeneticso)&&jelenlegiJatek.csovek.containsKey(kimeneticso)){
                            Szerelo sz1 = jelenlegiJatek.szerelok.get(allitonev);
                            Mezo m1 = sz1.rajtaAll;
                            Cso csobe = jelenlegiJatek.csovek.get(bemeneticso);
                            Cso csoki = jelenlegiJatek.csovek.get(kimeneticso);
                            if(m1.szomszedok.contains(csobe)&&m1.szomszedok.contains(csoki)) {
                                m1.atAllit(csobe, csoki);
                                System.out.println(allitonev + "atallitotta a pumpat, amin allt");
                            }
                        }else{
                            throw new ProtoException();
                        }
                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa allitasa");
                    }
                case "Javit":
                    String javitnev = arguments[1];
                    try {
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if (jelenlegiJatek.szerelok.containsKey(javitnev)) {
                            Szerelo sz1 = jelenlegiJatek.szerelok.get(javitnev);
                            sz1.foltoz();
                            System.out.println(javitnev + "megjavitotta a pumpat, amin allt");
                        } else {
                            throw new ProtoException();
                        }
                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa javitasa");
                    }
                case "PumpaElront":
                    String pumpa = arguments[1];
                    try{
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.mezok.containsKey(pumpa)){
                            Pumpa p = (Pumpa) jelenlegiJatek.mezok.get(pumpa);
                            p.setMukodik(false);
                            System.out.println(pumpa + " nevű pumpa elromlott.");
                        }
                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa elrontasa");
                    }
                    break;
                case "CsoFelvesz":
                    String lecsatlakozatoNev = arguments[1];
                    String lecsatlakoztatottCso = arguments[2];
                    try{
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.jatekosok.containsKey(lecsatlakozatoNev) && jelenlegiJatek.csovek.containsKey(lecsatlakoztatottCso)){

                        }

                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa elrontasa");
                    }
                    break;
                case "CsoLerak":
                    String lerakNev = arguments[1];
                    String lerakottMezo = arguments[2];
                    try{
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.jatekosok.containsKey(lerakNev) && jelenlegiJatek.mezok.containsKey(lerakottMezo)){

                        }

                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa elrontasa");
                    }
                    break;
                case "PumpaVasarlas":
                    String vasarlo = arguments[1];
                    try{
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.jatekosok.containsKey(vasarlo)){

                        }

                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa elrontasa");
                    }
                    break;
                case "PumpaLehelyez":
                    String lehelyezo = arguments[1];
                    String lehelyezendoMezo = arguments[1];
                    try{
                        if (jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.jatekosok.containsKey(lehelyezo) && jelenlegiJatek.mezok.containsKey(lehelyezendoMezo)){

                        }

                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa elrontasa");
                    }
                    break;
                case "RandomBe":
                    try{
                        if (jelenlegiJatek == null) throw new ProtoException();

                        System.out.println("Random mód bekapcsolva");
                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa elrontasa");
                    }
                    break;
                case "RandomKi":
                    try{
                        if (jelenlegiJatek == null) throw new ProtoException();


                    }catch (ProtoException e){
                        System.out.println("Nem sikerult a pumpa elrontasa");
                    }
                    break;

            }
        }
    }
}
