package tests;

import maps.Statistik;

import java.nio.file.Path;

public class MapsTests {
    public static void main(String[] args) {
        Statistik.zeichenStatistik(Path.of("ressources/cocktailmix.txt")).forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
