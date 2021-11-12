import DAOS.ClienteDAO;
import models.Cliente;

public class teste {

	public static void main(String[] args) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome("Mikael Tavares");
		cliente.setIdade("20");
		cliente.setCpf("17078982789");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
	}

}
