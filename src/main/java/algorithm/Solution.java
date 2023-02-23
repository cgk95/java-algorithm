package algorithm;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class Solution {
    public String solution(String[] bj, String[] one, String[] two) {
        HashSet<String> loser=new HashSet<>();
        StringBuilder sb=new StringBuilder();

        int prize=one.length*150+two.length*300+450;
        loser.addAll(Arrays.asList(one));
        loser.addAll(Arrays.asList(two));

        for (String name : bj) {
            if(!loser.contains(name)){
                sb.append(name);
            }
        }
        return String.format("%d만원(%s)",prize, sb);
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
