import java.io.*;

public class SearchByRegex {

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
                                if (line.matches("^[^\",\r\n]*[\",\r\n].*")) {
                                    count++;
                                }
                                line = br.readLine();
                        }
                }
                System.out.println("Search by Regex:");
                System.out.println("Counted " + count + " lines that would have needed to be quoted.");
        }

}
