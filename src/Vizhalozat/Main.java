package Vizhalozat;

import java.rmi.server.Skeleton;

public class Main {
    public static void main(String[] args) {
        Szkeleton szkeleton = new Szkeleton();

        szkeleton.kezdoFelulet();
    }
}
