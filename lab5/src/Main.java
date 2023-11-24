import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path_in = args[0];
        String path_out = args[1];
        int delay = Integer.parseInt(args[2]);
        int fps = Integer.parseInt(args[3]);

        try {
            File newFile = new File(path_in);
            if (newFile.length() == 0) {
                throw new MicroException("file is empty");
            } else {
                MicroDVDDelay.delay(path_in, path_out, delay, fps);
            }

        } catch (MicroException e) {
            System.err.println("Error at line " + e.getErrorLine() + ": " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
    }
}