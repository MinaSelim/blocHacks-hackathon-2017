package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController {
	@FXML
	private TextField serialNumber;
	@FXML
	private Label status;

	@FXML
	private TextField textField;

	@FXML
	private Label status1;
	
	private PrintWriter write_server;
	private Scanner scan_server;
	
	public void setUpNetworking(Socket x)
	{
		try
		{
			write_server = new PrintWriter(x.getOutputStream());
			scan_server = new Scanner(x.getInputStream());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Login method works once the user clicks on the Login Button which checks
	 * if the serial number of the user is exits or not in the local server.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void login(ActionEvent event) {
	
			
			write_server.println(serialNumber.getText());
			write_server.flush();
			if (serialNumber.getText().equals("123")) {
				status.setText("Valid");
			} else {
				status.setText("Invalid");
			}
			// if successful do the following
			try
			{
				Stage primaryStage= new Stage();
				FXMLLoader loader = new FXMLLoader(); 
				loader.setLocation(getClass().getResource("DisplayRefInfo.fxml")); 
				Parent root= loader.load(); 
				Scene scene = new Scene(root);
				DisplayRefController control = loader.<DisplayRefController>getController();
				control.setUpNetworking(write_server, scan_server);
				scene.getStylesheets().add(getClass().getResource("registration.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			 
			  
			 

	}
	

	public void getVerbalPassword(ActionEvent ev) {
		Stage primaryStage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("VerbalPassword.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	

	
	
	
	
	
}
