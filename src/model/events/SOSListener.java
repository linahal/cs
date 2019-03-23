package model.events;

import java.util.EventListener;

import simulation.Rescuable;

public interface SOSListener extends EventListener
{
	public void receiveSOSCall(Rescuable r);
		/* receiving SOS calls from any Rescuable
		reporting that they are affected by a disaster. The method should handle the call by adding said
		Rescuable to the appropriate list of visible rescuables.*/
}
