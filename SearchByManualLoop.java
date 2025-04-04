import java.io.*;
import java.util.*;

public class SearchByManualLoop {

        static final int cpQuote = "\"".codePointAt(0);
        static final int cpComma = ",".codePointAt(0);
        static final int cpCr = "\r".codePointAt(0);
        static final int cpNl = "\n".codePointAt(0);

        public static void main(String [] args) throws Exception {
                int count = 0;
                try (BufferedReader br = new BufferedReader(new FileReader("test_data.out"))) {
                        String line = br.readLine();
                        while (line != null) {
                                while (!line.endsWith("\"")) {
                                        String nextLine = br.readLine();
                                        if (nextLine == null) {
                                                break;
                                        }
                                        line = line + nextLine;
                                }
                                if (line.startsWith("\"")) {
                                        line = line.substring(1);
                                }
                                if (line.endsWith("\"")) {
                                        line = line.substring(0, line.length() - 1);
                                }
                                for (int i = 0; i < line.length(); i++) {
                                        int c = line.codePointAt(i);
                                        if (c == cpQuote || c == cpComma || c == cpCr || c == cpNl) {
                                                count++;
                                                break;
                                        }
                                }
                                line = br.readLine();
                        }
                }
                System.out.println("Search By Manual Loop:");
                System.out.println("Counted " + count + " lines that would have needed to be quoted.");
        }

}
