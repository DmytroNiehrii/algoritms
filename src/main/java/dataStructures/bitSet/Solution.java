package dataStructures.bitSet;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

// https://www.hackerrank.com/challenges/java-bitset/problem

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int setSize = sc.nextInt();
        int noOps = sc.nextInt();

        BitSet[] bitSets = new BitSet[]{new BitSet(setSize), new BitSet(setSize)};
        Map<String, BiConsumer<Integer,Integer>> ops = new HashMap<>();

        ops.put("AND", (index1, index2) -> bitSets[index1-1].and(bitSets[index2-1]));
        ops.put("OR", (index1, index2) -> bitSets[index1-1].or(bitSets[index2-1]));
        ops.put("XOR", (index1, index2) -> bitSets[index1-1].xor(bitSets[index2-1]));
        ops.put("SET", (index1, index2) -> bitSets[index1-1].set(index2));
        ops.put("FLIP", (index1, index2) -> bitSets[index1-1].flip(index2));

        for (int i = 0; i < noOps; i++){
            ops.get(sc.next()).accept(sc.nextInt(), sc.nextInt());
            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }
}
