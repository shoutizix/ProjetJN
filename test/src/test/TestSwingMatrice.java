package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

public class TestSwingMatrice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Lance l'application !
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwingMatrice frame = new TestSwingMatrice();
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
	Matrice matrice = new Matrice(4,4);
	
	public TestSwingMatrice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 2, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCombienDeLignes = new JLabel("Combien de ligne(s) y a-t-il dans la matrice?");
		contentPane.add(lblCombienDeLignes);
		
		textField = new JTextField();
		textField.setText("4");
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCombienDeColonnes = new JLabel("Combien de colonne(s) y a-t-il dans la matrice");
		contentPane.add(lblCombienDeColonnes);
		
		textField_1 = new JTextField();
		textField_1.setText("4");
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblVoulezvousMettreDes = new JLabel("Voulez-vous mettre des valeurs?");
		contentPane.add(lblVoulezvousMettreDes);

		JButton btnOui = new JButton("Oui");
		btnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOui) {
					String nbreLS = textField.getText();
					int nbreL = Integer.parseInt(nbreLS);
					String nbreCS = textField_1.getText();
					int nbreC = Integer.parseInt(nbreCS);
					matrice.changerDimension(nbreL, nbreC);
					matrice.setValue();
					
				} 
			}
		});
		contentPane.add(btnOui);
		
		JButton btnNon = new JButton("Non");
		btnNon.addActionListener(new ActionListener() {
			JTextArea Jmatrice = new JTextArea();
			public void actionPerformed(ActionEvent e) {
				String nbreLS = textField.getText();
				int nbreL = Integer.parseInt(nbreLS);
				String nbreCS = textField_1.getText();
				int nbreC = Integer.parseInt(nbreCS);
				matrice.changerDimension(nbreL, nbreC);
				matrice.valeurParDefaut(); 
				Jmatrice.setText(matrice.showValues());
				contentPane.add(Jmatrice);
				revalidate();
			}						
		});
		contentPane.add(btnNon);
		
		
		
		JLabel lblVoulezvousMultiplierLa = new JLabel("Voulez-vous multiplier la matrice par une autre matrice ?");
		contentPane.add(lblVoulezvousMultiplierLa);
		
		JButton btnOui_1 = new JButton("Oui");
		contentPane.add(btnOui_1);
		
		JLabel lblCombienDeLignes_1 = new JLabel("Combien de ligne(s) y a-t-il dans la matrice ?");
		contentPane.add(lblCombienDeLignes_1);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCombienDeColonnes_1 = new JLabel("Combien de colonne(s) y a-t-il dans la matrice ?");
		contentPane.add(lblCombienDeColonnes_1);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea);
		
		JLabel lblVoulezvousVoirLa = new JLabel("Voulez-vous voir la matrice inverse ?");
		contentPane.add(lblVoulezvousVoirLa);
		
		JButton btnOui_inverse = new JButton("Oui");
		btnOui_inverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOui_inverse) {
					JTextArea JmatriceInverse = new JTextArea(matrice.calculerInverse());
					contentPane.add(JmatriceInverse);
					revalidate();
				} 
			}
		});
		contentPane.add(btnOui_inverse);
		
		JButton btnNon_inverse = new JButton("Non");
		contentPane.add(btnNon_inverse);
		
		JTextArea textArea_1 = new JTextArea();
		contentPane.add(textArea_1);
		
		JLabel lblVoulezvousMultiplierLa_1 = new JLabel("Voulez-vous multiplier la matrice par un int ? (O/N)");
		contentPane.add(lblVoulezvousMultiplierLa_1);
		
		JButton btnOui_Int = new JButton("Oui");
		btnOui_Int.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOui_Int) {
					JTextArea JmatriceInt = new JTextArea(matrice.multiplierParInt(3));
					contentPane.add(JmatriceInt);
					revalidate();
				} 
			}
		});
		contentPane.add(btnOui_Int);
		
		JTextArea textArea_2 = new JTextArea(3,3); // Crée un JtextArea vide de 3 lignes et 3 colonnes 
		contentPane.add(textArea_2);


		
		
	}

}
