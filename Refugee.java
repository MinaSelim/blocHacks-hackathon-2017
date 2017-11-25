/*Refugee Class that implements */

package refugee;

import java.util.Scanner;

public class Refugee {

	protected String last_name;
	protected String first_name;
	protected String nationality;

	private String verbal_pass;

	protected int age;
	protected int heightCM;
	protected String passport;

	protected String gender;
	protected String eye_Colors;


	protected long phone;
	protected String email;

	protected String location;

	protected boolean mia;

	/**
	 * Default constructor that calls default constructor
	 * from object class
	 */

	public Refugee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor 
	 * for the refugee object
	 */
	public Refugee(String lastName, String firstName, String nationality, int age, int heightCM, String passport,
			String gender, long phone, String email, String location, String vPass, Boolean missing) 
	{
		super();
		this.last_name = lastName;
		this.first_name = firstName;
		this.nationality = nationality;
		this.age = age;
		this.heightCM = heightCM;
		this.passport = passport;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.location = location;
		this.verbal_pass = vPass;
		this.mia = missing;
	}

	/**
	 * Copy constructor 
	 * that reads from the input stream
	 */

	public Refugee registration(Scanner sc)
	{
		String temp = sc.nextLine();
		String[] parts = temp.split(" ");

		Boolean missing = false;
		Refugee ref;

		try
		{
			ref = new Refugee(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), parts[5], 
					parts[6], Long.parseLong(parts[7]), parts[8], parts[9],parts[10], missing);

			return ref;
		}
		catch(Exception e)
		{
			System.out.println("Could not create the refugee object");
			return ref = new Refugee();
		}
	}
	
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return   last_name +" "+ first_name +" "+ nationality+" "+age+" "+ heightCM+" "+passport+" "+gender+" "+phone
				+" "+email+" "+location;
	}


}
