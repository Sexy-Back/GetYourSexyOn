import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] makguli;
    static long max;
    static int k;

    public static void main(String[] args) throws IOException {
        init();
        execute();
    }

    private static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        makguli = new long[n];

        max = 0;

        for (int i = 0; i < n; i++) {
            makguli[i] = Long.parseLong(br.readLine());
            max = Math.max(max, makguli[i]);
        }
    }

    private static void execute() throws IOException {
        long low = 0;
        long high = max;
        long res = 0;
        while (low <= high) {
            long medium = (low+high)/2;
            long cups = countCups(medium);

            if (cups < k) {
                high = medium - 1;
            } else{
                low = medium + 1;
                res = Math.max(res, medium);
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long countCups(long std) {
        if (std == 0) return Long.MAX_VALUE;
        long cnt = 0;
        for (long l : makguli) {
            cnt += l/std;
        }
        return cnt;
    }
}
