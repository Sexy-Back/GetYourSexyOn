import java.io.*;
import java.util.*;

/**
 * 1. w대의 트럭만 동시에 올라갈 수 있음 + 다리의 최대 하중 L보다 작거나 같아야 함
 * 2. 트럭, 다리 두 개의 Queue 필요 (트럭 = 대기열, 다리 = 실제 실행)
 * 3. 다리 위 트럭이 이동할 때 (= 다리의 queue가 비어있기 전까지)마다 time++
 * 4. 현재 다리 위 트럭의 무게에서 건너간 트럭의 무게를 빼줌
 * 5. 현재 다리 위 트럭의 무게 + 다음 트럭의 무게 <= 다리 최대 하중 L일 경우, 다음 트럭의 무게 + 현재 다리 위 트럭의 무게를 해주고 다리 위에 해당 트럭 추가
 * 6. 반대의 경우는 다리 위에 올라가면 안되므로 다리 큐에 0 추가
 */
public class BOJ_13335 {
    static int n, w, L, a;
    static Queue<Integer> truck = new LinkedList<>();
    static Queue<Integer> bridge = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int time = 0;
        int curWeight = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(st.nextToken());
            truck.add(a);
        }

        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++;
            curWeight -= bridge.poll();

            if (!truck.isEmpty()) {
                if (curWeight + truck.peek() <= L) {
                    int nextTruck = truck.poll();
                    curWeight += nextTruck;
                    bridge.add(nextTruck);
                } else {
                    bridge.add(0);
                }
            }
        }
        sb.append(time);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
