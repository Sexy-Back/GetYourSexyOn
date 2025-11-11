import java.io.*;
import java.util.*;

/**
 * 1. 바구니의 끝 위치 < 사과가 떨어지는 위치 : 바구니 오른쪽으로 이동
 * 2. 바구니의 시작 위치 > 사과가 떨어지는 위치 : 바구니 왼쪽으로 이동
 */
public class BOJ_2828 {
    static int N, M, J, min;
    static int[] location;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());
        location = new int[J];

        for (int i = 0; i < J; i++) {
            location[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = M;

        for (int i = 0; i < J; i++) {
            int apple = location[i];
            if (apple > end) {
                int dist = apple - end;
                min += dist;
                start += dist;
                end += dist;
            } else if (apple < start) {
                int dist = start - apple;
                min += dist;
                start -= dist;
                end -= dist;
            }
        }
        sb.append(min);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
