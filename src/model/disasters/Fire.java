package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class Fire extends Disaster {

	public Fire(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}
	public void strike()
	{

		getTarget().struckBy(this);
		setActive(true);
		ResidentialBuilding  r= (ResidentialBuilding) getTarget();
		r.setFireDamage(r.getFireDamage()-10);
			
	}
	public void cycleStep()
	{
		ResidentialBuilding  r= (ResidentialBuilding) getTarget();
		r.setFireDamage(r.getFireDamage()-10);
	}

}
