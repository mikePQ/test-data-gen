package pl.michalperlak.testgen.jpf.running;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.JPFListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JpfRunner {

	public void run(JpfConfig config) {
	    Config jpfConfig = JPF.createConfig(config.getRunArguments());
		JPF jpf = new JPF(jpfConfig);
		addJpfListeners(jpf, config.getListeners());
		jpf.run();

		invokeMain(config.getClassToRun(), config.getRunArguments());
	}

    private void addJpfListeners(JPF jpf, Iterable<JPFListener> jpfListeners) {
        for (JPFListener listener : jpfListeners) {
            jpf.addListener(listener);
        }
    }

	private void invokeMain(Class<?> clazz, String[] args) {
		try {
			Method method = clazz.getMethod("main", String[].class);
			method.invoke(null, (Object) args);
		}
		catch (IllegalAccessException | InvocationTargetException |
				NoSuchMethodException e) {
			e.printStackTrace();
			//TODO handle properly
		}
	}


}
