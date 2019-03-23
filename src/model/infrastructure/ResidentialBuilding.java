package model.infrastructure;

import java.util.ArrayList;
import java.util.Random;

import model.disasters.Collapse;
import model.disasters.Disaster;
import model.disasters.Fire;
import model.events.SOSListener;
import model.people.Citizen;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public class ResidentialBuilding implements Rescuable, Simulatable {

	private Address location;
	private int structuralIntegrity;
	private int fireDamage;
	private int gasLevel;
	private int foundationDamage;
	private ArrayList<Citizen> occupants;
	private Disaster disaster;
	private SOSListener emergencyService;

	public ResidentialBuilding(Address location) {

		this.location = location;
		this.structuralIntegrity = 100;
		occupants = new ArrayList<Citizen>();

	}
	
	

	public void setEmergencyService(SOSListener emergencyService) {
		this.emergencyService = emergencyService;
	}



	public int getStructuralIntegrity() {
		return structuralIntegrity;
	}

	public void setStructuralIntegrity(int structuralIntegrity) {
		this.structuralIntegrity = structuralIntegrity;
		if(structuralIntegrity <=0)
		{
			structuralIntegrity = 0; 
			setHPofOccupants();
			
		}
	}
	
	public void setHPofOccupants()
	{
		for (int i=0; i<occupants.size(); i++)
		{
			occupants.get(i).setHp(0);
		}
	}

	public int getFireDamage() {
		return fireDamage;
	}

	public void setFireDamage(int fireDamage) {
		this.fireDamage = fireDamage;
		if(fireDamage<=0)
			fireDamage=0;
		if(fireDamage>=100)
			fireDamage=100;
	}

	public int getGasLevel() {
		return gasLevel;
	}

	public void setGasLevel(int gasLevel) {
		this.gasLevel = gasLevel;
		if(gasLevel<=0)
			gasLevel=0;
		if(gasLevel>=100)
		{
			gasLevel = 100;
			setHPofOccupants();
			
		}
			
	}

	public int getFoundationDamage() {
		return foundationDamage;
	}

	public void setFoundationDamage(int foundationDamage) 
	{
		this.foundationDamage =  foundationDamage ;
		if (foundationDamage>=100)
		{
			setStructuralIntegrity(0);
		}
	}

	public Address getLocation() {
		return location;
	}

	public ArrayList<Citizen> getOccupants() {
		return occupants;
	}

	public Disaster getDisaster() {
		return disaster;
	}

	@Override
	public void struckBy(Disaster d) {
		disaster= d; 
		
	}

	@Override
	public void cycleStep() {
		if( this.disaster instanceof Collapse)
		{
			if(foundationDamage>= 0 )
			{
				Random rand = new Random();
				int randomInteger = rand.nextInt(10) + 5;
				this.setStructuralIntegrity(this.getStructuralIntegrity()-randomInteger);
			}
			
		}
		if (this.disaster instanceof Fire)
		{
			if(fireDamage <=0 && fireDamage <30)
				this.setStructuralIntegrity(this.getStructuralIntegrity()-3);
			if(fireDamage >=30 && fireDamage <70)
				this.setStructuralIntegrity(this.getStructuralIntegrity()-5);
			if(fireDamage >= 70)
				this.setStructuralIntegrity(this.getStructuralIntegrity()-7);
			
			
				
		}
		
	}

}
