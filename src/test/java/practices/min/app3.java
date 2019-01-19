package practices.min;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author badrikant.soni on 16/01/19
 */
public class app3 {

    @Test
    public void min() {

        // find the minimum number from the list
        List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
        Integer min = numbers.stream()
                .min((number1, number2) -> number1 > number2 ? 1 : -1) // min() takes comparator object
                .get();

        assertThat(min).isEqualTo(1);
        System.out.println(min);

    }

    @Test
    public void max() {

        // find the maximum number from the list
        List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
        Integer max = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();

        assertThat(max).isEqualTo(100);
        System.out.println(max);

    }

}
