import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우 원리
        // [1 2 3] 4 5
        // 1 [2 3 4] 5
        // 1 2 [3 4 5]
        // : 하나 빼고 하나 추가

        // 첫 구간(k만큼 더하기)
        int sum = 0, max;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        max = sum;


        // i = x: 다음 더할 "인덱스"(arr[i])
        // arr[i-x]: 슬라이딩 했을 때 앞에 뺄 부분
        int cnt = 1;
        for (int i = x; i < n; i++) {
            sum = sum - arr[i-x] + arr[i];

            // 문제 조건1: max 값 개수 세기
            if (sum > max) {
                max = sum;
                cnt = 1; // max 값 갱신되면 cnt 초기화
            } else if (sum == max) {
                cnt++;
            }
        }

        if (max == 0) sb.append("SAD"); // 문제 조건2: max가 0일 경우
        else sb.append(max+"\n"+cnt);
        bw.write(sb.toString());
        bw.flush();
    }
}