
// Sets package for program.
package application;

//Import all necessary files for code.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.lang.Math;
import java.text.DecimalFormat;

public class Main extends Application {

	TextField tfNum1;
	TextField tfNum2;
	Button btnAddition;
	Button btnSubtraction;
	Button btnMultiply;
	Button btnDivide;
	Button btnPower;
	Button btnSquareRoot;
	Button btnAbsoluteValue;
	Button btnFloor;
	Button btnCeiling;
	Button btnFactorial;
	Button btnClear;
	Label lblAnswer;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Initialization
			tfNum1 = new TextField();
			tfNum2 = new TextField();
			btnAddition = new Button("+");
			btnSubtraction = new Button("-");
			btnMultiply = new Button("*");
			btnDivide = new Button("/");
			btnPower = new Button("Power");
			btnSquareRoot = new Button("SqRt");
			btnAbsoluteValue = new Button("ABS");
			btnFloor = new Button("Floor");
			btnCeiling = new Button("Ceiling");
			btnFactorial = new Button("FTRL");
			btnClear = new Button("Clear");
			lblAnswer = new Label("?");

			// Layout using a GridPane
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setHgap(10);
			root.setVgap(10);

			// Layout of buttons.
			root.add(btnDivide, 0, 0);
			root.add(btnMultiply, 1, 0);
			root.add(btnAddition, 0, 1);
			root.add(btnSubtraction, 1, 1);
			root.add(btnPower, 2, 0);
			root.add(btnSquareRoot, 2, 1);
			root.add(btnAbsoluteValue, 3, 1);
			root.add(btnFloor, 3, 0);
			root.add(btnFactorial, 1, 2);
			root.add(btnCeiling, 2, 2);
			root.add(btnClear, 1, 7, 2, 1);

			// Layout for user inputs and output answer.
			root.add(tfNum1, 1, 3);
			root.add(tfNum2, 2, 3);
			root.add(lblAnswer, 1, 5, 2, 1);
			setWidths();
			attachCode();

			Scene scene = new Scene(root, 300, 250);
			primaryStage.setTitle("Calculator FX 1.0");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Sets widths for buttons, user input areas, and output area.
	private void setWidths() {
		tfNum1.setPrefWidth(70);
		tfNum2.setPrefWidth(70);
		btnDivide.setPrefWidth(70);
		btnMultiply.setPrefWidth(70);
		btnAddition.setPrefWidth(70);
		btnSubtraction.setPrefWidth(70);
		btnPower.setPrefWidth(70);
		btnSquareRoot.setPrefWidth(70);
		btnAbsoluteValue.setPrefWidth(70);
		btnFloor.setPrefWidth(70);
		btnCeiling.setPrefWidth(70);
		btnFactorial.setPrefWidth(70);
		btnClear.setPrefWidth(150);
		lblAnswer.setPrefWidth(150);
		lblAnswer.setAlignment(Pos.CENTER);
		lblAnswer.setStyle("-fx-border-color: #0000; -fx-padding: 5px;");
	}

	// Job of attachCode is to associate a function to a button.
	public void attachCode() {
		btnAddition.setOnAction(e -> btncode(e));
		btnSubtraction.setOnAction(e -> btncode(e));
		btnMultiply.setOnAction(e -> btncode(e));
		btnDivide.setOnAction(e -> btncode(e));
		btnPower.setOnAction(e -> btncode(e));
		btnSquareRoot.setOnAction(e -> btncode(e));
		btnAbsoluteValue.setOnAction(e -> btncode(e));
		btnFloor.setOnAction(e -> btncode(e));
		btnCeiling.setOnAction(e -> btncode(e));
		btnFactorial.setOnAction(e -> btncode(e));
		btnClear.setOnAction(e -> btncode(e));
	}

	public void btncode(ActionEvent e) {
		DecimalFormat df = new DecimalFormat("#,###,###,###,###.####"); // Decimal format used to format outputs.
		float num1, num2, answer = 0; // Local variables.
		char symbol = ' ';

		// If-else statement used to determine whether second input box is empty or not.
		num1 = Float.parseFloat(tfNum1.getText());
		if (tfNum2.getText().length() == 0) {
			num2 = 0;
		} else {
			num2 = Float.parseFloat(tfNum2.getText());
		}
		
		// Long if-else statement determines which button has been pressed by user, and then calculates appropriate answer for user choice and input.
		if (e.getSource() == btnAddition) {
			symbol = '+';
			answer = num1 + num2;
			lblAnswer.setText("" + num1 + symbol + num2 + "=" + df.format(answer));
		} else if (e.getSource() == btnSubtraction) {
			symbol = '-';
			answer = num1 - num2;
			lblAnswer.setText("" + num1 + symbol + num2 + "=" + df.format(answer));
		} else if (e.getSource() == btnMultiply) {
			symbol = '*';
			answer = num1 * num2;
			lblAnswer.setText("" + num1 + symbol + num2 + "=" + df.format(answer));
		} else if (e.getSource() == btnDivide) {
			symbol = '/';
			answer = num1 / num2;
			lblAnswer.setText("" + num1 + symbol + num2 + "=" + df.format(answer));
		} else if (e.getSource() == btnPower) {
			symbol = '^';
			answer = (float) Math.pow(num1, num2);
			lblAnswer.setText("" + num1 + symbol + num2 + "=" + df.format(answer));
		} else if (e.getSource() == btnSquareRoot) {
			num2 = 2;
			symbol = '^';
			answer = (float) Math.sqrt(num1);
			lblAnswer.setText("" + num1 + symbol + num2 + "=" + df.format(answer));
		} else if (e.getSource() == btnAbsoluteValue) {
			answer = (float) Math.abs(num1);
			lblAnswer.setText("" + num1 + "=" + answer);
		} else if (e.getSource() == btnFloor) {
			answer = (float) Math.floor(num1);
			lblAnswer.setText("" + num1 + "=" + df.format(answer));
		} else if (e.getSource() == btnCeiling) {
			answer = (float) Math.ceil(num1);
			lblAnswer.setText("" + num1 + "=" + df.format(answer));
		} else if (e.getSource() == btnFactorial) { //Factorial button will always convert user positive number if negative, or an integer if it is not.
			num1 = (int) num1;
			if (num1 < 0) {
				num1 = num1 * -1;
			}
			answer = 1;
			symbol = '!';
			for (float i = num1; i >= 1; i--) {
				answer = answer * i;
				lblAnswer.setText("" + num1 + symbol + "=" + df.format(answer));
			}
		}
		// Sets input and answer areas as blank if "Clear" is pressed.
		else {
			tfNum1.setText("");
			tfNum2.setText("");
			lblAnswer.setText("");
			tfNum1.requestFocus();
			return;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}