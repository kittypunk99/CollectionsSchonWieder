package tests;


import cocktails.Cocktailbar;
import sets.Buch;
import sets.Person;
import sets.Punkt;

import java.util.Comparator;
import java.util.TreeSet;

public class SetsTests {

    public static void main(String[] args) {
        Person p1 = new Person("roman","rogner");
        Person p2 = new Person("Roman"," rogner");
        Person p3 = new Person("harald","jarald");
        Person p4 = new Person("randy","ck");
        Person p5 = new Person("asdf","jklö");


        TreeSet<Person> set = new TreeSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.forEach(System.out::println);
        System.out.println(    );

        Punkt pu1 = new Punkt(1,1);
        Punkt pu2 = new Punkt(1,-1);
        Punkt pu3 = new Punkt(-1,1);
        Punkt pu4 = new Punkt(-1,-1);
        Punkt pu5 = new Punkt(1,2);
        Punkt pu6 = new Punkt(2,1);
        Punkt pu7 = new Punkt(2,2);
        Punkt pu8 = new Punkt(1,1);

        TreeSet<Punkt> setP = new TreeSet<>();
        setP.add(pu1);
        setP.add(pu2);
        setP.add(pu3);
        setP.add(pu4);
        setP.add(pu5);
        setP.add(pu6);
        setP.add(pu7);
        setP.add(pu8);

        setP.forEach(System.out::println);
        System.out.println();

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

        System.out.println();

        Cocktailbar.getAvailableDrinks("ressources/cocktailmix.txt").forEach(System.out::println);
    }
}