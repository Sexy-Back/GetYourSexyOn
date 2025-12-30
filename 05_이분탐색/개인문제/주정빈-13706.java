import java.io.*;
import java.math.BigInteger;

public class BOJ_13706 {
    static BigInteger N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = new BigInteger(br.readLine());
        binarySearch(N);

        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void binarySearch(BigInteger key) {
        BigInteger left = BigInteger.ONE;
        BigInteger right = key;
        while (left.compareTo(right) <= 0) {
            BigInteger mid = left.add(right).divide(BigInteger.TWO);
            BigInteger midSq = mid.multiply(mid);
            if (midSq.compareTo(N) == 0) {
                result = mid;
                return;
            }
            else if (midSq.compareTo(N) < 0) left = mid.add(BigInteger.ONE);
            else right = mid.subtract(BigInteger.ONE);
        }
    }
}
