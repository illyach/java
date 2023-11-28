//lab 4.2
public class Decoder {

    public static String decodeVowels(String input) {
        return input.replaceAll("1", "a")
                .replaceAll("2", "e")
                .replaceAll("3", "i")
                .replaceAll("4", "0")
                .replaceAll("5", "u");
    }

    public static String decodeConsonants(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) {
                char decodedChar = (char) (currentChar - 1); // Верные значения ASCII кодов для строчных латинских букв - от 97 ('a') до 122 ('z').
                result.append(decodedChar); // append добавляет данные в конец текущей строки StringBuilder
                System.out.println();
                System.out.printf("ASCII-код символа %c: %d       ", currentChar, (int) currentChar);
                System.out.printf("ASCII-код декодированного символа %c: %d       \n", decodedChar, (int) decodedChar);

            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String encryptedMessage1 = "t2st3ng";
        String encryptedMessage2 = "uftujoh";

        // Декодування  заміною голосних
        String decodedMessage1 = decodeVowels(encryptedMessage1);
        // Декодування  заміною приголосних
        String decodedMessage2 = decodeConsonants(encryptedMessage2);

        System.out.println();
        System.out.println("Декодування  заміною голосних (1-5):" + " " + decodedMessage1 );
        System.out.println("Декодування  заміною приголосних:" + "    " + decodedMessage2 );
    }
}