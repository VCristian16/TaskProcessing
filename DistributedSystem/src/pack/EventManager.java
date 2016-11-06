package pack;

import javax.security.auth.Subject;

import pack.Dispatcher.EventTypeEnum;

public class EventManager extends java.lang.Object {

	public void executeEvent(EventTypeEnum event, Student student) {
		// TODO Auto-generated method stub
		if(event.equals("UPDATE")){
			System.out.println("Updated info for student" +student.getName());
			
		}
		else if(event.equals("DELETE")){
			System.out.println("Deleted info for student "+student.getName());
		}
		else{
			System.out.println("Saved info for student "+student.getName());
		}
		
		
	}

}
