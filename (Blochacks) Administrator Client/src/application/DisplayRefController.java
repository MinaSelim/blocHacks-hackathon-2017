package application;

import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import refugees.Refugee;

public class DisplayRefController {
	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField passport;

	@FXML
	private TextField gender;

	@FXML
	private TextField address;

	@FXML
	private TextField nationality;

	@FXML
	private TextField eye;

	@FXML
	private TextField height;

	@FXML
	private TextField phone;

	@FXML
	private TextField mail;

	@FXML
	private TextField password;

	@FXML
	private TextField center;

	@FXML
	private TextField age;

	@FXML
	private TextField addInfo;
	@FXML
	private TextField serialNumber;
	
	private PrintWriter print_server;
	private Scanner read_server;
	private Refugee refugee;
	
	public void displayInfoFromServer(ActionEvent event){
		
	}
	public void setRefugee(Refugee r)
	{
		refugee = r;
		firstName.setText(refugee.getFirst_name());
		lastName.setText(refugee.getLast_name());
		passport.setText(refugee.getPassport());
		gender.setText(refugee.getGender());
		address.setText(refugee.getLocation());
		nationality.setText(refugee.getNationality());
		eye.setText(refugee.getEye_Colors());
		height.setText(Integer.toString(refugee.getHeightCM()));
		
		
		
		
	}
	public void setUpNetworking(PrintWriter print, Scanner scan)
	{
		print_server = print;
		read_server = scan;
		
	}
}
