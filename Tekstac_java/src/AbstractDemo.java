abstract class Shape
{
	
	protected final double PI=3.14;
	
	protected double area;
	
	void show()
	{
		System.out.println(area);
	}
	
	abstract void findArea();
	
	
}
 
 
 
class Circle extends Shape
{
 
	private int r;
	
	@Override
	void findArea()
	{
		r=5;
		
		area=PI*r*r;
		show();
		
	}
	
}
 
 
class Triangle extends Shape
{
	int b,h;
	
	@Override
	void findArea()
	{
		b=3;
		h=5;
		
		area=0.5*b*h;
		show();
		
	}
	
	
}
 
 
 
public class AbstractDemo {
 
	public static void main(String[] args)
	{
 
		
		//Shape obj =new Shape();  //Error : we can't instantiate for Abstract class
		
		Shape baseRef;
		
		baseRef=new Circle();
		
		System.out.print("Circle Area is  :");
		baseRef.findArea();
		
		
		baseRef=new Triangle();
		System.out.print("Triangle Area is  :");
		baseRef.findArea();
		
		
		
		
		
	}
 
}