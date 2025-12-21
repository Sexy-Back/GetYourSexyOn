import java.io.*;
import java.util.*;

/**
 * 누적합
 * 1. 소의 품질 점수 (A), 소의 번호 (Q) 입력
 * 2. 소의 번호 입력은 인덱스 주의할 것 (0-based)
 * 3. 기존 S값 구해서 sum에 저장
 * 4. 타겟 소가 포함된 S값 미리 sum에서 빼줌 (어차피 해당 값 필요 X)
 * 5. 타겟 소가 포함된 S값 다시 계산
 * 6. sum 출력
 */
public class BOJ_17128 {
    static int N, Q, sum;
    static int[] A, S, qNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        S = new int[N + 1];
        qNum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i ++) {
            qNum[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < N; i++) {
            S[i] = A[i] * A[(i + 1) % N] * A[(i + 2) % N] * A[(i + 3) % N];
            sum += S[i];
        }

        for (int i = 0; i < Q; i++) {
            int target = qNum[i];

            for (int j = 0; j < 4; j++) {
                int idx = (target - j + N) % N;
                sum -= S[idx];
            }
            A[target] *= -1;

            for (int j = 0; j < 4; j++) {
                int idx = (target - j + N) % N;
                S[idx] = A[idx] * A[(idx + 1) % N] * A[(idx + 2) % N] * A[(idx + 3) % N];
                sum += S[idx];
            }
            sb.append(sum).append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
