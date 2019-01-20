package practices.flatMap;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App16 {

    private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
            Lists.newArrayList("Badri", "Vinay", "Zeeshan"),
            Lists.newArrayList("Deepak", "Kant", "Khan"),
            Lists.newArrayList("Abhishek", "Soni")
    );

    @Before
    public void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() {
        // Combine arrayListOfNames into one single list and print it to the console.
        // The output should be: [Badri, Vinay, Zeeshan, Deepak, Kant, Khan, Abhishek, Soni]
        List<String> names = Lists.newArrayList();
        for (List<String> listOfNames : arrayListOfNames) {
            for (String name : listOfNames) {
                names.add(name);
            }
        }
        System.out.println(names);
    }

    @Test
    public void withFlatMap() {
        List<String> names = arrayListOfNames.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
