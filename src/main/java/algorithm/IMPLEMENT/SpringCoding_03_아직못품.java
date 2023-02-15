package algorithm.IMPLEMENT;

import java.util.Arrays;

public class SpringCoding_03_아직못품 { // 펠린드롬 게임
    public int[] solution(int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (Arrays.stream(queries[i]).sum() % 2 == 0) {
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        }
        return answer;
    }

}
