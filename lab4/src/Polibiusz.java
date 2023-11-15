public class Polibiusz implements Algorithm {
    private char[][] arr;
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    int matrixSize;

    public Polibiusz() {
        this.arr = new char[][]{
                {'A', 'B', 'C', 'D', 'E', 'F'},
                {'G', 'H', 'I', 'J', 'K', 'L'},
                {'M', 'N', 'O', 'P', 'Q', 'R'},
                {'S', 'T', 'U', 'V', 'W', 'X'},
                {'Y', 'Z'}
        };
    }
    public Polibiusz(int matrixSize, String alphabet){
        this.arr = new char[matrixSize][matrixSize];
        this.alphabet = alphabet;
        int k = 0;

        if(matrixSize<=0){
            throw new IllegalArgumentException("invalid");
        }
        for(int i=0;i<matrixSize;i++){
            for(int j=0;j<matrixSize;j++){
                if(k<alphabet.length()){
                    arr[i][j] = alphabet.charAt(k % alphabet.length());
                    k++;
                }
                else{
                    arr[i][j] = ' ';
                }
            }
        }
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
        StringBuilder decryptedMessage = new StringBuilder();
        String[] pairs = inputWord.trim().split(" ");

        for (String pair : pairs) {
            if (pair.equals("")) {
                decryptedMessage.append(' ');
            } else {
                int x = Character.getNumericValue(pair.charAt(0));
                int y = Character.getNumericValue(pair.charAt(1));
                if (x >= 0 && x < arr.length && y >= 0 && y < arr[x].length) {
                    decryptedMessage.append(arr[x][y]);
                } else {
                    throw new IllegalArgumentException("Invalid indices in the input.");
                }
            }
        }

        return decryptedMessage.toString();
    }

}
