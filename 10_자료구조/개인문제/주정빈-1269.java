import java.io.*;
import java.util.*;

public class BOJ_1269 {
    static int N, M, A, B;
    static HashSet<Integer> setA = new HashSet<>();
    static HashSet<Integer> setB = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A = Integer.parseInt(st.nextToken());
            setA.add(A);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B = Integer.parseInt(st.nextToken());
            setB.add(B);
        }

        HashSet<Integer> tmpA = new HashSet<>(setA);
        HashSet<Integer> tmpB = new HashSet<>(setB);

        tmpA.removeAll(setB);
        tmpB.removeAll(setA);

        int result = tmpA.size() + tmpB.size();

        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
