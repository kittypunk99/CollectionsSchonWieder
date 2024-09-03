package maps.adv;

import maps.Birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthdayDatamining {
    List<Birthday> birthdays;

    public BirthdayDatamining(String fileName) throws IOException {
        birthdays = new ArrayList<>();
        try (BufferedReader b = Files.newBufferedReader(Path.of(fileName))) {
            b.lines().forEach(line -> {
                Arrays.stream(line.split(",")).forEach(date -> birthdays.add(new Birthday(date)));
            });
        }
    }

    public static void main(String[] args) throws IOException {
        BirthdayDatamining bd = new BirthdayDatamining("ressources/birthdays.txt");
        System.out.println(bd.averageBirthYear());
        System.out.println(bd.mostCommonBirthyear());
    }

    public double averageBirthYear() {
        return birthdays.stream().mapToInt(Birthday::getYear).average().orElse(0);
    }

    public int mostCommonBirthyear() {
        return birthdays.stream()
                .mapToInt(Birthday::getYear)
                .boxed()
                .collect(java.util.stream.Collectors.groupingBy(e -> e, java.util.stream.Collectors.counting()))
                .entrySet()
                .stream()
                .max(java.util.Map.Entry.comparingByValue())
                .map(java.util.Map.Entry::getKey)
                .orElse(0);
           }
}

