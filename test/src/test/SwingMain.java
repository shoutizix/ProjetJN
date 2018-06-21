package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int count = 0;
	private JButton btnCountDown;
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCounter = new JLabel("Counter");
		contentPane.add(lblCounter);
		
		textField = new JTextField();
		textField.setText("0");
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCount = new JButton("Count");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				textField.setText(count + "");
			}
		});
		contentPane.add(btnCount);
		
		btnCountDown = new JButton("Count Down");
		btnCountDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count--;
				textField.setText(count + "");
			}
		});
		contentPane.add(btnCountDown);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 0;
				textField.setText(count + "");
			}
		});
		contentPane.add(btnReset);
	}

}
