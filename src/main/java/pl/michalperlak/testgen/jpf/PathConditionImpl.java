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
    public boolean overlaps(IPathCondition condition) {
        if (condition instanceof PathConditionImpl) {
            PathConditionImpl pathCondition = (PathConditionImpl) condition;
            return this.condition.hasConstraint(pathCondition.condition.header);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathConditionImpl that = (PathConditionImpl) o;

        return method.equals(that.method) && condition.equals(that.condition);
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + condition.hashCode();
        return result;
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
