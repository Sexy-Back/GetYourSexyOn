import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int start = cur[0];  // start(= 시작 친구)
            int level = cur[1];   // 친구 레벨

            // start의 모든 친구 탐색
            for (int i = 1; i <= n; i++){
                if (map[start][i] == 1 // start와 친구인지
                        && !visited[i]  // 친구 아직 탐색 X (중복 방지)
                        && level < 2    // 나 - 친구, 친구 - 친구까지만
                ){
                    q.add(new int[]{i, level + 1});
                    visited[i] = true;  // 해당 친구 탐색 완료
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) { cnt++; }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}