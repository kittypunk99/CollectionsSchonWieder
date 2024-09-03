package maps;

public class Birthday implements Comparable<Birthday> {
    private final int day;
    private final int month;
    private final int year;

    public Birthday(String date) {
        String[] parts = date.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Date must be in format dd.mm.yyyy");
        }
        try {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Date must be in format dd.mm.yyyy");
        }

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Birthday o) {
        if (year != o.year) {
            return year - o.year;
        }
        if (month != o.month) {
            return month - o.month;
        }
        return day - o.day;
    }

    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

    public boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
