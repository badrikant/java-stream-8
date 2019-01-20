package practices.statistics;

import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;

/**
 * @author badrikant.soni on 20/01/19
 */
public class App13 {

    @Test
    public void statistics() throws IOException {
        // find all aggregators such as sum, avg, count, min and max for a list
        DoubleSummaryStatistics doubleSummaryStatistics = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(doubleSummaryStatistics);
        System.out.println(doubleSummaryStatistics.getAverage());
        System.out.println(doubleSummaryStatistics.getCount());
        System.out.println(doubleSummaryStatistics.getMax());
        System.out.println(doubleSummaryStatistics.getMin());
        System.out.println(doubleSummaryStatistics.getSum());
    }
}
