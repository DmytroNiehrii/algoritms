package dataStructures.bitSet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tester {

    static boolean isTwins(String a, String b) {
        if (a.length() != b.length()) return false;

        Set<String> aSet = getSwappedStrings(a, 0);
        Set<String> bSet = getSwappedStrings(b, 0);

        aSet.retainAll(bSet);

        return aSet.size() > 0;
    }

    static Set<String> getSwappedStrings(String s, int startIndex) {
        Set<String> result = new HashSet<>();
        result.add(s);
        int index1 = startIndex, index2 = startIndex + 2;
        while(index1 < s.length()) {
            while (index2 < s.length()) {
                String swapped = swap(s, index1, index2);
                result.add(swapped);
                result.addAll(getSwappedStrings(swapped, index1 + 1));
                index2 = index2 + 2;
            }
            index1 = index1 + 2;
        }
        return result;
    }

    static String swap(String s, int index1, int index2) {
        char[] chars = s.toCharArray();
        char x = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = x;
        return String.valueOf(chars);
    }

    static boolean[] twins(String[] a, String[] b) {
        boolean[] result = new boolean[a.length];
        for (int k = 0; k < a.length; k++)
            result[k] = isTwins(a[k], b[k]);
        return result;
    }



    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine().trim());
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }

        int m = Integer.parseInt(in.nextLine().trim());
        String[] b = new String[m];
        for(int i = 0; i < m; i++) {
            b[i] = in.nextLine();
        }

        // call twins function
        boolean[] results = twins(a, b);

        for(int i = 0; i < results.length; i++) {
            System.out.println(results[i]? "Yes" : "No");
        }
    }
}
