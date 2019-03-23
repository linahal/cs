package model.disasters;

import model.people.Citizen;

public class Injury extends Disaster {

	public Injury(int startCycle, Citizen target) {

		super(startCycle, target);

	}
	
	public void strike()
	{

		getTarget().struckBy(this);
		setActive(true);
		Citizen  r= (Citizen) getTarget();
		r.setBloodLoss(r.getBloodLoss()-30);
			
	}
	public void cycleStep()
	{
		Citizen  r= (Citizen) getTarget();
		r.setBloodLoss(r.getBloodLoss()-10);
		
	}

}
