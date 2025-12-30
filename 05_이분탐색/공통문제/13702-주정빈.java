import java.io.*;
import java.util.*;

public class BOJ_13702 {
    static int N, K;
    static long max, result;
    static int[] alcohol;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alcohol = new int[N];

        for (int i = 0; i < N; i++) {
            alcohol[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, alcohol[i]);
        }

        binarySearch();
        sb.append(result);

        br.close();
        bw.write(sb.toString());;
        bw.flush();
        bw.close();
    }

    private static void binarySearch() {
        long left = 1;
        long right = max;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += alcohol[i] / mid;
            }

            if (cnt >= K) {
                result = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
    }
}
