public class ROTXX implements Algorithm{
    public int rotation;
    public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public ROTXX(int rotation){
        this.rotation = rotation;
    }
    public ROTXX(){
        this.rotation = 11;
    }

    @Override
    public String crypt(String inputWord) {
        StringBuilder cryptedMessage = new StringBuilder();
        int alphabetLength = alphabet.length();
        for (int i = 0; i < inputWord.length(); i++) {
            char current= inputWord.charAt(i);
            int charIndex = alphabet.indexOf(current);

            if (charIndex != -1) {
                int rotatedIndex = (charIndex + this.rotation) % alphabetLength;
                char encryptedChar = alphabet.charAt(rotatedIndex);
                cryptedMessage.append(encryptedChar);
            } else {
                cryptedMessage.append(current);
            }
        }

        return cryptedMessage.toString();
    }

    @Override
    public String decrypt(String inputWord) {
        StringBuilder decryptedMessage = new StringBuilder();
        int alphabetLength = alphabet.length();
        for (int i = 0; i < inputWord.length(); i++) {
            char current = inputWord.charAt(i);
            int charIndex = alphabet.indexOf(current);

            if (charIndex != -1) {
                int rotatedIndex = (charIndex - this.rotation + alphabetLength) % alphabetLength;
                char decryptedChar = alphabet.charAt(rotatedIndex);
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(current);
            }
        }

        return decryptedMessage.toString();
    }


}
