package beans;

import lombok.Data;
import lombok.ToString;

/**
 * @author badrikant.soni on 07/01/19
 */

@Data
@ToString
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Integer age;
}
