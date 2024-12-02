package in.sm.main.entity;

import java.util.Date;
import java.util.Random;

public class Todo {
	
	
	private int id;
	private String todotitle;
	private String content;
	private Date todoDate;
	
	
	
	
	
	public Todo() {
		super();
		this.id = new Random().nextInt(10000);
	}
	
	public Todo(String todotitle, String content, Date todoDate) {
		super();
		this.id = new Random().nextInt(10000);
		this.todotitle = todotitle;
		this.content = content;
		this.todoDate = todoDate;
	}
	public String getTodotitle() {
		return todotitle;
	}
	public void setTodotitle(String todotitle) {
		this.todotitle = todotitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(Date todoDate) {
		this.todoDate = todoDate;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Todo [todotitle=" + todotitle + ", content=" + content + ", todoDate=" + todoDate + "]";
	}
	
	
	
	

}
