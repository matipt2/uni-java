import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDVDDelay {
    public static void delay(String in, String out, int delay, int fps) throws MicroException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(in));
            Pattern pattern = Pattern.compile("\\{(\\d+)}");

            for (int i = 0; i < lines.size() - 1; i++) {
                String line = lines.get(i);
                String nextLine = lines.get(i + 1);
                Matcher matcher = pattern.matcher(line);
                Matcher nextMatcher = pattern.matcher(nextLine);
                StringBuffer stringBuffer = new StringBuffer();

                while (matcher.find() && nextMatcher.find()) {
                    int currentNumber = Integer.parseInt(matcher.group(1));
                    int nextNumber = Integer.parseInt(nextMatcher.group(1));
                    if (currentNumber >= nextNumber) {
                        throw new MicroException("invalid sequence at line " + (i + 1), i + 1);
                    }
                    currentNumber += (delay * fps) / 1000;
                    matcher.appendReplacement(stringBuffer, "{" + currentNumber + "}");
                }

                matcher.appendTail(stringBuffer);
                lines.set(i, stringBuffer.toString());
            }

            String lastLine = lines.get(lines.size() - 1);
            Matcher lastMatcher = pattern.matcher(lastLine);
            StringBuffer lastStringBuffer = new StringBuffer();

            while (lastMatcher.find()) {
                int currentNumber = Integer.parseInt(lastMatcher.group(1));
                currentNumber += (delay * fps) / 1000;
                lastMatcher.appendReplacement(lastStringBuffer, "{" + currentNumber + "}");
            }

            lastMatcher.appendTail(lastStringBuffer);
            lines.set(lines.size() - 1, lastStringBuffer.toString());

            Files.write(Paths.get(out), lines);

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }
}