package refugee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[]args)
	{
		
		Boolean missing = false;
		
		Refugee r = new Refugee("Mike", "Calixte", "Haitian",20,178, "C13432123",
				"Male", 234565432, "mike.calixte@yahoo.ca", "Lybye", "mikeyCalixte",65434567,"No additional information", missing);
		System.out.println(r.toString());
		
		
		PrintWriter pw;
		try 
		{
			pw = new PrintWriter(new FileOutputStream("re.txt"));
			
			pw.println(r.toString());
			
			pw.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println("Could not create file");
		}
		
		
		
		//Printing onto the screen
		
		Scanner sc = null;
		String s;
		
		try
		{
			sc = new Scanner(new FileInputStream("ref.txt"));
			
			s = sc.nextLine();
			
			System.out.println(s);
			
			sc.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Could not open this");
		}
		
		
		System.out.println();
		
		//Reopening scanner from the ref.txt file and using scanner to make new ref. obj.
		try
		{
			sc = new Scanner(new FileInputStream("re.txt"));
				
		}
		catch(Exception e)
		{
			System.out.println("Could not open this");
		}
		
		
		Refugee r2 = new Refugee(sc);
		
		System.out.println(r2.toString());
		
		
	}

}
