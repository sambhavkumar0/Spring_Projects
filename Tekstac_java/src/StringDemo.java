public class StringDemo {
 
	public static void main(String[] args) {
 
 
		String s1="apple";
		String s2="   APPLE     ";
				
		
		System.out.println("String s1  ="+s1);
		System.out.println("String s2  ="+s2);
		
		System.out.println("String -1 Length :"+s1.length());
		System.out.println("String -2 Length :"+s2.length());
		
		s2=s2.trim(); //to remove the unwanted spaces in bothsides
		System.out.println("After trim String -2 Length :"+s2.length());
		
		
		System.out.println("s1 == s2 :"+s1.equals(s2));
		
		System.out.println("s1 == s2  using IgnoreCase method :"+s1.equalsIgnoreCase(s2));
		
		
		System.out.println("Upper String is  :"+s1.toUpperCase());
		System.out.println("Lower String is :"+s2.toLowerCase());
		
		
		System.out.println(" index of 'E' is  :"+s2.indexOf('E'));
		
		System.out.println("Character at 4th Pos :"+s2.charAt(4));
		
		
		System.out.println("s1 isEmpty :"+s1.isEmpty());
		
		System.out.println("String s2 starts with 'A' :"+s2.startsWith("A"));
		
		System.out.println("String s2 ends with 'A' :"+s2.endsWith("A"));
		
		System.out.println("Replace 'E'  with 'e'  :"+s2.replace('E', 'e'));
		
		System.out.println("Sub string from 1st pos to end of the string :"+s2.substring(1));
		System.out.println("Sub string from 1st to 3rd pos :"+s2.substring(1,3));
		
	}
	
 
}