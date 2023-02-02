package algorithm.GRAPH;
// 풀어야함
import algorithm.Application;
import java.util.*;
public class BOJ_1240_노드사이의거리 implements Application {
    static final int INF=Integer.MAX_VALUE;
    static Scanner sc= new Scanner(System.in);
    static int N,M;
    static List<ArrayList<int[]>> graph;
    static PriorityQueue<int[]> q;
    static int[] distance;
    static void myDijkstra(int start){

        q=new PriorityQueue<>();
        q.add(new int[]{0, start});
        distance[start]=0;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            if (distance[curr[1]] < curr[0]) {
                continue;
            }
            // 현재 노드와 연결된 다른 노드들을 확인
            for (int i = 0; i < graph.get(curr[1]).size(); i++) {
                int cost=curr[0]+graph.get(curr[1]).get(i)[0];
                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost<distance[graph.get(curr[1]).get(i)[0]]){
                    distance[graph.get(curr[1]).get(i)[0]]=cost;
                    q.add(new int[]{cost, distance[graph.get(curr[1]).get(i)[0]]});
                }
            }
        }
    }
    public static void main(String[] args) {
        N=sc.nextInt();
        M=sc.nextInt();
        // 그래프 초기화
        graph= new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N+1; i++) {
            int a=sc.nextInt(); int b=sc.nextInt(); int c= sc.nextInt();
            graph.get(a).add(new int[] {b,c});
            graph.get(b).add(new int[] {a,c}); // 무방향그래프이므로
        }
        //테케 출력
        for (int tc = 1; tc <= M; tc++) {
            // 최단거리테이블 초기화
            distance=new int[N+1];
            for(int idx:distance){
                distance[idx]=INF;
            }
            int start=sc.nextInt(); int end=sc.nextInt();
            myDijkstra(start);

            System.out.println(distance[end]);

        }
    }



}
