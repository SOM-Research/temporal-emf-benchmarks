package test.original;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import edu.uoc.som.temf.TURI;
import edu.uoc.som.temf.core.TObject;
import edu.uoc.som.temf.core.TResource;
import tll.Component;
import tll.Item;
import tll.ItemHistoryEntry;
import tll.LocationHistoryEntry;
import tll.load.ModelLoader;
import tll.time.TimeWatch;

public class SimulateSingleArea {

	// @formatter:off
	private static final String Q0_FORMAT      = "  Q0 - Number of assigned items for {0}: {1}";
	private static final String Q1_FORMAT      = "  Q1 - Number of components at {0,time,HH:mm:ss.SSS}: {1}";
	private static final String Q2_FORMAT      = "  Q2 - Number of components between {0,time,HH:mm:ss.SSS} - {1,time,HH:mm:ss.SSS}: {2}";
	private static final String Q3_FORMAT      = "  Q3 - Utilization of {0}: {1}";
	private static final String ELAPSED_FORMAT = "       {0} ms";
	// @formatter:on
	
	@Test
	public void test() {

		long startTime = System.nanoTime();

		tll.System system = new ModelLoader().load("model/IAFPlantMultiArea_huge.xmi");

		if (system instanceof TObject) {
			TResource resource = (TResource) new ResourceSetImpl().getResource(
					TURI.createTHBaseURI("localhost", String.valueOf(java.lang.System.currentTimeMillis())),
					true);
			resource.getContents().add(system);
		}

		System.out.println("Simulation start: " + new Timestamp(System.currentTimeMillis()));
		system.simulate();
		System.out.println("Simulation end: " + new Timestamp(System.currentTimeMillis()));

		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("Execution time: " + elapsedTime);

		queryTemporalModel(system);
		
		//31030858514
		//10055051493
		//12994784573
		//3908929302
		//3684747185
		//6040390482
		
		//234910561373

	}

	private void queryTemporalModel(tll.System system) {

				long startQuery = System.currentTimeMillis();
		String machineId = "a1_m1";

		Timestamp instant = new Timestamp(startQuery - 4000);
		Timestamp instant1 = new Timestamp(startQuery - 3800);
		Timestamp instant2 = new Timestamp(startQuery - 3500);

		TimeWatch watch = TimeWatch.start();
		
		System.out.println("Metamodel-based queries");
		
		watch.reset();
		query0xmi(system, machineId);
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));

		watch.reset();
		query1xmi(system, instant);
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));

		watch.reset();
		query2xmi(system, instant1, instant2);
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));

		watch.reset();
		query3xmi(system, machineId);
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));

		System.out.println("HBase-based queries");

//		watch.reset();
//		query0klyo(system, machineId);
//		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));
//		
//		watch.reset();
//		query1klyo(system, instant);
//		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));
//		
//		watch.reset();
//		query2klyo(system, instant1, instant2);
//		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));
//		
//		watch.reset();
//		query3klyo(system, machineId);
//		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time(TimeUnit.SECONDS)));
		

	}

	/**
	 * Query all items which have been processed by m3
	 * 
	 * @param system
	 * @param machineId 
	 */
	private void query0xmi(tll.System system, String machineId) {
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
		
		System.out.println(MessageFormat.format(Q0_FORMAT, machineId, items.size()));
	}

	/**
	 * Find the components which have an Item assigned at a particular point in time
	 * 
	 * @param system
	 * @param date 
	 */
	private void query1xmi(tll.System system, Timestamp instant) {
		// query assigned component for one particular point in time
		ArrayList<Component> assignedComponents = new ArrayList<Component>();
		for(Item i : system.getArea().get(0).getStore().getFinalItems()) {
				for (LocationHistoryEntry lhe : i.getHLocation()) {
				if(lhe.getEnd() != null) {
		    		if(lhe.getBegin().before(instant) && lhe.getEnd().after(instant)) {
		    			assignedComponents.add(lhe.getHValue());
		    		}
				}
			}
		}
		
		System.out.println(MessageFormat.format(Q1_FORMAT, instant, assignedComponents.size()));
	}

	/**
	 * Find the {@link Component}s which had an {@link Item} assigned at any
	 * particular moment between two instants <code>instant1</code> and
	 * <code>instant2</code>
	 * 
	 * @param system
	 * @param instant2 
	 * @param instant1 
	 */
	private void query2xmi(tll.System system, Timestamp instant1, Timestamp instant2) {
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
		
		System.out.println(MessageFormat.format(Q2_FORMAT, instant1, instant2, assignedComponents.size()));
	}

	/**
	 * Compute the utilization of the specified {@link Component} for the whole
	 * system lifecycle
	 * 
	 * @param system
	 * @param machineId 
	 * @param machineId
	 */
	private void query3xmi(tll.System system, String machineId) {
		// component to check: retrieve the machine - should be parameter
		Component machine = system.getArea().get(0).getComponent().stream().filter(c -> machineId.equals(c.getId())).reduce((a, b) -> null).get();

		float withNull = 0;
		float withItem = 0;
		
		int i = 0;
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
		
		System.out.println(MessageFormat.format(Q3_FORMAT, machineId, withItem / (withNull + withItem)));
	}


