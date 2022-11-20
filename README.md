# java-algorithm
## 알고리즘 코딩테스트 연습문제 -> 자바 풀이 저장소

---

## 입력 받기
### Scanner와 BurfferdReader

1) Scanner의 버퍼 크기는 1024 chars, BufferedReader는 8192 chars

2) BufferedReader는 문자열을 단순히 읽고 저장하지만 Scanner는 문자열을 구분해서 분석할 수 있다.

3) BufferedReader는 동기화가 지원되어 Thread-safe하고 Scanner는 지원되지 않는다. 따라서 BufferedReader는 멀티 스레드에서 안전하고 그렇지 않은 Scanner는 안전하지 않다.

4) BufferedReader는 즉시 IOException을 던지지만 Scanner는 숨긴다.

### Scanner
```java
public class Main{
    public static int[][] map = new int[200][200];
    public static int n, m;
    
	public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt(); // 개행 문자 전까지만 받아오므로
        sc.nextLine(); //버퍼 비우기
        
        for(int i = 0; i < n; i++){
        	String str = sc.nextLine();
            for(int j = 0; j < m; j++) {
            	map[i][j] = str.charAt(i) - '0';
            }
        }
    }
}
```

### BufferdReader

```java
public class Main{
    public static int[][] map = new int[200][200];
    public static int n, m;
    
	public static void main(String [] args) {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        //띄어쓰기가 있는 부분 읽기
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        //띄어쓰기 있는 부분 읽기
        for(int i = 0; i < n; i++) {
        	String input2 = br.readLine();
            for(int j = 0; j < m; j++) {
            	map[i][j] = input2.charAt(j) - '0';
            }
        }
    }
}
```

## ArrayList와 LinkedList
```java
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Main{
    public static void main(String[] args){
        Stack<Integer> stk=new Stack<>();
        stk.push();
    }
}


```

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Main{
    public static void main(String[] args){
        Queue<Integer> queue=new LinkedList<>();
        queue.add();
    }
}
```

## Set 콜렉션

```java
public class Set(){
    public static void main(String[] args){
        HashSet<Integer> hs = new HashSet<>();
        hs.add(5);
        hs.add(1);
        hs.add(3);
        hs.add(1);
        System.out.println("--hash set : 저장 순서를 유지하지 않고 중복을 제거한다. --");
        hs.forEach(e -> System.out.print(e + " "));
        System.out.println();

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(5);
        lhs.add(1);
        lhs.add(3);
        lhs.add(1);
        System.out.println("--linked hash set : 저장 순서를 유지하면서 중복을 제거한다. --");
        lhs.forEach(e -> System.out.print(e+ " "));
        System.out.println();

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5);
        ts.add(1);
        ts.add(3);
        hs.add(1);
        System.out.println("--tree set : hash set과 마찬가지로 저장 순서를 유지하지 않고 중복을 제거한다. --");
        ts.forEach(e -> System.out.print(e + " "));
    }
}
```

## Map 컬렉션

```java
import java.util.*;

public class 해시 {
    public static void main(String[] args) {
    	
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("사과", 1);
        hm.put("배", 5);
        hm.put("바나나", 2);
        hm.put("포도", 4);
        hm.put("포도", 7);
        
        hm.remove("사과"); //key값으로 제거
        
        System.out.println("---contains테스트---");
        System.out.println(hm.containsKey("배"));
        System.out.println(hm.containsValue(5));
        
        //출력1. stream
        System.out.println("--순회--");
        hm.forEach((key, value) -> {
        	System.out.println(key + " " + value);
        });
        
        //출력2. Iterator
        System.out.println("--Iterator--");
        Iterator<String> keys = hm.keySet().iterator();
        while(keys.hasNext()) {
        	String key = keys.next();
            Integer value = hm.get(key);
            System.out.print(value + " ");
        }
        System.out.println();
        
        //출력3. EntrySet
        System.out.println("--EntrySet 출력--");
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
        	System.out.print(entry.getKey() + "-" + entry.getValue()+",");
        }
        System.out.println();
        
        //출력4. KeySet
        System.out.println("--KeySet 출력--");
        for(String key: hm.keySet()) {
        	System.out.println(key + "-" + hm.get(key) + ",");
        }
        System.out.println();
        
        System.out.println("---putIfAbsent 테스트---");
        System.out.println(hm.putIfAbsent("putIfAbsent", 11)); // 없으니 저장한 뒤 null 반환
        System.out.println(hm.putIfAbsent("putIfAbsent", 12)); // 이미 있다면 그냥 기존 값 반환. 인자로 받은 값으로 바꾸지는 않는다. -> 지금상태로 출력하면 그냥 기존 값 11나온다.
        System.out.println("--출력--");  
        hm.forEach((key, value) -> {
            System.out.println(key+" "+value);
        });
        
        System.out.println("---computeIfAbsent 테스트---");
        System.out.println(hm.computeIfAbsent("computeIfAbsent", String::length)); // 없으니 저장한 뒤 null 반환
        System.out.println(hm.computeIfAbsent("computeIfAbsent", key -> key.length() * 2)); // 이미 있다면 그냥 기존 값 반환. 인자로 받은 값으로 바꾸지는 않는다. -> 지금상태로 출력하면 그냥 기존 값 10나온다.
        System.out.println("--출력--");  
        hm.forEach((key, value) -> {
            System.out.println(key+" "+value);
        });
    }
}
```

## 정렬

```java
import java.util.*;
import java.util.stream.*;

