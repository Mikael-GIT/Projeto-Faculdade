package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class PrincipalView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView window = new PrincipalView();
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
	public PrincipalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 463);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 180, 424);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente1View cliente = new Cliente1View();
				cliente.setVisible(true);
			}
		});
		btnNewButton.setBounds(37, 51, 103, 23);
		panel.add(btnNewButton);

		JButton btnMotocicletas = new JButton("Motocicletas");
		btnMotocicletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotocicletasView motocicleta = new MotocicletasView();
				motocicleta.setVisible(true);
			}
		});
		btnMotocicletas.setBounds(37, 105, 103, 23);
		panel.add(btnMotocicletas);

		JButton btnNewButton_1_1 = new JButton("Vendas");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VendasView frame = new VendasView();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(37, 168, 103, 23);
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(37, 227, 103, 23);
		panel.add(btnNewButton_1_1_1);

		JLabel lblNewLabel = new JLabel("Bem vindo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(297, 11, 196, 173);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblAoLojaDesktop = new JLabel("ao Loja Desktop!");
		lblAoLojaDesktop.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblAoLojaDesktop.setBounds(261, 58, 346, 173);
		frame.getContentPane().add(lblAoLojaDesktop);
	}
}
