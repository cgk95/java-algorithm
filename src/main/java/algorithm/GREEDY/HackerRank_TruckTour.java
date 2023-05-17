package algorithm.GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HackerRank_TruckTour {
    public static int truckTour(List<List<Integer>> petrolpumps) {
        int len = petrolpumps.size();
        int sum = 0;
        int result = 0;
        int total = 0;
        for (int i = 0; i < len; i++) {
            sum += petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1);
            if (sum < 0) {
                total += sum;
                sum = 0;
                result = i + 1;
            }
        }
        total += sum;
        return total < 0 ? -1 : result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = HackerRank_TruckTour.truckTour(petrolpumps);
        System.out.println(result);
        bufferedReader.close();
    }
}
