package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1254_펠린드롬만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            String adder = s.concat(sb.append(s, 0, i).reverse().toString());
            if (isPalindrome(adder)) {
                System.out.println(adder.length());
                break;
            }
        }
    }

    static private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
