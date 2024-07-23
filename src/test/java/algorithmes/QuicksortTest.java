package algorithmes;

import org.junit.jupiter.api.Test;

import static algorithmes.QuicksortExample.*;

public class QuicksortTest {

    @Test
    public void quickSort() {
        int[] a = getArray();
        printArray(a);
        sort(a);
        System.out.println("");
        printArray(a);
    }

}
