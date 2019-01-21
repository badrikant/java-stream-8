package practices.understandingCollect;

import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author badrikant.soni on 21/01/19
 */
public class App18 {

    @Test
    public void understandingCollect() throws IOException {
        ImmutableList<Person> people = MockData.getPeople();
        // goal : getting emails for each person in the list
        List<String> emails = people.stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());
        emails.forEach(System.out::println);
    }

    @Test
    public void understandingCollect1() throws IOException {
        ImmutableList<Person> people = MockData.getPeople();

        // goal : getting emails for each person in the list
        List<String> emails = people.stream()
                .map(Person::getEmail)

                // collect takes 3 arguments. 1) supplier  2) accumulator 3) combiner
                // 1 - Could be list or set etc,
                // 2 - Allow you to add an element to given list [given a list and also given an element]
                // 3 - Given two lists, whenever it gets invoked list2 to be added in the list1
                .collect(
                        () -> new ArrayList<String>(),
                        (list, element) -> list.add(element),
                        /*
                          Stream's is really powerful in fact that this take care of multi-threading for us. And this is exactly what's going on.
                          So it is saying that if you have multiple threads working on a stream when you come to collect the results
                          from both threads this is how you can actually combine them into one single result.
                         */
                        (list1, list2) -> list1.addAll(list2));   // lambda expression
        emails.forEach(System.out::println);
    }

    @Test
    public void understandingCollect2() throws IOException {
        ImmutableList<Person> people = MockData.getPeople();

        // goal : getting emails for each person in the list
        List<String> emails = people.stream()
                .map(Person::getEmail)
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);   // Method reference
        emails.forEach(System.out::println);
    }
}
