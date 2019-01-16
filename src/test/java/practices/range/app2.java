package practices.range;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author badrikant.soni on 16/01/19
 */
public class app2 {

    @Test
    public void range() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println();
        IntStream.range(0, 10).forEach(System.out::println); // inclusive range

        System.out.println("Exclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println); // exclusive range

    }

    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();

        // How to loop with IntStream range
        IntStream.range(0, people.size()).forEach(index -> {
            Person person = people.get(index);  // get item from people list
            System.out.println(person);
        });
    }

    @Test
    public void IntStreamIterate() {

        // how to iterate IntStream
        IntStream.iterate(0, operand -> operand + 1)
                .filter(number -> number % 2 == 0)  // find even numbers
                .limit(20)  // find first 20 even numbers
                .forEach(System.out::println); // print all of them
    }
}
