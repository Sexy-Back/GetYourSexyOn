import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // bit: 난이도 0, 1 배열
        // ps: 누적합 배열
        int[] bit = new int[n+1];
        int[] ps = new int[n+1];

        //  pre_ac: 이전 악보
        //  ac: 현재 악보
        int pre_ac, ac;
        pre_ac = 0;
        for (int i = 1; i <= n; i++) {
            ac = Integer.parseInt(st.nextToken());

            //  현재 악보가 이전 악보보다 쉬운 경우 (= 지금 연주하는 악보가 바로 다음에 연주할 악보보다 어렵다)
            if (pre_ac > ac) bit[i] = 1;
            ps[i] = bit[i] + ps[i-1];

            // pre_ac 값 업데이트
            pre_ac = ac;
        }

        // 누적합 원리: ps[4] - ps[2] = (1+2+3+4) - (1+2)
        int q = Integer.parseInt(br.readLine());
        int res;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            res = ps[end] - ps[start];
            sb.append(res + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}