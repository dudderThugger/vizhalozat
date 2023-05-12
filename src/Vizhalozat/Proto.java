package Vizhalozat;

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
            switch(arguments[0]) {
                case "JatekLetrehoz":
                    String ujJatekNeve = arguments[1];
                    if(!jatekAdatok.containsKey(ujJatekNeve)) {
                        jatekAdatok.put(ujJatekNeve, new ProtoJatek());
                        System.out.println(ujJatekNeve + " sikeresen letrehozva!");
                    } else {
                        System.out.println("Nem sikerult letrehozni a jatekot!");
                    }
                    break;
                case "JatekKivalaszt":
                    String jatekNeve = arguments[1];
                    if(jatekAdatok.containsKey(jatekNeve)) {
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
                case "Futtatas":
                    File fajl = new File(arguments[1]);
                    try {
                        parancsKezelo(new Scanner(fajl));
                    } catch (FileNotFoundException e) {
                        System.out.println("Nem talalhato a megadott fajl!");
                    }
                    break;
                case "JatekosLetrehoz":
                    String ujJatekosNeve = arguments[1];
                    String jatekosTipus = arguments[2];
                    try {
                        if(jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.jatekosok.containsKey(ujJatekosNeve)) throw new ProtoException();
                        if(jatekosTipus.equals("szerelo")) {
                            Szerelo ujSzerelo = new Szerelo();
                            jelenlegiJatek.jatek.addJatekos(ujSzerelo);
                            jelenlegiJatek.jatekosok.put(ujJatekosNeve, ujSzerelo);
                            jelenlegiJatek.szerelok.put(ujJatekosNeve, ujSzerelo);
                        } else if(jatekosTipus.equals("szabotor")) {
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
                case "MezoLetrehoz":
                    String mezoNeve = arguments[1];
                    String mezoTipusa = arguments[2];
                    try{
                        if(jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.mezok.containsKey(mezoNeve)) throw new ProtoException();
                        if(mezoTipusa.equals("ciszterna")) {
                            Ciszterna ujCiszterna = new Ciszterna(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujCiszterna);
                            jelenlegiJatek.mezok.put(mezoNeve, ujCiszterna);
                        } else if(mezoTipusa.equals("cso")) {
                            Cso ujCso = new Cso(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujCso);
                            jelenlegiJatek.mezok.put(mezoNeve, ujCso);
                            jelenlegiJatek.csovek.put(mezoNeve, ujCso);
                        } else if(mezoTipusa.equals("forras")) {
                            Forras ujForras = new Forras(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujForras);
                            jelenlegiJatek.mezok.put(mezoNeve, ujForras);
                        } else if(mezoTipusa.equals("pumpa")) {
                            Pumpa ujPumpa = new Pumpa(jelenlegiJatek.jatek);
                            jelenlegiJatek.jatek.addMezo(ujPumpa);
                            jelenlegiJatek.mezok.put(mezoNeve, ujPumpa);
                        } else {
                            throw new ProtoException();
                        }
                        System.out.println(mezoNeve + " mezo sikeresen letrehozva!");
                    } catch(ProtoException e) {
                        System.out.println("Nem sikerult letrehozni a mezot!");
                    }
                    break;
                case "SzomszedBeallit":
                    String mezo1Neve = arguments[1];
                    String mezo2Neve = arguments[2];
                    try {
                        if(jelenlegiJatek == null) throw new ProtoException();
                        if(jelenlegiJatek.mezok.containsKey(mezo1Neve) && jelenlegiJatek.mezok.containsKey(mezo2Neve)) {
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
            }
        }
    }
}
