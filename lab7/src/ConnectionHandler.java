import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionHandler implements Runnable {
    private final Socket clientSocket;

    public ConnectionHandler(Socket socket) {
        this.clientSocket = socket;
    }


    @Override
    public void run() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String inputLine;
        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(inputLine.contains("+") || inputLine.contains("-") || inputLine.contains("*") || inputLine.contains("/")){
                    int result = arithmeticExpression(inputLine);
                    out.println(result);
                }else{
                    String result = inputLine;
                    out.println(result);
                }

            } catch (Exception e) {
                out.println("error " + e.getMessage());
            }
        }
    }
    private static int arithmeticExpression(String expression) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        int number = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                number = (number * 10) + (ch - '0');
            } else if ("+-*/".contains(String.valueOf(ch))) {
                numbers.add(number);
                number = 0;
                operators.add(ch);
            } else {
                throw new Exception("Invalid character: " + ch);
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
                        throw new Exception("Division by zero");
                    }
                    result /= nextNumber;
                }
                default -> throw new Exception("Invalid operator: " + operator);
            }
        }

        return result;
    }
}
