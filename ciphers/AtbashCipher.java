package ciphers;

public class AtbashCipher extends CipherGenerator {
    public AtbashCipher() {
        super("Atbash Cipher");
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

            ciphertext.append((char) (('Z' - letter) + 'A'));
        }

        return ciphertext.toString();
    }

    @Override
    public String decrypt(String ciphertext) throws unknownCharacterException {
        return encrypt(ciphertext);
    }
}