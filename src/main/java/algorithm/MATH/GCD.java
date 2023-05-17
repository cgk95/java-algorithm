package algorithm.MATH;

public class GCD {
    public int myGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return myGCD(b, a % b);
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.myGCD(12, 8));
        System.out.println(gcd.myGCD(8, 12));
    }
}
