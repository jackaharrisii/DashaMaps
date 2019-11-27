import java.io.*;

public class Reader {

    public static String readWordList() throws IOException {
        StringBuilder sb = new StringBuilder();

        File file = new File("/Users/jack/Dev/Labs/Week5/DashaMaps/word-list.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) sb.append(st + "\n");

        return sb.toString();
    }

}
