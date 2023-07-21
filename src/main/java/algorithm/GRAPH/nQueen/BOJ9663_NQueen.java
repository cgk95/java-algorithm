package algorithm.GRAPH.nQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// TODO :: 다시 풀어보기
public class BOJ9663_NQueen {
    static int N, answer;
    static int[] queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new int[N + 1];
        myDFS(1);
        System.out.println(answer);
    }

    private static void myDFS(int index) {
        if (index == N + 1) { // 모든 퀸을 배치하는데 성공하였다면
            answer++;
            return;
        }
        for (int j = 1; j < N + 1; j++) {
            queen[index] = j;
            if (index == 1 || checkQueen(index)) {
                myDFS(index + 1);
            }
        }
    }

    private static boolean checkQueen(int index) {
        for (int i = 1; i < index; i++) { // 모든 이전 행에 대하여
            if (queen[i] == queen[index] || index - i == Math.abs(queen[index] - queen[i])) { // 같은 행에 있거나 대각선에 위치하면
                return false;
            }
        }
        return true;
    }

}


//    static int N, answer;
//    static int[] queen; // 해당 행의 몇 번째 열에 queen이 존재할 것인지 기록하는 배열
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        queen = new int[N + 1];
//        myDFS(1);
//        System.out.println(answer);
//    }
//
//    public static void myDFS(int index) { // 현재 행을 인자로 넘김
//        if (index == N + 1) {
//            answer++;
//            return;
//        }
//
//        for (int j = 1; j < N + 1; j++) { // 열 마다
//            queen[index] = j;
//            if (index == 1 || checkQueen(index)) { // 첫 번 째 행이거나 queen이 존재할 수 있는 위치라면
//                myDFS(index + 1);
//            }
//        }
//    }
//
//    public static boolean checkQueen(int currRow) {
//        for (int i = 1; i < currRow; i++) {
//            if (queen[i] == queen[currRow] || currRow - i == Math.abs(queen[i] - queen[currRow])) { // 이전 행과 같은 열에 Queen이 있지 않은 지 || 이전 행의 대각선에 Queen이 있지 않은지 확인
//                return false;
//            }
//        }
//        return true;
//    }
