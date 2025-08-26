import java.util.Scanner;
 
public class ArrayDemo {
 
	public static void main(String[] args) {
 
 
		//To initialize an array
		
		//int [] arr= {20,45,60,80,70};
		
		int arr[];    //declaration of an array
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter How many array elements :");
		int n=sc.nextInt();
		
		arr=new int[n];
		
		System.out.println("Type array elemnets :");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Initialized array elements are ");
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("arr["+i+"] ="+arr[i]);
		}
		
		System.out.println("2nd Index value is  :"+arr[2]);
		
		//for-each loop
		System.out.println("Using foreach loop array elements are ");
		System.out.println("======================================");
		
		for(int i : arr)
		{
			System.out.println(i);
		}
		
		
	}
 
}
