package pack;

import java.io.ObjectInputStream;
import java.util.concurrent.atomic.AtomicInteger;

class WorkerThread implements Runnable {  
  
    
	AtomicInteger numberOfJobsToExecute;
	Student b;
	static int n=1;
    public WorkerThread(AtomicInteger numberOfJobsToExecute, Student b){  
    	
        this.numberOfJobsToExecute=numberOfJobsToExecute; 
        this.b=b;
    }  
    
    
    
  


	public void run() {  
        System.out.println(Thread.currentThread().getName());    
        while(numberOfJobsToExecute.decrementAndGet() >= 0){      	
        processTask();//call processmessage method that sleeps the thread for 2 seconds 
        
        }
            
        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  
    } 
     
     
    private void processTask() {  
        try {  Thread.sleep(2000);               
               n++;
               System.out.println(n+" procesat!");
              
        } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
}  