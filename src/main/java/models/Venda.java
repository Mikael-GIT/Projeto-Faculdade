package models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Venda {
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	@OneToOne(cascade = CascadeType.ALL)
	private Motocicleta motocicleta;
	private LocalDateTime dataVenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Motocicleta getMotocicleta() {
		return motocicleta;
	}

	public void setMotocicleta(Motocicleta motocicleta) {
		this.motocicleta = motocicleta;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

}
