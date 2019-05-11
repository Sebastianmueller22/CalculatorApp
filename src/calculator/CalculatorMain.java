package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorMain extends Application {

	String firstNumberString;
	String secondNumberString;
	Double firstNumber;
	Double secondNumber;
	TextField inputFirstNumber;
	TextField inputSecondNumber;
	TextField outputTextField;
	Button addButton;
	Button subtractButton;
	Button multiplyButton;
	Button divideButton;
	Button moduloButton;
	Label resultLabel;
	Label firstNumberLabel;
	Label secondNumberLabel;

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * takes the User Input and stores it in two variables.
	 *
	 */
	public void getText() {
		firstNumberString = inputFirstNumber.getText();
		secondNumberString = inputSecondNumber.getText();
	}
	
	
	
	/**
	 * defines what happens, when the add Button is clicked
	 */
	public void handleAddButton() {
		addButton.setOnAction(e -> {
				getText();
				try {
					firstNumber = Double.valueOf(firstNumberString);
					secondNumber = Double.valueOf(secondNumberString);
					outputTextField.setText(String.valueOf(add()));
				} catch (Exception ex) {
					ErrorMessage.display();
				}
			}
		);
	}

	/**
	 * defines what happens, when the multiply Button is clicked
	 */
	public void handleMultiplyButton() {
		multiplyButton.setOnAction(e -> {
			getText();
				try {
					firstNumber = Double.valueOf(firstNumberString);
					secondNumber = Double.valueOf(secondNumberString);
					outputTextField.setText(String.valueOf(multiply()));
				} catch (Exception ex) {
					ErrorMessage.display();
				}

			}

		);
	}

	/**
	 * defines what happens, when the subtract Button is clicked.
	 */
	public void handleSubtractButton() {
		subtractButton.setOnAction(e -> {
				getText();
				try {
					firstNumber = Double.valueOf(firstNumberString);
					secondNumber = Double.valueOf(secondNumberString);
					outputTextField.setText(String.valueOf(subtract()));
				} catch (Exception ex) {
					ErrorMessage.display();
				}
			}
		);
	}

	/**
	 * defines what happens, when the divide Button is clicked.
	 */
	public void handleDivideButton() {
		divideButton.setOnAction(e -> {
				getText();
				try {
					firstNumber = Double.valueOf(firstNumberString);
					secondNumber = Double.valueOf(secondNumberString);
					outputTextField.setText(String.valueOf(divide()));
				} catch (Exception ex) {
				ErrorMessage.display();
				}

			}

		);
	}

	/**
	 * defines what happens, when the modulo Button is clicked
	 */
	public void handleModuloButton() {
		moduloButton.setOnAction(e -> {
				getText();
				try {
					firstNumber = Double.valueOf(firstNumberString);
					secondNumber = Double.valueOf(secondNumberString);
					outputTextField.setText(String.valueOf(modulo()));
				} catch (Exception ex) {
				ErrorMessage.display();
				}

			}
		);
	}

	/**
	 * initializes the Buttons, Textfields and Labels and arranges them on the Pane
	 */
	public void initializeAndArrange() {
		// create Buttons
		addButton = new Button("+");
		GridPane.setConstraints(addButton, 13, 2);
		subtractButton = new Button("-");
		GridPane.setConstraints(subtractButton, 13, 3);
		divideButton = new Button("/");
		GridPane.setConstraints(divideButton, 13, 4);
		multiplyButton = new Button("*");
		GridPane.setConstraints(multiplyButton, 13, 5);
		moduloButton = new Button("%");
		GridPane.setConstraints(moduloButton, 13, 6);

		// create Textfields
		inputFirstNumber = new TextField();
		GridPane.setConstraints(inputFirstNumber, 9, 2);
		inputSecondNumber = new TextField();
		GridPane.setConstraints(inputSecondNumber, 9, 4);
		outputTextField = new TextField();
		GridPane.setConstraints(outputTextField, 9, 6);

		// create Labels
		resultLabel = new Label();
		GridPane.setConstraints(resultLabel, 9, 5);
		resultLabel.setText("result:");
		secondNumberLabel = new Label();
		GridPane.setConstraints(secondNumberLabel, 9, 3);
		secondNumberLabel.setText("second number:");
		firstNumberLabel = new Label();
		GridPane.setConstraints(firstNumberLabel, 9, 1);
		firstNumberLabel.setText("first Number:");
	}

	/**
	 * divides two numbers
	 * 
	 * @requires secondNumber!=0;
	 *
	 */
	public double divide() {
			return 	firstNumber / secondNumber;
	}

	/**
	 * multiplies two Integers
	 */
	public double multiply() {
		return firstNumber * secondNumber;
	}

	/**
	 * adds two Doubles
	 * 
	 * @return the result of the Addition
	 */
	public double add() {
		return firstNumber + secondNumber;

	}

	/**
	 * subtracts to Integers from one another.
	 * 
	 * @requires \result>=Integer.MIN_VALUE;
	 * @return the result of the Substraction;
	 */
	public double subtract() {
		return firstNumber - secondNumber;
	}

	/**
	 * compares two numbers by the modulo operator
	 */
	public double modulo() {
		return firstNumber % secondNumber;
	}

	/**
	 * sets up the scene, adds all nodes to the Pane and arranges them.
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setVgap(8);
		root.setHgap(10);

		primaryStage.setTitle("Calculator 1.0");
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

		// initialize Buttons, Labels and Textfields and arrange them on the Pane
		initializeAndArrange();

		// handle User Events
		handleAddButton();
		handleSubtractButton();
		handleDivideButton();
		handleMultiplyButton();
		handleModuloButton();

		// add nodes to gridPane
		root.getChildren().addAll(addButton, subtractButton, inputFirstNumber, inputSecondNumber, divideButton,
				multiplyButton, outputTextField, moduloButton, secondNumberLabel, firstNumberLabel, resultLabel);

	}

}
