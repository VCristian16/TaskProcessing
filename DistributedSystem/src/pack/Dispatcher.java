package pack;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import pack.Dispatcher.EventTypeEnum;

public class Dispatcher {
	public enum EventTypeEnum {SAVE,UPDATE,DELETE};
	List<EventManager> saveEventManagers;
	List<EventManager> updateEventManagers;
	List<EventManager> deleteEventManagers;
	Logger logger = Logger.getLogger("MyLog");  
	

	public void dispatch(EventTypeEnum event, Student object)
	{
	    switch (event) {
	        case SAVE:
	            for(EventManager manager: this.saveEventManagers)
	            {
	                manager.executeEvent(event,object);
	            }
	            break;
	        case UPDATE:
	            for(EventManager manager: this.updateEventManagers)
	            {
	                manager.executeEvent(event,object);
	            }
	            break;
	        case DELETE:
	            for(EventManager manager: this.deleteEventManagers)
	            {
	                manager.executeEvent(event,object);
	            }
	            break;
	        default:
	            System.out.println("Unknow EventType of type " + event.name());
	        }
	 
	}
	
	 public static void main(String[] argv) throws Exception {
	       
	            System.out.println("Finished all threads");
	            
	            
	            
	            
	            Student received = new Student("Mike",30,30);
	            Dispatcher dispatcher = new Dispatcher();
	            dispatcher.dispatch(EventTypeEnum.UPDATE, received);
	            
	        }

	
	

}
