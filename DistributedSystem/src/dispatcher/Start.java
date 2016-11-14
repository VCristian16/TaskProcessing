package dispatcher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import pack.Task;
import dispatcher.Dispatcher.EventTypeEnum;

public class Start extends SwingWorker<Void, String> implements EventManager{
	String tName; 
	int data; 
	int mark;
	JTextArea txtS;
	
	public Start(String tName, int data, int mark, JTextArea txtS) {
		super();
		this.tName = tName;
		this.data = data;
		this.mark = mark;
		this.txtS = txtS;
	}



	@Override
	public void executeEvent(EventTypeEnum event) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	protected Void doInBackground() throws Exception {
		// TODO Auto-generated method stub
		Socket s = new Socket("localhost", 5000);
        ObjectOutputStream p = new ObjectOutputStream(s.getOutputStream());
        p.writeObject(new Task(tName, data, mark));
        p.flush();

        // Here we read the details from server
        BufferedReader response = new BufferedReader(new InputStreamReader( s.getInputStream()));
        txtS.setText("The server respond: " + response.readLine());
        p.close();
        response.close();
        s.close();
		
		
		return null;
	}



}
