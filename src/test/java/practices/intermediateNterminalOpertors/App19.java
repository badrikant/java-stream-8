package practices.intermediateNterminalOpertors;

import mockdata.MockData;
import org.junit.Test;

import java.util.stream.Collectors;

/**
 * @author badrikant.soni on 21/01/19
 */
public class App19 {
    /*
    1. Concrete to abstraction - invoke stream
    2. Multiple operations map, filter, flatmap, average, sum, min, max n...
      - Intermediate operations are lazy.
    3. Terminal operators collect streams back to concrete type. .collect, .get
  */
    // parallel streams ?
    @Test
    public void intermediateAndTerminalOperations() throws Exception {
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
                        })
                        .map(car -> {
                            System.out.println("mapping car " + car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())
        );
    }
}
