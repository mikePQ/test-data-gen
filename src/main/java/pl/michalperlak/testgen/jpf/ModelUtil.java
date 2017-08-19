package pl.michalperlak.testgen.jpf;

import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.MethodInfo;
import pl.michalperlak.testgen.model.Argument;
import pl.michalperlak.testgen.model.Method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelUtil {
    private ModelUtil() {
    }

    public static Method createMethod(MethodInfo methodInfo) {
        return new Method(methodInfo.getName(), methodInfo.getFullName(), createArguments(methodInfo.getArgumentLocalVars()));
    }

    public static Argument createArgument(LocalVarInfo localVarInfo) {
        return new Argument(localVarInfo.getName(), localVarInfo.getType());
    }

    private static List<Argument> createArguments(LocalVarInfo[] argumentLocalVars) {
        if (argumentLocalVars == null) {
            return Collections.emptyList();
        }

        List<Argument> arguments = new ArrayList<>();
        for (LocalVarInfo info : argumentLocalVars) {
            arguments.add(createArgument(info));
        }
        return arguments;
    }
}
