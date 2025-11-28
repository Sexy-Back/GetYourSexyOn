import java.io.*;
import java.math.BigInteger;

public class BOJ_10826 {
    static int n;
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n + 1];

        if (n == 0) {
            bw.write("0");
            bw.flush();
            return;
        }
        
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        sb.append(dp[n]);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
