package algorithm.HASH;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        HashMap<String, String> password = new HashMap<>();
        for (int i = 0; i < input[0]; i++) {
            String[] idPw = br.readLine().split(" ");
            password.put(idPw[0], idPw[1]);
        }
        for (int i = 0; i < input[1]; i++) {
            bw.write(password.get(br.readLine()));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
