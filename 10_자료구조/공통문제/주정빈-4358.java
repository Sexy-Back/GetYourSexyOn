import java.io.*;
import java.util.*;

public class BOJ_4358 {
    static String tree;
    static int cnt;
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while ((tree = br.readLine()) != null) {
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            cnt++;
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            double percent = (map.get(key) * 100.0) / cnt;
            sb.append(key).append(" ").append(String.format("%.4f", percent)).append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
