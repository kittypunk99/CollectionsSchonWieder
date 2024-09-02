package sets;

import java.util.Objects;

public class Buch implements Comparable<Buch> {
    public String titel;
    public String autor;
    public int preis;

    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public int getPreis() {
        return preis;
    }

    public Buch(String titel, String autor, int preis) {
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buch buch)) return false;
        return Objects.equals(titel, buch.titel) && Objects.equals(autor, buch.autor);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(titel);
        result = 31 * result + Objects.hashCode(autor);
        return result;
    }

    @Override
    public String toString() {
        return "Buch{" +
                "titel='" + titel + '\'' +
                ", autor='" + autor + '\'' +
                ", preis=" + preis +
                '}';
    }

    @Override
    public int compareTo(Buch o) {
        int result = Integer.compare(this.preis, o.preis);
        if (result == 0) {
            result = this.titel.compareTo(o.titel);
            if (result == 0) {
                result = this.autor.compareTo(o.autor);
            }
        }
        return result;
    }
}
