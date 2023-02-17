package algorithm.HASH;

import algorithm.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ26008_해시해킹 implements Application {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] NMA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = Integer.parseInt(br.readLine()); // 0~M-1의 수 중 하나.
        long answer = 1L;
        for (int i = 0; i < NMA[0] - 1; i++) {
            answer = answer * NMA[1] % 1000000007L;
        }
        System.out.println(answer);
    }

}
