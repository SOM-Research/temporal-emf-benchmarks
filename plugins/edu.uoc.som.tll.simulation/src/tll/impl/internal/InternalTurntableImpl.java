/**
 */
package tll.impl.internal;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tll.Area;
import tll.Component;
import tll.impl.TurntableImpl;
import tll.time.TimeDelay;

public class InternalTurntableImpl extends TurntableImpl {

	@Override
	public void do_() {
		// System.out.println("Start transfer " + this.id);

		Area area = (Area) this.eContainer();
		if (this.getHosts().isIsProcessed() && this.equals(area.getStore().getExit())) {
			area.getItem().remove(this.getHosts());
			// System.out.println("Item " + this.getHosts().getId() + " is processed and is
			// now stored");
			tll.System sys = ((tll.System) EcoreUtil.getRootContainer(InternalTurntableImpl.this));
			if (sys.getSimconfig().isStoreProcessedItems()) {
				area.getStore().getFinalItems().add(this.getHosts());
			}
			this.setHosts(null);
			return;
		}

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
