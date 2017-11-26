package refugee;


import java.util.Scanner;

public class Refugee {

	protected String last_name;
	protected String first_name;
	protected String nationality;
	
	private long fingerprint; 

	private String verbal_pass;

	protected int age;
	protected int heightCM;
	protected String passport;

	protected String gender;
	protected String eye_Colors;


	protected long phone;
	protected String email;

	protected String location;
	
	protected String more_information;

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
	public Refugee(String firstName, String lastName, String nationality, int age, int heightCM, String passport,
			String gender, long phone, String email, String location, String vPass,long fingerprint, String more_information, Boolean missing) 
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
		this.fingerprint = fingerprint;
		this.more_information = more_information;
		this.mia = missing;
	}

	/**
	 * Copy constructor 
	 * that reads from the input stream
	 */

	public Refugee(Scanner sc)
	{
		

		Boolean missing = false;
		

		sc.next();
		first_name = sc.nextLine(); 
		sc.next();
		last_name =sc.nextLine();
		sc.next();
		nationality = sc.nextLine();
		sc.next();
		age = sc.nextInt();
		sc.next();
		heightCM = sc.nextInt();
		sc.next();
		passport = sc.nextLine();
		sc.next();
		gender = sc.nextLine();
		sc.next();
		phone = sc.nextLong();
		sc.next();
		email =sc.nextLine();
		sc.next();
		location =sc.nextLine(); 
		sc.next();
		verbal_pass = sc.nextLine();
		sc.next();
		fingerprint = sc.nextLong();
		sc.next();
		more_information = sc.nextLine();
		
		
		
		mia = missing;

			
		
	}
	
	
	/**
	 * Getter for the fingerprint 
	 */
	public long getFingerprint()
	{
		return fingerprint;
	}
	
	
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return   "first_name: "+first_name +"\n"+"last_name: "+ last_name +"\n"+"nationality: "+ nationality+"\n"+"age: "+age+"\n"+ "heightCM: "+heightCM+"\n"+"Passport: "+passport+"\n"+"Gender: "+gender+"\n"+"Phone: "+phone
				+"\n"+"Email: "+email+"\n"+"Location: "+location+"\n"+"verbal_pass: "+verbal_pass+"\n"+"Fingerprint: "+fingerprint+"\n"+"Additional_information: "+more_information;
	}


}
