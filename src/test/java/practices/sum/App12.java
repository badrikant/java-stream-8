package practices.sum;

import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App12 {

    @Test
    public void sum() throws IOException {
        // calculate sum of of all car prices
        double sum = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice)
                .sum(); // it doesn't return an optional because if list is empty, it will sum to 0
        System.out.println(sum);

        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum); // its needed because sum is very big numbers.
        System.out.println(bigDecimalSum);
    }
}
