import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EchoServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = randomPort(1024, 65535);
        System.out.println(port);
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(-1);
        }

        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(new ConnectionHandler(clientSocket));
            }
        } catch (IOException e) {
            System.err.println("Error accepting connection: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }

    private static int randomPort(int minPort, int maxPort) {
        if (minPort < 0 || maxPort > 65535 || minPort > maxPort) {
            throw new IllegalArgumentException("Invalid port range");
        }
        int port;
        do {
            port = minPort + (int) (Math.random() * ((maxPort - minPort) + 1));
        } while (!isAvailable(port));

        return port;
    }

    private static boolean isAvailable(int port) {
        try (ServerSocket ignored = new ServerSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}