public class Sort {

    public static void ArrayListSort() {

        System.out.println("----ArrayList를 정렬하기----");

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("C", "A", "B", "a"));
        System.out.println("원본: "+ list);

        //오름차순
        Collections.sort(list);
        System.out.println("오름차순: "+ list);

        //내림차순
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("내림차순: "+list);

        //대소문자 구분 없이 오름차순
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("대소문자 구분 없이 오름차순: "+list);

        Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        System.out.println("대소문자 구분 없이 내림차순: "+list);

        /*
        원본: [C, A, B, a]
        오름차순: [A, B, C, a]
        내림차순: [a, C, B, A]
        대소문자 구분 없이 오름차순: [a, A, B, C]
        대소문자 구분 없이 내림차순: [C, B, a, A]
        **/
    }

    public static void ArraySort(){

        System.out.println("----일반 배열을 정렬하기----");

        String [] arr = {"banana", "orange", "apple", "peer"};

        //오름차순
        Arrays.sort(arr);
        System.out.print("오름차순 : ");
        for(String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        //내림차순
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.print("내림차순 : ");
        for(String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        //일부분만 정렬
        Arrays.sort(arr, 0, 2);
        //Arrays.sort(arr, 0, 2, Collections.reverseOrder());
        System.out.print("0-2만 정렬 : ");
        for(String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static class Player implements Comparable<Player> {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Player o) {
//            return o.score - score; //넘어온 인자값이 더 크다! 큰 것부터 정렬
            return score - o.score; // 넘어온 인자값이 더 작다! 작은 정수부터 정렬
        }
    }

    public static void ObjectSortInt() {

        System.out.println("----원하는 대로 객체 정렬하기----");

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("alice", 899));
        players.add(new Player("bob", 982));
        players.add(new Player("chloe", 1090));
        players.add(new Player("dale", 982));
        players.add(new Player("eric", 1018));

        /**
         * 첫 방법은 Player 클래스를 implements Comparable<Player>
         */
        System.out.println("--- 1. Comparable 결과---");
        Collections.sort(players); //정렬 기준 없이 호출하면 compile error
        for(Player p : players){
            System.out.print(p.name+"-"+p.score+" ");
        }
        System.out.println();


        /**
         * 둘째 방법은 Comparator 인터페이스
         */
        Comparator<Player> comparator = new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                return b.score - a.score; //뒤에거가 더 크게!
//                return a.score - b.score;
            }
        };
        System.out.println("--- 2. Comparator 결과---");
        Collections.sort(players, comparator); //정렬 기준 없이 호출하면 compile error
        for(Player p : players){
            System.out.print(p.name+"-"+p.score+" ");
        }
        System.out.println();

        /**
         * 셋째 방법은 comparator 람다 사용 (1)
         */
        Comparator<Player> comparatorLambda = (a, b) -> {
            return b.score - a.score; //뒤에거가 더 크게!
        };

        System.out.println("--- 3. Comparator 람다 (1) 결과---");
        Collections.sort(players, comparator); //정렬 기준 없이 호출하면 compile error
        for(Player p : players){
            System.out.print(p.name+"-"+p.score+" ");
        }
        System.out.println();
        Collections.sort(players, (a,b) -> b.score - a.score);

        /**
         * 기존 객체는 그대로 두고 정렬한 값을 새 객체에 할당 할 때
         * */
        List<Player> players1 = players.stream().sorted((a,b) -> b.score - a.score).collect(Collectors.toList());
    }

    public static void ObjectSortString() {

        System.out.println("----원하는 대로 객체 정렬하기 String 정렬 ----");

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("alice", 899));
        players.add(new Player("bob", 982));
        players.add(new Player("chloe", 1090));
        players.add(new Player("dale", 982));
        players.add(new Player("eric", 1018));

        Collections.sort(players, new Comparator<Player>() {
           @Override
           public int compare(Player a, Player b) {
                return a.name.compareTo(b.name);
           }
        });
        for(Player p : players){
            System.out.print(p.name+"-"+p.score+" ");
        }

        System.out.println();
        System.out.println("----원하는 대로 객체 정렬하기 String 정렬 역순으로----");
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                return b.name.compareTo(a.name);
            }
        });
        for(Player p : players){
            System.out.print(p.name+"-"+p.score+" ");
        }
    }

    public static void main(String [] args){
        ArrayListSort();
        ArraySort();
        ObjectSortInt();
        ObjectSortString();
    }
}
```

## 그래프 탐색

### BFS
```java
import java.util.*;

/**
 * 꼭 기억하기!!!!
 * 큐에 넣을 때부터 미리 방문처리를 해야 해!!!!
 * 큐에서 꺼낼 때에 방문처리를 해버리면 계속 중복해서 또 들어갈 수 있음.
 * 큐에 들어가는 순간 방문처리로 해야 해.
 */
public class Bfs {

    public static boolean[] visit = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visit[y]) {
                    q.offer(y);
                    visit[y] = true;
                }
            }
        }
    }
}
```

### DFS

```java
import java.util.*;

public class Dfs {

    public static boolean[] visit = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int x) {
        visit[x] = true;
        System.out.println(x + " ");
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visit[y]) dfs(y);
        }
    }
}
```

## 