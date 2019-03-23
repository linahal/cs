package model.people;

import model.disasters.Disaster;
import model.disasters.Infection;
import model.disasters.Injury;
import model.events.SOSListener;
import model.events.WorldListener;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public class Citizen implements Rescuable, Simulatable {

	private CitizenState state;
	private Disaster disaster;
	private String name;
	private String nationalID;
	private int age;
	private int hp;
	private int bloodLoss;
	private int toxicity;
	private Address location;
	private SOSListener emergencyService;
	private WorldListener worldListener; 
	
	
	


	public Citizen(Address location, String nationalID, String name, int age) {

		this.name = name;
		this.nationalID = nationalID;
		this.age = age;
		this.location = location;
		this.state = CitizenState.SAFE;
		this.hp = 100;

	}
	
	public WorldListener getWorldListener() {
		return worldListener;
	}

	public void setWorldListener(WorldListener worldListener) {
		this.worldListener = worldListener;
	}

	public void setEmergencyService(SOSListener emergencyService) {
		this.emergencyService = emergencyService;
	}


	public CitizenState getState() {
		return state;
	}

	public void setState(CitizenState state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		
		this.hp =  hp;
		if ( hp > 100)
			hp=100;
		if(hp<=0)
		{
			hp=0;
			state= CitizenState.DECEASED;
		}
		
	}

	public int getBloodLoss() {
		return bloodLoss;
	}

	public void setBloodLoss(int bloodLoss) {
		this.bloodLoss = bloodLoss;
		if(bloodLoss<0)
		{
			bloodLoss=0; 
			
		}
		
		if (bloodLoss>=100)
		{
			bloodLoss=100;
			this.setHp(0);
		}
	}

	public int getToxicity() {
		return toxicity;
	}

	public void setToxicity(int toxicity) {
		this.toxicity = toxicity;
		if(toxicity<0)
			toxicity=0;
		if(toxicity>=100)
		{
			toxicity=100;
			this.setHp(0);
		}
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public Disaster getDisaster() {
		return disaster;
	}

	public String getNationalID() {
		return nationalID;
	}

	@Override
	public void struckBy(Disaster d) {
		state= CitizenState.IN_TROUBLE;
		// TODO inform listener SOS
		
	}

	@Override
	public void cycleStep() {
		Disaster d= this.getDisaster();
		if(d instanceof Infection)
		{
			if(toxicity>0 && toxicity<30)
				this.setHp(this.getHp()-5);
			if(toxicity>= 30 && toxicity<70)
				this.setHp(this.getHp()-10);
			if(toxicity >= 70)
				this.setHp(this.getHp()-15);
			
		}
		else
		{
			if(d instanceof Injury)
			{
				if(bloodLoss>0 && bloodLoss<30)
					this.setHp(this.getHp()-5);
				if(bloodLoss>= 30 && bloodLoss<70)
					this.setHp(this.getHp()-10);
				if(bloodLoss >= 70)
					this.setHp(this.getHp()-15);
				
			}
		}
		
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[]args)
	{
		Address a= new Address(1,2);
		Citizen s= new Citizen ( a, "123", "mar", 19);
		
	}
	


}
