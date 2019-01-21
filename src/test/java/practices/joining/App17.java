package practices.joining;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.stream.Collectors;

/**
 * @author badrikant.soni on 21/01/19
 */
public class App17 {

    @Test
    public void joiningStrings() {

        // Concatenate names into one String joined by comma
        // o/p => Badri,vinay,Diwakar,Mahohar,Gaurav

        ImmutableList<String> names = ImmutableList.of("Badri", "vinay", "Diwakar", "Mahohar", "Gaurav");
        String join = "";
        for (String name : names) {
            join += name + ", ";
        }
        System.out.println(join.substring(0, join.length() - 2));
    }

    @Test
    public void joiningStringsWithStream() {
        // Concatenate names into one String joined by comma
        // o/p => Badri,vinay,Diwakar,Mahohar,Gaurav

        ImmutableList<String> names = ImmutableList.of("Badri", "vinay", "Diwakar", "Mahohar", "Gaurav");
        String name = names.stream()
                .map(String::toUpperCase) // In case of you need them in upper case
                .collect(Collectors.joining(",")); // by delimiter
        System.out.println(name);
    }
}
