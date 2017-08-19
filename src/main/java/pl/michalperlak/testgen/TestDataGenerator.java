package pl.michalperlak.testgen;

import pl.michalperlak.testgen.model.Argument;
import pl.michalperlak.testgen.model.Method;
import pl.michalperlak.testgen.jpf.PathConditionImpl;
import pl.michalperlak.testgen.model.TestData;

import java.util.*;

public class TestDataGenerator {
    public List<TestData> processMethod(Method method, Collection<PathConditionImpl> conditions) {
        List<TestData> testData = new ArrayList<>();
        for (PathConditionImpl condition : conditions) {
            testData.add(new TestData(method, solveCondition(method, condition)));
        }
        return testData;
    }

    private Map<Argument, String> solveCondition(Method method, PathConditionImpl condition) {
        return null; //TODO implement
    }
}
