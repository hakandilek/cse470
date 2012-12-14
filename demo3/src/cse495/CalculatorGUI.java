package cse495;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class CalculatorGUI implements ActionListener, ItemListener, KeyListener {

	@Inject
	private NumberFormat format;

	private final Calculator calculator;

	private final JFrame frame;

	private final JTextField number1;

	private final JTextField number2;

	private final JComboBox<Character> operator;

	private final JButton calculate;

	private final JLabel result;

	@Inject
	CalculatorGUI(Calculator calculator, JFrame frame,
			@Named("number1") JTextField number1,
			@Named("number2") JTextField number2,
			JComboBox<Character> operator, JButton calculate, JLabel result) {
		super();
		this.calculator = calculator;
		this.frame = frame;
		this.number1 = number1;
		this.number2 = number2;
		this.number1.addKeyListener(this);
		this.number2.addKeyListener(this);
		this.result = result;
		this.calculate = calculate;
		this.calculate.addActionListener(this);
		this.operator = operator;
		this.operator.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		calculate();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		calculate();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		calculate();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	public void show() {
		calculate();
		frame.setVisible(true);
	}

	private void calculate() {
		Float res = 0f, n1 = 0f, n2 = 0f;
		int idx = operator.getSelectedIndex();
		char sel = operator.getModel().getElementAt(idx);
		try {
			n1 = format.parse(number1.getText()).floatValue();
		} catch (Exception e) {
			number1.setText(format.format(0));
		}
		try {
			n2 = format.parse(number2.getText()).floatValue();
		} catch (Exception e) {
			number2.setText(format.format(0));
		}
		switch (sel) {
		case '+':
			res = calculator.add(n1, n2);
			break;
		case '-':
			res = calculator.subtract(n1, n2);
			break;
		case '*':
			res = calculator.multiply(n1, n2);
			break;
		case '/':
			res = calculator.divide(n1, n2);
			break;
		default:
			break;
		}

		String text;
		if (res.isInfinite() || res.isNaN()) {
			text = res + "";
		} else {
			text = format.format(res);
		}
		result.setText(text);
		frame.pack();
	}

}
