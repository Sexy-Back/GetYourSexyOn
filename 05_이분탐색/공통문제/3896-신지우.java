import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] isPrime;
    static ArrayList<Integer> prime;

    public static void main(String[] args) throws IOException {
        init();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            execute();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void init() throws IOException {
        int MAX = 1399710;
        isPrime = new boolean[MAX];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(MAX);i++) {
            if (isPrime[i]) {
                for(int j = i*i ; j < MAX; j+= i) isPrime[j] = false;
            }
        }

        prime = new ArrayList<>();
        for (int i = 0; i < isPrime.length; i++)
            if (isPrime[i]) prime.add(i);
    }

    private static void execute() throws IOException {
        int k = Integer.parseInt(br.readLine());

        int low = 0;
        int high = prime.size();
        int res = 0;
        while (low <= high) {
            int medium = (low+high)/2;
            if (prime.get(medium) > k) {
                high = medium - 1;
            } else {
                low = medium + 1;
                res = medium;
            }
         }

        int length = 0;
        if (k != prime.get(res)) {
            length = prime.get(res+1) - prime.get(res);
        }

        bw.write(length+"\n");
    }
}
