package beans;

import lombok.Data;
import lombok.ToString;

/**
 * @author badrikant.soni on 19/01/19
 */

@Data
@ToString
public class Car {

    private final Integer id;
    private final String make;
    private final String model;
    private final String color;
    private final Integer year;
    private final Double price;
}
