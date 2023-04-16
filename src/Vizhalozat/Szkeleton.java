package Vizhalozat;

import java.util.ArrayList;
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

    public void ujObjektum(Object obj, String name) {
        ids.put(obj, name);
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
        System.out.println(++lineCount + ". "+ name + "." + functionName + "() visszater");
        --tabs;
    }

    public void visszateres(Object caller, String functionName, String ret) {
        String name = ids.get(caller);
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". "+ name + "." + functionName + "() visszater " + ret + " ertekkel");
        --tabs;
    }

    public void visszateres(Object caller, String functionName, Object ret) {
        String retName = ids.get(ret);
        String name = ids.get(caller);
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". "+ name + "." + functionName + "() visszater " + retName + " objektummal");
        --tabs;
    }

    public String kerdes(Object caller, String question) {
        String name = ids.get(caller);
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". "+ name + ": " + question + "?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println(++lineCount + ". tesztelo: " + answer);
        return answer;
    }

    public void uzenet( String uzenet) {
        ++tabs;
        for (int i = 0; i < tabs; ++i) { System.out.print('\t');}
        System.out.println( uzenet );
        --tabs;
    }


    public void kezdoFelulet() {
        Scanner scanner = new Scanner(System.in);
        int selectedTest = 1;
        String menu = "Valasszon tesztesetet!\n" +
                "\t1. Pumpa elromlik\n" +
                "\t2. Szerelo lerak egy pumpat\n" +
                "\t3. Szerelo rossz helyen rak le pumpat\n" +
                "\t4. Szerelo foltoz\n" +
                "\t5. Szerelo aktiv elemen foltoz\n" +
                "\t6.Teszt: Cső lehelyezése\n" +
                "\t7.Teszt: Cső lehelyezése csövön\n" +
                "\t8.Teszt: Cső felvétele\n" +
                "\t9.Teszt: Cső felvétele csövön\n" +
                "\t10.Teszt: Pumpa vásárlás ciszternán\n" +
                "\t11.Teszt: Pumpa vásárlás nem ciszternán\n" +
                "\t12.Teszt: Játékos pumpát állít pumpán\n" +
                "\t13.Teszt: Játékos pumpát állít nem pumpán\n" +
                "\t14.Teszt: Pumpa javítás pumpán\n" +
                "\t15.Teszt: Pumpa javítás nem pumpán\n" +
                "\t16.Teszt: Szabotőr lyukaszt csövön\n" +
                "\t17.Teszt: Szabotőr lyukaszt aktív elemen\n" +
                "\t18.Teszt: Pumpa vízfolyás\n" +
                "\t19.Teszt: Folyik a csőben a víz\n" +
                "\t20.Teszt: Befolyik a ciszternába a víz\n" +
                "\t69. Kilépés\n" +
                "\n\n";

        System.out.println(menu);

        while(scanner.hasNext()) {

            selectedTest = Integer.parseInt(scanner.nextLine());
            switch(selectedTest) {
                case 1:
                    teszt1();
                    break;
                case 2:
                    teszt2();
                    break;
                case 3:
                    teszt3();
                    break;
                case 4:
                    teszt4();
                    break;
                case 5:
                    teszt5();
                    break;
                case 6:
                    teszt6();
                    break;
                case 7:
                    teszt7();
                    break;
                case 8:
                    teszt8();
                    break;
                case 9:
                    teszt9();
                    break;
                case 10:
                    teszt10();
                    break;
                case 11:
                    teszt11();
                    break;
                case 12:
                    teszt12();
                    break;
                case 13:
                    teszt13();
                    break;
                case 14:
                    teszt14();
                    break;
                case 15:
                    teszt15();
                    break;
                case 16:
                    teszt16();
                    break;
                case 17:
                    teszt17();
                    break;
                case 18:
                    teszt18();
                    break;
                case 19:
                    teszt19();
                    break;
                case 20:
                    teszt20();
                    break;
                case 69:
                    System.exit(69);
                default:
                    System.out.println("Nincs ilyen teszteset!");
                    break;
            }
            System.out.println(menu);
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
        System.out.println("Teszt vege\n");
        lineCount = 0;
    }

    public void teszt2() {
        System.out.println("2.Teszt: Szerelo lerak pumpat");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Cso rajtaAll = new Cso(j, this);
        Szerelo sz = new Szerelo(rajtaAll, this);
        Pumpa szomszed1 = new Pumpa(j, this);
        Pumpa szomszed2 = new Pumpa(j, this);
        Pumpa tart = new Pumpa(j, this);

        ids.put(j, "j");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");
        ids.put(szomszed1, "szomszed1");
        ids.put(szomszed2, "szomszed2");
        ids.put(tart, "tart");

        /** Objektumok referenciáinak beállítása */
        sz.add_PumpaTart(tart);
        rajtaAll.raAllit(sz);
        ArrayList<Mezo> szomszedok = new ArrayList<Mezo>();
        szomszedok.add(szomszed1);
        szomszedok.add(szomszed2);
        rajtaAll.setSzomszedok(szomszedok);

        sz.lerak_pumpa();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt3() {
        System.out.println("3.Teszt: Szerelo rossz helyen rak le pumpat");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Pumpa rajtaAll = new Pumpa(j, this);
        Szerelo sz = new Szerelo(rajtaAll, this);
        Pumpa tart = new Pumpa(j, this);

        ids.put(j, "j");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");
        ids.put(tart, "tart");

        /** Objektum referenciáinak beállítása */
        sz.add_Kezebe(tart);
        sz.add_PumpaTart(tart);
        rajtaAll.raAllit(sz);

        sz.lerak_pumpa();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt4() {
        System.out.println("4.Teszt: Szerelo foltoz");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Cso rajtaAll = new Cso(j, this);
        Szerelo sz = new Szerelo(rajtaAll, this);

        ids.put(j, "j");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);

        sz.foltoz();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt5() {
        System.out.println("5.Teszt: Szerelo aktiv elemen foltoz");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Pumpa rajtaAll = new Pumpa(j, this);
        Szerelo sz = new Szerelo(rajtaAll, this);

        ids.put(j, "j");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);

        sz.foltoz();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt6() {
        System.out.println("6.Teszt: Cső lehelyezése");

        Jatek j = new Jatek(this);
        Cso tart = new Cso(j, this);
        Pumpa rajtaAll = new Pumpa(j,this);
        Szerelo sz = new Szerelo(rajtaAll,this);

        ujObjektum(j,"j");
        ujObjektum(tart,"tart");
        ujObjektum(rajtaAll,"rajtaAll");
        ujObjektum(sz,"sz");

        sz.add_Kezebe(tart);
        sz.lerak_cso();

        System.out.println("Teszt vége\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt7() {
        System.out.println("7.Teszt: Cső lehelyezése csövön");

        Jatek j = new Jatek(this);
        Cso tart = new Cso(j, this);
        Cso rajtaAll = new Cso(j,this);
        Szerelo sz = new Szerelo(rajtaAll,this);

        ujObjektum(j,"j");
        ujObjektum(tart,"tart");
        ujObjektum(rajtaAll,"rajtaAll");
        ujObjektum(sz,"sz");

        sz.add_Kezebe(tart);
        sz.lerak_cso();

        System.out.println("Teszt vége\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt8() {
        System.out.println("8.Teszt: Cső felvétele");

        Jatek j = new Jatek(this);
        Cso felveves = new Cso(j, this);
        Pumpa rajtaAll = new Pumpa(j,this);
        Szerelo sz = new Szerelo(rajtaAll,this);

        ujObjektum(j,"j");
        ujObjektum(felveves,"felveves");
        ujObjektum(rajtaAll,"rajtaAll");
        ujObjektum(sz,"sz");


        rajtaAll.addSzomszed(felveves);
        //felveves.addSzomszed(rajtaAll);


        sz.felvesz_cso(felveves);

        System.out.println("Teszt vége\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt9() {
        System.out.println("9.Teszt: Cső felvétele csövön");

        Jatek j = new Jatek(this);
        Cso rajtaAll = new Cso(j,this);
        Szerelo sz = new Szerelo(rajtaAll,this);

        ujObjektum(sz,"sz");
        ujObjektum(rajtaAll,"rajtaAll");

        sz.felvesz_cso(rajtaAll);
        System.out.println("Teszt vége\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt10() {
        System.out.println("10.Teszt: Pumpa vásárlás ciszternán");

        Jatek jatek = new Jatek(this);
        Ciszterna rajtaAll = new Ciszterna(jatek,this);
        Szerelo sz = new Szerelo(rajtaAll,this);
        Pumpa tart = new Pumpa(jatek,this);


        ujObjektum(tart,"tart");
        ujObjektum(jatek,"j");
        ujObjektum(rajtaAll,"rajtaAll");
        ujObjektum(sz,"sz");

        sz.add_PumpaTart(tart);
        rajtaAll.raAllit(sz);

        sz.pumpatvesz();

        System.out.println("Teszt vége\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt11(){
        System.out.println("11.Teszt: Pumpa vásárlás nem ciszternán");

        /** Objektumok létrehozása */
        Jatek jatek = new Jatek(this);
        Cso rajtaAll = new Cso(jatek, this);
        Szerelo sz = new Szerelo(rajtaAll, this);

        ids.put(jatek, "jatek");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);
        sz.pumpatvesz();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt12(){
        System.out.println("12.Teszt: Játékos pumpát állít pumpán");

        /** Objektumok létrehozása */
        Jatek jatek = new Jatek(this);
        Pumpa p = new Pumpa(jatek, this);
        Szerelo sz = new Szerelo(p, this);
        Cso cs1 = new Cso(jatek, this);
        Cso cs2 = new Cso(jatek, this);
        Cso cs3 = new Cso(jatek, this);
        Cso cs4 = new Cso(jatek, this);

        ids.put(jatek, "jatek");
        ids.put(p, "p");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        p.raAllit(sz);
        p.addSzomszed(cs1);
        p.addSzomszed(cs2);
        p.addSzomszed(cs3);
        p.addSzomszed(cs4);
        sz.pumpaAllitas();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt13(){
        System.out.println("13.Teszt: Játékos pumpát állít nem pumpán");

        /** Objektumok létrehozása */
        Jatek jatek = new Jatek(this);
        Cso rajtaAll = new Cso(jatek, this);
        Szerelo sz = new Szerelo(rajtaAll, this);

        ids.put(jatek, "jatek");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);
        sz.pumpaAllitas();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt14(){
        System.out.println("14.Teszt: Pumpa javítás pumpán");

        /** Objektumok létrehozása */
        Jatek jatek = new Jatek(this);
        Pumpa rajtaAll = new Pumpa(jatek, this);
        Szerelo sz = new Szerelo(rajtaAll, this);

        ids.put(jatek, "jatek");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);
        sz.szerel();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt15(){
        System.out.println("15.Teszt: Pumpa javítás nem pumpán");

        /** Objektumok létrehozása */
        Jatek jatek = new Jatek(this);
        Cso rajtaAll = new Cso(jatek, this);
        Szerelo sz = new Szerelo(rajtaAll, this);

        ids.put(jatek, "jatek");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);
        sz.szerel();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

    public void teszt16(){
        System.out.println("16.Teszt: Szabotőr lyukaszt csövön");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Cso rajtaAll = new Cso(j, this);
        Szabotor sz = new Szabotor(rajtaAll, this);

        ids.put(j, "j");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);
        sz.lyukaszt();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt17(){
        System.out.println("17.Teszt: Szabotőr lyukaszt aktív elemen");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Pumpa rajtaAll = new Pumpa(j, this);
        Szabotor sz = new Szabotor(rajtaAll, this);

        ids.put(j, "j");
        ids.put(rajtaAll, "rajtaAll");
        ids.put(sz, "sz");

        /** Objektum referenciáinak beállítása */
        rajtaAll.raAllit(sz);
        sz.lyukaszt();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt18(){
        System.out.println("18.Teszt: Pumpa vízfolyás");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Pumpa p = new Pumpa(j, this);
        Cso be = new Cso(j, this);
        Cso ki = new Cso(j, this);

        ids.put(j, "j");
        ids.put(p, "p");
        ids.put(be, "be");
        ids.put(ki, "ki");

        /** Objektum referenciáinak beállítása */
        p.setBemenet(be);
        p.setKimenet(ki);

        p.befolyik();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt19(){
        System.out.println("19.Folyik a csőben a víz");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Pumpa p = new Pumpa(j, this);
        Cso be = new Cso(j, this);
        Cso ki = new Cso(j, this);

        ids.put(j, "j");
        ids.put(p, "p");
        ids.put(be, "be");
        ids.put(ki, "ki");

        /** Objektum referenciáinak beállítása */
        p.setBemenet(be);
        p.setKimenet(ki);

        p.befolyik();

        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }
    public void teszt20(){
        System.out.println("20.Teszt: Befolyik a ciszternába a víz");

        /** Objektumok létrehozása */
        Jatek j = new Jatek(this);
        Cso cs = new Cso(j, this);
        Ciszterna c = new Ciszterna(j, this);

        ids.put(j, "j");
        ids.put(cs, "cs");
        ids.put(c, "c");

        /** Objektum referenciáinak beállítása */
        ArrayList<Mezo> csoSzomszed = new ArrayList<>();
        ArrayList<Mezo> ciszternaSzomszed = new ArrayList<>();
        csoSzomszed.add(c);
        ciszternaSzomszed.add(cs);
        cs.setSzomszedok(csoSzomszed);
        c.setSzomszedok(ciszternaSzomszed);

        cs.befolyik();


        System.out.println("Teszt vege\n");
        ids.clear();
        lineCount = 0;
    }

}
