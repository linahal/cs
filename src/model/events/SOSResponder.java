package model.events;

import java.util.EventListener;

import simulation.Rescuable;

public interface SOSResponder extends EventListener
{
	public void respond(Rescuable r);

}
