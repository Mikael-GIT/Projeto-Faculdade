package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOS.ClienteDAO;
import DAOS.MotocicletaDAO;
import models.Cliente;
import models.Motocicleta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MotocicletasView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MotocicletasView frame = new MotocicletasView();
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
	public MotocicletasView() {
		setTitle("Tela de Motocicletas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(34, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(34, 63, 86, 20);
		contentPane.add(txtId);
		
		JButton btnBuscarPorId = new JButton("Buscar");
		btnBuscarPorId.setBounds(142, 62, 89, 23);
		contentPane.add(btnBuscarPorId);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(34, 98, 86, 14);
		contentPane.add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(34, 118, 86, 20);
		contentPane.add(txtFabricante);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(34, 162, 46, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(34, 182, 86, 20);
		contentPane.add(txtModelo);
		
		JLabel lblVaor = new JLabel("Valor");
		lblVaor.setBounds(34, 224, 46, 14);
		contentPane.add(lblVaor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(34, 244, 86, 20);
		contentPane.add(txtValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(59, 309, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(173, 309, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(288, 309, 89, 23);
		contentPane.add(btnExcluir);
	}
	
	public void atualizar(Long id) {
		MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
		Motocicleta motocicleta = motocicletaDAO.consultarPorId(id);
		try {
			motocicletaDAO.salvar(motocicleta);
			JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void salvar() {
		MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
		Motocicleta motocicleta = new Motocicleta();
		txtFabricante.setText(motocicleta.getFabricante());
		txtModelo.setText(motocicleta.getModelo());
		txtValor.setText(String.valueOf(motocicleta.getValor()));
		try {
			motocicletaDAO.salvar(motocicleta);
			JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void buscarPorId(Long id) {
		MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
		try {
		Motocicleta motocicleta = motocicletaDAO.consultarPorId(Long.parseLong(txtId.getText()));
		txtFabricante.setText(motocicleta.getFabricante());
		txtModelo.setText(motocicleta.getModelo());
		txtValor.setText(String.valueOf(motocicleta.getValor()));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void excluir(Long id) {
		MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
		motocicletaDAO.excluir(id);
		JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
	}

}
