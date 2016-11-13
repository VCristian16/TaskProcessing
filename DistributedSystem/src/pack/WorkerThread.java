package pack;



class WorkerThread implements Runnable {  
    
	int workerNumber;
	Task b;
	static int n=1;
    public WorkerThread(int i, Task b){  
    	
        this.workerNumber=i; 
        this.b=b;
    }  

	public void run() {  
		 // The thread simply prints 1 to 5
	      for (int i = 1; i <= 5; ++i) {
	         System.out.printf("Worker %d: %d\n", workerNumber, i);
	         
	         try {
	            // sleep for 0 to 0.5 second
	            Thread.sleep((int)(Math.random() * 500));
	         } catch (InterruptedException e) {}
	      }     
    } 
     

	
	
    private void processTask() {  
        try {  Thread.sleep(2000);               
               n++;
               System.out.println(n+" procesat!");
              
        } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
    
    
}  