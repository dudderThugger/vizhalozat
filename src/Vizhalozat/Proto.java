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
import java.util.Map;
import java.util.Scanner;

/**
 * Prototípus osztály megvalósítása
 */

public class Proto {
    /*
    private HashMap<String, ProtoJatek> jatekAdatok = new HashMap<String, ProtoJatek>();
    private ProtoJatek jelenlegiJatek = null;

    /**
     * Prototípusjáték
     */
    /*
    private class ProtoJatek {
        Jatek jatek = new Jatek();
        boolean randomKi;
        HashMap<String, Jatekos> jatekosok = new HashMap<>();
        HashMap<String, Szerelo> szerelok = new HashMap<>();
        HashMap<String, Szabotor> szabotorok = new HashMap<>();
        HashMap<String, Mezo> mezok = new HashMap<>();
        HashMap<String, Cso> csovek = new HashMap<>();
        HashMap<String,AktivElemek> aktivelemek = new HashMap<>();
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
                        System.out.println("Nem sikerült létrehozni a játékot!");
                    }
                    break;
                case "JatekKivalaszt":
                    String jatekNeve = arguments[1];
                    if (jatekAdatok.containsKey(jatekNeve)) {
                        jelenlegiJatek = jatekAdatok.get(jatekNeve);
                        System.out.println(jatekNeve + " kivalasztva!");
                    } else {
                        System.out.println("Nem sikerült kivalasztani a játékot!");
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
                        System.out.println("Nem található a megadott fájl!");
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
                        System.out.println(ujJatekosNeve + " játékos sikeresen létrehozva!");
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerült letrehozni a játékost");
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
                            jelenlegiJatek.aktivelemek.put(mezoNeve,ujCiszterna);
                        } else if (mezoTipusa.equals("cso")) {
                            Cso ujCso = new Cso(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujCso);
                            jelenlegiJatek.mezok.put(mezoNeve, ujCso);
                            jelenlegiJatek.csovek.put(mezoNeve, ujCso);
                        } else if (mezoTipusa.equals("forras")) {
                            Forras ujForras = new Forras(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujForras);
                            jelenlegiJatek.mezok.put(mezoNeve, ujForras);
                            jelenlegiJatek.aktivelemek.put(mezoNeve,ujForras);
                        } else if (mezoTipusa.equals("pumpa")) {
                            Pumpa ujPumpa = new Pumpa(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujPumpa);
                            jelenlegiJatek.mezok.put(mezoNeve, ujPumpa);
                            jelenlegiJatek.aktivelemek.put(mezoNeve,ujPumpa);
                        } else {
                            throw new ProtoException();
                        }
                        System.out.println(mezoNeve + " mező sikeresen létrehozva!");
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerült létrehozni a mezőt!");
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
                        System.out.println("Szomszedság beállítva!");
                    } catch (ProtoException e) {
                        System.out.println("Nem sikerült beállitani a szomszédokat!");
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
                        j.raAllit(m);
                        System.out.println( jatekosNeve + " ráállt a " + mezoNeve + " mezőre!");
                    } else {
                        throw new ProtoException();
                    }
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült ráállítani a mezőre!");
                }
                break;
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
                break;
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
                break;
            }
            case "Inditas": {
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();

                    System.out.println("Start!");
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült elindítani a játékot!");
                }
                break;
            }
            case "Leallit": {
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();

                    System.out.println("Game Over!");
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült leállítani a játékot!");
                }
                break;
            }
            case "Init": {
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.randomKi) {
                        System.out.println("Inicializálás! \n" +
                                "A következő objektumok jöttek létre:\n" +
                                "szerelo1, szerelo2, szabotor1, szabotor2, forras1, forras2, ciszterna1, ciszterna 2");
                        jelenlegiJatek.jatek.init();

                        Szabotor szabotor1 = new Szabotor();
                        Szabotor szabotor2 = new Szabotor();
                        jelenlegiJatek.jatekosok.put("szabotor1", szabotor1);
                        jelenlegiJatek.jatekosok.put("szabotor2", szabotor2);
                        jelenlegiJatek.jatek.addJatekos(szabotor1);
                        jelenlegiJatek.jatek.addJatekos(szabotor2);

                        Szerelo szerelo1 = new Szerelo();
                        Szerelo szerelo2 = new Szerelo();
                        jelenlegiJatek.jatekosok.put("szerelo1", szerelo1);
                        jelenlegiJatek.jatekosok.put("szerelo2", szerelo2);
                        jelenlegiJatek.jatek.addJatekos(szerelo1);
                        jelenlegiJatek.jatek.addJatekos(szerelo2);

                        Forras forras1 = new Forras(jelenlegiJatek.jatek);
                        Forras forras2 = new Forras(jelenlegiJatek.jatek);
                        jelenlegiJatek.mezok.put("forras1", forras1);
                        jelenlegiJatek.mezok.put("forras2", forras2);
                        jelenlegiJatek.jatek.addMezo(forras1);
                        jelenlegiJatek.jatek.addMezo(forras2);

                        Ciszterna ciszterna1 = new Ciszterna(jelenlegiJatek.jatek);
                        Ciszterna ciszterna2 = new Ciszterna(jelenlegiJatek.jatek);
                        jelenlegiJatek.mezok.put("ciszterna1", ciszterna1);
                        jelenlegiJatek.mezok.put("ciszterna2", ciszterna2);
                        jelenlegiJatek.jatek.addMezo(ciszterna1);
                        jelenlegiJatek.jatek.addMezo(ciszterna2);
                    } else {
                        System.out.println("Inicializálás! \n" +
                                "A következő objektumok jöttek létre:\n" +
                                "<létrejövő objektumok nevei>\n");
                    }
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült az inicializálás!");
                }
                break;
            }
            case "Leptet":
                String jatekosneve = arguments[1];
                String mezoneve = arguments[2];
                try {
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if (jelenlegiJatek.csovek.containsKey(mezoneve) && jelenlegiJatek.jatekosok.containsKey(jatekosneve)) {
                        Cso mezo1 = jelenlegiJatek.csovek.get(mezoneve);
                        Jatekos jatekos1 = jelenlegiJatek.jatekosok.get(jatekosneve);
                        jatekos1.lepes(mezo1);
                        System.out.println(jatekosneve + " rálépett a " + mezoneve + " mezőre!");
                    }
                    else if (jelenlegiJatek.aktivelemek.containsKey(mezoneve) && jelenlegiJatek.jatekosok.containsKey(jatekosneve)) {
                            AktivElemek mezo1 = jelenlegiJatek.aktivelemek.get(mezoneve);
                            Jatekos jatekos1 = jelenlegiJatek.jatekosok.get(jatekosneve);
                            jatekos1.lepes(mezo1);
                            System.out.println(jatekosneve + " rálépett a " + mezoneve + " cdmezőre!");
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
                    if (jelenlegiJatek.jatekosok.containsKey(jatekosnev)) {
                        Jatekos szabotor1 = jelenlegiJatek.szabotorok.get(jatekosnev);
                        szabotor1.lyukaszt();
                        System.out.println(jatekosnev + " kilyukasztotta a mezőt, amin áll!");
                    } else {
                        throw new ProtoException();
                    }
                } catch (ProtoException e) {
                    System.out.println("Nem sikerült a lyukasztás!");
                }
                break;
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
                    System.out.println("Nem sikerült a befoltozas!");
                }
                break;
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
                    System.out.println("Nem sikerült a mező beragasztása!");
                }
                break;
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
                    System.out.println("Nem sikerült a vazelinezés!");
                }
                break;
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
                            System.out.println(allitonev + "atallitotta a pumpat, amin áll!");
                        }
                    }else{
                        throw new ProtoException();
                    }
                }catch (ProtoException e){
                    System.out.println("Nem sikerült a pumpa állitása!");
                }
                break;
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
                    System.out.println("Nem sikerült a pumpa javítása!");
                }
                break;
            case "PumpaElront":
                String pumpa = arguments[1];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.mezok.containsKey(pumpa)){
                        Pumpa p = (Pumpa) jelenlegiJatek.mezok.get(pumpa);
                        p.setMukodik(false);
                        System.out.println(pumpa + " nevű pumpa elromlott.");
                    }
                    else{
                        throw  new ProtoException();
                    }
                }catch (ProtoException e){
                    System.out.println("Nem sikerült a pumpa elrontása!");
                }
                break;
            case "CsoFelvesz":
                String lecsatlakozatoNev = arguments[1];
                String lecsatlakoztatottCso = arguments[2];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.jatekosok.containsKey(lecsatlakozatoNev) && jelenlegiJatek.csovek.containsKey(lecsatlakoztatottCso)){
                        Jatekos j = jelenlegiJatek.jatekosok.get(lecsatlakozatoNev);
                        Cso cs = jelenlegiJatek.csovek.get(lecsatlakoztatottCso);
                        j.felvesz_cso(cs);
                        System.out.println(j + " felvette a " + cs + " csövet!");
                    }
                    else{
                        throw new ProtoException();
                    }

                }catch (ProtoException e){
                    System.out.println("Nem sikerült a cső felvétele!");
                }
                break;
            case "CsoLerak":
                String lerakNev = arguments[1];
                String lerakottMezo = arguments[2];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.jatekosok.containsKey(lerakNev) && jelenlegiJatek.mezok.containsKey(lerakottMezo)){
                        Jatekos j = jelenlegiJatek.jatekosok.get(lerakNev);
                        Mezo m = jelenlegiJatek.mezok.get(lerakottMezo);
                        if(j.getRajtaAll().equals(m) && j.getTart() != null){
                            j.lerak_cso();
                            System.out.println(j + " lerakta a kezében tartott csövet a " + m +" mezőre!");
                        }
                        else{
                            throw new ProtoException();
                        }
                    }
                    else{
                        throw new ProtoException();
                    }

                }catch (ProtoException e){
                    System.out.println("Nem sikerült a cső lehelyezése!");
                }
                break;
            case "PumpaVasarlas":
                String vasarlo = arguments[1];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.jatekosok.containsKey(vasarlo)){
                        Szerelo sz = jelenlegiJatek.szerelok.get(vasarlo);
                        sz.pumpatvesz();
                        System.out.println(sz + "vásárolt egy pumpát!");
                    }
                    else{
                        throw new ProtoException();
                    }

                }catch (ProtoException e){
                    System.out.println("Nem sikerült a pumpa vásárlása!");
                }
                break;
            case "PumpaLehelyez":
                String lehelyezo = arguments[1];
                String lehelyezendoMezo = arguments[2];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.jatekosok.containsKey(lehelyezo) && jelenlegiJatek.mezok.containsKey(lehelyezendoMezo)){
                        Szerelo sz = jelenlegiJatek.szerelok.get(lehelyezo);
                        Mezo m = jelenlegiJatek.mezok.get(lehelyezendoMezo);
                        if(sz.getRajtaAll().equals(m) && sz.getTart() != null){
                            sz.lerak_pumpa();
                            System.out.println(sz + " lerakta a pumpát " + m + " mezőre!");
                        }
                        else{
                            throw new ProtoException();
                        }
                    }
                    else{
                        throw new ProtoException();
                    }
                }catch (ProtoException e){
                    System.out.println("Nem sikerult a pumpa lehelyezése!");
                }
                break;
            case "RandomBe":
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    jelenlegiJatek.randomKi = false;
                    System.out.println("Random mód bekapcsolva");
                }catch (ProtoException e){
                    System.out.println("Nem sikerult a random mód bekapcsolása!");
                }
                break;
            case "RandomKi":
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    jelenlegiJatek.randomKi = true;
                    System.out.println("Random mód kikapcsolva");
                }catch (ProtoException e){
                    System.out.println("Nem sikerult a random mód kikapcsolása!");
                }
                break;
            case "Befolyik":
                String mezoneve1 = arguments[1];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.mezok.containsKey(mezoneve1)){
                        Mezo m = jelenlegiJatek.mezok.get(mezoneve1);
                        m.befolyik();
                        System.out.println(m + "-be befolyik a víz ");
                        for (Mezo m1: m.getSzomszedok()) {
                            System.out.println(m1 +  "-be tovább folyt a víz!");
                        }
                    }
                }catch (ProtoException e){
                    System.out.println("Nem sikerült!");
                }
                break;
            case "Var":
                int msIdo = Integer.parseInt(arguments[1]);
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    System.out.println(msIdo + "ms várása!");
                }catch (ProtoException e){
                    System.out.println("Nem sikerült várni!");
                }
                break;
            case "Vizfolyas":
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    jelenlegiJatek.jatek.vizFolyas(jelenlegiJatek.randomKi);
                    for (Forras f : jelenlegiJatek.jatek.getForrasok()) {
                        System.out.println(f + "-ből elindult a víz! ");
                    }
                    for (Cso cs : jelenlegiJatek.jatek.getCsovek()) {
                        System.out.println(cs + "-be befolyt a víz! ");
                    }
                    for (Pumpa p : jelenlegiJatek.jatek.getPumpak()) {
                        System.out.println(p + "-be befolyt a víz! ");
                    }
                    for (Ciszterna c : jelenlegiJatek.jatek.getCiszternak()) {
                        System.out.println(c + " elnyelte a vizet! ");
                    }

                }catch (ProtoException e){
                    System.out.println("Nem sikerült!");
                }
                break;
            case "BeallitCso":
                String csoNeve = arguments[1];
                boolean lyukase = arguments[2].equalsIgnoreCase("igen");
                boolean ragade = arguments[3].equalsIgnoreCase("igen");
                boolean csuszike = arguments[4].equalsIgnoreCase("igen");
                int msLyukasztasIdo = Integer.parseInt(arguments[5]);
                String ragasztottaNeve = arguments[6];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.mezok.containsKey(csoNeve)) {
                        Cso cso1 = (Cso) jelenlegiJatek.mezok.get(csoNeve);
                        cso1.lyukas = lyukase;
                        cso1.ragad = ragade;
                        cso1.csuszik = csuszike;
                        cso1.lyukasztasiIdo = msLyukasztasIdo;
                        if(jelenlegiJatek.jatekosok.containsKey(ragasztottaNeve)) cso1.ragasztotta = jelenlegiJatek.jatekosok.get(ragasztottaNeve);
                        System.out.println(csoNeve + " állapota sikeresen beállítva: " + "lyukas: " + (lyukase ? "igen " : "nem ") + "ragad: " + (ragade ? "igen " : "nem ")
                                + "csúszik: " + (csuszike ? "igen " : "nem ") + "lyukasztási idő: " + msLyukasztasIdo +  " ragasztotta: " + ragasztottaNeve);
                    }
                }catch (ProtoException e){
                    System.out.println("Nem sikerült a cső beállítása!");
                }
                break;
            case "Pumpaszerkesztes":
                String pumpaNeve = arguments[1];
                String csoKimenet = arguments[2];
                String csoBemenet = arguments[3];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.mezok.containsKey(pumpaNeve)) {
                        Pumpa pumpa1 = (Pumpa) jelenlegiJatek.mezok.get(pumpaNeve);
                        Cso kimenet = null;
                        Cso bemenet = null;
                        for (Mezo cs1 : pumpa1.getSzomszedok()) {
                            if(cs1.equals((Cso) jelenlegiJatek.mezok.get(csoKimenet))) kimenet = (Cso) jelenlegiJatek.mezok.get(csoKimenet);
                            else if( cs1.equals((Cso) jelenlegiJatek.mezok.get(csoBemenet))) bemenet = (Cso) jelenlegiJatek.mezok.get(csoBemenet);
                        }
                        pumpa1.atAllit(bemenet, kimenet);
                        System.out.println(pumpaNeve + " beállítva!");
                    }
                }catch (ProtoException e){
                    System.out.println("Nem sikerült beállítani!");
                }
                break;
            case "HolAll":
                String jatekosNeve = arguments[1];
                try{
                    if (jelenlegiJatek == null) throw new ProtoException();
                    if(jelenlegiJatek.jatekosok.containsKey(jatekosNeve)) {
                        Jatekos jatekos = jelenlegiJatek.jatekosok.get(jatekosNeve);
                        Mezo mezo = jatekos.getRajtaAll();
                        String mezoNeve = "";
                        for(Map.Entry<String, Mezo> it :
                                jelenlegiJatek.mezok.entrySet()) {
                            if(it.getValue() == mezo) {
                                mezoNeve = it.getKey();
                                break;
                            }
                        }
                        System.out.println(jatekosNeve + " a " + mezoNeve + " mezon all!");
                    }
                }catch (ProtoException e){
                    System.out.println("Nem sikerült a lekerdezes!");
                }
                break;
            default:
                System.out.println("Nem megfelelő formátum!");
                break;

            }
        }
    }*/
}
