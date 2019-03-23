package model.units;

import java.util.ArrayList;

import model.people.Citizen;
import simulation.Address;

public abstract class FireUnit extends Unit {
	private ArrayList<Citizen> passengers;
	public FireUnit(String unitID, Address location, int stepsPerCycle) {

		super(unitID, location, stepsPerCycle);
		passengers = new ArrayList<Citizen>();
	}
	public ArrayList<Citizen> getPassengers() {
		return passengers;
	}
	
	

}
