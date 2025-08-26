
interface intf1
{
	
	void method1();
	void method2();
	
	 private void display()
	{
		System.out.println("This is Private method");
	}
	
 
	 default void hi()
	 {
		 display();
	 }
	
	static void show()
	{
	System.out.println("This is Static method");	
	}
}
 
interface intf2 extends intf1
{
	
	void method3();
	
}
 
 
class ImplementDemo implements  intf2
{
 
	
	@Override
	public void method1() {
		System.out.println("This is Method1()");
		
	}
 
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("This is Method2()");
	}
 
	@Override
	public void method3() {
		// TODO Auto-generated method stub
		System.out.println("This is Method3()");
		
		intf1.show();
	}
	
	
}
public class InterfaceDemo
{
 
	public static void main(String[] args)
	{
 
		ImplementDemo ob=new ImplementDemo();
		
		ob.method1();
		ob.method2();
		ob.method3();
		
		ob.hi();
		
	
		
 
	}
 
}