package test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import tll.Component;
import tll.Item;
import tll.ItemHistoryEntry;
import tll.LocationHistoryEntry;

public class SimulateXmi extends Simulate {

	
	public static void main(String[] args) throws IOException {
		new SimulateXmi().run(args[0]);
	}

	@Override
	protected Resource getResource(String modelName) throws IOException {
		Resource resource = new ResourceSetImpl().createResource(URI.createFileURI("sim-results/" + modelName + ".xmi"));
		return resource;
	}

	@Override
	protected void configure(tll.System system) {
//		system.getSimconfig().setEnableLogging(true);
//		system.getSimconfig().setRecordHistory(true);
//		system.getSimconfig().setStoreProcessedItems(true);
	}
	
	@Override
	protected void query(tll.System system) {
		System.out.println("Metamodel-based queries");
		super.query(system);
	}
	
	@Override
	protected Set<Item> query0(tll.System system, String machineId) {
		// query all items which have been processed by m3
		Set<Item> items = new HashSet<Item>();
		
		// component to check
		Component machine = system.getArea().get(0).getComponent().stream().filter(c -> machineId.equals(c.getId())).reduce((a, b) -> null).get();
		
		for(Item i : system.getArea().get(0).getStore().getFinalItems()) {
			for (LocationHistoryEntry lhe : i.getHLocation()) {
				if(lhe.getEnd() != null) {
		    		if(lhe.getHValue().equals(machine)) {
		    			items.add((Item)lhe.eContainer());
		    		}
				}
			}
		}
		return items;
	}

	@Override
	protected Set<Component> query1(tll.System system, Timestamp instant) {
		// query assigned component for one particular point in time
		Set<Component> assignedComponents = new HashSet<Component>();
		for(Item i : system.getArea().get(0).getStore().getFinalItems()) {
				for (LocationHistoryEntry lhe : i.getHLocation()) {
				if(lhe.getEnd() != null) {
		    		if(lhe.getBegin().before(instant) && lhe.getEnd().after(instant)) {
		    			assignedComponents.add(lhe.getHValue());
		    		}
				}
			}
		}
		
		return assignedComponents;
	}

	@Override
	protected Set<Component> query2(tll.System system, Timestamp instant1, Timestamp instant2) {
		// query assigned components for one particular time span T1-T2
		Set<Component> assignedComponents = new HashSet<>();
		
		for(Item i : system.getArea().get(0).getStore().getFinalItems()) {
			for (LocationHistoryEntry lhe : i.getHLocation()) {
				if(lhe.getEnd() != null) {
		    		if(lhe.getBegin().after(instant1) && lhe.getEnd().before(instant2)) {
		    			assignedComponents.add(lhe.getHValue());
		    		}
				}
			}
		}
		
		return assignedComponents;
	}

	@Override	
	protected float query3(tll.System system, String machineId) {
		// component to check: retrieve the machine - should be parameter
		Component machine = system.getArea().get(0).getComponent().stream().filter(c -> machineId.equals(c.getId())).reduce((a, b) -> null).get();

		float withNull = 0;
		float withItem = 0;
		
//		int i = 0;
		for (ItemHistoryEntry ihe : machine.getHHosts()) {
			
			if(ihe.getEnd() == null) continue;
			
			long lapse = ihe.getEnd().getTime() - ihe.getBegin().getTime();
			
//			System.out.println(MessageFormat.format("{0,number,0000} {1} [{2,number,0000}ms]: {3,time,HH:mm:ss.SSS}-{4,time,HH:mm:ss.SSS}",
//					i++, ihe.getHValue() != null ? "busy" : "free", lapse, ihe.getBegin(), ihe.getEnd()));
			
			if (ihe.getHValue() != null) {
				withItem += lapse;
			} else {
				withNull += lapse;
			}
		}
		
		// compute the time spans of both sets. 
		
		// relate the time spans
		
		return withItem / (withNull + withItem);
	}

}
