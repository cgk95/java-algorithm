package algorithm.IMPLEMENT;

public class Programmers_구슬을나누는경우의수 {
    public int myCombination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        return myCombination(n - 1, r) + myCombination(n - 1, r - 1);
    }
    public int solution(int balls, int share) {
        return myCombination(balls, share);
    }
}
