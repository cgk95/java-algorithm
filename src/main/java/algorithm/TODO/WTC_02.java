package algorithm.TODO;

public class WTC_02 {
    public static int solution(int width, int height, int[][] diagonals) {
        int[][] board = new int[height + 1][width + 1];
        board[0][0] = 1;
        for (int j = 0; j <= height; j++) {
            for (int i = 0; i <= width; i++) {
                if(i==0 && j!=0) board[j][i]=1;
                if(j==0 && i!=0) board[j][i]=1;
            }
        }
        for (int j = 1; j <= height; j++) {
            for (int i = 1; i <= width; i++) {
                int left = 0, down = 0;
                if (j >= 1) down = board[j - 1][i];
                if (i >= 1) left = board[j][i - 1];
                board[j][i] = (left+down) % 10000019 ;
            }
        }
        return board[height][width]*2;

    }


    // 해당 위치에 대각선이 있는지 확인하는 함수
    private static boolean isDiagonal(int[][] diagonals, int x, int y) {
        for (int[] diagonal : diagonals) {
            if (diagonal[0] == x && diagonal[1] == y) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WTC_02 wtc_02 = new WTC_02();
        System.out.println(wtc_02.solution(2, 2, new int[][]{{1, 1}, {2, 2}}));
        System.out.println(wtc_02.solution(51, 37, new int[][]{{17, 19}}));
    }
}

/*
 * 가로 한 칸, 세로 1칸의 크기를 갖는 정사각형으로 이루어진 가로 width 칸, 세로 height 칸의 격자가 있다. 일부 정사각형에는 "왼쪽 위의 점과 오른쪽 아래점을 잇는" 대각선이 있다.
 * 이 격자에서 다음 조건을 만족하는 경로의 개수를 구하고자 한다.
 * 1. 좌측 하단의 끝점에서 우측 상단의 끝점으로 가는 경로이다.
 * 2. 대각선을 정확히 1번 이용해야 한다.
 * 3. 1,2번 조건을 만족하는 전제 하에서 최단거리 경로여야 한다.
 * 격자의 가로길이 width, 세로 길이 height, 대각선이 위치한 정사각형의 정보 diagonals 가 매개변수로 주어진다. 주어진 조건을 모두 만족하는 경로의 개수를 10000019로 나눈 나머지를 반환하도록 solution 함수를 완성하라.
 * <제한사항>
 * 1 <= width <= 250
 * 1<= height <=250
 * 1<= diagonals.length <= width * height
 * diagonals 의 각 행은 {x,y} 로 이루어져 있으며 왼쪽에서부터 x 번째, 아래에서부터 y번째 사각형에 대각선이 있음을 의미한다.
 * 1 <= x <= width
 * 1 <= y <= height
 * 똑같은 {x,y} 순서쌍은 2번이상 등장하지 않는다.
 * 예를 들어, width =2, height =2, diagonals = {{1,1},{2,2}} 일 경우 solution의 반환값은 12 이다.
 * 예를 들어, width = 51, height = 37, diagonals = {{17,19}} 일 경우 solution의 반환값은 3225685 이다.
 * * */