package test;

import java.awt.*;
import java.awt.event.*;

public class AWTCounterAnonymousInnerClass extends Frame {
	private TextField tfCount;
	private Button btnCountUp;
	private Button btnCountDown;
	private Button btnReset;
	
	private int count = 0;
	
	public AWTCounterAnonymousInnerClass() {
		setLayout(new FlowLayout());
		add(new Label("Counter: "));
		tfCount = new TextField("0", 10);
		tfCount.setEditable(false);
		add(tfCount);
		
		btnCountUp = new Button("Count Up");
		add(btnCountUp);
		btnCountUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				++count;
				tfCount.setText(count + "");
			}
		});
		
		btnCountDown = new Button("Count Down");
		add(btnCountDown);
		btnCountDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				--count;
				tfCount.setText(count + "");
			}
		});
		
		btnReset = new Button("Reset");
		add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				count = 0;
				tfCount.setText(count + "");
			}
		});
		
		setTitle("AWT Counter");
		setSize(250, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTCounterAnonymousInnerClass();
	}
	
	

}
