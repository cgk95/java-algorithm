package algorithm.GRAPH.DFS_BFS;

public class Programmers_타깃넘버 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        myDfs(numbers, target, 0, 0);
        return answer;
    }

    private void myDfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            myDfs(numbers, target, index + 1, sum + numbers[index]);
            myDfs(numbers, target, index + 1, sum - numbers[index]);
        }
    }

    public static void main(String[] args) {
        Programmers_타깃넘버 sol = new Programmers_타깃넘버();
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(sol.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
