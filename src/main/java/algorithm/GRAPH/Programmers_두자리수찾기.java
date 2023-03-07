package algorithm.GRAPH;

import java.util.ArrayList;

public class Programmers_두자리수찾기 {
    ArrayList<Integer> permutations;
    public int solution(int[] A, int K) {
        permutations = new ArrayList<>();
        for (int j = 1; j < A.length; j++) {
            myDFS(A,0,A.length,2);
        }
        permutations.sort(Integer::compareTo);
//        System.out.println(permutations);
        return permutations.get(permutations.size()-K);
    }

    private void myDFS(int[] arr,int depth,int n,int k){
        if(depth==k){
            ArrayList<String> number=new ArrayList<>();
            for(int i=0;i<k;i++){
                number.add(String.valueOf(arr[i]));
            }
            int num= Integer.parseInt(String.join("", number));
            if(!permutations.contains(num)){
                permutations.add(num);
            }
            return;
        }
        for(int i=depth;i<n;i++){
            swap(arr,depth,i);
            myDFS(arr,depth+1,n,k);
            swap(arr, depth, i);
        }
    }
    private void swap(int[] arr,int index,int y){
        int temp=arr[index];
        arr[index]=arr[y];
        arr[y]=temp;
    }

    public static void main(String[] args) {
        Programmers_두자리수찾기 sol= new Programmers_두자리수찾기();
        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5}, 1));
    }
}
