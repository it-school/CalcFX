package classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller
{
	@FXML
	TextArea display;

	@FXML
	Label memLbl;

	boolean isFirstCalc = true;
	boolean isFromMemory = false;

	public void numberBtn(ActionEvent actionEvent)
	{
		if (isFromMemory == false) {
			String number = ((Button) actionEvent.getSource()).getText();
			if (display.getText().equals("0")) { display.setText(number); }
			else { display.setText(display.getText() + number); }
		}
	}

	public void commaBtn(ActionEvent actionEvent)
	{
		if (display.getText().equals("0")) {
			display.setText("0.");
		}
		else if (!display.getText().contains(".")) { display.setText(display.getText() + "."); }
	}

	public void clearBtn(ActionEvent actionEvent)
	{
		display.setText("0");
		Main.calc.setNumber1(0);
		Main.calc.setNumber2(0);
		Main.calc.setResult("0");
		Main.calc.setOperation(Operation.noop);
		isFirstCalc = true;
		isFromMemory = false;
	}

	public void clearEBtn(ActionEvent actionEvent)
	{
		display.setText(display.getText().substring(0, display.getText().length() - 1));
	}

	public void changeSignBtn(ActionEvent actionEvent)
	{
		//double number = -1 * Double.valueOf(display.getText());
		//display.setText(String.valueOf(number));

		display.setText(display.getText().toCharArray()[0] == '-' ? display.getText().substring(1,
				display.getText().length()) : "-" + display.getText());
	}


	public void sqrtBtnClick(ActionEvent actionEvent)
	{
		try {
			Main.calc.setNumber1(Double.parseDouble(display.getText()));
			Main.calc.setOperation(Operation.sqrt);
			Main.calc.calculate();
			display.setText(Main.calc.getResult());
		}
		catch (Exception exc) {
			display.setText("Can't get Number from display");
		}
	}

	public void calcBtn(ActionEvent actionEvent)
	{
		try {
			if (isFirstCalc) {
				Main.calc.setNumber2(Double.parseDouble(display.getText()));
			}
			else {
				Main.calc.setNumber1(Double.parseDouble(Main.calc.getResult()));
			}
			Main.calc.calculate();
			display.setText(Main.calc.getResult());
			isFirstCalc = false;
		}
		catch (Exception exc) {
		}
	}

	public void doubleElementOperClick(ActionEvent actionEvent)
	{
		try {
			Main.calc.setNumber1(Double.parseDouble(display.getText()));

			String operation = ((Button) actionEvent.getSource()).getText();
			switch (operation) {
				case "+":
					Main.calc.setOperation(Operation.plus);
					break;
				case "-":
					Main.calc.setOperation(Operation.minus);
					break;
				case "*":
					Main.calc.setOperation(Operation.multiply);
					break;
				case "/":
					Main.calc.setOperation(Operation.divide);
					break;
				default:
					Main.calc.setOperation(Operation.noop);
			}
			display.setText("0");
			isFirstCalc = true;
			isFromMemory = false;
		}
		catch (Exception exc) {
		}
	}

	public void clearMBtn(ActionEvent actionEvent)
	{
		Main.calc.setMemory(0);
	}

	public void readMBtn(ActionEvent actionEvent)
	{
		display.setText(Main.calc.simplify(String.valueOf(Main.calc.getMemory())));
		isFromMemory = true;
	}

	public void addMClick(ActionEvent actionEvent)
	{
		Main.calc.setMemory(Main.calc.getMemory() + Double.parseDouble(display.getText()));
		display.setText(Main.calc.simplify(String.valueOf(Main.calc.getMemory())));
		isFromMemory = true;
		memLbl.setVisible(Main.calc.getMemory() != 0 ? true : false);

	}
	public void subtMClick(ActionEvent actionEvent)
	{
		Main.calc.setMemory(Main.calc.getMemory() - Double.parseDouble(display.getText()));
		display.setText(Main.calc.simplify(String.valueOf(Main.calc.getMemory())));
		isFromMemory = true;
		memLbl.setVisible(Main.calc.getMemory() != 0 ? true : false);
	}
}
