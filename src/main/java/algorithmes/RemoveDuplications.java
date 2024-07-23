package algorithmes;

// Given an integer array nums sorted in non-decreasing order,
// remove the duplicates in-place such that each unique element appears only once.
// The relative order of the elements should be kept the same.

// Input [1,1,2,3,4,5,4,8]
// Output [1,2,3,4,5,8]

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RemoveDuplications {

    public static void main(String[] args) {

        System.out.println("Output: " + removeByConvertingToSet(List.of(1,1,2,3,4,5,4,8)));
        System.out.println("Output: " + removeManually(List.of(1,1,2,3,4,5,4,8)));
    }

    // Approach applied for sorted list only
    static List<Integer> removeManually(List<Integer> input) {
        List<Integer> output = new LinkedList<>();
        for(Integer i: input) {
            if (output.isEmpty() || output.getLast() < i) {
                output.add(i);
            }
        }
        return output;
    }

    static List<Integer> removeByConvertingToSet(List<Integer> input) {
        Set<Integer> set = new HashSet<>(input);
        return set.stream().toList();
    }
}
