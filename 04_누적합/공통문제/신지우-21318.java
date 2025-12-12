import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] difficulties;
    static int[] ac;
    public static void main(String[] args) throws IOException {
        initialize();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bw.write((ac[y] - ac[x]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void initialize() throws IOException{
        int n = Integer.parseInt(br.readLine());
        difficulties = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        difficulties[0] = 0;
        for (int i= 1 ; i <= n; i++) {
            difficulties[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        ac = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (difficulties[i-1] > difficulties[i]) ac[i] = ac[i-1] + 1;
            else ac[i] = ac[i-1];
        }
    }
}
