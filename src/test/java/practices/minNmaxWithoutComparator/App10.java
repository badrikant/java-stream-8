package practices.minNmaxWithoutComparator;

import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.function.Predicate;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App10 {

    final Predicate<Car> carFilter = car -> car.getColor().equalsIgnoreCase("yellow");

    @Test
    public void minWithoutComparator() throws IOException {
        // find minimum price of yellow cars from the list of cars.
        double minPrice = MockData.getCars()
                .stream()
                .filter(carFilter)
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0); // if don't find min, return 0 as default value
        System.out.println(minPrice);

    }

    @Test
    public void maxWithoutComparator() throws IOException {
        // find maximum price of yellow cars from the list of cars.
        double maxPrice = MockData.getCars()
                .stream()
                .filter(carFilter)
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(maxPrice);
    }
}
