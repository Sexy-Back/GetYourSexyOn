import java.io.*;

public class BOJ_2417 {
    static long n, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Long.parseLong(br.readLine());
        binarySearch(n);

        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void binarySearch(long key) {
        long left = 0;
        long right = key;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (n <= (Math.pow(mid, 2))) {
                result = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
    }
}
