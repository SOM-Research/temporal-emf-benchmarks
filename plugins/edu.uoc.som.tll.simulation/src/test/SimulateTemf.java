package test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Assert;

import edu.uoc.som.temf.TURI;
import edu.uoc.som.temf.core.TResourceFactory;
import tll.Area;
import tll.Component;
import tll.Item;
import tll.TllPackage;

public class SimulateTemf extends Simulate {

	private static final String HBASE_SERVER = System.getenv("hbase.server") != null ? System.getenv("hbase.server") : "localhost";
	
	{
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put(TURI.TEMF_HBASE_SCHEME, TResourceFactory.eINSTANCE);
	}
	
	public static void main(String[] args) throws IOException {
		new SimulateTemf().run(args[0]);
	}
	
	@Override
	protected Resource getResource(String modelName) throws IOException {
		Resource resource = new ResourceSetImpl().createResource(TURI.createTHBaseURI(HBASE_SERVER, modelName));
		resource.load(Collections.emptyMap());
		return resource;
	}

	@Override
	protected void configure(tll.System system) {
//		system.getSimconfig().setEnableLogging(false);
//		system.getSimconfig().setRecordHistory(false);
//		system.getSimconfig().setStoreProcessedItems(false);
	}
	
	@Override
	protected void query(tll.System system) {
		System.out.println("HBase-based queries");
		super.query(system);
	}
	

	@Override
	protected Set<Item> query0(tll.System system, String machineId) {

		// component to check
		Area area = system.getArea().get(0);
		Component machine = area.getComponent().stream().filter(c -> machineId.equals(c.getId())).reduce((a, b) -> null).get();

		// @formatter:off
		Set<Item> items = machine.eGetAllBetween(new Date(0), new Date(Long.MAX_VALUE), TllPackage.eINSTANCE.getComponent_Hosts())
				.values()
				.parallelStream()
				.filter(v -> v != null)
				.map(i -> (Item) i)
				.collect(Collectors.toSet());
		// @formatter:on

		return items;
	}

	@Override
	protected Set<Component> query1(tll.System system, Timestamp instant) {

		Area area = system.getArea().get(0);

//		{ // @formatter:off
//			
//			// This block may be commented
//			// The XMI-based query assumed that the plan layout was not changing, but if the
//			// plant was indeed changing, the queries below would allow us to obtain the
//			// right Components 'instant'
//			EList<Area> areas = (EList<Area>) system.eGetAt(instant, TllPackage.eINSTANCE.getSystem_Area());
//			Assert.assertEquals(area, areas.toArray()[0]);
//			
//			EList<Component> components = (EList<Component>) area.eGetAt(instant, TllPackage.eINSTANCE.getArea_Component());
//			Assert.assertEquals(area.getComponent(), components);
//		} // @formatter:on

		// @formatter:off
		Set<Component> assignedComponents = area.getComponent()
				.stream()
				.filter(c -> c.eGetAt(instant, TllPackage.eINSTANCE.getComponent_Hosts()) != null)
				.collect(Collectors.toSet());
		// @formatter:on

		return assignedComponents;
	}

	@Override
	protected Set<Component> query2(tll.System system, Timestamp instant1, Timestamp instant2) {

		Area area = system.getArea().get(0);

//		{ // @formatter:off
//			
//			// This block may be commented
//			// The XMI-based query assumed that the plan layout was not changing, but if the
//			// plant was indeed changing, the queries below would allow us to obtain the
//			// right Components that were available between 'instant1' and 'instant2'
//			Map<Date, Object> areasMap = (Map<Date, Object>) system.eGetAllBetween(instant1, instant2, TllPackage.eINSTANCE.getSystem_Area());
//			Set<Area> areas = areasMap.values().stream().map(o -> (EList<Area>) o).map(l -> l.get(0)).collect(Collectors.toSet());
//			Assert.assertEquals(1, areas.size(), 1);
//			Assert.assertEquals(area, areas.toArray()[0]);
//			
//			Map<Date, Object> componentsMap = (Map<Date, Object>) area.eGetAllBetween(instant1, instant2, TllPackage.eINSTANCE.getArea_Component());
//			Set<Component> components = componentsMap.values().stream().map(o -> (EList<Component>) o).flatMap(EList::stream).collect(Collectors.toSet());
//			Assert.assertEquals(components, new HashSet<>(area.getComponent()));
//		} // @formatter:on

		// @formatter:off
		Set<Component> assignedComponents = area.getComponent().stream()
				.filter(c -> 
						c.eGetAllBetween(instant1, instant2, TllPackage.eINSTANCE.getComponent_Hosts())
						.values()
						.stream()
						.anyMatch(v -> v != null)
						)
				.collect(Collectors.toSet());
		// @formatter:on

		return assignedComponents;
	}

	/**
	 * Compute the utilization of the specified {@link Component} for the whole
	 * system lifecycle
	 * 
	 * @param system
	 * @param machineId
	 */
	@Override
	protected float query3(tll.System system, String machineId) {
		// component to check
		Area area = system.getArea().get(0);
		Component machine = area.getComponent().stream().filter(c -> machineId.equals(c.getId())).reduce((a, b) -> null)
				.get();

		float withNull = 0;
		float withItem = 0;

		SortedMap<Date, Object> items = machine.eGetAllBetween(new Date(0), new Date(Long.MAX_VALUE),
				TllPackage.eINSTANCE.getComponent_Hosts());

		Assert.assertFalse(items.isEmpty());
		
		Entry<Date, Object> prevEntry = items.entrySet().iterator().next();
		
//		int i = 0;
		
		for (Entry<Date, Object> entry : items.entrySet()) {
			Item item = (Item) prevEntry.getValue();

			long lapse = entry.getKey().getTime() - prevEntry.getKey().getTime();

//			System.out.println(MessageFormat.format("{0,number,0000} {1} [{2,number,0000}ms]: {3,time,HH:mm:ss.SSS}-{4,time,HH:mm:ss.SSS}",
//					i++, item != null ? "busy" : "free", lapse, prevEntry.getKey(), entry.getKey()));

			if (item == null) {
				withNull += lapse;
			} else {
				withItem += lapse;
			}
			prevEntry = entry;
		}

		// relate the time spans
		return withItem / (withNull + withItem);
	}

}
