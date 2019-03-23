package model.disasters;

import model.infrastructure.ResidentialBuilding;
import simulation.Rescuable;

public class Collapse extends Disaster {

	public Collapse(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}
	
	public void strike()
	{

		getTarget().struckBy(this);
		setActive(true);
		ResidentialBuilding  r= (ResidentialBuilding) getTarget();
		r.setFoundationDamage(r.getFoundationDamage()-10);
			
	}
	
	public void cycleStep()
	{
		ResidentialBuilding  r= (ResidentialBuilding) getTarget();
		r.setFoundationDamage(r.getFoundationDamage()-10);
	}
}
