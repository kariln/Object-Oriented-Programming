package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

import javafx.scene.control.TextField;

public class ControllerApp {
	
	@FXML
	Button button1;
	
	@FXML
	Button button2;
	
	@FXML
	Button button3;
	
	@FXML
	Button button4;
	
	@FXML
	Button button5;
	
	@FXML
	Button button6;
	
	@FXML
	Button button7;
	
	@FXML
	Button button8;
	
	@FXML
	Button button9;
	
	@FXML
	Button button0;
	
	@FXML
	Button button_pluss;
	
	@FXML
	Button button_minus;
	
	@FXML
	Button button_dele;
	
	@FXML
	Button button_gange;
	
	@FXML
	Button button_enter;
	
	@FXML
	Button button_lik;
	
	@FXML
	TextField skjerm;
	
	@FXML
	Button buttonsho;
	//hvorfor kan jeg ikke skrive vise?
	
	kalkulator kalkulator = new kalkulator();
	grensesnitt_app historie = new historie();
	String input = "";
	String operator = "";
	Integer input1;
	Integer input2;
	Double output = null;
	
	//HISTORIE
	//lager en fil for at tekstfilen skal kunne lagres
	//hvordan kan jeg knytte file og printwriter sammen?
	
	File file = new File ("C:\\Users\\Bruker\\tdt4100-v2019-master2\\git\\tdt4100-v2019-students\\ovinger\\src\\app\\svar_vec.txt");
	//String F="C:\\Users\\Bruker\\tdt4100-v2019-master2\\git\\tdt4100-v2019-students\\ovinger\\src\\app\\svar_vec.txt";
	
	public void handleClick_dele() {
		operator = "/";
		if (input!= "") {
			input1 = Integer.parseInt(input);
			input = "";
		}
		skjerm.setText("/");
	}
	
	public void handleClick_gange() {
		operator = "*";
		if (input!= "") {
			input1 = Integer.parseInt(input);
			input = "";
		}
		skjerm.setText("*");
	}
	
	public void handleClick_minus() {
		operator = "-";
		if (input!= "") {
			input1 = Integer.parseInt(input);
			input = "";
		}
		skjerm.setText("-");
	}
	
	public void handleClick_pluss() {
		operator = "+";
		if (input!= "") {
			input1 = Integer.parseInt(input);
			input = "";
		}
		skjerm.setText("+");
	}
	
	public void handleClick_0() {
		input += "0";
		skjerm.setText(input);
	}
	
	public void handleClick_1() {
		input += "1";
		skjerm.setText(input);
	}
	
	public void handleClick_2() {
		input += "2";
		skjerm.setText(input);
	}
	
	public void handleClick_3() {
		input += "3";
		skjerm.setText(input);
	}
	
	public void handleClick_4() {
		input += "4";
		skjerm.setText(input);
	}
	
	public void handleClick_5() {
		input += "5";
		skjerm.setText(input);
	}
	
	public void handleClick_6() {
		input += "6";
		skjerm.setText(input);
	}
	
	public void handleClick_7() {
		input += "7";
		skjerm.setText(input);
	}
	
	public void handleClick_8() {
		input += "8";
		skjerm.setText(input);
	}
	
	public void handleClick_9() {
		input += "9";
		skjerm.setText(input);
	}
	
	public void handleClick_clear() {
		skjerm.clear();
		input = "";
		input1 = null;
		output = null;
		//kan jeg sette intene til noe annet enn 0? 
	}
	
	public void handleClick_lik() {
		input2 = Integer.parseInt(input);
		//settes den nå til det man taster inn?
		//Double output = null;
		if (operator.equals("*")) {
			if (input1 != null) {
				output = kalkulator.gange(input1, input2);
			}
			else {
				handleClick_clear();
			}
		}
		
		if (operator.equals("/")) {
			if (input1 != null) {
				output = kalkulator.dele(input1, input2);
			}
			else {
				handleClick_clear();
			}
		}
		
		if (operator.equals("+")) {
			if (input1 != null) {
				output = (double) kalkulator.pluss(input1, input2);
			}
			else {
				handleClick_clear();
			}

		}
		
		if (operator.equals("-")) {
			if (input1 != null) {
				output = (double) kalkulator.minus(input1, input2);
			}
			else {
				handleClick_clear();
			}
		}
		
		
		//skal lagre historie
		
		if (!output.equals(null)) {
			historie.vise(input1,input2,operator, output, file);
			skjerm.setText(Double.toString(output));
		}
		else {
			skjerm.setText("");
		}
		
		input1 = null;
		input2 = null;
		input = "";
		output = null;
				
		//hvis man bare vil fortsette
	}
	
	public void handleclick_vise() {
		String forrige = historie.lese(file);
		skjerm.setText(forrige);
	}

}

//kobler sammen App.fxml med kalkulator.java
