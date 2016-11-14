package dispatcher;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import pack.Task;



public class Dispatcher {
	public enum EventTypeEnum {START,PAUSE,RESUME,STOP};
	
	
	Logger logger = Logger.getLogger("MyLog");  
	

	public void manageDispatch(EventTypeEnum event)
	{
		
	    if (event == EventTypeEnum.PAUSE){
	    	Pause pause=new Pause();
	    	pause.executeEvent(event);
	    	
	    }
	    else if (event == EventTypeEnum.START){
	    	Start process=new Start();
	    	process.executeEvent(event);
	    	
	    }
	 
	}
	


	
	

}
