import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs > 시간초과
class Main {
    static int n, m;
    static int[] magic;
    static ArrayList<int[]> interval = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        magic = new int[2];
        magic[0] = Integer.parseInt(st.nextToken());
        magic[1] = Integer.parseInt(st.nextToken());

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            interval.add(new int[]{start, end});
        }

        // 강아지 마법 시도 (bfs)
        int result = makePuppies();

        bw.write(result+"\n");
        bw.flush();
    }

    // bfs
    static int makePuppies() {
        // 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new int[]{0, 0}); // {현재 강아지 수, 이동 횟수}
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pup = cur[0];
            int cnt = cur[1];

            if (pup == n) return cnt; // 목표 도달

            // + 강아지
            for (int i = 0; i < 2; i++) {
                int update = pup + magic[i];

                if (update > n) continue;       // 범위 초과 > 다음 마법
                if (visited[update]) continue;  // 중복 탐색 방지

                // 구간 통과 여부 체크
                boolean isInterval = false;
                for (int[] inter : interval) {
                    if (update >= inter[0] && update <= inter[1]) {
                        isInterval = true;
                        break; // 다른 구간 살펴볼 필요 X
                    }
                }
                if (isInterval) continue; // 구간 걸림 > 다음 마법

                visited[update] = true;   // 현재 +강아지 계산 완료 > 최소 cnt 보장
                queue.add(new int[]{update, cnt + 1});
            }
        }

        return -1;
    }
}