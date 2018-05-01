package test.original;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import edu.uoc.som.temf.TURI;
import edu.uoc.som.temf.core.TObject;
import edu.uoc.som.temf.core.TResource;
import tll.load.ModelLoader;

public class SimulateMultipleAreas {

	@Test
	public void test() {
		
		long startTime = System.nanoTime();
		
		tll.System system = new ModelLoader().load("model/IAFPlantMultipleAreas.xmi");

		if (system instanceof TObject) {
			TResource resource = (TResource) new ResourceSetImpl().getResource(TURI.createTHBaseURI("localhost", String.valueOf(java.lang.System.currentTimeMillis())), true);
			resource.getContents().add(system);
		}
		
		system.simulate();
		
	    long stopTime = System.nanoTime();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
	}

}
