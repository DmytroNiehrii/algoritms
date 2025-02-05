package algorithmes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MinPositiveMissed {

    public static void main(String[] args) {
        List<Integer> arr = List.of(1,-1,4,3);

        System.out.println("Array: " + arr);
        System.out.println("Missed positive: " + findMissedFirstPositive(arr));
        System.out.println("Extended list: " + extendByMissedFirstPositive(arr));
    }

    private static List<Integer> extendByMissedFirstPositive(List<Integer> arr) {
        var newList = new ArrayList<>(arr);
        findMissedFirstPositive(arr).ifPresent(newList::add);
        return newList;
    }


    private static Optional<Integer> findMissedFirstPositive(List<Integer> arr) {
        var orderedList = arr.stream()
                .filter(i -> i != null && i > 0)
                .sorted()
                .toList();
        for (int i = 0; i < orderedList.size(); i++) {
            if (orderedList.get(i) != i+1) return Optional.of(i+1);
        }
        return Optional.empty();
    }


}
