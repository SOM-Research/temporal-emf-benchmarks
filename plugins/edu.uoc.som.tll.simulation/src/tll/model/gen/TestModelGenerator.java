package tll.model.gen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import tll.Area;
import tll.SimConfig;
import tll.TllFactory;
import tll.load.ModelLoader;
import tll.store.ModelStore;

public class TestModelGenerator {

	public static void main(String[] args) {
		scaleUpModel("_middle",  10,   200);
		scaleUpModel("_large",  100,  2000);
		scaleUpModel("_huge",   100, 20000);
	}

	private static void scaleUpModel(String size, int patternInstantiated, int iterations) {
		tll.System systemToClone = new ModelLoader().load("model/IAFPlantSingleArea.xmi");
		
		tll.System sys = TllFactory.eINSTANCE.createSystem();
		
		SimConfig simconfig = TllFactory.eINSTANCE.createSimConfig();
		simconfig.setTimeout(-1);
		simconfig.setIterations(iterations);
		sys.setSimconfig(simconfig);
		sys.setId(size);
		
		Area areaToClone = systemToClone.getArea().get(0);
		
		for (int i = 0; i < patternInstantiated; i++) {
			Copier copier = new Copier();
			EObject result = copier.copy(areaToClone);
			copier.copyReferences();
			sys.getArea().add((Area) result);
		}
		
		new ModelStore().store(sys, "model/IAFPlantMultiArea" + size + ".xmi");
	}

}
