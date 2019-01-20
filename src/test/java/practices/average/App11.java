package practices.average;

import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App11 {

    @Test
    public void average() throws IOException {
        // find the average price of cars
        double avg = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice) // want to calculate avg on price
                .average()
                .orElse(0);
        System.out.println(avg);

    }
}
