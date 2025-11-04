import java.io.*;
import java.util.*;

// 두번 다신 보기 싫은 문제 ㅗ
class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, t;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;
        int sx = -1, sy = -1, tTime = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        // 탐색 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], time = cur[2];

            // 종료 조건: 공주 좌표 > 종료 시간 기록
            if (x == n-1 && y == m-1) {
                result = Math.min(result, time);
            }

            // 검 발견 > 해당 좌표 + 시간 기록
            if (map[x][y] == 2) {
                sx = x;
                sy = y;
                tTime = time;
            }

            // 일반 시간 계산
            for (int i = 0; i < 4; i++) {
                int cx = cur[0] + dx[i];
                int cy = cur[1] + dy[i];
                if (0 <= cx && cx < n && 0 <= cy && cy < m
                        && !visited[cx][cy]
                        && map[cx][cy] != 1) {
                    q.add(new int[]{cx, cy, time + 1});
                    visited[cx][cy] = true;
                }
            }
        }

        // 검 존재 >  최종 거리 계산
        int sTime = Integer.MAX_VALUE;
        if (tTime != 0) {
            sTime = tTime + (n-1-sx) + (m-1-sy);
            result = Math.min(result, sTime);
        }


        if (result > t || result == Integer.MAX_VALUE) bw.write("Fail");
        else bw.write(result + "\n");

        bw.flush();
    }
}