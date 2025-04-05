import java.util.*;

public class SearchByParallelStream {

        public static int count(List<String> data) {
                int count = (int) data.parallelStream()
                    .filter(line -> line.indexOf(',') >= 0 || line.indexOf('\n') >= 0 || 
                        line.indexOf('\r') >= 0 || line.indexOf('"') >= 0)
                    .count();
                return count;
        }
}
