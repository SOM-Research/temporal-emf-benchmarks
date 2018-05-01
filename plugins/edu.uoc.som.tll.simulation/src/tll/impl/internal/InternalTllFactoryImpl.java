package tll.impl.internal;

import tll.Area;
import tll.Conveyor;
import tll.Item;
import tll.ItemGenerator;
import tll.Machine;
import tll.System;
import tll.Turntable;
import tll.impl.TllFactoryImpl;

public class InternalTllFactoryImpl extends TllFactoryImpl {

	public InternalTllFactoryImpl() {
		super();
	}

	@Override
	public Area createArea() {
		return new InternalAreaImpl();
	}

	@Override
	public Conveyor createConveyor() {
		return new InternalConveyorImpl();
	}

	@Override
	public ItemGenerator createItemGenerator() {
		return new InternalItemGeneratorImpl();
	}

	@Override
	public Item createItem() {
		return new InternalItemImpl();
	}

	@Override
	public Machine createMachine() {
		return new InternalMachineImpl();
	}

	@Override
	public System createSystem() {
		return new InternalSystemImpl();
	}

	@Override
	public Turntable createTurntable() {
		return new InternalTurntableImpl();
	}

}
