package test.original;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import edu.uoc.som.temf.TURI;
import edu.uoc.som.temf.core.TObject;
import edu.uoc.som.temf.core.TResource;
import tll.Area;
import tll.Item;
import tll.ItemGenerator;
import tll.SimConfig;
import tll.StorageQueue;
import tll.System;
import tll.TllFactory;
import tll.Turntable;
import tll.WaitingQueue;;

public class SimulateOneItemInMemory {

	@Test
	public void test() {
		
		System system = TllFactory.eINSTANCE.createSystem();

		if (system instanceof TObject) {
			TResource resource = (TResource) new ResourceSetImpl().getResource(TURI.createTHBaseURI("localhost", String.valueOf(java.lang.System.currentTimeMillis())), true);
			resource.getContents().add(system);
		}
					
		system.setId("ViennaVirtualPlant");
		
		// very short simulation time to just route one element
		SimConfig simconfig = TllFactory.eINSTANCE.createSimConfig();
		simconfig.setTimeout(100);
		system.setSimconfig(simconfig);
		
		Area area = TllFactory.eINSTANCE.createArea();
		area.setId("area1");
		system.getArea().add(area);
		
		// very slow generator to not produce input items
		ItemGenerator ig = TllFactory.eINSTANCE.createItemGenerator();
		ig.setFrequency(1000000);
		area.setItemGen(ig);
		
		// create waiting queue and add one item
		WaitingQueue wqb = TllFactory.eINSTANCE.createWaitingQueue();
		wqb.setProcessingTime(20);
		wqb.setId("buffer");
		area.setBuffer(wqb);
		area.getComponent().add(wqb);
		wqb.setUncertainty(2);
		
		Item i = TllFactory.eINSTANCE.createItem();
		i.setId("item1");
		i.setIsProcessed(true);
		wqb.getBufferedItems().add(i);
		
		Turntable t = TllFactory.eINSTANCE.createTurntable();
		t.setId("t1");
		t.setProcessingTime(1);
		t.setUncertainty(1);
		area.getComponent().add(t);
		wqb.setEntry(t);

		Turntable t2 = TllFactory.eINSTANCE.createTurntable();
		t2.setId("t2");
		t2.setProcessingTime(1);
		t2.setUncertainty(1);
		area.getComponent().add(t2);
		t.getNeighbour().add(t2);

		Turntable t3 = TllFactory.eINSTANCE.createTurntable();
		t3.setId("t3");
		t3.setProcessingTime(1);
		t3.setUncertainty(1);
		area.getComponent().add(t3);
		t2.getNeighbour().add(t3);

		StorageQueue sq = TllFactory.eINSTANCE.createStorageQueue();
		sq.setProcessingTime(10);
		sq.setUncertainty(2);
		sq.setId("store");
		sq.setExit(t3);
		area.setStore(sq);
		area.getComponent().add(sq);
		
		system.simulate();
		
		java.lang.System.out.println("--------------");
		java.lang.System.out.println("Items finally ended in store: ");
		java.lang.System.out.println(((Area)system.getArea().get(0)).getStore().getFinalItems());
	}
}
