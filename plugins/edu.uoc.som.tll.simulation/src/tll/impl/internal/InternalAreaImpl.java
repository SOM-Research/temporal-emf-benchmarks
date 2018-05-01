
package tll.impl.internal;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import tll.Component;
import tll.Item;
import tll.SimConfig;
import tll.TllFactory;
import tll.impl.AreaImpl;
import tll.time.TimeWatch;

public class InternalAreaImpl extends AreaImpl {
	
	private final long TLL_ITERATIONS_PERIOD = Long.parseLong(System.getenv("tll.iterations.period") != null ? System.getenv("tll.iterations.period") : "10000");
	private static final Logger LOG = Logger.getLogger(InternalAreaImpl.class.getName());

	private class IterationLogger extends Thread {
		private final String area;
		private final long period;
		private volatile boolean finish = false;
		private volatile int currentIteration = 0; 
		
		public IterationLogger(String area, long period) {
			this.area = area;
			this.period = period;
			this.setDaemon(true);
		}
		@Override
		public void run() {
			LOG.log(Level.FINER, "Logging numbers of iterations every " + period + " millisecons");
			while (!finish) {
				try {
					sleep(period);
					LOG.log(Level.FINER, "Running iteration " + currentIteration + " on " + area);
				} catch (InterruptedException e) {
					LOG.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
			LOG.log(Level.FINE, "Last iteration was " + currentIteration);
		}
	}
	
	@Override
	public void start() {
		// System.out.println("Start Area " + this.getId());

		SimConfig sim = ((tll.System) this.eContainer()).getSimconfig();

		if (sim.getTimeout() > 0) {
			TimeWatch global_watch = TimeWatch.start();
			TimeWatch watch = TimeWatch.start();

			while (true) {
				executeAssignment();

				this.itemGen(watch);

				streamNextItemToEntry();

				if (global_watch.time() > sim.getTimeout()) {
					// System.out.println("Time is up");

					// System.out.println("Process assigned items");
					postprocess();

					break;
				}
			}
		} else {
			IterationLogger logger = new IterationLogger(getId(), TLL_ITERATIONS_PERIOD);
			if (LOG.isLoggable(Level.FINE)) {
				logger.start();
			}
			
			int iter = sim.getIterations();

			for (int i = 0; i <= iter; i++) {
				
				logger.currentIteration = i;
				
				executeAssignment();

				this.getItemGen().genItem();

				streamNextItemToEntry();
			}
			
			logger.finish = true;

			// System.out.println("Iterations are done");

			postprocess();
		}
		// System.out.println("End Area" + this.getId());
	}

	private void streamNextItemToEntry() {
		if (this.getComponent().stream().filter(element -> element.getHosts() != null).count() == 0) {
			if (!this.getBuffer().getBufferedItems().isEmpty()) {
				Item item = this.getBuffer().getBufferedItems().get(0);
				item.setStartLocation(this.getBuffer().getEntry());
				this.getBuffer().getEntry().setHosts(item);
				this.getItem().add(item);
			}
		}
	}

	private void postprocess() {
		for (int i = 0; i < 500; i++) {
			List<Component> assignedComponents = this.getComponent().stream().filter(p -> p.getHosts() != null)
					.collect(Collectors.toList());
			if (!assignedComponents.isEmpty()) {
				executeAssignment();
			} else {
				break;
			}
		}
	}

	private void executeAssignment() {
		// find components with assigned items
		List<Component> assignedComponents = this.getComponent().stream().filter(p -> p.getHosts() != null)
				.collect(Collectors.toList());

		// strategy -> where to start to move items
		// default: from beginning to end
		// Collections.shuffle(assignedComponents);

		// ArrayList<Component> l = new ArrayList<Component>();
		// for(Component x : assignedComponents){
		// l.add(x);
		// }
		// Collections.shuffle(l);
		// assignedComponents = l;

		// Collections.reverse(assignedComponents);

		// try to move items
		assignedComponents.stream().forEach(element -> element.do_());
	}

	@Override
	public void itemGen(TimeWatch watch) {

		long passedTimeInMs = watch.time();

		java.lang.System.out.println(passedTimeInMs);

		// TODO shift this part into the ItemGen genItem() method
		if (passedTimeInMs > this.getItemGen().getFrequency()) {
			if (this.getBuffer().getEntry().getHosts() == null) {
				if (this.getBuffer().getBufferedItems().isEmpty()) {
					Item item = TllFactory.eINSTANCE.createItem();
					item.setIsProcessed(false);
					item.setId(UUID.randomUUID().toString());
					this.getItem().add(item);
					this.getBuffer().getEntry().setHosts(item);
				} else {
					this.getBuffer().getEntry().setHosts(this.getBuffer().getBufferedItems().get(0));
					this.getItem().add(this.getBuffer().getBufferedItems().get(0));
				}
			} else {
				Item item = TllFactory.eINSTANCE.createItem();
				item.setIsProcessed(false);
				item.setId(UUID.randomUUID().toString());
				this.getBuffer().getBufferedItems().add(item);
			}
			watch.reset();
		}
	}

}
