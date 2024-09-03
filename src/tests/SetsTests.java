package tests;


import cocktails.Cocktailbar;
import sets.Buch;

import java.util.Comparator;
import java.util.TreeSet;

public class SetsTests {

    public static void main(String[] args) {
        Buch b1 = new Buch("Harry Potter", "J.K. Rowling", 20);
        Buch b2 = new Buch("Harrald jarrald Potter", "zainzi", 200);
        Buch b3 = new Buch("Harry der ringe", "J.K. tgolgejn", 10);
        Buch b4 = new Buch("Harry Potter", "J.K. Rowling", 20);
        Buch b5 = new Buch("Potter potter", "J.K. jk", 2110);
        Buch b6 = new Buch("Harry harry", "rowling Rowling", 2);
        TreeSet<Buch> set1 = new TreeSet<>(Comparator.comparing(Buch::getTitel).thenComparing(Buch::getAutor).thenComparing(Buch::getPreis));
        set1.add(b1);
        set1.add(b2);
        set1.add(b3);
        set1.add(b4);
        set1.add(b5);
        set1.add(b6);

        set1.forEach(System.out::println);
        System.out.println();
        TreeSet<Buch> set2 = new TreeSet<>();
        set2.add(b1);
        set2.add(b2);
        set2.add(b3);
        set2.add(b4);
        set2.add(b5);
        set2.add(b6);
        set2.forEach(System.out::println);

        Cocktailbar.getAvailableDrinks("ressources/cocktailmix.txt").forEach(System.out::println);
    }
}