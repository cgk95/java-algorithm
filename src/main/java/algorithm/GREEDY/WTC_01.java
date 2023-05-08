package algorithm.GREEDY;

import java.util.Arrays;

public class WTC_01 {

    public static int solution(int[] boxes, int m, int k) {
        while (k > 0) {
            int w = m / 10000;
            int gain = Arrays.stream(boxes).filter(x -> x * w <= 100000).max().orElse(0);
            if (gain == 0) {
                break;
            }
            m += gain * w;
            k--;
        }
        return m;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1000,800,900},1000000,3));
    }
}
