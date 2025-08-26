package Day28_07_25;

import java.util.*;
class Employ
{
	private int id;
	private String name;
	private Double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Employ(int id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
}
 
public class EmployDemo {
 
	public static void main(String[] args) {
 
 
		List<Employ> ob=new ArrayList<Employ>();
		
		ob.add(new Employ(100,"A",50000.45));
		ob.add(new Employ(200,"X",20000.45));
		ob.add(new Employ(400,"T",70000.45));
		ob.add(new Employ(500,"Y",10000.45));
		ob.add(new Employ(20,"A",50000.45));
		
		ob.stream().filter(s -> s.getSalary()>50000).
		filter(s-> s.getName().startsWith("A")).
		
		forEach(s -> System.out.println(s.getName()+"  "+s.getSalary()));
		
	}
 
}