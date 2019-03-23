package model.disasters;

import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;

public class Infection extends Disaster {

	public Infection(int startCycle, Citizen target) {

		super(startCycle, target);

	}
	
	public void strike()
	{

		getTarget().struckBy(this);
		setActive(true);
		Citizen  r= (Citizen) getTarget();
		r.setToxicity(r.getToxicity()-25);
			
	}
	public void cycleStep()
	{
		Citizen  r= (Citizen) getTarget();
		r.setToxicity(r.getToxicity()-15);
		
	}

}
