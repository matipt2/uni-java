import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MicroDVDDelay {
    public static void delay(String in, String out, int delay, int fps) throws MicroException, IOException {
        Path inputFilePath = Paths.get(in);
        Path outputFilePath = Paths.get(out);

        int lineNumber = 0;
        try (BufferedReader reader = Files.newBufferedReader(inputFilePath, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(outputFilePath, StandardCharsets.UTF_8)) {

            Pattern pattern = Pattern.compile("\\{(\\d+)}");
            String line;
            lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                Matcher matcher = pattern.matcher(line);
                StringBuffer stringBuffer = new StringBuffer();

                while (matcher.find()) {
                    int currentNumber = Integer.parseInt(matcher.group(1));
                    currentNumber += (delay * fps) / 1000;
                    matcher.appendReplacement(stringBuffer, "{" + currentNumber + "}");
                }

                matcher.appendTail(stringBuffer);
                writer.write(stringBuffer.toString());
                writer.newLine();

                validateSequence(line, lineNumber);
            }

        } catch (IOException e) {
            throw new IOException("Error reading or writing files", e);
        }
    }

    private static void validateSequence(String line, int lineNumber) throws FrameException {
        Pattern sequencePattern = Pattern.compile("\\{(\\d+)}(\\{(\\d+)})?");
        Matcher sequenceMatcher = sequencePattern.matcher(line);

        while (sequenceMatcher.find()) {
            int startFrame = Integer.parseInt(sequenceMatcher.group(1));
            int endFrame = sequenceMatcher.group(3) != null ? Integer.parseInt(sequenceMatcher.group(3)) : startFrame;

            if (startFrame > endFrame) {
                throw new FrameOrderException("Start frame is greater than end frame", lineNumber);
            }

            if (!sequenceMatcher.group(1).matches("\\d+") ||
                    (sequenceMatcher.group(3) != null && !sequenceMatcher.group(3).matches("\\d+"))) {
                throw new FrameNumberException("Invalid frame number format", lineNumber);
            }
        }
    }
}