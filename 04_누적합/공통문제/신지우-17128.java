import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] s = new int[n];
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            s[i] = arr[(i+3)%n] * arr[(i+2)%n] * arr[(i+1)%n] * arr[i];
            sum += s[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int target = Integer.parseInt(st.nextToken()) - 1;
            // target 소 포함된 ac 반전
            for (int j = 0; j < 4; j++) {
                int idx = (n + target - j) % n;
                sum -= s[idx];
                s[idx] *= -1;
                sum += s[idx];
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
