package pack;



public class WorkerThread implements Runnable {  
    
	int workerNumber;
	Task b;
	private volatile boolean suspended = false; 
	Object o = new Object();  
	
	public WorkerThread() {
	}
	
    public WorkerThread(int i, Task b){  
    	
        this.workerNumber=i; 
        this.b=b;
    } 
    
    public void suspend(){          
        suspended = true;  
    }  

    public void resume(){       
        suspended = false;  
        synchronized (o) {  
            o.notifyAll();  
        }  
    }  


	public void run() {  
		 // The thread simply prints 1 to 5
	      
	      
	      while(!Thread.currentThread().isInterrupted()){  
              if(!suspended){ 
            	  
            	  for (int i = 1; i <= 5; ++i) {
         	         System.out.printf("Worker %d: %d\n", workerNumber, i);
         	         int increment=b.getData();
         	         increment++;
         	         b.setData(increment);
         	         System.out.println("New data:"+b.getData());
         	         
         	         
         	         try {
         	            // sleep for 0 to 0.5 second
         	            Thread.sleep((int)(Math.random() * 500));
         	         } catch (InterruptedException e) {}
         	      }  

   
              }
              else{  
                  //Has been suspended  
                  try {                   
                      while(suspended){  
                          synchronized(o){  
                              o.wait();  
                          }                           
                      }                       
                  }  
                  catch (InterruptedException e) {                    
                  }             
              }                           
          }  
          System.out.println("Cancelled");    
	      
	      
    } 
     
    
}  