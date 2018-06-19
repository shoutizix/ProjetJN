package test;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class MainWindow {

	JFrame frame;
	private JTextField textField_Colonne;
	private JTextField textField_Ligne;
	private JTextField textField_Chiffre;
	public Matrice matrice = new Matrice(3,3);
	JTextArea textArea_Matrice = new JTextArea();
	JTextArea textArea_Matrice2 = new JTextArea();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					window.frame.setTitle("Algorithme du Simplexe en Java");
					//window.frame.setBackground(Color.ORANGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 538, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 522, 471);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_M = new JPanel();
		tabbedPane.addTab("Calcul de matrice", null, panel_M, null);
		panel_M.setLayout(null);
		panel_M.setBackground(Color.CYAN);
		
		textArea_Matrice.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea_Matrice.setEditable(false);
		textArea_Matrice.setBounds(95, 28, 147, 135);
		panel_M.add(textArea_Matrice);
		
		JLabel label_Egal = new JLabel("=");
		label_Egal.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_Egal.setHorizontalAlignment(SwingConstants.CENTER);
		label_Egal.setBounds(252, 87, 43, 20);
		panel_M.add(label_Egal);
		
		
		textArea_Matrice2.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea_Matrice2.setEditable(false);
		textArea_Matrice2.setBounds(306, 31, 183, 135);
		panel_M.add(textArea_Matrice2);
		
		JLabel lblNombreDeColonne = new JLabel("Nombre de colonne :");
		lblNombreDeColonne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeColonne.setBounds(144, 189, 131, 14);
		panel_M.add(lblNombreDeColonne);
		
		textField_Colonne = new JTextField();
		textField_Colonne.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Colonne.setText("3");
		textField_Colonne.setBounds(306, 186, 28, 20);
		panel_M.add(textField_Colonne);
		textField_Colonne.setColumns(10);
		
		JLabel lblNombreDeLigne = new JLabel("Nombre de ligne :");
		lblNombreDeLigne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeLigne.setBounds(164, 220, 121, 17);
		panel_M.add(lblNombreDeLigne);
		
		textField_Ligne = new JTextField();
		textField_Ligne.setText("3");
		textField_Ligne.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Ligne.setBounds(306, 217, 28, 20);
		panel_M.add(textField_Ligne);
		textField_Ligne.setColumns(10);
		
		JButton btn_DefaultValues = new JButton("Valeurs par d\u00E9faut");
		btn_DefaultValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nbreLS = textField_Ligne.getText();
				int nbreL = Integer.parseInt(nbreLS);
				String nbreCS = textField_Colonne.getText();
				int nbreC = Integer.parseInt(nbreCS);
				matrice.changerDimension(nbreL, nbreC);
				matrice.valeurParDefaut(); 
				textArea_Matrice.setText(matrice.showValues());
				frame.revalidate();
			}
		});
		btn_DefaultValues.setBounds(7, 257, 147, 23);
		panel_M.add(btn_DefaultValues);
		
		JButton btn_SetValues = new JButton("Valeurs personnalis\u00E9es");
		btn_SetValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaisieWindow sw = new SaisieWindow();
				sw.frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton btn_RandomValues = new JButton("Valeurs al\u00E9atoires");
		btn_RandomValues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nbreLS = textField_Ligne.getText();
				int nbreL = Integer.parseInt(nbreLS);
				String nbreCS = textField_Colonne.getText();
				int nbreC = Integer.parseInt(nbreCS);
				matrice.changerDimension(nbreL, nbreC);
				matrice.randomValues();
				textArea_Matrice.setText(matrice.showValues());
				frame.revalidate();
			}
		});
		btn_RandomValues.setBounds(174, 257, 149, 23);
		panel_M.add(btn_RandomValues);
		btn_SetValues.setBounds(333, 257, 174, 23);
		panel_M.add(btn_SetValues);
		
		JLabel lblOprations = new JLabel("Op\u00E9rations :");
		lblOprations.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOprations.setBounds(54, 291, 100, 29);
		panel_M.add(lblOprations);
		
		JButton btn_CalculerInverse = new JButton("Calculer Inverse");
		btn_CalculerInverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Matrice2.setText(matrice.calculerInverse());
				frame.revalidate();
			}
		});
		btn_CalculerInverse.setBounds(54, 331, 128, 23);
		panel_M.add(btn_CalculerInverse);
		
		JButton btn_MuliplierMatrice = new JButton("Muliplier avec une autre matrice");
		btn_MuliplierMatrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaisieWindow2 sw2 = new SaisieWindow2(matrice);
				sw2.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_MuliplierMatrice.setBounds(226, 331, 228, 23);
		panel_M.add(btn_MuliplierMatrice);
		
		JLabel lblMultiplierParUn = new JLabel("Multiplier par un chiffre :");
		lblMultiplierParUn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMultiplierParUn.setBounds(54, 386, 145, 20);
		panel_M.add(lblMultiplierParUn);
		
		textField_Chiffre = new JTextField();
		textField_Chiffre.setBounds(212, 388, 43, 20);
		panel_M.add(textField_Chiffre);
		textField_Chiffre.setColumns(10);
		
		JButton btn_MultiplierInt = new JButton("Multiplier");
		btn_MultiplierInt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chiffreS = textField_Chiffre.getText();
				int chiffre = Integer.parseInt(chiffreS);
				textArea_Matrice2.setText(matrice.multiplierParInt(chiffre));
				frame.revalidate();
			}
		});
		btn_MultiplierInt.setBounds(279, 387, 89, 23);
		panel_M.add(btn_MultiplierInt);
		
		
		
		JPanel panel_S = new JPanel();
		tabbedPane.addTab("Algorithme du Simplexe", null, panel_S, null);
		panel_S.setLayout(null);
		
		JLabel lblPremierCritreDe = new JLabel("Premier crit\u00E8re de Dantzig :");
		lblPremierCritreDe.setBounds(107, 101, 155, 23);
		panel_S.add(lblPremierCritreDe);
		
		JLabel lblDeuximeCritreDe = new JLabel("Deuxi\u00E8me crit\u00E8re de Dantzig :");
		lblDeuximeCritreDe.setBounds(107, 55, 177, 23);
		panel_S.add(lblDeuximeCritreDe);
				
		JTextArea textArea_DeuxiemeCD = new JTextArea();
		textArea_DeuxiemeCD.setBounds(294, 54, 33, 23);
		panel_S.add(textArea_DeuxiemeCD);
		
		JTextArea textArea_PremierCD = new JTextArea();
		textArea_PremierCD.setBounds(272, 100, 33, 23);
		panel_S.add(textArea_PremierCD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 164, 323, 82);
		panel_S.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Z =", null, null, null},
				{"x3 =", null, null, null},
				{"x4 =", null, null, null},
			},
			new String[] {
				"", "", "-x1", "-x2"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btn_MontrerLePivot = new JButton("Montrer le pivot");
		btn_MontrerLePivot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();

				int[][] tableau = new int[dtm.getRowCount()][dtm.getColumnCount()-1];
				
				for (int i=0; i<dtm.getRowCount(); i++) {
					for (int j=1; j<dtm.getColumnCount(); j++) {
						Object o = dtm.getValueAt(i, j);
						if (o==null) {
							table.setValueAt(0, i, j);
							tableau[i][j-1] = 0;
						} else {
							String valueS = o.toString();
							int value = Integer.parseInt(valueS.trim());
							tableau[i][j-1] = value;
						}
					}
				}
				
				AlgoSimplex alg = new AlgoSimplex(tableau);
				textArea_DeuxiemeCD.setText(String.valueOf(table.getValueAt(0, alg.deuxiemeCDantzig())));
				textArea_PremierCD.setText(String.valueOf(tableau[alg.premierCDantzig(alg.deuxiemeCDantzig())][alg.deuxiemeCDantzig()]));
				frame.revalidate();
				
				
				
			}
		});
		btn_MontrerLePivot.setBounds(77, 282, 131, 23);
		panel_S.add(btn_MontrerLePivot);
		
		JButton btn_Pivoter = new JButton("Pivoter");
		btn_Pivoter.setBounds(312, 282, 89, 23);
		panel_S.add(btn_Pivoter);
				
		//panel_S.setBackground(new ImageIcon("220px-Simplex-method-3-dimensions"));
		//panel_S.setBackground(new JLabel(new ImageIcon("resources/taverna.jpg")));
	}
}
