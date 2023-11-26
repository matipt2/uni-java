import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String path_in = args[0];
        String path_out = args[1];
        int delay = Integer.parseInt(args[2]);
        int fps = Integer.parseInt(args[3]);

        try {
            MicroDVDDelay.delay(path_in, path_out, delay, fps);
        } catch (FrameOrderException e) {
            System.err.println("FrameOrderException: Error at line " + e.getErrorLine() + ": " + e.getMessage());
        } catch (FrameNumberException e) {
            System.err.println("FrameNumberException: Error at line " + e.getErrorLine() + ": " + e.getMessage());
        } catch (FrameException e) {
            System.err.println("FrameException: Error at line " + e.getErrorLine() + ": " + e.getMessage());
        } catch (MicroException e) {
            System.err.println("MicroException: Error at line " + e.getErrorLine() + ": " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
    }
}

class MicroException extends Exception {
    private final int errorLine;

    public MicroException(String message, int errorLine) {
        super(message);
        this.errorLine = errorLine;
    }

    public int getErrorLine() {
        return errorLine;
    }
}

class FrameException extends MicroException {
    public FrameException(String message, int errorLine) {
        super(message, errorLine);
    }
}

class FrameOrderException extends FrameException {
    public FrameOrderException(String message, int errorLine) {
        super(message, errorLine);
    }
}

class FrameNumberException extends FrameException {
    public FrameNumberException(String message, int errorLine) {
        super(message, errorLine);
    }
}