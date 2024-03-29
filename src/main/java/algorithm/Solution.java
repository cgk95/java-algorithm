package algorithm;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class Solution {

    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 1;
        for (int i = 0; i < capacity.length; i++) {
            int k = capacity[i];
            answer *= combination(N, k);
            N -= k;
        }

        while (M > 0) {
            answer *= K;
            K--;
        }
        return answer;
    }

    private int combination(int n, int k) {
        if (n < k) {
            return 0;
        }
        if (n == k) {
            return 1;
        }
        int x = 1;
        int y = 1;
        for (int i = n; i >= n - k + 1; i--) {
            x *= i;
        }
        for (int i = k; i >= 1; i--) {
            y *= i;
        }

        return x / y;
    }

    public int solution(int n, int i, int j) {
        return divideNConquer(n, i, j);
    }

    public int divideNConquer(int n, int i, int j) { // 단위 조각이 아니라면 쪼개서 재귀
        if (n == 0) {
            return 0;
        }
        int half = 1 << (n - 1);
        int k = 0;
        if (i >= half) {
            k += 2;
            i -= half;
        }
        if (j >= half) {
            k += 1;
            j -= half;
        }
        int subResult = divideNConquer(n - 1, i, j);
        int addValue = (int) Math.pow(4, n - 1) * k;
        return subResult + addValue;
    }


    public int n보다작은소수찾기(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            int j = 2;
            while (i * j < n) {
                isPrime[i * j] = true;
                j++;
            }
        }
        int answer = 0;
        for (int b = 2; b < isPrime.length; b++) {
            if (!isPrime[b]) {
                System.out.printf("%d\t", b);
                answer++;
            }
        }
        return answer;
    }

    public int[] 지폐그리디(int[] arr) {
        if (arr.length == 0) {
            return new int[]{};
        }
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> changes = new ArrayList<>();

        int lastIdxOfBill = -1;
        for (int i = 0; i < arr.length; i++) {
            array.add(arr[i]);
            if (arr[i] / 10 >= 100) {
                lastIdxOfBill = i;
            }
        }

        if (lastIdxOfBill != -1) { // 지폐가 들어왔을 때만
            changes.add(array.remove(lastIdxOfBill)); // 지폐 반환
        }
        int sum = 0;
        for (int d : array) {
            sum += d;
        }

        keepYourChange(changes, sum);

        int[] answer = new int[changes.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = changes.get(i);
        }
        return answer;
    }

    private static void keepYourChange(ArrayList<Integer> changes, int sum) {
        for (int i = 0; i < sum / 500; i++) {
            changes.add(500);
        }
        sum = sum % 500;
        for (int i = 0; i < sum / 100; i++) {
            changes.add(100);
        }
        sum = sum % 100;
        for (int i = 0; i < sum / 50; i++) {
            changes.add(50);
        }
        sum = sum % 50;
        for (int i = 0; i < sum / 10; i++) {
            changes.add(10);
        }

    }

    public int 양심적인훔치기(int[] A, int K) {
        Arrays.sort(A);
        int valueSum = 0;
        int count = 0;
        for (int value : A) {
            if (valueSum + value <= K) {
                valueSum += value;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public int 최소비용문열기(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j >= 1 && j < A[i].length - 1) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
                } else if (j == 0) {
                    A[i][j] += A[i - 1][j];
                } else if (j == A[i].length - 1) {
                    A[i][j] += A[i - 1][j - 1];
                }
            }
        }
        // 맨 마지막 결과 배열만 정렬해서
        Arrays.sort(A[A.length - 1]);
        return A[A.length - 1][0];
    }

    public int 삽입해서가장큰수만들기(int N, int K) {
        StringBuilder sb = new StringBuilder();
        if (N < 0) {
            sb.append(N * -1);
            if (K == 0) {
                sb.insert(1, K);
                return Integer.parseInt(sb.toString()) * -1;
            }
            // K가 자릿수보다 큰경우 뒤로 작으면 현재 자리에 삽입
            for (int i = 0; i < sb.length(); i++) {
                if (K <= Integer.parseInt(String.valueOf(sb.charAt(i)))) {
                    sb.insert(i, K);
                    return Integer.parseInt(sb.toString()) * -1;
                }
                sb.insert(sb.length() - 1, K);
                return Integer.parseInt(sb.toString()) * -1;
            }
        }
        // 양수인 경우
        sb.append(N);
        if (K == 0) {
            sb.append(K);
            return Integer.parseInt(sb.toString());
        }
        for (int i = 0; i < sb.length(); i++) {
            if (K > Integer.parseInt(String.valueOf(sb.charAt(i)))) {
                sb.insert(i, K);
                return Integer.parseInt(sb.toString());
            }
        }
        sb.insert(sb.length() - 1, K);
        return Integer.parseInt(sb.toString());
    }

    public int 문제가이상함(int n) {
        int answer = 0;
        for (int i = 0; i < n + 1; i++) {
            int sum = 0;
            for (int j = i; j < n + 1; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    System.out.printf("%d ~ %d\t", i, j);
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }

    public boolean 다리건너기(int[] bridge, int jumpSize) {
        boolean answer = true;
        int curr = 0;
        while (curr < bridge.length - 1) {
            boolean flag = false;
            for (int i = curr + jumpSize + 1; i > 0; i--) {
                if (bridge[i] == 1) {
                    curr = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer = false;
                break;
            }

        }
        return answer;
    }


    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{-1, 0, 1, 0};

    public int[][] 도시순회(int[][] city) {
        int[][] answer = new int[city.length][city.length];
        ArrayList<int[]> busStation = new ArrayList<>();
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (city[i][j] == 0) {
                    busStation.add(new int[]{i, j});
                }

            }
        }
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (city[i][j] == 1) {
                    answer[i][j] = calculateDistance(i, j, busStation);
                }

            }
        }
        return answer;
    }

    private int calculateDistance(int i, int j, ArrayList<int[]> busStation) {
        int answer = Integer.MAX_VALUE;
        for (int[] arr : busStation) {
            answer = Math.min(answer, Math.abs(i - arr[0])) + Math.abs(j - arr[1]);
        }
        return answer;
    }

    public int dl이거아님(int[] A) {
        int answer = 0;
        Arrays.sort(A);
        int[] even = IntStream.range(0, A.length / 2).map(i -> A[i]).boxed().sorted((o1, o2) -> o2 - o1).mapToInt(Integer::intValue).toArray();
        int[] odd = IntStream.range(A.length / 2, A.length).map(i -> A[i]).toArray();
        for (int i = 0; i < even.length; i++) {
            answer += -(i + 2) * even[i];
        }
        int j = 1;
        for (int i = 0; i < odd.length; i++, j++) {
            answer += (i + j) * odd[i];
        }
        return answer;
    }

    public String 앞뒤에붙이기(int[] arr, String prefix, String separator, String postfix) {
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(i).append(separator);
        }
        sb.append(arr[arr.length - 1]);
        sb.append(postfix);
        return sb.toString();
    }

    public int[] 같은숫자찾아서조인(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .filter(f -> arrContains(f, arr2))
                .sorted()
                .toArray();

    }

    private boolean arrContains(int n, int[] arr2) {
        for (int i : arr2) {
            if (n == i) {
                return true;
            }
        }
        return false;
    }

    public int 플러스1이벤트(int n, int price) {
        int[] answer = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i % 10 == 0) {
                answer[i] = i - i / 10 + 1;
                continue;
            }
            if (i % 10 < i / 10) {
                answer[i] = i / 10 * 10;
                continue;
            }
            answer[i] = n - n / 10;
        }
        return answer[n] * price;
    }

    public int kkk() {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("구입하고 싶은 개수: %d , 구입하면 되는 개수: %d\n", i, 플러스1이벤트(i, 1));
        }
        return 0;
    }

    public String 피아노치기(String s) {
        String[] str = s.split("");
        int hands = 2;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("1")) {
                if (i + 1 < str.length) {
                    if (i + 2 < str.length) {
                        str[i + 2] = "0";
                    }
                    str[i + 1] = "0";
                }
                str[i] = "0";
                hands--;
            }
            if (hands < 1) {
                break;
            }
        }
        for (String p : str) {
            if (p.equals("1")) {
                return "NO";
            }
        }
        return "YES";
    }

    public int n자리의펠린드롬수(int n) {
        int answer = 0;
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (isPalindrome(String.valueOf(i))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPalindrome(String arg) {
        int j = arg.length() - 1;
        for (int i = 0; i < arg.length() / 2; i++, j--) {
            if (arg.charAt(i) != arg.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public int 같은거있나보기(int[] arr) {
        int answer = arr.length / 2 + 1;
        arr = Arrays.stream(arr).boxed()
                .sorted((o1, o2) -> o2 - o1)
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = arr.length / 2 + 1; i < arr.length; i++) {
            if (arr[arr.length / 2] == arr[i]) {
                answer++;
            }
        }
        return answer;
    }

    public int recursiveSample(int n) {
        return divideNConquer(n);
    }

    private int divideNConquer(int n) {
        if (n == 1) {
            return 1;
        }
        return (divideNConquer(n - 1) * 2 + 1) % 1000000007;
    }

    public String sol최소힙검증(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            int index = i * 2;
            if (index <= arr.length && arr[index - 1] < arr[i - 1]) {
                return "NO";
            }
            if (index + 1 <= arr.length && arr[index] < arr[i - 1]) {
                return "NO";
            }
        }
        return "YES";
    }

    public double 문자열수식1(String S) {
        double answer = 0;
        String[] str = S.replaceAll("[+]", " + ")
                .replaceAll("-", " - ")
                .replaceAll("[*]", " * ")
                .replaceAll("/", " / ").split(" ");

        PriorityQueue<Operation> operation = new PriorityQueue<>();
        for (String s : str) {
            if (s.equals("*")) {
                operation.offer(new Operation(2, s, null));
            } else if (s.equals("/")) {
                operation.offer(new Operation(2, s, null));
            } else if (s.equals("+")) {
                operation.offer(new Operation(3, s, null));
            } else if (s.equals("-")) {
                operation.offer(new Operation(3, s, null));
            } else { // 숫자인 경우
                operation.offer(new Operation(1, null, s));
            }
        }

        return answer;
    }

    class Operation implements Comparable<Operation> {
        private int priority;
        private String operator;
        private String operand;

        public Operation(int priority, String operator, String operand) {
            this.priority = priority;
            this.operator = operator;
            this.operand = operand;
        }

        public int getPriority() {
            return priority;
        }

        public String getOperator() {
            return operator;
        }

        public String getOperand() {
            return operand;
        }

        @Override
        public int compareTo(Operation o) {
            return Integer.compare(this.priority, o.getPriority());
        }

    }

    public int 회전뽑기(int N, int K) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int pvt = K - 1;
        while (list.size() > 1) {
            list.remove(pvt);
            pvt = (pvt + K - 1) % list.size();
        }
        return list.get(0);
    }

    public int 뒤집어야하는비트갯수(int A, int B) {
        int XOR = A ^ B;
        int answer = 0;
        for (String s : Integer.toBinaryString(XOR).split("")) {
            if (s.equals("1")) {
                answer++;
            }
        }
        return answer;
    }

    public int[] 출석부2(int[] nums) {
        int[] book = new int[nums.length + 1];
        for (int n : nums) {
            if (n > book.length) {
                continue;
            }
            book[n]++;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < book.length; i++) {
            if (book[i] == 0) {
                arr.add(i);
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public int[] 출석부1(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                arr.add(i + 1);
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public String 많이포함된문자열정수(String s) {
        int[] count = new int[10];
        for (String k : s.split("")) {
            count[Integer.parseInt(k)]++;
        }

        int[] seq = IntStream.range(0, 10)
                .mapToObj(i -> new int[]{count[i], i})
                .sorted((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                }).mapToInt(o -> o[1]).toArray();

        String answer = "";
        for (int sq : seq) {
            answer += sq;
            answer += " ";
        }
        return answer.stripTrailing();
    }

    public int 구슬빼내기(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = -1;
        for (int n : arr) {
            map.computeIfPresent(n, (k, v) -> v + 1);
            map.putIfAbsent(n, 1);
        }
        if (!map.containsValue(1)) {
            answer = 0;
        } else {
            for (int k : map.keySet()) {
                if (map.get(k) == 1) {
                    answer = k;
                }
            }
        }
        return answer;
    }

    public int[] 헉(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            answer[x] = IntStream.rangeClosed(i + 1, j + 1)
                    .map(o -> array[o])
                    .sorted().toArray()[k - 1];
        }
        return answer;
    }

    public int 옹알이(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            boolean flag = true;
            String replaced = s.replace("aya", "-")
                    .replace("ye", "-")
                    .replace("woo", "-")
                    .replace("ma", "-");

            flag = checkAlphabetRemains(flag, replaced);
            if (flag) {
                answer++;
            }
        }
        return answer;
    }

    // 알파벳 소문자가 남아있으면 거짓을 반환, 없으면 참을 반환
    private static boolean checkAlphabetRemains(boolean flag, String replaced) {
        for (char c : replaced.toCharArray()) {
            if (97 <= c && c <= 122) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    public int[] 몰라(int num, int total) {
        int[] answer = {};
        for (int i = -total; i < total; i++) {
            int count = num - 1;
            int tmp = 0;
            while (count >= 0) {
                tmp += i + count;
                count--;
            }
            if (tmp == total) {
                answer = makeAnswer(i, num);
                break;
            }
        }
        return answer;
    }

    private int[] makeAnswer(int i, int num) {
        int[] answer = new int[num];
        for (int j = 0; j < num; j++) {
            answer[j] = i;
            i++;
        }
        return answer;
    }

    public int 문자열밀기(String A, String B) {
        int answer = 0;
        LinkedList<String> q = new LinkedList<>();
        for (String s : A.split("")) {
            q.offer(s);
        }
        int count = A.length();
        while (count > 0) {
            if (String.join("", q).equals(B)) {
                return A.length() - count;
            }
            q.offerFirst(q.pollLast());
            count--;
        }
        return -1;
    }

    public String 로그인성공(String[] id_pw, String[][] db) {
        HashMap<String, String> DB = new HashMap<>();
        for (String[] str : db) {
            DB.put(str[0], str[1]);
        }
        if (!DB.containsKey(id_pw[0])) {
            return "fail";
        }
        if (!DB.get(id_pw[0]).equals(id_pw[1])) {
            return "wrong pw";
        }
        return "login";
    }

    public int 치킨쿠폰(int chicken) {
        int answer = 0;
        while (chicken >= 10) {
            answer += chicken / 10;
            chicken = chicken / 10 + chicken % 10;
        }
        return answer;
    }

    public int[] 성적평균으로정렬(int[][] score) {
        double[] absoluteScore = Arrays.stream(score)
                .mapToDouble(o -> (o[0] + o[1]) / 2.0)
                .toArray();
        int a = 10;
        double[] sortedAbsScore = Arrays.stream(absoluteScore).boxed()
                .sorted(Collections.reverseOrder())
                .mapToDouble(Double::doubleValue)
                .toArray();

        double[][] rank = IntStream.range(0, sortedAbsScore.length).mapToObj(i -> new double[]{sortedAbsScore[i], i}).toArray(double[][]::new);
        for (int i = 1; i < rank.length; i++) {
            if (rank[i][0] == rank[i - 1][0]) {
                rank[i][1] = rank[i - 1][1];
            }
        }

        HashMap<Double, Double> scoreRankMap = new HashMap<>();
        for (double[] arr : rank) {
            scoreRankMap.putIfAbsent(arr[0], arr[1] + 1);
        }

        int[] answer = new int[score.length];
        for (int i = 0; i < absoluteScore.length; i++) {
            answer[i] = scoreRankMap.get(absoluteScore[i]).intValue();
        }
        return answer;
    }

    public int[] weirdSort(int[] numlist, int n) {
        return Arrays.stream(numlist)
                .mapToObj(o -> new int[]{Math.abs(n - o), o})
                .sorted((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    }
                    return o1[0] - o2[0];
                }).mapToInt(o -> o[0]).toArray();
    }

    public int superPositionLine(int[][] lines) {
        int[] check = new int[400];
        int answer = 0;
        for (int[] arr : lines) {
            for (int i = arr[0]; i < arr[1]; i++) {
                check[i + 200]++;
            }
        }
        for (int n : check) {
            if (n >= 2) {
                answer++;
            }
        }
        return answer;
    }

    public String 알파벳구별(String s) {
        String[] array = s.split("");
        StringBuilder sb = new StringBuilder();
        for (String a : array) {
            char c = a.charAt(0);
            if (65 <= c && c <= 90) {
                sb.append(a.toLowerCase());
            } else if (97 <= c && c <= 122) {
                sb.append(a.toUpperCase());
            }
        }
        return sb.toString();
    }

    public String hashSortSample(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : s.split("")) {
            map.computeIfPresent(a, (s1, v) -> v + 1);
            map.putIfAbsent(a, 1);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue().compareTo(o2.getValue());
        });

        return entries.get(0).getKey();
    }

    public String hashSample02(String[] bj, String[] one, String[] two) {
        HashSet<String> loser = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int prize = one.length * 150 + two.length * 300 + 450;
        loser.addAll(Arrays.asList(one));
        loser.addAll(Arrays.asList(two));

        for (String name : bj) {
            if (!loser.contains(name)) {
                sb.append(name);
            }
        }
        return String.format("%d만원(%s)", prize, sb);
    }

    public int opSample02(String s) {
        String[] target = s.replaceAll("-", " -")
                .replaceAll("[+]", " ")
                .split(" ");
        return Arrays.stream(target).filter(f -> !f.equals(""))
                .mapToInt(Integer::parseInt).sum();
    }

    public int 괄호여닫기(String S) {
        Stack<String> stk = new Stack<>();
        for (String s : S.split("")) {
            if ("({[<".contains(s)) {
                stk.push(s);
            } else if (!stk.isEmpty()) {
                Integer x = checkSwitch(stk, s);
                if (x != null) return x;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private static Integer checkSwitch(Stack<String> stk, String s) {
        if (s.equals(")")) {
            Integer x = checkType(stk, "(");
            if (x != null) return x;
        } else if (s.equals("}")) {
            Integer x = checkType(stk, "{");
            if (x != null) return x;
        } else if (s.equals(">")) {
            Integer x = checkType(stk, "<");
            if (x != null) return x;

        } else if (s.equals("]")) {
            Integer x = checkType(stk, "[");
            if (x != null) return x;
        }
        return null;
    }

    private static Integer checkType(Stack<String> stk, String s) {
        if (!stk.peek().equals(s)) {
            return 0;
        }
        stk.pop();
        return null;
    }

    public String 문자열압축(String s) {
        int count = 15;
        while (count > 0) {
            String[] target = s.split("");
            for (int i = 0; i < target.length - 1; i++) {
                if (target[i].equals(target[i + 1])) {
                    target[i] = target[i + 1] = "";
                }
            }
            s = Arrays.stream(target)
                    .filter(f -> !f.equals(""))
                    .collect(Collectors.joining());
            count--;
        }
        return s;
    }

    public int 영에가장가까운수(int[] orders, int n) {
        int[] table = new int[1001];
        int answer = n;
        for (int i : orders) {
            table[i] = 1;
        }
        for (int i = 1; i < table.length; i++) {
            if (table[i] == 0) {
                n--;
            }
            if (n == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public int arrayGCDSample(int[] A) {
        Integer[] numbers = Arrays.stream(A).boxed().toArray(Integer[]::new);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i : numbers) {
            dq.add(i);
        }
        while (dq.size() > 1) {
            dq.addFirst(myGCD(dq.pollFirst(), dq.pollFirst()));
        }
        return dq.poll();
    }

    private Integer myGCD(Integer a, Integer b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public String[] stringSample08(String my_str) {
        String[] filteredString = Arrays.stream(my_str.split(""))
                .map(s -> {
                    if (".,!? ".contains(s)) {
                        s = " ";
                    }
                    return s;
                })
                .collect(Collectors.joining())
                .split(" ");

        ArrayList<String> container = new ArrayList<>();
        for (int i = 0; i < filteredString.length; i++) {
            if (!filteredString[i].equals("")) {
                container.add(filteredString[i]);
            }
        }
        String[] answer = container.toArray(String[]::new);
        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = answer[i].length() - 1; j >= 0; j--) {
                sb.append(answer[i].charAt(j));
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public String 전광판(int n, String s, int t) {
        LinkedList<String> deque = new LinkedList<>();
        for (int i = 0; i < n + s.length(); i++) {
            if (i < n) {
                deque.add(".");
            } else {
                deque.add(String.valueOf(s.charAt(i - n)));
            }
        }
        int dt = 0;
        while (dt < t) {
            deque.addLast(deque.pollFirst());
            dt++;
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(deque.pollFirst());
            n--;
        }
        return sb.toString();
    }

    public int coupledLines(int[][] lines) {
        int[][] sortedLines = Arrays.stream(lines).sorted(((o1, o2) -> o1[0] - o2[0])).toArray(int[][]::new);
        System.out.println(Arrays.deepToString(sortedLines));
        int answer = 0;
        for (int i = 1; i < sortedLines.length; i++) {
            int subLine = sortedLines[i - 1][1] - sortedLines[i][0];
            if (subLine > 0) {
                answer += subLine;
            }
        }

        int[] part1 = new int[]{sortedLines[1][0], sortedLines[0][1]};
        int[] part2 = new int[]{sortedLines[2][0], sortedLines[1][1]};
        if (part1[1] - part2[0] > 0) {
            answer -= (part1[1] - part2[0] + 1);
        }
        return answer;
    }

    public int hashSample(String[] spell, String[] dic) {
        for (String s : dic) {
            String[] word = s.split("");
            HashMap<String, Integer> map = new HashMap<>();

            for (String x : word) {
                map.computeIfPresent(x, (k, v) -> v + 1);
                map.putIfAbsent(x, 1);
            }
            int count = 0;
            for (String y : spell) {
                if (map.containsKey(y) && map.get(y) == 1) {
                    count++;
                }
            }
            if (count == spell.length) { // 모두 하나씩 쓴게 한 단어라도 있으면
                return 1;
            }
        }
        return 2;
    }

    public int checkDigitSample(String my_string) {
        int answer = 0;
        ArrayDeque<String> q = new ArrayDeque<>();
        for (String s : my_string.split("")) {
            if (isDigit(s)) {
                q.add(s);
            }
            if (!isDigit(s) && !q.isEmpty()) {
                answer += Integer.parseInt(String.join("", q));
                q.clear();
            }
        }
        if (!q.isEmpty()) {
            answer += Integer.parseInt(String.join("", q));
        }
        return answer;
    }


    private boolean isDigit(String s) {
        for (char c : s.toCharArray()) {
            if (c < 48 || 57 < c) {
                return false;
            }
        }
        return true;
    }

    public String stringSample03(String polynomial) {
        String[] str = polynomial.split(" ");
        int[] xy = new int[]{0, 0};
        for (String s : str) {
            if (s.contains("x")) {
                if (s.length() == 1) {
                    xy[0] += 1;
                } else {
                    xy[0] += Integer.parseInt(s.replace("x", ""));
                }
            } else if (!s.equals("+")) {
                xy[1] += Integer.parseInt(s);
            }
        }

        if (xy[0] == 0) {
            return String.format("%d", xy[1]);
        } else if (xy[1] == 0) {
            return xy[0] != 1 ? String.format("%dx", xy[0]) : "x";
        } else {
            return xy[0] != 1 ? String.format("%dx + %d", xy[0], xy[1]) : String.format("x + %d", xy[1]);
        }
    }

    public int[] codinationSample(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        for (String s : keyinput) {
            if (s.equals("up")) {
                if (answer[1] + 1 <= board[1] / 2) {
                    answer[1] += 1;
                }
            } else if (s.equals("down")) {
                if (-board[1] / 2 <= answer[1] - 1) {
                    answer[1] -= 1;
                }

            } else if (s.equals("left")) {
                if (answer[0] - 1 >= -(board[0] / 2)) {
                    answer[0] -= 1;
                }
            } else if (s.equals("right")) {
                if (answer[0] + 1 <= board[0] / 2) {
                    answer[0] += 1;
                }
            }
        }
        return answer;
    }

    public int squareSample(int[][] dots) {
        int[][] Dots = Arrays.stream(dots).sorted((o1, o2) -> o1[0] - o2[0]).toArray(int[][]::new);
        int x = Math.abs(Dots[0][1] - Dots[1][1]);
        int y = Math.abs(Dots[2][0] - Dots[0][0]);
        return x * y;
    }

    public int bitSample(String S) {
        int num = Integer.parseInt(S, 2);
        int answer = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num = num >> 1;
            }
            answer++;
        }
        return answer;
    }

    public int stremaGroupingSample(String s) {
        return Arrays.stream(s.split("")).collect(groupingBy(Integer::parseInt))
                .entrySet().stream().map(o -> new int[]{o.getValue().size(), o.getKey()})
                .max(((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    }
                    return o1[0] - o2[0];
                })).orElseThrow()[1];
    }

    /**
     * 스트림으로 인덱스에 접근하면서 2중 루프를 돌리는 법.
     *
     * @param A 소스 배열
     * @return 정수
     */
    public int stream2DimensionLoop(int[] A) {
        return IntStream.range(0, A.length - 2)
                .flatMap(i -> IntStream.range(i + 1, A.length).map(j -> A[j] - A[i]))
                .max()
                .orElse(0);
    }

    public int stringStreamSample04(String before, String after) {
        return Arrays.stream(before.split(""))
                .sorted()
                .collect(Collectors.joining())
                .equals(Arrays.stream(after.split(""))
                        .sorted()
                        .collect(Collectors.joining())) ? 1 : 0;
    }

    public String[] stringStreamSample03_2(String myStr, int n) {
        return IntStream.range(0, myStr.length() / n + (myStr.length() % n > 0 ? 1 : 0))
                .mapToObj(i -> i == myStr.length() / n ? myStr.substring(i * n) : myStr.substring(i * n, (i + 1) * n))
                .toArray(String[]::new);
    }

    public String[] stringStreamSample03_1(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < my_str.length() - n; i += n) {
            answer.add(my_str.substring(i, i + n));
        }

        if ((my_str.length() + 1) % n != 0) {
            answer.add(my_str.substring(n * answer.size()));
        }
        return answer.toArray(String[]::new);
    }

    public int stringStreamSample02(int[] array) {
        return Arrays.stream(array)
                .map(i -> {
                    int count = 0;
                    for (Character c : String.valueOf(i).toCharArray()) {
                        if (c.equals('7')) {
                            count++;
                        }
                    }
                    return count;
                }).sum();
    }

    public String stringStreamSample01(String my_string) {
        return Arrays.stream(my_string.split(""))
                .map(s -> s.toLowerCase())
                .sorted()
                .collect(Collectors.joining());
    }

    public String[] OXstreamSample02(String[] quiz) {
        return Arrays.stream(quiz).map(s -> {
            String[] arr = s.trim().split(" ");
            return arr[1].equals("+") && Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) || Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) ? "O" : "X";
        }).toArray(String[]::new);
    }

    public String[] OXstreamSample(String[] quiz) {
        return Arrays.stream(quiz).map(o -> {
            String[] str = o.replaceAll("- ", "-")
                    .replaceAll("= ", "")
                    .replaceAll("[+] ", "").split(" ");
            int[] numbers = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            if (numbers[0] + numbers[1] == numbers[2]) {
                return "O";
            }
            return "X";
        }).toArray(String[]::new);
    }

    public int opSample01(String my_string) {
        String[] input = my_string.split(" ");
        int answer = Integer.parseInt(input[0]);
        boolean flag = true;
        for (int i = 1; i < input.length; i++) {
            if (input[i].equals("+")) {
                flag = true;
            } else if (input[i].equals("-")) {
                flag = false;
            } else {
                int num = Integer.parseInt(input[i]);
                if (flag) {
                    answer += num;
                } else {
                    answer -= num;
                }
            }
        }
        return 0;
    }

    public int streamSample07(int[] array, int n) {
        return Arrays.stream(Arrays.stream(array)
                        .sorted() // 입력 스트림을 먼저 오름차순 정렬(거리가 같으면 작은 수가 나오도록 하기 위해)
                        .mapToObj(i -> new int[]{i, Math.abs(n - i)}) //숫자와 절대값(=거리)를 묶어서 매핑
                        .min(Comparator.comparing(o -> o[1])) // 절대값(=거리)를 기준으로 정렬하여 최소값을 찾고
                        .orElseThrow()) // 예외가 있으면 던져주고
                .toArray()[0]; // 값 반환
    }

    public int triAngleSample02(int[] sides) {
        int answer = 0;
        int b = sides[0] + sides[1];
        int a = Math.abs(sides[0] - sides[1]);
        for (int i = 1; i <= 1999; i++) {
            if (a < i && i < b) {
                answer++;
            }
        }
        return answer;
    }

    public int triAngleSample01(int[] sides) {
        int answer = 2;
        int[] sorted = Arrays.stream(sides).sorted().toArray();
        if (sorted[0] + sorted[1] > sorted[2]) {
            answer = 1;
        }
        return answer;
    }

    public String stringSample02(String my_string) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>(List.of(my_string.split("")));
        String answer = "";
        for (Object o : lhs) {
            answer = answer.concat(String.valueOf(o));
        }
        return answer;
    }

    public int[] stringSample(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }

    public int stkSample(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        String[] input = s.split(" ");
        for (String str : input) {
            if (!stk.isEmpty() && str.equals("Z")) {
                stk.pollLast();
                continue;
            }
            stk.addLast(Integer.parseInt(str));
        }
        return stk.stream().reduce(0, Integer::sum);
    }

    public int[] soinsuBunhaeSample(int number) {
        HashSet<Integer> arr = new HashSet<>(); // 뽑을때마다 다르게 나온다!!
        int pvt = 2;
        while (number != 1) {
            if (number % pvt == 0) {
                arr.add(pvt);
                number = number / pvt;
                continue;
            }
            pvt++;
        }
        return Arrays.stream(arr.toArray()).mapToInt(o -> (Integer) o).sorted().toArray();
    }

    public int myStringSample(String my_string) {
        int answer = 0;
        for (char c : my_string.toCharArray()) {
            if (48 <= c && c <= 57) {
                answer += Integer.parseInt(String.valueOf(c));
            }
        }
        return answer;
    }

    public int[] useReplaceAllSample(String my_string) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (char c : my_string.toCharArray()) {
            if (48 <= c && c <= 57) {
                numbers.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        numbers.sort(Integer::compareTo);
        int[] answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        return answer;
    }

    public int factSample(int n) {
        int answer = 0;
        for (int i = 1; i <= 10; i++) {
            if (n >= factorial(i)) {
                answer = i;
            } else {
                break;
            }
        }
        return answer;
    }

    public static int factorial(int number) {
        if (number > 1) return number * factorial(number - 1);
        return number;
    }

    public int sortSample02(int[] numbers) {
        Integer[] num = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(num, ((o1, o2) -> o2 - o1));
        return num[0] * num[1];
    }

    public int sosuSample(int n) {
        int answer = 0;
        int[] sosuTable = new int[n + 1];
        findSosu(sosuTable, n);
        for (int num : sosuTable) {
            if (num == 1) {
                answer++;
            }
        }
        if (n >= 4) {
            return answer + 1;
        }
        return answer;
    }

    private void findSosu(int[] arr, int n) {
        for (int i = 2; i <= (int) Math.sqrt(n) + 1; i++) {
            if (arr[i] == 0) {
                int j = 2;
                while (i * j < n) {
                    arr[i * j] = 1;
                    j++;
                }
            }
        }
    }

    public int[] arrayRL(int[] numbers, String direction) { // 이거 옮기기
        LinkedList<Integer> list = (LinkedList<Integer>) Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int num : numbers) {
            list.add(num);
        }
        if (direction.equals("left")) {
            list.add(list.pollFirst());
        } else {
            list.addFirst(list.pollLast());
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!list.isEmpty()) {
                numbers[i] = list.poll();
            }
        }
        return numbers;
    }

    public int[] arrayRLHeah(int[] numbers, String direction) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        if (direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        } else {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int circleSample(int[] numbers, int k) {
        int idx = 0;
        while (k > 1) {
            idx = (idx + 2) % numbers.length;
            k--;
        }
        return idx + 1;
    }

    public int[][] twodimensionSample(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }
        return answer;
    }

    public long myFactorial(long num) {
        if (num <= 1) {
            return num;
        }
        return myFactorial(num - 1) * num;
    }

    public String rspSample(String rsp) {
        String answer = "";
        HashMap<String, String> winningMap = new HashMap<>();
        winningMap.put("2", "0");
        winningMap.put("0", "5");
        winningMap.put("5", "2");
        for (int i = 0; i < rsp.length(); i++) {
            answer = answer.concat(winningMap.get(Character.toString(rsp.charAt(i))));
        }
        return answer;
    }

    public String morseSample(String letter) {
        String[] letters = letter.split(" ");
        String answer = "";
        String[] morse = {
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."
        };

        for (String s : letters) {
            for (int i = 0; i < morse.length; i++) {
                if (s.equals(morse[i])) {
                    answer = answer.concat(Character.toString(i + 97));
                }
            }
        }
        return answer;
    }

    public int numberOfCouplesSample(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).boxed().count();
    }

    public int[] sortSample(int[] emergency) {
        ArrayList<int[]> arr = new ArrayList<>();
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            arr.add(new int[]{emergency[i], i});
        }
        arr.sort((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < arr.size(); i++) {
            answer[arr.get(i)[1]] = i + 1;
        }
        return answer;
    }

    public int[] IntStreamSample01(int[] num_list) {
        return IntStream.rangeClosed(0, num_list.length - 1) // IntStream.rangeClosed 메서드를 사용하여 0부터 num_list.length-1 까지의 int 범위를 표현하는 Stream을 생성
                .map(i -> num_list[num_list.length - 1 - i]) // .map 메서드를 사용하여 Stream의 각 요소에 대해 num_list.length-1-i 인덱스의 값을 가져와서 새로운 Stream을 생성
                .toArray(); // .toArray 메서드를 사용하여 생성된 Stream을 int 배열로 변환하여 answer 변수에 저장
        // 최종적으로 생성된 int 배열은 주어진 num_list 배열의 순서가 뒤집어져 저장되어 있을 것
    }

    public String asciiToNumberSample(int age) {
        StringBuilder answer = new StringBuilder();
        for (char c : Integer.toString(age).toCharArray()) {
            answer.append((char) ((int) c + 97));
        }
        return answer.toString();
    }

    public int[] streamSample(int[] numbers, int num1, int num2) {
        return Arrays.stream(numbers, num1, num2)
                .toArray();
    }

    public int IntStreamSample02(int n) {
        return IntStream.rangeClosed(0, n)
                .filter(e -> e % 2 == 0)
                .sum();
    }

}
