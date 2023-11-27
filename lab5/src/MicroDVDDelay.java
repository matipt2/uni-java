import java.io.*;

public class MicroDVDDelay {
    public static void delay(String input, String output, int delay, int fps) throws MicroException {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                if (!line.matches("\\{\\d+\\}\\{\\d+\\}.*")) {
                    throw new FrameException("Invalid frame sequence format", lineCount);
                }

                String[] frames = line.split("[{}]");
                if (frames.length < 5) {
                    throw new FramesNumberException("Missing braces in the sequence", lineCount);
                }

                try {
                    int startFrame = Integer.parseInt(frames[1]);
                    int endFrame = Integer.parseInt(frames[3]);

                    if (startFrame < 0 || endFrame < 0) {
                        throw new FrameNegativeException("Negative frame values are not allowed", lineCount);
                    }

                    if (startFrame > endFrame) {
                        throw new FrameOrderException("Start frame is greater than end frame", lineCount);
                    }

                    int resultStartFrame = startFrame + delay * fps / 1000;
                    int resultEndFrame = endFrame + delay * fps / 1000;

                    String newLine = "{" + resultStartFrame + "}{" + resultEndFrame + "}" + frames[4];
                    writer.write(newLine);
                    writer.newLine();

                } catch (NumberFormatException e) {
                    throw new FrameStringException("Frame values must be numeric", lineCount);
                }
            }

        } catch (IOException e) {
            throw new BufferedStreamException("Error in buffered stream", 7);
        }
    }
}
