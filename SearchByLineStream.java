import java.util.*;

public class SearchByLineStream {

        static final char cpQuote = '\"';
        static final char cpComma = ',';
        static final char cpCr = '\r';
        static final char cpNl = '\n';

        public static int count(List<String> data) {
                int count = 0;
                for (String line : data) {
                        if (line.chars().anyMatch(c ->
                                c == cpQuote || c == cpComma ||
                                c == cpCr || c == cpNl)) {
                                count++;
                        }
                }
                return count;
        }
}
