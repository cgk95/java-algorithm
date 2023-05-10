package algorithm.DFS_BFS;

public class Programmers_예상대진표 {
    int round;

    public int solution(int n, int a, int b) {
        round = Integer.toBinaryString(n).length() - 1;
        int start = 0, end = n;
        myDFS(start, end, a, b);
        return round;
    }

    private void myDFS(int start, int end, int a, int b) {
        int mid = (start + end) / 2;
        if (start < a && a <= mid && start < b && b <= mid) { // 왼쪽 브라켓에 모여있으면
            round--;
            myDFS(start, mid, a, b);
        } else if (mid < a && a <= end && mid < b && b <= end) { // 오른쪽 브라켓에 모여있으면
            round--;
            myDFS(mid, end, a, b);
        }
    }

    public static void main(String[] args) {
        Programmers_예상대진표 sol = new Programmers_예상대진표();
        System.out.println(sol.solution(8, 7, 8)); // 3
    }
}
