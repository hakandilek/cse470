package cse495;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CalculatorModule());
		CalculatorGUI gui = injector.getInstance(CalculatorGUI.class);
		gui.show();
	}

}
