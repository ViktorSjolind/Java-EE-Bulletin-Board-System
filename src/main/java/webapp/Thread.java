package webapp;

import java.sql.Timestamp;

public class Thread {
	private int id;
	private String content;
	private Timestamp date;
	
	
	public Thread(int id, String content, Timestamp date){
		this.id = id;
		this.content = content;
		this.date = date;		
	}
	
	public int getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public Timestamp getDate() {
		return date;
	}
	
	
	
	
}
