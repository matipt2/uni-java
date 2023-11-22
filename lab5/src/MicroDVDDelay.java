import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDVDDelay extends MicroException {
    private String in;
    private String out;
    private int delay;
    private int fps;
    public MicroDVDDelay() {
    }

    public static void delay(String in, String out, int delay, int fps) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(in));
            Pattern pattern = Pattern.compile("\\{(\\d+)}");

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                Matcher matcher = pattern.matcher(line);
                StringBuffer stringBuffer = new StringBuffer();

                while (matcher.find()) {
                    int number = Integer.parseInt(matcher.group(1));
                    number += (delay * fps) / 1000;
                    matcher.appendReplacement(stringBuffer, "{" + number + "}");
                }

                matcher.appendTail(stringBuffer);
                lines.set(i, stringBuffer.toString());
            }

            Files.write(Paths.get(out), lines);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }
}
