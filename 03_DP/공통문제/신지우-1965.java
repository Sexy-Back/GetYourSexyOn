import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 앞 상자가 뒷 상자보다 작으면 넣을 수 있다
        // 1 5 2 3 7이 있을 때
        // 1 - 5 - 7
        // 1 - 2 - 3 - 7

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (answer.isEmpty() || answer.get(answer.size() - 1) < arr[i]) {
                answer.add(arr[i]);
            }
            else {
                //answer에서 이분탐색으로 arr[i]보다 큰 것 중 가장 작은 것 찾아서 그걸로 교체
                int low = 0;
                int high = answer.size() - 1;
                int idx = answer.size();
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (answer.get(mid) < arr[i]) { // mid가 더 작으면
                        low = mid + 1;
                    }
                    else { //mid가 크거나 같으면
                        high = mid - 1;
                        idx = mid;
                    }
                }
                if (idx != answer.size()) answer.set(idx, arr[i]);
            }
        }

        bw.write(answer.size()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
