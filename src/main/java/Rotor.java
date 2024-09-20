public class Rotor {
    private static final int ALPHABET = 26;
    private final String wiring;
    private final String notch;
    private int position;

    public Rotor(String wiring, String notch) {
        this.wiring = wiring;
        this.notch = notch;
        this.position = 0;
    }

    public void rotate() {
        position = (position + 1) % ALPHABET;
    }

    public boolean atNotch() {
        return notch.indexOf(wiring.charAt(position)) != -1;
    }

    public char forward(char c) {
        int index = (c - 'A' + position) % ALPHABET;
        if (index < 0) {
            index += ALPHABET;
        }
        return wiring.charAt(index);
    }

    public char backward(char c) {
        int index = (wiring.indexOf(c) - position + ALPHABET) % ALPHABET;
        return (char) (index + 'A');
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
