package webapp;

import java.sql.Timestamp;

/**
 * 
 * Data structure for threads and posts
 *
 */
public class Message {
	private int id;
	private String content;
	private Timestamp date;
	
	
	public Message(int id, String content, Timestamp date){
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
