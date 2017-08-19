package pl.michalperlak.testgen.model;

import java.util.Iterator;
import java.util.Map;

public class TestData {
    private final Method method;
    private final Map<Argument, String> values;

    public TestData(Method method, Map<Argument, String> values) {
        this.method = method;
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestData testData = (TestData) o;

        return method.equals(testData.method) && values.equals(testData.values);
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + values.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getShortName());
        sb.append(" : ");
        sb.append("(");
        Iterator<Map.Entry<Argument, String>> iterator = values
                .entrySet()
                .iterator();

        while (iterator.hasNext()) {
            Map.Entry<Argument, String> entry = iterator.next();
            sb.append(entry.getKey().getType());
            sb.append(" ");
            sb.append(entry.getKey().getName());
            sb.append(" = ");
            sb.append(entry.getValue());

            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(")");

        return sb.toString();
    }
}
