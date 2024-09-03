package maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Statistik {
    public static Map<Character, Double> zeichenStatistik(String text) {
        String lc = text.toLowerCase();
        Map<Character, Double> stats = new HashMap<>();
        for (int i = 0; i < lc.length(); i++) {
            char c = lc.charAt(i);
            if (stats.containsKey(c)) {
                stats.put(c, stats.get(c) + 1);
            } else {
                stats.put(c, 1.0);
            }
        }
        stats.replaceAll((_, v) -> v / lc.length());
        return stats;
    }

    public static Map<Character, Double> zeichenStatistik(Path datei) {
        try {
            return zeichenStatistik(Files.readString(datei));
        } catch (IOException e) {
            return new HashMap<>();
        }
    }


}
