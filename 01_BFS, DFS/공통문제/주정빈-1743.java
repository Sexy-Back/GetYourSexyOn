import java.io.*;
import java.util.*;

public class BOJ_1743 {
    static int N, M, K, r, c, maxSize;
    static int[][] passage;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        passage = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            passage[r - 1][c - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && passage[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        sb.append(maxSize);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        int curSize = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || passage[nx][ny] == 0) continue;

                curSize++;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        maxSize = Math.max(maxSize, curSize);
    }
}
