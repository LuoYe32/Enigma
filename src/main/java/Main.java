public class Main {
    public static void main(String[] args) {
        // Настройки
        Rotor rotor1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q");
        Rotor rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", "E");
        Rotor rotor3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", "V");
        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
        Plugboard plugboard = new Plugboard("ABCDEFGHIJ");

        // Начальные позиции
        rotor1.setPosition(0);
        rotor2.setPosition(0);
        rotor3.setPosition(0);

        EnigmaMachine enigma = new EnigmaMachine(new Rotor[]{rotor1, rotor2, rotor3}, reflector, plugboard);

        String plaintext = "There are three ways to survive in a ruined world.";
        String encrypted = enigma.encrypt(plaintext);

        System.out.println("Encrypted text: " + encrypted);
    }
}
