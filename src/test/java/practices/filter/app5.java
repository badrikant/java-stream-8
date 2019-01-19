package practices.filter;

import beans.Car;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author badrikant.soni on 19/01/19
 */
public class app5 {

    @Test
    public void understandingFiler() throws IOException {
        final ImmutableList<Car> cars = MockData.getCars();
        Predicate<Car> carPredicate = car -> car.getPrice() < 20000;
        List<Car> filteredCars = cars.stream()
                // Inside the filter we usually keep an expression/condition called predicate.
                // predicate means what you want to keep.
                // predicate can be extracted and resued in other methods as well.
                .filter(carPredicate)
                .collect(Collectors.toList());

        filteredCars.forEach(System.out::println);

        System.out.println(filteredCars.size());

    }
}
