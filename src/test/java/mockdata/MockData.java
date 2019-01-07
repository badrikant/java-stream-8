package mockdata;

import beans.Person;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author badrikant.soni on 07/01/19
 */
public class MockData {

    public static ImmutableList<Person> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Person>>() {
        }.getType();
        List<Person> people = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(people);
    }
}
