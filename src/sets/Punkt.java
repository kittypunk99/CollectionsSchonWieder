package sets;

import java.util.TreeSet;

public class Punkt implements Comparable<Punkt> {
    public int x;
    public int y;

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Punkt p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

    @Override
    public int compareTo(Punkt o) {
       /* int result = Double.compare(this.distance(new Punkt(0, 0)), o.distance(new Punkt(0, 0)));
        if (result == 0) {
            result = ;
        }*/
        return Double.compare(Math.atan2(x, y), Math.atan2(o.x ,  o.y));
    }

    @Override
    public String toString() {
        return "("+x+" | "+y+")";
    }

    public static void main(String[] args) {
        Punkt p1 = new Punkt(1, 1);
        Punkt p2 = new Punkt(1, -1);
        Punkt p3 = new Punkt(2, 1);
        Punkt p4 = new Punkt(2, 2);
        Punkt p5 = new Punkt(1, 0);
        Punkt p8 = new Punkt(-1, 0);
        Punkt p6 = new Punkt(0, -1);
        Punkt p7 = new Punkt(0, 0);
        TreeSet<Punkt> punkte = new TreeSet<>();
        punkte.add(p1);
        punkte.add(p2);
        punkte.add(p3);
        punkte.add(p4);
        punkte.add(p5);
        punkte.add(p6);
        punkte.add(p7);
        punkte.add(p8);
        punkte.forEach(System.out::println);

    }
}
