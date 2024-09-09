package sets;

public class Person implements Comparable<Person> {
    public String vorname;
    public String famname;

    public Person(String vorname, String famname) {
        this.vorname = vorname;
        this.famname = famname;
    }

    @Override
    public String toString() {
        return famname + " " + vorname;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.famname.toLowerCase().strip().compareTo(o.famname.toLowerCase().strip());
        if (result == 0) {
            result = this.vorname.toLowerCase().strip().compareTo(o.vorname.toLowerCase().strip());
        }
        return result;
    }
}
