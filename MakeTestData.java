
import java.io.*;
import java.util.*;

/**
 *  Generate a test data file for our benchmark.
 *  We just generate random noise for this.
 *  A representative data set of common CSV data would
 *  be better, if someone wants to put that together or
 *  link to one.
 */
public class MakeTestData {

    
    static final String CHARS_NEEDING_QUOTES = "\",\r\n";
    static final int needQuotesLen = CHARS_NEEDING_QUOTES.length(); // of course 4

    static final int NUM_WORDS = 1000000;

    public static void main(String [] args) throws Exception {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            try(FileWriter fw = new FileWriter("test_data.out")) {
                    for (int i = 0; i < NUM_WORDS; i++) {
                            sb.setLength(0);
                            sb.append("\"");
                            int randomEntryLength = 20 + random.nextInt(500);
                            for (int j = 0; j < randomEntryLength; j++) {
                                int randomCodePoint = random.nextInt(Character.MAX_CODE_POINT);
                                while (!Character.isDefined(randomCodePoint)) {
                                        randomCodePoint = random.nextInt(Character.MAX_CODE_POINT);
                                }
                                sb.appendCodePoint(randomCodePoint);
                                if (random.nextInt(1000) < 2) {
                                        int idx = random.nextInt(4);
                                        sb.append(CHARS_NEEDING_QUOTES.charAt(idx));
                                }
                            }
                            sb.append("\"\n");
                            fw.append(sb.toString());
                    }
            }  
    }
}
