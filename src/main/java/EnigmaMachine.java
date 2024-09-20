public class EnigmaMachine {
    private final Rotor[] rotors;
    private final Reflector reflector;
    private final Plugboard plugboard;

    public EnigmaMachine(Rotor[] rotors, Reflector reflector, Plugboard plugboard) {
        this.rotors = rotors;
        this.reflector = reflector;
        this.plugboard = plugboard;
    }

    public String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c: text.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                c = plugboard.substitute(c);  //Замена плагборда

                for (Rotor rotor: rotors) {
                    c = rotor.forward(c);  // Прямой проход через роторы
                }

                c = reflector.reflect(c);  //Reflection

                for (int i = rotors.length - 1; i >= 0; i--) {
                    c = rotors[i].backward(c);  // Обратный проход через роторы
                }

                c = plugboard.substitute(c);  // Снова плагборд

                encryptedText.append(c);  // Добавляем к результату

                rotateRotors();  // Поворот первого ротора (и мб других)
            } else {
                encryptedText.append(c);  // Для символов
            }
        }
        return encryptedText.toString();
    }

    private void rotateRotors() {
        boolean rotateNext = true;

        for (Rotor rotor: rotors) {
            if (rotateNext) {
                rotor.rotate();
                rotateNext = rotor.atNotch();
            } else {
                break;
            }
        }
    }
}
