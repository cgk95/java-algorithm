package algorithm.MATH;

public class Programmers_K진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String[] candidates = Integer.toString(n, k).split("0");
        for (String s : candidates) {
            if (!s.equals("") && isPrime(s)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(String num) {
        long target = Long.parseLong(num);
        if (target == 1) {
            return false;
        }
        long endPoint = (long) Math.sqrt(target)+1;
        for (int i = 2; i < endPoint; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Programmers_K진수에서소수개수구하기 sol = new Programmers_K진수에서소수개수구하기();
        System.out.println(sol.solution(437674,3));
        System.out.println(sol.solution(110011,10));



    }
}
