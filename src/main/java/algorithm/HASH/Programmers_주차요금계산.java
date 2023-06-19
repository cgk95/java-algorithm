package algorithm.HASH;

import java.util.*;

public class Programmers_주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, String> parking = new TreeMap<>();
        TreeMap<String, Integer> parkingTime = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));
        StringTokenizer st;

        for (String rec : records) {
            st = new StringTokenizer(rec);
            String time = st.nextToken();
            String number = st.nextToken();
            String state = st.nextToken();

            if (state.equals("IN")) { // 입차인 경우
                parking.putIfAbsent(number, time);
            } else { // 출차인 경우
                String prevInTime = parking.get(number); // 꺼내서
                parking.remove(number); // 출차 처리
                // 주차시간 계산
                int timeDiff = computeTotalMinute(prevInTime, time);
                parkingTime.computeIfPresent(number, (k, v) -> v + timeDiff);
                parkingTime.putIfAbsent(number, timeDiff);
            }
        }
        // 자정이 되도록 출차하지 않은 차들 처리
        while (!parking.isEmpty()) {
            Map.Entry<String, String> rest = parking.pollFirstEntry();
            int time = computeTotalMinute(rest.getValue(), "23:59");
            parkingTime.computeIfPresent(rest.getKey(), (k, v) -> v + time);
            parkingTime.putIfAbsent(rest.getKey(), time);
        }
        // 주차요금 계산
        ArrayList<Integer> answer = new ArrayList<>();
        computeTotalFees(fees, parkingTime, answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void computeTotalFees(int[] fees, TreeMap<String, Integer> parkingTime, ArrayList<Integer> answer) {
        while (!parkingTime.isEmpty()) {
            int totalTime = parkingTime.pollFirstEntry().getValue();
            int fee = 0;
            if (totalTime > 0) {
                fee += fees[1];
            }
            if (totalTime > fees[0]) {
                fee += (int) Math.ceil(((double) totalTime - fees[0]) / fees[2]) * fees[3];
            }
            answer.add(fee);
        }
    }

    public int computeTotalMinute(String timeIn, String timeOut) {
        String[] out = timeOut.split(":");
        String[] in = timeIn.split(":");
        int min;
        int hour;
        // 분 계산
        int outMin = Integer.parseInt(out[1]);
        int inMin = Integer.parseInt(in[1]);
        if (inMin > outMin) {
            outMin += 60;
            out[0] = String.valueOf(Integer.parseInt(out[0]) - 1);
        }
        min = outMin - inMin;
        hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
        return hour * 60 + min;
    }

    public static void main(String[] args) {
        Programmers_주차요금계산 sol = new Programmers_주차요금계산();
        System.out.println(Arrays.toString(sol.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }
}
