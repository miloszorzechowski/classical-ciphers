package ciphers;

public class CaesarCipher extends CipherGenerator {
    private int offset;

    public CaesarCipher(int offset) {
        super("Caesar Cipher");
        this.offset = offset % 26;
    }

    @Override
    public String encrypt(String content) throws unknownCharacterException {
        StringBuilder ciphertext = new StringBuilder();

        for (char letter : content.toUpperCase().toCharArray()) {
            if (Character.isSpaceChar(letter)) {
                ciphertext.append(letter);
                continue;
            }

            isLetter(letter);

            char replacement = (char) (letter + offset);

            if (replacement > 'Z') {
                replacement -= 26;
            } else if (replacement < 'A') {
                replacement += 26;
            }

            ciphertext.append(replacement);
        }

        return ciphertext.toString();
    }

    @Override
    public String decrypt(String ciphertext) throws unknownCharacterException {
        offset *= -1;
        String plaintext = encrypt(ciphertext);
        offset *= -1;

        return plaintext;
    }
}