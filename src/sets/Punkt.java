package sets;

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
    public String toString() {
        return "(" + x + "|" + y + ")";
    }

    @Override
    public int compareTo(Punkt o) {
        int result = Double.compare(this.distance(new Punkt(0, 0)), o.distance(new Punkt(0, 0)));
        if (result == 0) {
            result = Integer.compare(x + y, o.x + o.y);
        }
        if (result == 0) {
            result = Integer.compare(x, o.x);
        }
        if (result == 0) {
            result = Integer.compare(y, o.y);
        }
        return result;
    }
}
