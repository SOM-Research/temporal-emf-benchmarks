package test;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Descriptor;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import tll.Component;
import tll.Item;
import tll.TllPackage;
import tll.impl.internal.InternalTllFactoryImpl;
import tll.load.ModelLoader;
import tll.time.TimeWatch;

public abstract class Simulate {

	private static final long TLL_MEMORY_PERIOD = Long.parseLong(System.getenv("tll.memory.period") != null ? System.getenv("tll.memory.period") : "60000");
	private static final Logger LOG = Logger.getLogger(Simulate.class.getName());

	private class MemoryLogger extends Thread {
		private final long period;
		private volatile boolean finish = false;
		
		public MemoryLogger(long period) {
			this.period = period;
		}
		
		@Override
		public void run() {
			LOG.log(Level.FINER, "Logging memory usage every " + period + " millisecons");
			while (!finish) {
				try {
					sleep(period);
					LOG.log(Level.FINER, MessageFormat.format("Using {0} MB out of {1} MB", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576, Runtime.getRuntime().totalMemory() / 1048576));
				} catch (InterruptedException e) {
					LOG.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
			LOG.log(Level.FINER, "Leaving memory monitor thread");
		}
	}
	
	
	// @formatter:off
	protected static final String Q0_FORMAT      = "  Q0 - Number of assigned items for {0}: {1}";
	protected static final String Q1_FORMAT      = "  Q1 - Number of components at {0,time,HH:mm:ss.SSS}: {1}";
	protected static final String Q2_FORMAT      = "  Q2 - Number of components between {0,time,HH:mm:ss.SSS} - {1,time,HH:mm:ss.SSS}: {2}";
	protected static final String Q3_FORMAT      = "  Q3 - Utilization of {0}: {1}";
	protected static final String ELAPSED_FORMAT = "       {0} ms";
	// @formatter:on
	
	{
		Registry.INSTANCE.put(TllPackage.eNS_URI, new Descriptor() {
			public EPackage getEPackage() {
				return TllPackage.eINSTANCE;
			}

			public EFactory getEFactory() {
				return new InternalTllFactoryImpl();
			}
		});
	}
	
	@Test
	public void test() throws IOException {
		String path = "test-instances/IAFPlantMultiArea_middle.xmi";
		run(path);
	}

	protected void run(String path) throws IOException {
		MemoryLogger logger = new MemoryLogger(TLL_MEMORY_PERIOD);
		if (LOG.isLoggable(Level.FINE)) {
			logger.start();
		}
		try {
			tll.System system = new ModelLoader().load(path);
			configure(system);
			simulate(system);
			query(system);
		} finally {
			logger.finish = true;
		}
	}
	
	protected abstract void configure(tll.System system);

	protected void simulate(tll.System system) throws IOException {
		
		long startTime = System.nanoTime();
		
		System.out.println("Loading " + system.eResource().getURI().toString());
		Resource resource = getResource(String.valueOf(System.currentTimeMillis()));
		resource.getContents().add(system);
		
		System.out.println("Simulating " + resource.getURI().toString());
		
		TimeWatch watch = TimeWatch.start();
		
		System.out.println("Simulation start: " + new Timestamp(System.currentTimeMillis()));
		system.simulate();
		System.out.println("Simulation end: " + new Timestamp(System.currentTimeMillis()));
		System.out.println("Simulation time: " + watch.time());
		
		watch.reset();

		LOG.log(Level.FINER, "Requesting GC");
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		LOG.log(Level.FINER, MessageFormat.format("Using {0} MB out of {1} MB before saving", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576, Runtime.getRuntime().totalMemory() / 1048576));
		resource.save(Collections.emptyMap());
		System.out.println("Save time: " + watch.time());
		LOG.log(Level.FINER, "Requesting GC");
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		LOG.log(Level.FINER, MessageFormat.format("Using {0} MB out of {1} MB after saving", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576, Runtime.getRuntime().totalMemory() / 1048576));

		long stopTime = System.nanoTime();
		System.out.println("Total time: " + (stopTime - startTime) / 1000000);
	}

	protected void query(tll.System system) {

		long startQuery = System.currentTimeMillis();
		String machineId = "a1_m1";

		Timestamp instant = new Timestamp(startQuery - 4000);
		Timestamp instant1 = new Timestamp(startQuery - 3800);
		Timestamp instant2 = new Timestamp(startQuery - 3500);

		TimeWatch watch = TimeWatch.start();
		
		watch.reset();
		Set<Item> q0 = query0(system, machineId);
		System.out.println(MessageFormat.format(Q0_FORMAT, machineId, q0.size()));
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));
		
		watch.reset();
		Collection<Component> q1 = query1(system, instant);
		System.out.println(MessageFormat.format(Q1_FORMAT, instant, q1.size()));
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));
		
		watch.reset();
		Set<Component> q2 = query2(system, instant1, instant2);
		System.out.println(MessageFormat.format(Q2_FORMAT, instant1, instant2, q2.size()));
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));
		
		watch.reset();
		float q3 = query3(system, machineId);
		System.out.println(MessageFormat.format(Q3_FORMAT, machineId, q3));
		System.out.println(MessageFormat.format(ELAPSED_FORMAT, watch.time()));
		

	}
	
	protected abstract Resource getResource(String modelName) throws IOException;

	/**
	 * Query all items which have been processed by m3
	 * 
	 * @param system
	 * @return 
	 */
	protected abstract Set<Item> query0(tll.System system, String machineId);

	/**
	 * Find the components which have an Item assigned at a particular point in time
	 * 
	 * @param system
	 * @return 
	 */
	protected abstract Set<Component> query1(tll.System system, Timestamp instant);

	/**
	 * Find the {@link Component}s which had an {@link Item} assigned at any
	 * particular moment between two instants <code>instant1</code> and
	 * <code>instant2</code>
	 * 
	 * @param system
	 */
	protected abstract Set<Component> query2(tll.System system, Timestamp instant1, Timestamp instant2);
	
	/**
	 * Compute the utilization of the specified {@link Component} for the whole
	 * system lifecycle
	 * 
	 * @param system
	 * @param machineId
	 */
	protected abstract float query3(tll.System system, String machineId);

}
