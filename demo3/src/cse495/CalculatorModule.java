package cse495;

import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

public class CalculatorModule extends AbstractModule {

	protected void configure() {
		bind(Calculator.class).asEagerSingleton();
		bind(CalculatorGUI.class).asEagerSingleton();
		bind(NumberFormat.class).toInstance(new DecimalFormat("#,##0.00"));
	}

	@Provides
	public JFrame frame(JPanel content) {
		JFrame frm = new JFrame("Calculator");
		frm.setContentPane(content);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocation(200, 200);
		frm.pack();
		return frm;
	}

	@Provides
	@Singleton
	public JPanel content(JComboBox<Character> operator,
			@Named("number1") JTextField number1,
			@Named("number2") JTextField number2,
			JButton calculate,
			JLabel result) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p.add(number1);
		p.add(operator);
		p.add(number2);
		p.add(calculate);
		p.add(result);
		return p;
	}

	@Provides
	@Singleton
	@Named("number1")
	public JTextField number1(NumberFormat format) {
		JTextField tf = new JTextField(format.format(10.50), 6);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		return tf;
	}

	@Provides
	@Singleton
	@Named("number2")
	public JTextField number2(NumberFormat format) {
		JTextField tf = new JTextField(format.format(300), 6);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		return tf;
	}

	@Provides
	@Singleton
	public JComboBox<Character> operator() {
		Character[] operators = new Character[] { '+', '-', '/', '*' };
		return new JComboBox<Character>(operators);
	}

	@Provides
	@Singleton
	public JButton calculate() {
		JButton btn = new JButton("=");
		return btn;
	}

	@Provides
	@Singleton
	public JLabel result() {
		return new JLabel("" + 0f);
	}
}