//	/**
//	 * Query all items which have been processed by m3
//	 * 
//	 * @param system
//	 */
//	private void query0klyo(tll.System system, String machineId) {
//
//		// component to check
//		Area area = system.getArea().get(0);
//		Component machine = area.getComponent().stream().filter(c -> machineId.equals(c.getId())).reduce((a, b) -> null).get();
//
//		// @formatter:off
//		Set<Item> items = machine.eGetAllBetween(new Date(0), new Date(Long.MAX_VALUE), TllPackage.eINSTANCE.getComponent_Hosts())
//				.values()
//				.stream()
//				.filter(v -> v != null)
//				.map(i -> (Item) i)
//				.collect(Collectors.toSet());
//		// @formatter:on
//
//		System.out.println(MessageFormat.format(Q0_FORMAT, machineId, items.size()));
//	}
//
//	/**
//	 * Find the components which have an Item assigned at a particular point in time
//	 * 
//	 * @param system
//	 */
//	private void query1klyo(tll.System system, Timestamp instant) {
//
//		Area area = system.getArea().get(0);
//
////		{ // @formatter:off
////			
////			// This block may be commented
////			// The XMI-based query assumed that the plan layout was not changing, but if the
////			// plant was indeed changing, the queries below would allow us to obtain the
////			// right Components 'instant'
////			EList<Area> areas = (EList<Area>) system.eGetAt(instant, TllPackage.eINSTANCE.getSystem_Area());
////			Assert.assertEquals(area, areas.toArray()[0]);
////			
////			EList<Component> components = (EList<Component>) area.eGetAt(instant, TllPackage.eINSTANCE.getArea_Component());
////			Assert.assertEquals(area.getComponent(), components);
////		} // @formatter:on
//
//		// @formatter:off
//		Set<Component> assignedComponents = area.getComponent()
//				.stream()
//				.filter(c -> c.eGetAt(instant, TllPackage.eINSTANCE.getComponent_Hosts()) != null)
//				.collect(Collectors.toSet());
//		// @formatter:on
//
//		System.out.println(MessageFormat.format(Q1_FORMAT, instant, assignedComponents.size()));
//	}
//
//	/**
//	 * Find the {@link Component}s which had an {@link Item} assigned at any
//	 * particular moment between two instants <code>instant1</code> and
//	 * <code>instant2</code>
//	 * 
//	 * @param system
//	 */
//	private void query2klyo(tll.System system, Timestamp instant1, Timestamp instant2) {
//
//		Area area = system.getArea().get(0);
//
////		{ // @formatter:off
////			
////			// This block may be commented
////			// The XMI-based query assumed that the plan layout was not changing, but if the
////			// plant was indeed changing, the queries below would allow us to obtain the
////			// right Components that were available between 'instant1' and 'instant2'
////			Map<Date, Object> areasMap = (Map<Date, Object>) system.eGetAllBetween(instant1, instant2, TllPackage.eINSTANCE.getSystem_Area());
////			Set<Area> areas = areasMap.values().stream().map(o -> (EList<Area>) o).map(l -> l.get(0)).collect(Collectors.toSet());
////			Assert.assertEquals(1, areas.size(), 1);
////			Assert.assertEquals(area, areas.toArray()[0]);
////			
////			Map<Date, Object> componentsMap = (Map<Date, Object>) area.eGetAllBetween(instant1, instant2, TllPackage.eINSTANCE.getArea_Component());
////			Set<Component> components = componentsMap.values().stream().map(o -> (EList<Component>) o).flatMap(EList::stream).collect(Collectors.toSet());
////			Assert.assertEquals(components, new HashSet<>(area.getComponent()));
////		} // @formatter:on
//
//		// @formatter:off
//		Set<Component> assignedComponents = area.getComponent().stream()
//				.filter(c -> 
//						c.eGetAllBetween(instant1, instant2, TllPackage.eINSTANCE.getComponent_Hosts())
//						.values()
//						.stream()
//						.anyMatch(v -> v != null)
//						)
//				.collect(Collectors.toSet());
//		// @formatter:on
//
//		System.out.println(MessageFormat.format(Q2_FORMAT, instant1, instant2, assignedComponents.size()));
//	}
//
//	/**
//	 * Compute the utilization of the specified {@link Component} for the whole
//	 * system lifecycle
//	 * 
//	 * @param system
//	 * @param machineId
//	 */
//	private void query3klyo(tll.System system, String machineId) {
//		// component to check
//		Area area = system.getArea().get(0);
//		Component machine = area.getComponent().stream().filter(c -> machineId.equals(c.getId())).reduce((a, b) -> null)
//				.get();
//
//		float withNull = 0;
//		float withItem = 0;
//
//		SortedMap<Date, Object> items = machine.eGetAllBetween(new Date(0), new Date(Long.MAX_VALUE),
//				TllPackage.eINSTANCE.getComponent_Hosts());
//
//		Assert.assertFalse(items.isEmpty());
//		
//		Entry<Date, Object> prevEntry = items.entrySet().iterator().next();
//		
//		int i = 0;
//		
//		for (Entry<Date, Object> entry : items.entrySet()) {
//			Item item = (Item) prevEntry.getValue();
//
//			long lapse = entry.getKey().getTime() - prevEntry.getKey().getTime();
//
////			System.out.println(MessageFormat.format("{0,number,0000} {1} [{2,number,0000}ms]: {3,time,HH:mm:ss.SSS}-{4,time,HH:mm:ss.SSS}",
////					i++, item != null ? "busy" : "free", lapse, prevEntry.getKey(), entry.getKey()));
//
//			if (item == null) {
//				withNull += lapse;
//			} else {
//				withItem += lapse;
//			}
//			prevEntry = entry;
//		}
//
//		// relate the time spans
//		System.out.println(MessageFormat.format(Q3_FORMAT, machineId, withItem / (withNull + withItem)));
//	}

}
