import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 입력
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] cows = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        long[] sub = new long[n+1];
        long s = 0;

        for (int i = 1; i <= n; i++) {
            long b = 1;
            for (int j = 0; j < 4; j++) {
                // index 0 based:
                // int index = (i + j) % n;
                int index = (i + j - 1) % n + 1;
                b *= cows[index];
            }
            sub[i] = b;
            s += b;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int trick = Integer.parseInt(st.nextToken());
            cows[trick] = -cows[trick];

            for (int k = 0; k < 4; k++) {
                // index 0 based:
                // int idx = (trick - k + n) % n;
                int idx = (trick - k -1 + n) % n +1;

                long old = sub[idx];
                long now = 1;
                for (int j = 0; j < 4; j++) {
                    now *= cows[(idx + j -1) % n +1];
                }
                sub[idx] = now;
                s += now - old;
            }

            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}