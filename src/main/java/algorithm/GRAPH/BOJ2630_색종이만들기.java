package algorithm.GRAPH;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2630_색종이만들기 {
    static Scanner sc = new Scanner(System.in);
    static int[][] board;
    static int blue=0;
    static int white=0;
    public static void main(String[] args){
        int N=sc.nextInt(); // 2,4,6,8,16,32,64,128
        sc.nextLine();
        board=new int[N][];
        for (int i = 0; i < N; i++) {
            int[] line=Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[i]=line;
        }
        // 준비 끝, 연산
        divNConquer(0,0,N);
        System.out.printf("%d\n%d",white,blue);
    }
    private static void divNConquer(int x, int y, int n){
        int currColor=board[x][y];
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(board[i][j]!=currColor){ // 하나라도 서로 다르면
                    divNConquer(x,y,n/2);
                    divNConquer(x,y+n/2,n/2);
                    divNConquer(x+n/2,y,n/2);
                    divNConquer(x+n/2,y+n/2,n/2);
                    return;
                }
            }
        }
        // 영역이 다 같으면
        if (currColor == 1) {
            blue++;
        } else {
            white++;
        }
    }
}
