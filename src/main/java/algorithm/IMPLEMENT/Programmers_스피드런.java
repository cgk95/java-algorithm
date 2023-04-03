package algorithm.IMPLEMENT;

public class Programmers_스피드런 {
    public int solution(int[] reward, int[] health, int[] optional) {
        return recursive(1, 0, reward, health, optional);
    }

    int recursive(int attack, int current, int[] reward, int[] health, int[] optional) {
        if (current == reward.length) {
            return 0;
        }

        int time = (health[current] + attack - 1) / attack;
        int pathA = time + recursive(
                attack + reward[current],
                current + 1,
                reward, health, optional);

        if (optional[current] == 0) {
            return pathA;
        } else {
            int pathB = recursive(
                    attack,
                    current + 1,
                    reward, health, optional);
            return Math.min(pathA, pathB);
        }
    }
}
