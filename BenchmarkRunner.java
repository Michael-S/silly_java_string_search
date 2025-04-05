import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class BenchmarkRunner {

    private static final int WARMUP_RUNS = 2;
    private static final int MEASURED_RUNS = 5;

    static List<String> load() throws IOException {
        ArrayList<String> lines = new ArrayList<String>(1000000);

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
                    lines.add(line);
                    line = br.readLine();
            }
        }

        return lines;
    }

    public static void main(String[] args) throws Exception {
        List<String> classNames = Arrays.asList(
            "SearchByContains",
            "SearchByManualLoop",
            "SearchByRegex"
        );
        
        List<String> data = load();

        for (String className : classNames) {
            System.out.println("Benchmarking " + className + "...");

            Class<?> clazz = Class.forName(className);
            Method mainMethod = clazz.getMethod("count", List.class);
            Integer count = 0;

            for (int i = 0; i < WARMUP_RUNS; i++) {
                count = (Integer) mainMethod.invoke(null, data);
            }

            long totalTime = 0;
            for (int i = 0; i < MEASURED_RUNS; i++) {
                long start = System.nanoTime();
                mainMethod.invoke(null, data);
                long end = System.nanoTime();
                totalTime += (end - start);
            }

            double avgMs = totalTime / MEASURED_RUNS / 1_000_000.0;
            System.out.printf("Average time: %.3f ms%nCount: %d%n", avgMs, count);
            System.out.println();
        }
    }
}
