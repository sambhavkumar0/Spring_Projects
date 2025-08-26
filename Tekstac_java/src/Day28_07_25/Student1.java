package Day28_07_25;

import java.io.Serializable;

public class Student1 implements Serializable
{
 
	private int no;
	private String name;
	transient String course;
	
	public Student1(int no, String name, String course) {
		
		this.no = no;
		this.name = name;
		this.course = course;
	}
 
	public int getNo() {
		return no;
	}
 
	public void setNo(int no) {
		this.no = no;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getCourse() {
		return course;
	}
 
	public void setCourse(String course) {
		this.course = course;
	}
	
	
}