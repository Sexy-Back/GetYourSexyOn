import java.io.*;
import java.util.*;

public class BOJ_21318 {
    static int N, Q, result;
    static int[] level, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        level = new int[N + 1];
        prefix = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1];
            if (level[i] > level[i + 1]) {
                prefix[i]++;
            }
        }

        Q = Integer.parseInt(br.readLine());

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            result = prefix[y - 1] - prefix[x - 1];
            sb.append(result).append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
