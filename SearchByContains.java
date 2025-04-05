import java.util.*;

public class SearchByContains {
        public static int count(List<String> data) {
                int count = 0;
                for (String line : data) {
                        if (line.contains("\"") || line.contains(",") || line.contains("\r") ||
                                        line.contains("\n")) {
                                count++;
                        }
                }
                return count;
        }
}
