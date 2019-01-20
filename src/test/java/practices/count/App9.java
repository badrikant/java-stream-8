package practices.count;

import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App9 {

    @Test
    public void count() throws IOException {
        // find count of females in the given list of people.
        long count = MockData.getPeople()
                .stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .count();
        System.out.println("Total Female Counts : " + count);
    }
}
