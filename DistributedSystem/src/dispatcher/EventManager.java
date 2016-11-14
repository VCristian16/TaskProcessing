package dispatcher;

import dispatcher.Dispatcher.EventTypeEnum;
import pack.Task;

public interface EventManager  {
	
	void executeEvent(EventTypeEnum event);


}

