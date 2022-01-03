package janclient.event;

public class EventCancelable extends Event{

	private boolean cancelled = false;
	
	public boolean isCancelled() {
		return cancelled;
	}
	
}
