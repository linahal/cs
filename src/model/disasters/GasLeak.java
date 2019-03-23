package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class GasLeak extends Disaster {

	public GasLeak(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}
	
	public void strike()
	{

		getTarget().struckBy(this);
		setActive(true);
		ResidentialBuilding  r= (ResidentialBuilding) getTarget();
		r.setGasLevel(r.getGasLevel()-10);
			
	}
	
	public void cycleStep()
	{
		ResidentialBuilding  r= (ResidentialBuilding) getTarget();
		r.setGasLevel(r.getGasLevel()-15);
	}

}
