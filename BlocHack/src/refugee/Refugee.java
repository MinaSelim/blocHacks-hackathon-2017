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

	public Refugee(Scanner sc)
	{
		String temp = sc.nextLine();
		String[] parts = temp.split(" ");

		Boolean missing = false;
		

		last_name = parts[0]; 
		first_name =parts[1];
		nationality = parts[2];
		age = Integer.parseInt(parts[3]);
		heightCM = Integer.parseInt(parts[4]);
		passport = parts[5];
		gender = parts[6];
		phone = Long.parseLong(parts[7]);
		email =parts[8];
		location =parts[9]; 
		verbal_pass = parts[10];
		mia = missing;

			
		
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
