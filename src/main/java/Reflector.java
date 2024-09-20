public class Reflector {
    private final String wiring;

    public Reflector(String wiring) {
        this.wiring = wiring;
    }

    public char reflect(char c) {
        return wiring.charAt(c - 'A');
    }
}