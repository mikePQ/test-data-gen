package pl.michalperlak.testgen.jpf.running;

import gov.nasa.jpf.JPFListener;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class JpfConfig {
    private final Path configPath;
    private final Class<?> classToRun;
    private final Set<JPFListener> jpfListeners = new HashSet<>();

    public JpfConfig(Path configPath, Class<?> classToRun) {
        this.configPath = configPath;
        this.classToRun = classToRun;
    }

    public Class<?> getClassToRun() {
        return classToRun;
    }

    public String[] getRunArguments() {
        return createArguments();
    }

    public Iterable<JPFListener> getListeners() {
        return jpfListeners;
    }

    private String[] createArguments() {
        return new String[] { configPath.toAbsolutePath().toString() };
    }
}
