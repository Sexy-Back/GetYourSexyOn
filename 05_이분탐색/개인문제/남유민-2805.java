import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken()); // long 범위 주의

        long min = 0, max = 0;
        long[] trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long tree = Long.parseLong(st.nextToken());
            trees[i] = tree;
            max = Math.max(tree, max);
        }

        long result = 0;
        while (min <= max) {
            long mid = (max + min) / 2;

            long len = 0;
            for (int i = 0; i < n; i++) {
                // 나무가 톱 절단기 높이보다 높을 때 자르기
                if (trees[i] > mid) len += trees[i] - mid;
            }

            if (len >= m) {
                result = Math.max(result, mid); // 최대값 갱신
                min = mid + 1; // 더 높게 잘라야 하므로 min 증가시키기
            } else {
                max = mid -1; // 더 낮게 잘라야 하므로 max 감소시키기
            }
        }

        bw.write(result+" ");
        bw.flush();
    }
}