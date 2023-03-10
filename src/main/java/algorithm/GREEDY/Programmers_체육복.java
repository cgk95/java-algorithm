package algorithm.GREEDY;

public class Programmers_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] dontHave = new boolean[n + 2]; // 체육복이 없는 학생을 표시할 배열, 앞뒤로 한칸씩은 padding
        for (int num : lost) {
            for (int i = 1; i < dontHave.length; i++) {
                if (num == i) {
                    dontHave[num] = true;
                    break;
                }
            }
        }
        boolean[] have = new boolean[n + 2]; // 여분의 체육복이 있는 학생을 표시할 배열
        for (int num : reserve) {
            for (int i = 1; i < have.length; i++) {
                if (num == i) {
                    if (!dontHave[i]) { // 여분을 도둑맞지 않은 경우만
                        have[i] = true; // 빌려줄 수 있으면 참
                        break;
                    } else {   // 여분을 도둑맞았다면
                        have[i] = false;
                        dontHave[i] = false;
                        break;
                    }
                }
            }
        }
        // 체육복 빌려주기
        for (int i = 1; i < dontHave.length; i++) {
            if (dontHave[i]) { // 체육복을 빌려야 하는데
                for (int j = -1; j <= 1; j++) {
                    if (have[i + j]) {
                        have[i + j] = false;
                        dontHave[i] = false; // 상태 갱신
                        break;
                    }
                }
            }
        }
        // 운동복을 가진 학생 수 세기
        int answer = 0;
        for (int i = 1; i < dontHave.length - 1; i++) {
            if (!dontHave[i]) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_체육복 sol = new Programmers_체육복();
        System.out.println(sol.solution(2, new int[]{2}, new int[]{2}));
    }
}
