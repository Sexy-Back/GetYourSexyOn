import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (true) {
            String s = br.readLine();
            if (s == null) break;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int total = 0;
        List<String> list = new ArrayList<String>();
        for (String key : map.keySet()) {
            total += map.get(key);
            list.add(key);
        }

        Collections.sort(list);

        for (String key : list) {
            bw.write(String.format("%s %.4f\n", key, ((float)map.get(key))/total*100));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
