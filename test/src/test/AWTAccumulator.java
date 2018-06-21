package test;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame implements ActionListener {
	private Label lblInput;
	private Label lblOutput;
	private TextField tfInput;
	private TextField tfOutput;
	private double sum = 0;
	
	public AWTAccumulator() {
		setLayout(new FlowLayout());
		
		lblInput = new Label("Enter a double: ");
		add(lblInput);
		
		tfInput = new TextField(10);
		add(tfInput);
		
		tfInput.addActionListener(this);
		
		lblOutput = new Label("The accumulated sum is: ");
		add(lblOutput);
		
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);
		
		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTAccumulator();
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		double numberDbe = Double.parseDouble(tfInput.getText());
		sum += numberDbe;
		tfInput.setText("");
		tfOutput.setText(sum + "");
		
	}
}
