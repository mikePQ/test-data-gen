package pl.michalperlak.testgen.jpf.running.examples;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.symbc.SymbolicListener;
import pl.michalperlak.testgen.TestDataGenerator;
import pl.michalperlak.testgen.jpf.listeners.PathConditionListener;
import pl.michalperlak.testgen.model.Method;
import pl.michalperlak.testgen.model.PathCondition;

import java.nio.file.Paths;
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

        ConcurrentMap<Method, Set<PathCondition>> conditions = pathConditionListener.getConditions();
        System.out.println("%%%%%" + conditions);

        TestDataGenerator testDataGenerator = new TestDataGenerator();
//        testDataGenerator.processMethod()
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
