package pl.michalperlak.testgen;

import choco.Problem;
import choco.Solver;
import pl.michalperlak.testgen.model.Argument;
import pl.michalperlak.testgen.model.Method;
import pl.michalperlak.testgen.model.PathCondition;
import pl.michalperlak.testgen.model.TestData;

import java.util.*;

public class TestDataGenerator {
    public List<TestData> processMethod(Method method, Collection<PathCondition> conditions) {
        List<TestData> testData = new ArrayList<>();
        for (PathCondition condition : conditions) {
            testData.add(new TestData(method, solveCondition(method, condition)));
        }
        return testData;
    }

    private Map<Argument, String> solveCondition(Method method, PathCondition condition) {
        return null; //TODO implement
    }
}
