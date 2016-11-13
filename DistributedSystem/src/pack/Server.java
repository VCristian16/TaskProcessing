package pack;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import dispatcher.Dispatcher;
import dispatcher.Dispatcher.EventTypeEnum;

public class Server {


    public static void main(String[] argv) throws Exception {
        @SuppressWarnings("resource")
		ServerSocket s = new ServerSocket(5000);
        System.out.println("Server started");
        while (true) {
            Socket t = s.accept();// wait for client to connect
            System.out.println("server connected");
            ObjectInputStream b = new ObjectInputStream(t.getInputStream());
            Task received = (Task) b.readObject();
            
           int numberOfThrd = 2;

            //starting thread pool
           // AtomicInteger numberOfJobsToExecute = new AtomicInteger(5);
           int numWorkers = 5;
            ExecutorService executor = Executors.newFixedThreadPool(numberOfThrd);//creating a pool of 5 threads  
            WorkerThread[] workers = new WorkerThread[numWorkers];
            for (int i = 0; i < numWorkers; ++i) {
               workers[i] = new WorkerThread(i+1,received);
               executor.execute(workers[i]);
            }
            executor.shutdown();  
            while (!executor.isTerminated()) {   }  
      
            
            
            
            
            
            System.out.println("Finished all threads");
            
            
            
            
            
            //Dispatcher dispatcher = new Dispatcher();
            //dispatcher.manageDispatch(EventTypeEnum.PAUSE);
            PrintWriter output = new PrintWriter(t.getOutputStream(), true);
            output.println("Student " + received.getName() + " with age: "
                    + received.getData() + " has been received");
            b.close();
            output.close();
            t.close();
        }

    }
}