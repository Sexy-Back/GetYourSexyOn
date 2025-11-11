import java.io.*;

public class B1283 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        boolean[] alphabet = new boolean['z' - 'a' + 1]; // a-z 단축키 사용 여부

        int[] loc = new int[n]; // 각 단어의 단축키 지정 알파벳 위치
        String[] words = new String[n];

        for (int i = 0 ; i < n ; i ++) {
            words[i] = br.readLine();
            loc[i] = -1;
            String[] tokens = words[i].split(" ");
            for (int j = 0; j < tokens.length; j++) {
                if (!alphabet[tokens[j].toLowerCase().charAt(0) - 'a']){
                    alphabet[tokens[j].toLowerCase().charAt(0) - 'a'] = true;
                    int length = 0;
                    for (int k = 0 ; k < j; k++) {
                        length += tokens[k].length()+1;
                    }
                    loc[i] = length;
                    break;
                }
            }
            if (loc[i] != -1) continue;
            for (int j = 0 ; j < words[i].length(); j++) {
                int cur = words[i].toLowerCase().charAt(j)-'a';
                if (cur < 0 || cur > 'z' -'a' + 1) continue;
                if (!alphabet[cur]){
                    alphabet[cur] = true;
                    loc[i] = j;
                    break;
                }
            }
        }

        // 출력
        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if(j==loc[i]) bw.write("["+word.charAt(j)+"]");
                else bw.write(word.charAt(j)+"");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
