package pl.michalperlak.testgen.jpf;

import gov.nasa.jpf.symbc.numeric.PathCondition;
import pl.michalperlak.testgen.model.Argument;
import pl.michalperlak.testgen.model.IPathCondition;
import pl.michalperlak.testgen.model.Method;
import pl.michalperlak.testgen.model.TestData;

import java.util.HashMap;
import java.util.Map;

public class PathConditionImpl implements IPathCondition {
    private final Method method;
    private final PathCondition condition;

    public PathConditionImpl(Method method, PathCondition condition) {
        this.method = method;
        this.condition = condition;
    }

    @Override
    public String getAsString() {
        return condition.header.toString();
    }

    @Override
    public TestData solve() {
        Map<String, Object> valuation = condition.solveWithValuation();
        return new TestData(method, convertValuationToMethodTestData(method, valuation));
    }

    @Override
    public String toString() {
        return getAsString();
    }

    private static Map<Argument, String> convertValuationToMethodTestData(Method method, Map<String, Object> valuation) {
        Map<Argument, String> argumentsValues = new HashMap<>();
        for (Argument argument : method.getArguments()) {
            Object value = valuation.get(argument.getName());
            if (value != null) {
                argumentsValues.put(argument, value
                        .toString());
            }
        }
        return argumentsValues;
    }
}
