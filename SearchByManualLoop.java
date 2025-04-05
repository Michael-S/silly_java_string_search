import java.util.*;

public class SearchByManualLoop {

        static final int cpQuote = "\"".codePointAt(0);
        static final int cpComma = ",".codePointAt(0);
        static final int cpCr = "\r".codePointAt(0);
        static final int cpNl = "\n".codePointAt(0);

        public static int count(List<String> data) {
                int count = 0;
                for (String line : data) {
                        for (int i = 0; i < line.length(); i++) {
                                int c = line.codePointAt(i);
                                if (c == cpQuote || c == cpComma || c == cpCr || c == cpNl) {
                                        count++;
                                        break;
                                }
                        }
                }
                return count;
        }
}
