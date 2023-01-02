import ciphers.AtbashCipher;
import ciphers.CaesarCipher;
import ciphers.MorseCode;
import ciphers.unknownCharacterException;

public class Main {
    public static void main(String[] args) throws unknownCharacterException {
        MorseCode morseCode = new MorseCode();
        CaesarCipher caesarCipher = new CaesarCipher(13);
        AtbashCipher atbashCipher = new AtbashCipher();

        String content = "Merry Christmas";
        String ciphertext;

        System.out.printf("%s%n", morseCode);
        ciphertext = morseCode.encrypt(content);
        System.out.printf("Ciphertext: %s%n", ciphertext);
        System.out.printf("Plaintext: %s%n", morseCode.decrypt(ciphertext));

        System.out.printf("%n%s%n", caesarCipher);
        ciphertext = caesarCipher.encrypt(content);
        System.out.printf("Ciphertext: %s%n", ciphertext);
        System.out.printf("Plaintext: %s%n", caesarCipher.decrypt(ciphertext));

        System.out.printf("%n%s%n", atbashCipher);
        ciphertext = atbashCipher.encrypt(content);
        System.out.printf("Ciphertext: %s%n", ciphertext);
        System.out.printf("Plaintext: %s%n", atbashCipher.decrypt(ciphertext));
    }
}