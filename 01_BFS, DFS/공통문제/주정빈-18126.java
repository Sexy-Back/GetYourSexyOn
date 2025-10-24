/**
 * 1. A번 방과 B번 방 사이를 C가 양방향으로 연결
 * 2. 현재 방과 인접한 방, 거리를 알아야 하므로 객체를 생성하여 graph에 넣어줌
 * 3. dfs 시작 노드 방문 처리
 * 4. 입구에서 최대한 먼 방에 아이스크림을 숨김 = result를 현재 거리와 비교 후, 매번 Max로 갱신
 * 5. 현재 방과 인접한 방이 존재할 때까지 dfs 재귀 반복 (= 현재 노드와 인접한 노드를 계속 비교)
 * 6. 다음으로 탐색할 방의 번호 + 현재까지의 누적 거리를 바탕으로 dfs 재귀
 */
public class BOJ_18126 {
    static int N, A, B, C;
    static long result;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node {
        int next;
        long dist;

        Node(int next, long dist) {
            this.next = next;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }
        dfs(1, 0);

        sb.append(result);
        
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int start, long dist) {
        visited[start] = true;
        result = Math.max(result, dist);

        for (Node nextNode : graph.get(start)) {
            if (!visited[nextNode.next]) {
                visited[nextNode.next] = true;
                dfs(nextNode.next, dist + nextNode.dist);
            }
        }
    }
}
