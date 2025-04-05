import java.util.List;
import java.util.regex.*;

public class SearchByRegex {
        public static int count(List<String> data) {
                Pattern regex = Pattern.compile("[\",\\r\\n]");
                int count = 0;
                for (String line : data) {
                        Matcher matcher = regex.matcher(line);
                        if (matcher.find()) {
                                count++;
                        }
                }
                return count;
        }
}
