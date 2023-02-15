package algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
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
        Arrays.sort(num,((o1, o2) -> o2-o1));
        return num[0]*num[1];
    }
    public int sosuSample(int n) {
        int answer=0;
        int[] sosuTable=new int[n+1];
        findSosu(sosuTable,n);
        for(int num:sosuTable){
            if(num==1){
                answer++;
            }
        }
        if(n>=4){
            return answer+1;
        }
        return answer;
    }

    private void findSosu(int[] arr,int n){
        for(int i=2;i<=(int)Math.sqrt(n)+1;i++){
            if(arr[i]==0){
                int j=2;
                while(i*j<n){
                    arr[i*j]=1;
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
