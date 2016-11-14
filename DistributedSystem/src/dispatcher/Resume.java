package dispatcher;

import dispatcher.Dispatcher.EventTypeEnum;
import pack.Task;
import pack.WorkerThread;

public class Resume implements EventManager {

	@Override
	public void executeEvent(EventTypeEnum event) {
		// TODO Auto-generated method stub
		System.out.println("Thread is" + event);
		WorkerThread thread =new WorkerThread();
		thread.resume();
		
	}

}
