package practices.reduce;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App15 {

    @Test
    public void reduce() {
        // Reduce - Combine all the elements in the stream and produce the results.
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum1 = Arrays.stream(integers)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum1);

        int sum2 = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        System.out.println(sum2);
    }
}
