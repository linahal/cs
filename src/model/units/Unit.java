package model.units;

import model.events.SOSResponder;
import model.events.WorldListener;
import model.people.Citizen;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public abstract class Unit implements Simulatable, SOSResponder {

	private String unitID;
	private UnitState state;
	private Address location;
	private Rescuable target;
	private int distanceToTarget;
	private int stepsPerCycle;
	private WorldListener worldListener;

	public Unit(String unitID, Address location, int stepsPerCycle) {

		this.unitID = unitID;
		this.location = location;
		this.stepsPerCycle = stepsPerCycle;
		this.state = UnitState.IDLE;
		distanceToTarget= Math.abs(this.getLocation().getX()- target.getLocation().getX()) + Math.abs(this.getLocation().getY()- target.getLocation().getY());
				

	}
	
	

	public WorldListener getWorldListener() {
		return worldListener;
	}



	public void setWorldListener(WorldListener worldListener) {
		this.worldListener = worldListener;
	}



	public UnitState getState() {
		return state;
	}

	public void setState(UnitState state) {
		this.state = state;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public String getUnitID() {
		return unitID;
	}

	public Rescuable getTarget() {
		return target;
	}

	public int getStepsPerCycle() {
		return stepsPerCycle;
	}



	public void setDistanceToTarget(int distanceToTarget) {
		this.distanceToTarget = distanceToTarget;
	}
	
	public void cycleStep()
	{
		if(getState()!=UnitState.IDLE)
		{
			if(getState()== UnitState.RESPONDING)
			{
				this.setDistanceToTarget(distanceToTarget - stepsPerCycle);
				if(distanceToTarget==0)
				{
					this.setLocation(target.getLocation());
				}
				return;
			}
			if(distanceToTarget==0)
			{
				state= UnitState.TREATING;
				treat();
				
				
			}
			
		}
		
	}
	
	public void treat()
	{
		this.target.getDisaster().setActive(false);
		Rescuable t= this.target;
		if(t instanceof Citizen)
		{
			
		}
		
	}
	
	public void jobsDone(){
		//continue
	}
	

}
