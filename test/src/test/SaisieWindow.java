package test;

import java.awt.Color;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaisieWindow {

	JFrame frame;
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
					window.frame.setTitle("Fenêtre de saisie");
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
		panel.setBackground(Color.CYAN);
		
		JLabel lblNewLabel = new JLabel("Ins\u00E9rez les valeurs de la matrice !");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 11, 206, 38);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(216, 94, 174, 67);
		table.setModel(dtm);
		panel.add(table);
		
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
		spinner_Ligne.setBounds(136, 108, 29, 20);
		panel.add(spinner_Ligne);
		
		JLabel lblLignes = new JLabel("Lignes :");
		lblLignes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLignes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLignes.setBounds(60, 106, 83, 20);
		panel.add(lblLignes);
		
		JButton btn_Terminer = new JButton("Terminer");
		btn_Terminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow mw = new MainWindow();
				mw.matrice.changerDimension(dtm.getRowCount(), dtm.getColumnCount());
				for (int i=0; i<dtm.getRowCount(); i++) {
					for (int j=0; j<dtm.getColumnCount(); j++) {
						Object o = dtm.getValueAt(i, j);
						if (o==null) {
							mw.matrice.setValueAt(i, j, 0);
						} else {
							String valueS = o.toString();
							int value = Integer.parseInt(valueS.trim());
							mw.matrice.setValueAt(i, j, value);
						}
					}
				}
				mw.matrice.showValues();
				mw.textArea_Matrice.setText(mw.matrice.showValues());
				mw.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_Terminer.setBounds(165, 193, 89, 23);
		panel.add(btn_Terminer);
	}

}
