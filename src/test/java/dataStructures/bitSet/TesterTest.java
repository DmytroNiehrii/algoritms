package dataStructures.bitSet;

import org.junit.jupiter.api.Test;

import java.util.Set;


class TesterTest {

    @Test
    public void getSwappedStrings() throws Exception {

        Set<String> result = Tester.getSwappedStrings("dcba", 0);
        result.forEach(s -> System.out.println(s));
    }
}