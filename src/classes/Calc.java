package classes;

public class Calc
{
	private double number1, number2, memory;
	private String result;
	private Operation operation;

	public Calc()
	{
	}

	public double getNumber1()
	{
		return number1;
	}

	public void setNumber1(double number1)
	{
		this.number1 = number1;
	}

	public double getNumber2()
	{
		return number2;
	}

	public void setNumber2(double number2)
	{
		this.number2 = number2;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public Operation getOperation()
	{
		return operation;
	}

	public void setOperation(Operation operation)
	{
		this.operation = operation;
	}

	public void calculate()
	{
		switch (operation) {
			case plus:
				setResult(String.valueOf(number1 + number2));
				break;
			case minus:
				setResult(String.valueOf(number1 - number2));
				break;
			case multiply:
				setResult(String.valueOf(number1 * number2));
				break;
			case divide:
				if (number2 != 0)
					setResult(String.valueOf(number1 / number2));
				else
					setResult("Division by zero!");
				break;
			case sqrt:
				if (number1 >= 0)
					setResult(String.valueOf(Math.sqrt(number1)));
				else
					setResult("No root of negative number!");
				break;
		}

		result = simplify(result);
	}

	public String simplify(String number)
	{
		return number.substring(number.length()-2, number.length()).equals(".0") ? number.substring(0,
				number.length()-2) : number;
	}

	public double getMemory()
	{
		return memory;
	}

	public void setMemory(double memory)
	{
		this.memory = memory;
	}

}
