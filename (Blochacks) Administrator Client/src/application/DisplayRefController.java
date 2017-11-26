package application;

import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
	
	public void displayInfoFromServer(ActionEvent event){
		
	}
	public void setUpNetworking(PrintWriter print, Scanner scan)
	{
		print_server = print;
		read_server = scan;
		
	}
}
