/**
 */
package tll.impl.internal;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import tll.Area;
import tll.Item;
import tll.TllFactory;
import tll.impl.ItemGeneratorImpl;

public class InternalItemGeneratorImpl extends ItemGeneratorImpl {

	@Override
	public void genItem() {
		try {
			TimeUnit.MILLISECONDS.sleep(this.getFrequency());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Area area = (Area) this.eContainer();
		if (area.getBuffer().getEntry().getHosts() == null) {
			if (area.getBuffer().getBufferedItems().isEmpty()) {
				Item item = TllFactory.eINSTANCE.createItem();
				item.setIsProcessed(false);
				item.setId(UUID.randomUUID().toString());
				area.getItem().add(item);
				area.getBuffer().getEntry().setHosts(item);
			} else {
				area.getBuffer().getEntry().setHosts(area.getBuffer().getBufferedItems().get(0));
				area.getItem().add(area.getBuffer().getBufferedItems().get(0));
			}
		} else {
			Item item = TllFactory.eINSTANCE.createItem();
			item.setIsProcessed(false);
			item.setId(UUID.randomUUID().toString());
			area.getBuffer().getBufferedItems().add(item);
		}
	}

}
