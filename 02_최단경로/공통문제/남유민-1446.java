import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    // 지름길 저장 클래스
    static class Road {
        int start;
        int end;
        int dist;

        Road(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<Road> roads = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int rs = Integer.parseInt(st.nextToken());
            int re = Integer.parseInt(st.nextToken());
            int rd = Integer.parseInt(st.nextToken());

            // 지름길 조건에 맞지 않는 경우 거름
            // rs < 0 || re > d: 유효 거리 벗어남
            // (re - rs) <= rd: 지름길 의미 X
            if (rs < 0 || re > d || (re - rs) <= rd) continue;

            roads.add(new Road(rs, re, rd));
        }

        // 2. 최단 경로
        int[] dp = new int[d+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 시작점 설정

        for (int i = 0; i <= d; i++) {

            // dp[0]은 거리 0으로 고정되어야 하므로
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 지름길 다시 업데이트
            }

            // 지름길 먼저 계산
            for (Road road : roads) {
                if (i == road.start) {
                    dp[road.end] = Math.min(dp[road.end], dp[i] + road.dist);
                }
            }
        }

        bw.write(dp[d] + "\n");
        bw.flush();
    }
}