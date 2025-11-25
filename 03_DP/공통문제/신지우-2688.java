import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        long[][] dp = new long[1001][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][k] += dp[i-1][j];
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long res = 0;
            for (int j = 0; j < 10; j++) {
                res += dp[n][j];
            }
            bw.write(res+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
