package pl.michalperlak.testgen;

import pl.michalperlak.testgen.model.IPathCondition;
import pl.michalperlak.testgen.model.TestData;

import java.util.*;

public class TestDataGenerator {
    public List<TestData> processMethod(Collection<IPathCondition> conditions) {
        Set<TestData> testData = new HashSet<>();
        for (IPathCondition condition : conditions) {
            if (!overlaps(conditions, condition)) {
                testData.add(condition.solve());
            }
        }

        return new ArrayList<>(testData);
    }

    private static boolean overlaps(Iterable<IPathCondition> otherConditions, IPathCondition condition) {
        for (IPathCondition condition1 : otherConditions) {
            if (condition.equals(condition1)) {
                continue;
            }

            if (condition1.overlaps(condition)) {
                return true;
            }
        }
        return false;
    }
}
