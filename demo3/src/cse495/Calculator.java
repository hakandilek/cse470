package cse495;

public class Calculator {

	public float add(float n1, float n2) {
		return n1 + n2;
	}

	public float subtract(float n1, float n2) {
		return n1 - n2;
	}

	public float multiply(float n1, float n2) {
		return n1 * n2;
	}

	public float divide(float n1, float n2) {
		return n1 / n2;
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println("2 + 2 = " + c.add(2, 2));
		System.out.println("2 - 4 = " + c.subtract(2, 4));
		System.out.println("2 * 2 = " + c.multiply(2, 2));
		System.out.println("2 / 0 = " + c.divide(2, 0));
	}
}
