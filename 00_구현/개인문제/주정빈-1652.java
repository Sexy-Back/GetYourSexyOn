import java.io.*;

public class BOJ_1652 {
    static int N, widthResult, lengthResult;
    static char[][] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        room = new char[N][N];

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = st.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            int widthCnt = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == 'X') {
                    if (widthCnt >= 2) {
                        widthResult++;
                    }
                    widthCnt = 0;
                } else {
                    widthCnt++;
                }
            }
            if (widthCnt >= 2) widthResult++;
        }

        for (int i = 0; i < N; i++) {
            int lengthCnt = 0;
            for (int j = 0; j < N; j++) {
                if (room[j][i] == 'X') {
                    if (lengthCnt >= 2) {
                        lengthResult++;
                    }
                    lengthCnt = 0;
                } else {
                    lengthCnt++;
                }
            }
            if (lengthCnt >= 2) lengthResult++;
        }

        sb.append(widthResult).append(" ").append(lengthResult);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
