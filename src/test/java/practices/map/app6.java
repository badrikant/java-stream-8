package practices.map;

import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author badrikant.soni on 19/01/19
 * <p>
 * Transformation with stream.map
 */
public class app6 {

    @Test
    public void firstMapping() throws IOException {
        // transform from one data type to another data type
        ImmutableList<Person> people = MockData.getPeople();

        List<PersonDTO> personDTOS = people.stream()
                .map(person -> {
                    return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());  // with return statement
                })
                .collect(Collectors.toList());
        personDTOS.forEach(System.out::println);
        System.out.println(personDTOS.size());
    }

    @Test
    public void firstMapping1() throws IOException {
        // transform from one data type to another data type
        ImmutableList<Person> people = MockData.getPeople();

        List<PersonDTO> personDTOS = people.stream()
                .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))  // without return statement
                .collect(Collectors.toList());
        personDTOS.forEach(System.out::println);
        System.out.println(personDTOS.size());
    }

    @Test
    public void firstMapping2() throws IOException {
        // transform from one data type to another data type (data object transfer)
        ImmutableList<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()); // take person & transform it to PersonDTO object
        List<PersonDTO> personDTOS = people.stream()
                .map(personPersonDTOFunction)  // extracted function and reuse it across
                .collect(Collectors.toList());
        personDTOS.forEach(System.out::println);
        System.out.println(personDTOS.size());
    }

    @Test
    public void firstMapping3() throws IOException {
        // transform from one data type to another data type (data object transfer)
        ImmutableList<Person> people = MockData.getPeople();

        List<PersonDTO> personDTOS = people.stream()
                .map(PersonDTO::map)  // calling method called map from PersonDTO class
                .collect(Collectors.toList());
        personDTOS.forEach(System.out::println);
        System.out.println(personDTOS.size());

    }
}