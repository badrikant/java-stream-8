package beans;

import lombok.Data;
import lombok.ToString;

/**
 * @author badrikant.soni on 19/01/19
 */
@Data
@ToString
public class PersonDTO {
    private Integer id;
    private String firstName;
    private Integer age;

    public PersonDTO(Integer id, String firstName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
    }

    public static PersonDTO map(Person person) {
        return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
    }
}
