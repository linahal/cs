package model.units;

import simulation.Address;
import simulation.Rescuable;

public class Evacuator extends PoliceUnit {

	public Evacuator(String unitID, Address location, int stepsPerCycle, int maxCapacity) {

		super(unitID, location, stepsPerCycle, maxCapacity);

	}

	public void cycleStep()
	{
		if(this.getState()!=UnitState.IDLE)
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
			
			if( passengerToCapacityRatio(this.getMaxCapacity())==0)
			{
				//return to  base, unload passengers, and go back
			}
			
		}
		

}

	@Override
	public void respond(Rescuable r) {
		// TODO Auto-generated method stub
		
	}}
