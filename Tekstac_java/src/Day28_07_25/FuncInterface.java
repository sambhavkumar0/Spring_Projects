package Day28_07_25;

@FunctionalInterface
interface I
{
	//void greeting(String str);
	
	int add(int x, int  y);
}
 
 
public class FuncInterface
{
 
	public static void main(String[] args)
	{

		I ref=(a,b) ->  a+b;
		
		System.out.println("Addition is :"+ref.add(20,5));
		
	}
 
}
 