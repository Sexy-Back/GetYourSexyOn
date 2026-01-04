import java.io.*;
import java.util.*;

/**
 * 이분탐색
 * 1. 새롭게 배열에 저장된 값 vs 현재 최대 나무 높이 값 비교 후, 최댓값 갱신하여 경계로 사용
 * 2. sum의 경우, int의 범위를 넘어갈 수 있으므로 long 타입으로 선언
 * 3. 만약 현재 나무의 높이가 잘라야 하는 값 (=mid)보다 클 경우, sum에 현재 나무 높이 - 잘라야 하는 값을 더해줌
 * 4. sum이 M보다 크거나 같을 경우, mid값을 result에 저장 후 최댓값을 찾기 위해 left를 mid + 1로 이동
 * 5. 이외의 경우는 나무가 부족하므로 right = mid - 1
 */
public class BOJ_2805 {
    static int N, M, max, result;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        binarySearch();

        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void binarySearch() {
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) sum += trees[i] - mid;
            }
            if (sum >= M) {
                result = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
    }
}
