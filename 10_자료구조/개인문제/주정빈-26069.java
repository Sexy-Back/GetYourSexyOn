import java.io.*;
import java.util.*;

public class BOJ_26069 {
    static int N;
    static String A, B;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        set.add("ChongChong");

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();

            if (set.contains(A) || set.contains(B)) {
                set.add(A);
                set.add(B);
            }
        }
        sb.append(set.size());

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
