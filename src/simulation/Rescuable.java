package simulation;

import model.disasters.Disaster;

public interface Rescuable
{
	public void struckBy(Disaster d);
	// applying a disaster to a building or a citizen. It should update the state where applicable and inform the appropriate SOSListener.
	public Address getLocation();
	public Disaster getDisaster();
	//returns the disaster currently affecting the Rescuable object.
		

}
