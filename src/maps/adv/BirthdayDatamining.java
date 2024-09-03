package maps.adv;

import maps.Birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class BirthdayDatamining {
    List<Birthday> birthdays;

    public BirthdayDatamining(String fileName) throws IOException {
        birthdays = new ArrayList<>();
        try (BufferedReader b = Files.newBufferedReader(Path.of(fileName))) {
            b.lines().forEach(line -> Arrays.stream(line.split(",")).forEach(date -> birthdays.add(new Birthday(date))));
        }
    }

    public static void main(String[] args) throws IOException {
        BirthdayDatamining bd = new BirthdayDatamining("ressources/birthdays.txt");
        System.out.println(bd.averageBirthYear());
        System.out.println(bd.mostCommonBirthyear());
        System.out.println(Arrays.toString(bd.birthdaysPerMonth()));
        System.out.println(bd.getBirthdaysOnDay(26, 1));
        System.out.println(bd.getBirthdaysOnDay(29, 2));
        System.out.println(bd.getBirthdaysOnDay(22, 5));
        System.out.println(bd.getBirthdaysOnDay(24, 12));
        System.out.println(bd.birthdaysOnLeapYear());
        System.out.println(bd.getOldest());
        System.out.println(bd.getYoungest());
        System.out.println(bd.getYoungestTeacher());
        System.out.println(bd.getAmountOfTeachers());

        System.out.println(bd.getTeacherBirthdays().getFirst());
        System.out.println(bd.getTeacherBirthdays().getLast());
        System.out.println(bd.getStudentBirthdays().getFirst());
        System.out.println(bd.getStudentBirthdays().getLast());

        System.out.println(bd.peopleWithSameBirthday());
    }

    public double averageBirthYear() {
        return birthdays.stream().mapToInt(Birthday::getYear).average().orElse(0);
    }

    public int mostCommonBirthyear() {
        return birthdays.stream().mapToInt(Birthday::getYear).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0);
    }

    public int[] birthdaysPerMonth() {
        int[] months = new int[12];
        birthdays.stream().mapToInt(Birthday::getMonth).forEach(month -> months[month - 1]++);
        return months;
    }

    public int getBirthdaysOnDay(int day, int month) {
        return (int) birthdays.stream().filter(b -> b.getDay() == day && b.getMonth() == month).count();
    }

    public int birthdaysOnLeapYear() {
        return (int) birthdays.stream().filter(Birthday::isLeapYear).count();
    }

    public Birthday getOldest() {
        return birthdays.stream().min(Birthday::compareTo).orElse(null);
    }

    public Birthday getYoungest() {
        return birthdays.stream().max(Birthday::compareTo).orElse(null);
    }

    public Birthday getYoungestTeacher() {
        Birthday oldest = birthdays.getFirst();
        List<Birthday> birthdays = this.birthdays.stream().sorted().toList();
        for (Birthday b : birthdays) {
            if (b.getYear() - oldest.getYear() >= 4) {
                return oldest;
            }
            oldest = b;
        }
        return null;
    }

    public int getAmountOfTeachers() {
        Birthday youngest = getYoungestTeacher();
        return (int) birthdays.stream().filter(b -> youngest.compareTo(b) >= 0).count();
    }

    public List<Birthday> getTeacherBirthdays() {
        Birthday youngestTeacher = getYoungestTeacher();
        return birthdays.stream().filter(b -> b.compareTo(youngestTeacher) <= 0).collect(Collectors.toList());
    }

    public List<Birthday> getStudentBirthdays() {
        Birthday youngestTeacher = getYoungestTeacher();
        return birthdays.stream().filter(b -> b.compareTo(youngestTeacher) > 0).collect(Collectors.toList());
    }

    public Map<Birthday, Long> peopleWithSameBirthday() {
        TreeMap<Birthday, Long> birthdayMap = new TreeMap<>();
        birthdays.forEach(b -> birthdayMap.put(b, birthdayMap.getOrDefault(b, 0L) + 1));
        /*int x = 0;
        for (Map.Entry<Birthday, Long> entry : birthdayMap.entrySet()) {
            if (entry.getValue() > 1) {
                x += entry.getValue();
            }
        }*/
        return birthdayMap; //birthdays.size()-(int) birthdayMap.values().stream().filter(v -> v > 1).count();//x; //birthdayMap.size();//(int) birthdayMap.values().stream().filter(v -> v > 1).count(); was ist da gewollt?
    }
}

