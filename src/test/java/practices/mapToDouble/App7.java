package practices.mapToDouble;

import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;

/**
 * @author badrikant.soni on 19/01/19
 */
public class App7 {

    @Test
    public void averageCarPrice() throws IOException {
        // calculate average of car prices
        double average = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice) // taking price and convert it to stream of Double
                .average() // calculating the avg on stream of doubles
                .orElse(0); // default value if collection is empty or don't find the average
        System.out.println(average);

    }

    @Test
    public void test() throws IOException {
        MockData.getCars().forEach(System.out::println);
    }
}
