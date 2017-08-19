package pl.michalperlak.testgen.model;

import java.util.Map;

public class TestData {
    private final Method method;
    private final Map<Argument, String> values;

    public TestData(Method method, Map<Argument, String> values) {
        this.method = method;
        this.values = values;
    }
}
