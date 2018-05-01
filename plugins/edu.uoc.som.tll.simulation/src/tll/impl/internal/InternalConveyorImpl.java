/**
 */
package tll.impl.internal;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import tll.Component;
import tll.impl.ConveyorImpl;
import tll.time.TimeDelay;

public class InternalConveyorImpl extends ConveyorImpl {

	@Override
	public void do_() {
		// System.out.println("Start transfer " + this.id);

		EList<Component> neighbours = this.getNeighbour();
		ArrayList<Component> tempList = new ArrayList<Component>();
		neighbours.forEach(element -> tempList.add(element));

		for (Component neighbour : tempList) {
			if (neighbour.getHosts() == null) {
				neighbour.setHosts(this.getHosts());
				neighbour.getHosts().getHistory().add(neighbour);
				this.setHosts(null);
				// System.out.println("Transfer from " + this.getId() + " to " +
				// neighbour.getId());
				break;
			}
		}
		
		TimeDelay.simulateProcessingTime(this);
		
		//System.out.println("End transfer " + this.id);
	}
}
