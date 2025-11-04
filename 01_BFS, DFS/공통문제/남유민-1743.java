import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로의 길이 = row
        int m = Integer.parseInt(st.nextToken()); // 가로의 길이 = col
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // row = x
            int y = Integer.parseInt(st.nextToken()); // col = y
            map[x][y] = 1;
        }

        // bfs
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // 쓰레기 있는 곳부터 cnt
                if (!visited[i][j] && map[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});  // 해당 좌표 큐에 넣고
                    visited[i][j] = true;   // 방문 처리
                    int trash = 1; // 해당 좌표 쓰레기 cnt 시작

                    // 이웃 좌표 확인
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int cx = curr[0], cy = curr[1];

                        for (int l = 0; l < 4; l++) {
                            int ux = cx + dx[l]; // update
                            int uy = cy + dy[l];
                            if (1 <= ux && ux <= n && 1 <= uy && uy <= m // 1. 좌표 범위 안
                                    && !visited[ux][uy]                  // 2. 방문하지 않은 좌표
                                    && map[ux][uy] == 1                  // 3. 쓰레기가 있는 좌표
                            ) {
                                q.add(new int[]{ux,uy});
                                visited[ux][uy] = true;
                                trash++;
                            }
                        }
                    }

                    max = Math.max(max, trash);
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
    }
}