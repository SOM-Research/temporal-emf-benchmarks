/**
 */
package tll.impl.internal;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tll.Component;
import tll.Item;
import tll.ItemHistoryEntry;
import tll.TllFactory;
import tll.TllPackage;
import tll.impl.MachineImpl;
import tll.time.TimeDelay;

public class InternalMachineImpl extends MachineImpl {

	Adapter adapter = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			if (msg.getFeature().equals(TllPackage.eINSTANCE.getComponent_Hosts())) {
				Item newItem = (Item) msg.getNewValue();

				tll.System sys = ((tll.System) EcoreUtil.getRootContainer(InternalMachineImpl.this));
				if (sys.getSimconfig().isRecordHistory()) {
					if (InternalMachineImpl.this.getHHosts().isEmpty()) {
						ItemHistoryEntry ihe = TllFactory.eINSTANCE.createItemHistoryEntry();
						ihe.setBegin(new Timestamp(new Date().getTime()));
						ihe.setHValue(newItem);
						InternalMachineImpl.this.getHHosts().add(ihe);
					} else {
						ItemHistoryEntry ihe = InternalMachineImpl.this.getHHosts()
								.get(InternalMachineImpl.this.getHHosts().size() - 1);
						ihe.setEnd(new Timestamp(new Date().getTime()));
						ItemHistoryEntry ihe2 = TllFactory.eINSTANCE.createItemHistoryEntry();
						ihe2.setBegin(new Timestamp(new Date().getTime()));
						ihe2.setHValue(newItem);
						InternalMachineImpl.this.getHHosts().add(ihe2);
					}
				}
			}
		};
	};

	public InternalMachineImpl() {
		this.eAdapters().add(adapter);
	}

	@Override
	public void do_() {
		// System.out.println("Start transfer " + this.id);

		this.getHosts().setIsProcessed(true);

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
