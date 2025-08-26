package Day28_07_25;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
public class SerializeDemo {
 
	public static void main(String[] args)
	{
 
		try
		{
		Student1 s=new Student1(100, "Rahul", "Java FUllStack");
		
		FileOutputStream fos=new FileOutputStream("stream.txt");
		
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		oos.writeObject(s);
		
		System.out.println("Serialization process completed");
		
		oos.close();
		fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
 
}