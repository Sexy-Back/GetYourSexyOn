import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 막걸리 병
        long k = Integer.parseInt(st.nextToken());  // 사람 수

        int min = 1, max = 0;       // min 용량 1, max 용량 0 부터 시작(문제 조건)
        int[] maks = new int[n];
        for (int i = 0; i < n; i++) {
            int mak = Integer.parseInt(br.readLine());
            maks[i] = mak;
            max = Math.max(mak, max);
        }

        int result = Integer.MIN_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2; // 나누기 0 및 오버플로우 방지
            // max = min + (max - min): min에서 (max - min)만큼 이동
            // 위 max를 mid = (min + max) / 2 에 대입

            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += maks[i]/mid;
            }

            if (cnt >= k) {
                result = Math.max(result, mid); // 최대값 갱신
                min = mid + 1;
            } else {
                max = mid -1;
            }
        }

        bw.write(result+" ");
        bw.flush();
    }
}