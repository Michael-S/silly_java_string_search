import java.util.*;

public class SearchByArray {
        public static int count(List<String> data) {
                int count = 0;

                // Lookup tables my beloved
                boolean[] match = new boolean[256];
                match[','] = true;
                match['\n'] = true;
                match['\r'] = true;
                match['\"'] = true;

                for (String line : data) {
                        for (char c : line.toCharArray()) {
                                if (c < 256 && match[c]) {
                                        count++;
                                        break;
                                }
                        }
                }
                return count;
        }
}
