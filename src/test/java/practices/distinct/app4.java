package practices.distinct;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author badrikant.soni on 19/01/19
 */
public class app4 {

    @Test
    public void distinct() {

        //remove the duplicate numbers from the list and print the unique numbers using stream().distinct()
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        List<Integer> distinctNumber = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(distinctNumber).hasSize(9);
        System.out.println(distinctNumber);


    }

    @Test
    public void distinctWithSet() {

        // remove the duplicate numbers from the list and print the unique numbers using stream().collect(Collect.toSet)
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        Set<Integer> distinctNumbers = numbers.stream()
                .collect(Collectors.toSet());

        assertThat(distinctNumbers).hasSize(9);

        System.out.println(distinctNumbers);
    }
}
