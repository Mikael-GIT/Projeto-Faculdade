package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAOS.ClienteDAO;
import models.Cliente;

public class Cliente1View extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente1View frame = new Cliente1View();
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
	public Cliente1View() {
		setTitle("Tela de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(36, 51, 86, 20);
		contentPane.add(txtId);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(36, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorId(Long.parseLong(txtId.getText()));
			}
		});
		btnNewButton_1.setBounds(144, 50, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(36, 106, 86, 20);
		contentPane.add(txtNome);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(36, 86, 46, 14);
		contentPane.add(lblNome);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(36, 170, 86, 20);
		contentPane.add(txtIdade);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(36, 150, 46, 14);
		contentPane.add(lblIdade);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(36, 232, 86, 20);
		contentPane.add(txtCpf);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(36, 212, 46, 14);
		contentPane.add(lblCpf);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnNewButton.setBounds(61, 297, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAtualziar = new JButton("Atualizar");
		btnAtualziar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar(Long.parseLong(txtId.getText()));
			}
		});
		btnAtualziar.setBounds(175, 297, 89, 23);
		contentPane.add(btnAtualziar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir(Long.parseLong(txtId.getText()));
			}
		});
		btnExcluir.setBounds(290, 297, 89, 23);
		contentPane.add(btnExcluir);
	}
	
	public void atualizar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.consultarPorId(id);
		try {
			clienteDAO.salvar(cliente);
			JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void salvar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setNome(txtNome.getText());
		cliente.setIdade(txtIdade.getText());
		cliente.setCpf(txtCpf.getText());
		try {
			clienteDAO.salvar(cliente);
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void buscarPorId(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
		Cliente cliente = clienteDAO.consultarPorId(Long.parseLong(txtId.getText()));
		txtNome.setText(cliente.getNome());
		txtIdade.setText(cliente.getIdade());
		txtCpf.setText(cliente.getCpf());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void excluir(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluir(id);
		JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
	}

}
