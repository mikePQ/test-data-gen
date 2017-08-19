package pl.michalperlak.testgen.jpf.listeners;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.*;
import pl.michalperlak.testgen.jpf.ModelUtil;
import pl.michalperlak.testgen.model.Method;
import pl.michalperlak.testgen.model.PathCondition;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PathConditionListener extends ListenerAdapter {
    private ConcurrentMap<Method, Set<PathCondition>> conditions = new ConcurrentHashMap<>();

    @Override
    public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction, Instruction executedInstruction) {
        Method method = ModelUtil.createMethod(executedInstruction.getMethodInfo());
        Set<PathCondition> pathConditions = conditions.get(method);
        if (pathConditions == null) {
            pathConditions = new HashSet<>();
        }
        conditions.putIfAbsent(method, pathConditions);

        gov.nasa.jpf.symbc.numeric.PathCondition pc = gov.nasa.jpf.symbc.numeric.PathCondition.getPC(vm);
        if (pc != null) {
            if (pc.header != null) {
                pathConditions.add(new PathCondition(pc.header.toString()));
            }
        }
    }

    public ConcurrentMap<Method, Set<PathCondition>> getConditions() {
        return conditions;
    }
}
