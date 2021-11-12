package views;

import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAOS.ClienteDAO;
import DAOS.MotocicletaDAO;
import DAOS.VendasDAO;
import models.Cliente;
import models.Motocicleta;
import models.Venda;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VendasView extends JFrame {

	private JPanel contentPane;
	private static JTable jTable;
	static EntityManagerFactory factory = null;
    static EntityManager entityManager = null;
    private JTextField txtIdCliente;
    private JTextField txtIdMotocicleta;
    private JTextField txtQuantidade;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					VendasView frame = new VendasView();
					frame.setVisible(true);
				    try {
				      factory = Persistence.createEntityManagerFactory("loja");
				      entityManager = factory.createEntityManager();
				      List<Cliente> clientes = entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
				      DefaultTableModel tabela = (DefaultTableModel) jTable.getModel();
				      for (Cliente cliente : clientes) {
							tabela.addRow(cliente.obterDados(cliente.getNome(), cliente.getIdade(), cliente.getCpf()));
					  }
				      
				    } catch(Exception error) {
				    	JOptionPane.showMessageDialog(null, error);
				    }
				} 
		});
	}

	/**
	 * Create the frame.
	 */
	public VendasView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Id", "Idade", "Nome", "CPF"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		jTable.getColumnModel().getColumn(2).setPreferredWidth(76);
		jTable.setBounds(25, 268, 619, 134);
		contentPane.add(jTable);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(25, 68, 86, 20);
		contentPane.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtIdMotocicleta = new JTextField();
		txtIdMotocicleta.setBounds(25, 124, 86, 20);
		contentPane.add(txtIdMotocicleta);
		txtIdMotocicleta.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(25, 180, 86, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id do cliente");
		lblNewLabel.setBounds(25, 43, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdDaMotocicleta = new JLabel("Id da motocicleta");
		lblIdDaMotocicleta.setBounds(25, 99, 86, 14);
		contentPane.add(lblIdDaMotocicleta);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(25, 155, 86, 14);
		contentPane.add(lblQuantidade);
		
		JButton btnNewButton = new JButton("Realizar compra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar(Long.parseLong(txtIdCliente.getText()), Long.parseLong(txtIdMotocicleta.getText()));
			}
		});
		btnNewButton.setBounds(147, 67, 109, 23);
		contentPane.add(btnNewButton);
	}
	
	public void salvar(Long idCliente, Long idMotocicleta) {
		VendasDAO vendasDAO = new VendasDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
		Venda venda = new Venda();
		
		Cliente cliente = clienteDAO.consultarPorId(idCliente);
		Motocicleta motocicleta = motocicletaDAO.consultarPorId(idMotocicleta);
		
		venda.setCliente(cliente);
		venda.setDataVenda(LocalDateTime.now());
		
		try {
			vendasDAO.salvar(venda);
			JOptionPane.showMessageDialog(null, "Venda salva com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
