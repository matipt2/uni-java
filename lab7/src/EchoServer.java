import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer{

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        int port = randomPort(1024,65535);
        System.out.println(port);
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port: " + port);
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + port);
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            while(true){
                clientSocket = serverSocket.accept();
                executorService.submit(new ConnectionHandler(clientSocket));
            }

        } catch (IOException e) {
            System.out.println("Accept failed: " + port);
            System.exit(-1);
        }
        finally {
            executorService.shutdown();
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
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

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

}

    private static int arithmeticExpression(String expression) throws DivisionByZeroException, Exception {
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
                        throw new DivisionByZeroException("division by zero cannot be allowed!");
                    }
                    result /= nextNumber;
                }
                default -> throw new Exception("Invalid operator: " + operator);
            }
        }

        return result;
    }

    public static int randomPort(int minPort, int maxPort) {
        if (minPort < 0 || maxPort > 65535 || minPort > maxPort) {
            throw new IllegalArgumentException("Invalid port range");
        }
        int port;
        do {
            port = minPort + (int)(Math.random() * ((maxPort - minPort) + 1));
        } while (!isAvailable(port));

        return port;
    }


    private static boolean isAvailable(int port){
            try(ServerSocket serverSocket = new ServerSocket(port)){
                return true;
            } catch(IOException e){
                return false;
            }
    }

}

