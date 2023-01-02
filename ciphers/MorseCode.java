package ciphers;

import java.util.Arrays;

public class MorseCode extends CipherGenerator {
    private final String[] symbols = {
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
    };

    public MorseCode() {
        super("Morse Code");
    }

    @Override
    public String encrypt(String content) throws unknownCharacterException {
        StringBuilder ciphertext = new StringBuilder();

        for (char letter : content.toUpperCase().toCharArray()) {
            if (Character.isSpaceChar(letter)) {
                ciphertext.append("/ ");
                continue;
            }

            isLetter(letter);

            ciphertext.append(symbols[letter - 'A']).append(' ');
        }

        return ciphertext.toString();
    }

    @Override
    public String decrypt(String ciphertext) throws unknownCharacterException {
        StringBuilder plaintext = new StringBuilder();

        for (String symbol : ciphertext.split(" ")) {
            if (symbol.equals("/")) {
                plaintext.append(' ');
                continue;
            }

            int symbolIndex = Arrays.asList(symbols).indexOf(symbol);

            if (symbolIndex == -1) {
                throw new unknownCharacterException(String.format("\"%s\" is not a Morse Code symbol", symbol));
            }

            plaintext.append((char) (symbolIndex + 'A'));
        }

        return plaintext.toString();
    }
}