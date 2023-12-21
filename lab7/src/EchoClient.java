import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException, IllegalArgumentException {

        if(args.length != 2){
            throw new IllegalArgumentException("invalid arguments!");
        }

        int port = Integer.parseInt(args[0]);
        String mathematicalOperation = args[1];


        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", port);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
        out.println(mathematicalOperation);

        String resultFromServer = in.readLine();
        System.out.println(resultFromServer);


        out.close();
        in.close();
        echoSocket.close();
    }
}