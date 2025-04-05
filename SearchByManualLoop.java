import java.util.*;

public class SearchByManualLoop {

        static final char cpQuote = '\"';
        static final char cpComma = ',';
        static final char cpCr = '\r';
        static final char cpNl = '\n';

        public static int count(List<String> data) {
                int count = 0;
                for (String line : data) {
                        for (char c : line.toCharArray()) {
                                if (c == cpQuote || c == cpComma || c == cpCr || c == cpNl) {
                                        count++;
                                        break;
                                }
                        }
                }
                return count;
        }
}
