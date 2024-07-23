package pragmaticPlayTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task2 {


    static String getRandomValue(String[] values, int[] weights) {

        int weightSum = Arrays.stream(weights).sum();

        Random randomizer = new Random();
        int randomIndex = randomizer.nextInt(0, weightSum);
        int valueIndex = 0;
        int i = 0;
        int currentWeight = 0;
        while (i < values.length) {
            currentWeight = currentWeight + weights[i];
            if (randomIndex < currentWeight) {
                return values[i];
            }
            valueIndex = valueIndex + weights[i];
            i++;
        }
        return values[valueIndex];
    }

    public static void main(String[] args) {

        String[] values = {"A", "B", "C"};
        int[] weights = {3, 5, 2};

        Map<String, Integer> results = new HashMap();

        for (int i = 0; i < 1000000; i++) {
            String str = getRandomValue(values, weights);
            if (results.get(str) == null) {
                results.put(str, 1);
            } else {
                results.put(str, results.get(str) + 1);
            }
        }

        System.out.println(results);
    }


}
