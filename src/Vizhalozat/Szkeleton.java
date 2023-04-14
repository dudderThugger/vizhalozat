package Vizhalozat;

import java.util.HashMap;
import java.util.Scanner;

public class Szkeleton {
    private HashMap<Object, String> ids;
    private int tabs;
    private int lineCount;

    public Szkeleton() {
        ids = new HashMap<Object, String>();
        tabs = 0;
        lineCount = 0;
    }

    public void hivas(Object caller, String functionName) {
        ++tabs;
        String name = ids.get(caller);
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". "+ name + "." + functionName + "()");
    }

    public void visszateres(Object caller, String functionName) {
        String name = ids.get(caller);
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". "+ name + "." + functionName + "() visszatér");
        --tabs;
    }

    public void kerdes(Object caller, String question) {
        String name = ids.get(caller);
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". "+ name + ": " + question + "?");
    }

    public void valasz(String answer) {
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". tesztelo: " + answer);
    }

    public void kezdoFelulet() {
        System.out.println("Valasszon tesztesetet!\n" +
                "\t1. Pumpa elromlik" +
                "\n\n");
        Scanner scanner = new Scanner(System.in);
        int selectedTest = 1;

        while(scanner.hasNext()) {
            selectedTest = Integer.parseInt(scanner.nextLine());
            switch(selectedTest) {
                case 1:
                    teszt1();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public void teszt1() {
        System.out.println("1.Teszt: Pumpa elromlik");
        Jatek j = new Jatek(this);
        Pumpa p = new Pumpa(j, this);
        j.addPumpa(p);

        ids.put(j, "j");
        ids.put(p, "p");

        j.pumpaElRomlik();
        System.out.println("Teszt vége\n");
    }
}
