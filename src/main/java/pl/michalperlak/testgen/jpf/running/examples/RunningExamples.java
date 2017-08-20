package pl.michalperlak.testgen.jpf.running.examples;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.symbc.SymbolicListener;
import pl.michalperlak.testgen.TestDataGenerator;
import pl.michalperlak.testgen.jpf.listeners.PathConditionListener;
import pl.michalperlak.testgen.model.IPathCondition;
import pl.michalperlak.testgen.model.Method;
import pl.michalperlak.testgen.jpf.PathConditionImpl;
import pl.michalperlak.testgen.model.TestData;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class RunningExamples {
    public static void main(String[] args) {
        runSymbolicExample(args);
    }

    private static void runSymbolicExample(String[] args) {
        String[] argsCopy = new String[]{Paths
                .get(args[0])
                .toAbsolutePath().toString()};
        Config config = JPF.createConfig(argsCopy);
        JPF jpf = new JPF(config);
        jpf.addListener(new SymbolicListener(config, jpf));
        PathConditionListener pathConditionListener = new PathConditionListener();
        jpf.addListener(pathConditionListener);
        jpf.run();

        ConcurrentMap<Method, Set<IPathCondition>> conditions = pathConditionListener.getConditions();
        Optional<Method> testedMethod = conditions
                .keySet()
                .stream()
                .filter(method -> "testMe2".equals(method.getShortName()))
                .findFirst();

        if (!testedMethod.isPresent()) {
            return;
        }

        TestDataGenerator testDataGenerator = new TestDataGenerator();
        List<TestData> testData = testDataGenerator.processMethod(conditions.getOrDefault(testedMethod.get(), Collections.emptySet()));

        System.out.println("---------------------------------------------");
        System.out.println(testData);
    }

//    private static void runWithRunner() throws URISyntaxException {
//        Path configFile = Paths.get(RunningExamples.class
//                .getResource("/configs/racer.properties")
//                .toURI());
//        System.out.println(configFile);
//        JpfRunner runner = new JpfRunner(configFile, Racer.class);
//        Config config = runner.createConfig();
//        PreciseRaceDetector raceDetector = new PreciseRaceDetector(config);
//        runner.addListeners(raceDetector);
//        runner.run(config);
//    }

}
