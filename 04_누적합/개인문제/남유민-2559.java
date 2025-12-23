import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int e = n - k;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= e; i++) {
            int res = 0;
            for (int j = 0; j < k; j++) {
                res  += arr[i+j];
            }
            max = Math.max(max, res);
        }

        bw.write(max+" ");
        bw.flush();
    }
}