import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ConnectionHandler implements Runnable {
    private final Socket clientSocket;

    public ConnectionHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                try {
                    if (inputLine.matches(".*[+\\-*/].*")) {
                        int result = arithmeticExpression(inputLine);
                        out.println(result);
                    } else {
                        out.println(inputLine);
                    }

                } catch (Exception e) {
                    out.println("error " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error handling connection: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }

    private static int arithmeticExpression(String expression) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        int number = 0;
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = (number * 10) + (ch - '0');
            } else if ("+-*/".contains(String.valueOf(ch))) {
                numbers.add(number);
                number = 0;
                operators.add(ch);
            } else {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }
        }
        numbers.add(number);

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char operator = operators.get(i);
            int nextNumber = numbers.get(i + 1);

            switch (operator) {
                case '+' -> result += nextNumber;
                case '-' -> result -= nextNumber;
                case '*' -> result *= nextNumber;
                case '/' -> {
                    if (nextNumber == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= nextNumber;
                }
                default -> throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }

        return result;
    }
}