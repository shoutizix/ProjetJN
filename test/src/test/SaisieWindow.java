package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SaisieWindow {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaisieWindow window = new SaisieWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaisieWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ins\u00E9rez les valeurs de la matrice !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 11, 206, 38);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(192, 60, 206, 169);
		panel.add(table);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(153, 83, 29, 20);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(153, 155, 29, 20);
		panel.add(spinner_1);
		
		JLabel lblNewLabel_1 = new JLabel("Colonnes :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 81, 83, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblLignes = new JLabel("Lignes :");
		lblLignes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLignes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLignes.setBounds(60, 153, 83, 20);
		panel.add(lblLignes);
	}
}
