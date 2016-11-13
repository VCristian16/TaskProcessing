package pack;

import java.io.Serializable;

public class Task implements Serializable {

    private String name;
    private int data;
    private int id;
    
	public Task(String name, int data, int id) {
		super();
		this.name = name;
		this.data = data;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

   

}