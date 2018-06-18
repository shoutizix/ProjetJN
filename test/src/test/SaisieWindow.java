package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.util.Vector;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SaisieWindow {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel(3,3);

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
		table.setModel(dtm);
		panel.add(table);
		
		JSpinner spinner_Colonne = new JSpinner();
		spinner_Colonne.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int chiffre = (int) spinner_Colonne.getValue();
				switch (chiffre) {
				case 2:
					if (table.getColumnCount()>2) {
						//dtm.removeColumn(0);
					} else {
						dtm.addColumn(0);
					}
					break;
				case 3:
					if (table.getColumnCount()>3) {
						//table.removcol
					} else {
						dtm.addColumn(0);
					}
					break;
				case 4:
					if (table.getColumnCount()>4) {
						//dtm.removeColumn(0);
					} else {
						dtm.addColumn(0);
					}
					break;
				}

			}
		});
		spinner_Colonne.setModel(new SpinnerNumberModel(3, 2, 4, 1));
		spinner_Colonne.setBounds(153, 83, 29, 20);
		panel.add(spinner_Colonne);
		
		JSpinner spinner_Ligne = new JSpinner();
		spinner_Ligne.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int chiffre = (int) spinner_Ligne.getValue();
				switch (chiffre) {
				case 2:
					if (table.getRowCount()>2) {
						dtm.removeRow(0);
					} else {
						Vector<String> ligne = new Vector<String>();
						dtm.addRow(ligne);
					}
					break;
				case 3:
					if (table.getRowCount()>3) {
						dtm.removeRow(0);
					} else {
						Vector<String> ligne = new Vector<String>();
						dtm.addRow(ligne);
					}
					break;
				case 4:
					if (table.getRowCount()>4) {
						dtm.removeRow(0);
					} else {
						Vector<String> ligne = new Vector<String>();
						dtm.addRow(ligne);
					}
					break;
				}
			}
		});
		spinner_Ligne.setModel(new SpinnerNumberModel(3, 2, 4, 1));
		spinner_Ligne.setBounds(153, 155, 29, 20);
		panel.add(spinner_Ligne);
		
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
