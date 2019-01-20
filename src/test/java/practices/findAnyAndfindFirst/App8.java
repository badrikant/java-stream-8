package practices.findAnyAndfindFirst;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author badrikant.soni on 19/01/19
 */

public class App8 {

    final Predicate<Integer> numberLessThan10 = n -> n > 5 && n < 10;

    /**
     * The behavior of this operation is explicitly nondeterministic; it is free to select any element in the stream.
     * This is to allow for maximal performance in parallel operations; the cost is that multiple invocations on the
     * same source may not return the same result.  (If a stable result is desired, use {@link #findFirst()} instead.)
     *
     * @return an {@code Optional} describing some element of this stream, or an
     * empty {@code Optional} if the stream is empty
     * @throws NullPointerException if the element selected is null
     * @see #findFirst()
     */

    @Test
    public void findAny() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int any = Arrays.stream(numbers)
                .filter(numberLessThan10)
                .findAny()
                .get();
        System.out.println(any);
    }

    @Test
    public void findFirst() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int first = Arrays.stream(numbers)
                .filter(numberLessThan10)
                .findFirst()
                .get();
        System.out.println(first);
    }
}
