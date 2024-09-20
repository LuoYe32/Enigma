import java.util.HashMap;
import java.util.Map;

public class Plugboard {
    private final Map<Character, Character> plugboardMapping;

    public Plugboard(String connections) {
        plugboardMapping = new HashMap<>();

        for (int i = 0; i < connections.length(); i += 2) {
            char c1 = connections.charAt(i);
            char c2 = connections.charAt(i + 1);
            plugboardMapping.put(c1, c2);
            plugboardMapping.put(c2, c1);
        }
    }

    public char substitute(char c) {
        return plugboardMapping.getOrDefault(c, c);
    }
}
