package pl.michalperlak.testgen.model;

import java.util.List;

public class Method {
    private final String shortName;
    private final String fullName;
    private final List<Argument> arguments;

    public Method(String shortName, String fullName, List<Argument> arguments) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.arguments = arguments;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Method method = (Method) o;
        return fullName.equals(method.fullName) && arguments.equals(method.arguments);
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        result = 31 * result + arguments.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
