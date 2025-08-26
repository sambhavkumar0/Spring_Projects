package Day28_07_25;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
 
public class DeserializeDemo {
 
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
 
		Student1 s=null;
		
		FileInputStream fis=new FileInputStream("stream.txt");
		
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		s=(Student1) ois.readObject();
		
		System.out.println("Sno  :"+s.getNo()+" Sname "+s.getName()+" Course  "+s.getCourse());
		
	}
 
}