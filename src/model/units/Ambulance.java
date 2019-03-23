package model.units;

import simulation.Address;
import simulation.Rescuable;

public class Ambulance extends MedicalUnit {

	public Ambulance(String unitID, Address location, int stepsPerCycle) {

		super(unitID, location, stepsPerCycle);

	}

	@Override
	public void cycleStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respond(Rescuable r) {
		// TODO Auto-generated method stub
		
	}

}
