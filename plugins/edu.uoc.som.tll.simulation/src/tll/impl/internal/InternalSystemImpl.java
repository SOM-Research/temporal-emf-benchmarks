/**
 */
package tll.impl.internal;

import tll.impl.SystemImpl;

public class InternalSystemImpl extends SystemImpl {

	@Override
	public void simulate() {
		// System.out.println("Start SIM");

		this.getArea().stream().forEach(element -> element.start());

		// System.out.println("End SIM");

//		new ModelStore().store(EcoreUtil.copy(this), "sim-resul/simOutput.xmi");
//		try {
//			PrintWriter writer = new PrintWriter("model/log.csv", "UTF-8");
//			this.getArea().stream().forEach(area -> area.getLog().forEach(logEntry -> writer.println(logEntry)));
//			writer.close();
//		} catch (IOException e) {
//			// do something
//		}
	}

}
