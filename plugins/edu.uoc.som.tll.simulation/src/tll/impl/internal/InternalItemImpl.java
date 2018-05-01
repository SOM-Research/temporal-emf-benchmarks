/**
 */
package tll.impl.internal;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tll.Area;
import tll.Component;
import tll.LocationHistoryEntry;
import tll.TllFactory;
import tll.TllPackage;
import tll.impl.ItemImpl;

public class InternalItemImpl extends ItemImpl {

	Adapter adapter = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			if (msg.getFeature().equals(TllPackage.eINSTANCE.getItem_Location())) {

				tll.System sys = ((tll.System) EcoreUtil.getRootContainer(InternalItemImpl.this));
				if (sys.getSimconfig().isRecordHistory()) {
					Component newLocation = (Component) msg.getNewValue();
					if (InternalItemImpl.this.getHLocation().isEmpty()) {
						LocationHistoryEntry lhe = TllFactory.eINSTANCE.createLocationHistoryEntry();
						lhe.setBegin(new Timestamp(new Date().getTime()));
						lhe.setHValue(newLocation);
						InternalItemImpl.this.getHLocation().add(lhe);
					} else {
						LocationHistoryEntry lhe = InternalItemImpl.this.getHLocation()
								.get(InternalItemImpl.this.getHLocation().size() - 1);
						lhe.setEnd(new Timestamp(new Date().getTime()));
						LocationHistoryEntry lhe2 = TllFactory.eINSTANCE.createLocationHistoryEntry();
						lhe2.setBegin(new Timestamp(new Date().getTime()));
						lhe2.setHValue(newLocation);
						InternalItemImpl.this.getHLocation().add(lhe2);
					}
				}

				if (sys.getSimconfig().isEnableLogging()) {
					Component newLocation = (Component) msg.getNewValue();
					if (newLocation != null) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-ms-SSS");
						String dateString = format.format(new Date());
						Area area = ((Area) InternalItemImpl.this.getLocation().eContainer());
						String x = "entered-/" + sys.getId() + "/" + area.getId() + "/" + newLocation.getId() + ","
								+ dateString + ",0.0.0.0," + InternalItemImpl.this.getId() + ",1,GET";
						area.getLog().add(x.toString());
					}
				}
			}
		};
	};

	public InternalItemImpl() {
		this.eAdapters().add(adapter);
	}
}
