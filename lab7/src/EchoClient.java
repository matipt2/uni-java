import java.io.*;
import java.net.*;

class EchoClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid arguments!");
        }

        int port = Integer.parseInt(args[0]);
        String mathematicalOperation = args[1];

        try (Socket echoSocket = new Socket("localhost", port);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()))) {

            out.println(mathematicalOperation);

            String resultFromServer = in.readLine();
            System.out.println(resultFromServer);

        } catch (IOException e) {
            System.err.println("Error in client: " + e.getMessage());
        }
    }
}