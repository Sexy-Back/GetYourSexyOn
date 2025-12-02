import java.io.*;
import java.util.*;

public class BOJ_14929 {
    static int n;
    static long result;
    static long[] x, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        x = new long[n + 1];
        prefix = new long[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + x[i];
        }

        for (int i = 1; i <= n; i++) {
            result += prefix[i - 1] * x[i];
        }
        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
