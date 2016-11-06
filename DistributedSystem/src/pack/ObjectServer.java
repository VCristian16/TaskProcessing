package pack;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pack.Dispatcher.EventTypeEnum;

public class ObjectServer {


    public static void main(String[] argv) throws Exception {
        @SuppressWarnings("resource")
		ServerSocket s = new ServerSocket(5000);
        System.out.println("Server started");
        while (true) {
            Socket t = s.accept();// wait for client to connect
            System.out.println("server connected");
            ObjectInputStream b = new ObjectInputStream(t.getInputStream());
            
            
            //starting thread pool
            ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
            for (int i = 0; i < 2; i++) {  
                Runnable worker = new WorkerThread("" + i);
                
                executor.execute(worker);//calling execute method of ExecutorService  
              }  
            executor.shutdown();  
            while (!executor.isTerminated()) {   }  
      
            System.out.println("Finished all threads");
            
            
            
            
            Student received = (Student) b.readObject();
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.dispatch(EventTypeEnum.UPDATE, received);
            PrintWriter output = new PrintWriter(t.getOutputStream(), true);
            output.println("Student " + received.getName() + " with age: "
                    + received.getAge() + " has been received");
            b.close();
            output.close();
            t.close();
        }

    }
}