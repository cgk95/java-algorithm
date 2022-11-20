package algorithm.domain;

import java.util.Scanner;
public class BOJ_9663 {
    public static int[] arr;
    public static int N;
    public static int count=0;
    public BOJ_9663(){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        arr=new int[N];
        myNqueen(0);
        System.out.println(count);
    }
    public static void myNqueen(int depth){
        if(depth==N){
            count++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(isValid(depth)){
                myNqueen(depth+1);
            }
        }
    }
    public static boolean isValid(int column){
        for(int j=0;j<column;j++){
            if (arr[column] == arr[j]) {
                return false;
            } else if (Math.abs(column-j)==Math.abs(column-arr[j])) {
                return false;
            }
        }
        return true;
    }
}
