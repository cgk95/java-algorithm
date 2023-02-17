package algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] array, int n) {
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
