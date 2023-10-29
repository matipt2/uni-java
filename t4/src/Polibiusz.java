public class Polibiusz implements Algorithm {
    private char[][] arr;

    public Polibiusz() {
        this.arr = new char[][]{
                {'A', 'B', 'C', 'D', 'E', 'F'},
                {'G', 'H', 'I', 'J', 'K', 'L'},
                {'M', 'N', 'O', 'P', 'Q', 'R'},
                {'S', 'T', 'U', 'V', 'W', 'X'},
                {'Y', 'Z'}
        };
    }

    @Override
    public String crypt(String inputWord) {
        inputWord = inputWord.toUpperCase();
        StringBuilder cryptedMessage = new StringBuilder();

        for (int i = 0; i < inputWord.length(); i++) {
            char currentChar = inputWord.charAt(i);

            if (currentChar == ' ') {
                cryptedMessage.append(' ');
            } else {
                for (int j = 0; j < arr.length; j++) {
                    for (int k = 0; k < arr[j].length; k++) {
                        if (arr[j][k] == currentChar) {
                            cryptedMessage.append(j).append(k).append(" ");
                        }
                    }
                }
            }
        }
        return cryptedMessage.toString();
    }

    @Override
    public String decrypt(String inputWord) {
        int index = 0;
        StringBuilder decryptedMessage = new StringBuilder();

        while (index < inputWord.length()) {
            if (inputWord.charAt(index) == ' ') {
                decryptedMessage.append(' ');
                index++;
            } else {
                int firstChar = Character.getNumericValue(inputWord.charAt(index));
                int secondChar = Character.getNumericValue(inputWord.charAt(index + 1));
                decryptedMessage.append(arr[firstChar][secondChar]);
                index += 2;
            }
        }
        return decryptedMessage.toString();
    }
}
