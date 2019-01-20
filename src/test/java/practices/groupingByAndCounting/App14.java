package practices.groupingByAndCounting;

import beans.Car;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App14 {

    @Test
    public void simpleGrouping() throws IOException {
        // group all the cars by their make
        Map<String, List<Car>> grouping = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake)); // group cars by their make
        grouping.forEach((make, cars) -> {
            System.out.println(make);
            cars.forEach(System.out::println);
        });
    }

    @Test
    public void groupingAndCounting() throws IOException {
        ImmutableList<Car> cars = MockData.getCars();
        Map<String, Long> collect = cars.stream()
                .collect(Collectors.groupingBy((Car::getMake), Collectors.counting()));  // group by make and count

        collect.forEach((car, aLong) -> {
            System.out.println(car + " > " + aLong);

        });
    }

    @Test
    public void simpleGroupingAndCounting() {
        // find count of each characters in the list
        ArrayList<String> newArrayList = Lists.newArrayList("a", "b", "a", "c", "d", "d", "b");
        Map<String, Long> collect = newArrayList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((s, aLong) -> {
            System.out.println(s + " > " + aLong);
        });
    }

    @Test
    public void WordsCount() {
        String sentence = "The big brown fox, jumped over the fence and jumped in a hole.";

        // Part (A)Word Splitting
        String[] words = sentence
                .trim()
                .replaceAll("[^A-Za-z]", " ") // replace delimeters by empty space
                .toLowerCase()  // covert it lower case
                .split("\\s+"); // split by space character

        Map<String, Long> countMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        countMap.forEach((s, aLong) -> {
            System.out.println(s + " > " + aLong);
        });
    }
}
