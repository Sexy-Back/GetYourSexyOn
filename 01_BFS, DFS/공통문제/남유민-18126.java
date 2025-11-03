import java.io.*;
import java.util.StringTokenizer;

class Main {

    static long[][] arr;
    static boolean[] visited;
    static long[] dist;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력 및 초기화
        n = Integer.parseInt(br.readLine());
        arr = new long[n+1][n+1];
        visited = new boolean[n+1];
        dist = new long[n+1];

        StringTokenizer st;
        int a, b;
        long c;
        for (int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            arr[a][b] = c;
            arr[b][a] = c;
        }

        // 2. dfs (무방향 그래프인 '트리' 탐색)
        dfs(1, 0l);

        long value = Long.MIN_VALUE;
        for (int i=1; i<=n; i++) {
            value = Math.max(value, dist[i]);
        }

        bw.write(value+"\n");
        bw.flush();
    }

    static void dfs(int start, long interval) {
        visited[start] = true;
        dist[start] = interval;

        // start: 1, next: 2~4,
        // start: 2, next: 3~4,
        // start: 3, next: 4
        for (int next = 1; next <= n; next++) {
            // !visited[next]: 역행 방지 > 알아서 깊이 탐색
            // arr[start][next]: 노드 연결
            if (!visited[next] && arr[start][next] > 0) {
                dfs(next, interval + arr[start][next]);
            }
        }
    }
}