package algorithm.TWO_POINTER;

public class Hackerrank_PalindromeIndex {
    public static int palindromeIndex(String s) {
        int len = s.length();
        int start = 0;
        int end = len - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        if (start >= end) {
            return -1;
        }
        int i = start;
        int j = end;
        start++;
        // TODO : 직감적으로 말고 논리적으로 확실히 이해하기
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return j;
            }
            start++;
            end--;
        }
        return i;
    }


    public static void main(String[] args) {
//        System.out.println(palindromeIndex("aaa"));
//        System.out.println(palindromeIndex("aba"));
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baaa"));
    }
}
