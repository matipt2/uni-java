public class Polibiusz implements Algorithm {
    private char[][] arr;
    private final String alphabet;
    private int matrixSize;

    public Polibiusz() {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 8);
    }

    public Polibiusz(String alphabet, int matrixSize) {
        this.matrixSize = matrixSize;
        this.alphabet = alphabet;
        this.arr = new char[matrixSize][matrixSize];
        int k = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (k < this.alphabet.length()) {
                    arr[i][j] = this.alphabet.charAt(k);
                    k++;
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public String crypt(String inputWord) {
        StringBuilder cryptedMessage = new StringBuilder();
        for (int i = 0; i < inputWord.length(); i++) {
            char currentChar = inputWord.charAt(i);
            boolean found = false;

            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    if (arr[j][k] == currentChar) {
                        cryptedMessage.append((j + 1) + "" + (k + 1) + " ");
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                cryptedMessage.append(currentChar);
            }
        }
        return cryptedMessage.toString();
    }

    @Override
    public String decrypt(String inputWord) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < inputWord.length(); i += 2) {
            int x = Character.getNumericValue(inputWord.charAt(i)) - 1;
            int y = Character.getNumericValue(inputWord.charAt(i + 1)) - 1;

            if (x >= 0 && x < arr.length && y >= 0 && y < arr[x].length) {
                decryptedMessage.append(arr[x][y]);
            } else {
                decryptedMessage.append(inputWord.charAt(i)).append(inputWord.charAt(i + 1));
            }
        }
        return decryptedMessage.toString();
    }
}