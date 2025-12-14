import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] honey = new int[n];
        long[] sum = new long[n];
        for (int i = 0; i < honey.length; i ++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = honey[0];
        for (int i = 1; i < honey.length; i++ ){
            sum[i] = honey[i] + sum[i-1];
        }

        //최대값 구하기
        //중간 벌통 : 무조건 벌 양 끝
        long max = Long.MIN_VALUE;
        for (int i = 1; i < sum.length-1; i++) {
            long res = (sum[i] - sum[0]) + (sum[sum.length-1] - sum[i-1] - honey[sum.length-1]);
            max = res > max ? res : max;
        }

        // 왼쪽 끝 벌통
        for (int i = 1; i < sum.length-1; i++) {
            long res = sum[i-1] + sum[sum.length-2] - honey[i];
            max = res > max ? res : max;
        }

        // 오른쪽 끝 벌통
        for (int i = 1; i < sum.length - 1; i++) {
            long res = (sum[sum.length-1] - sum[0] - honey[i]) + (sum[sum.length-1] - sum[i]);
            bw.write(String.format("%d %d %d %d %d ",sum[sum.length-1],sum[0],honey[i],sum[sum.length-1], sum[i]));
            max = res > max ? res : max;
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
