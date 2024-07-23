package algorithmes;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    BloomFilter<Integer> filter;

    @BeforeEach
    void init() {
        filter = BloomFilter.create(Funnels.integerFunnel(),500,0.01);
        filter.put(1);
        filter.put(2);
        filter.put(3);
    }

    @Test
    void bloomFilterTest() {
        assertTrue(filter.mightContain(1));
        assertTrue(filter.mightContain(2));
        assertTrue(filter.mightContain(3));

        assertFalse(filter.mightContain(100));
    }
}