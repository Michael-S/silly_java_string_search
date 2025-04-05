import java.util.*;

public class SearchByStream {

        public static int count(List<String> data) {
                int count = (int) data.stream() // or parallelStream()
                    .filter(line -> line.indexOf(',') >= 0 || line.indexOf('\n') >= 0 || 
                        line.indexOf('\r') >= 0 || line.indexOf('"') >= 0)
                    .count();
                return count;
        }
}
