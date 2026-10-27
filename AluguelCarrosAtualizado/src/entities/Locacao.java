package entities;

public class Locacao {

	private int idContrato;
	private String nomeCliente;
	private int diasAlugados;
	private Carro carro;
	private StatusLocacao status;

	public Locacao(int idContrato, String nomeCliente, int diasAlugados, Carro carro, StatusLocacao status) {
		this.idContrato = idContrato;
		this.nomeCliente = nomeCliente;
		this.diasAlugados = diasAlugados;
		this.carro = carro;
		this.status = StatusLocacao.ATIVO;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public int getDiasAlugados() {
		return diasAlugados;
	}

	public Carro getCarro() {
		return carro;
	}

	public StatusLocacao getStatus() {
		return status;
	}

	public void setStatus(StatusLocacao status) {
		this.status = status;
	}

	public double calcularTotal() {
		double valorTotal = diasAlugados * carro.getPrecoDiaria();
		return valorTotal;
	}
	
	public String toString() {
		return "ID do contatro: " + idContrato 
				+ " ||Cliente: " + nomeCliente 
				+ " ||Status: " + status 
				+ carro 
				+ " ||Valor total: " + calcularTotal();
	}
	
}
