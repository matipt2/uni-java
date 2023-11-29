import java.io.*;

public class MicroDVDDelay {
    public static void delay(String input, String output, int delay, int fps) throws MicroException {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            String line;
            int counting = 0;

            while ((line = reader.readLine()) != null) {
                counting++;
                processLine(line, counting, delay, fps, writer);
            }

        } catch (IOException e) {
            throw new BufferException("Error in buffered stream", 7);
        }
    }

    private static void processLine(String line, int lineCount, int delay, int fps, BufferedWriter writer) throws MicroException {
        if (!line.matches("\\{\\d+\\}\\{\\d+\\}.*")) {
            throw new InvalidFrameException("Invalid frame sequence format", lineCount);
        }

        String[] frames = line.split("[{}]");
        if (frames.length < 5) {
            throw new NumberInFramesException("Missing braces in the sequence", lineCount);
        }

        try {
            int start = Integer.parseInt(frames[1]);
            int end = Integer.parseInt(frames[3]);

            frameValidation(start, end, lineCount);

            int startingResult = start + delay * fps / 1000;
            int endingResult = end + delay * fps / 1000;

            String newLine = "{" + startingResult + "}{" + endingResult + "}" + frames[4];
            writer.write(newLine);
            writer.newLine();

        } catch (NumberFormatException | IOException e) {
            throw new StringFrameException("Frame values must be numeric", lineCount);
        }
    }

    private static void frameValidation(int startFrame, int endFrame, int lineCount) throws MicroException {
        if (startFrame < 0 || endFrame < 0) {
            throw new NegativeFrameException("Negative frame values are not allowed", lineCount);
        }

        if (startFrame > endFrame) {
            throw new InvalidFrameOrderException("Start frame is greater than end frame", lineCount);
        }
    }
}