package entities;

public class Carro {

	private String modelo;
	private double precoDiaria;
	private CategoriaCarro categoria;
	
	
	public Carro(String modelo, double precoDiaria, CategoriaCarro categoria) {
		this.modelo = modelo;
		this.precoDiaria = precoDiaria;
		this.categoria = categoria;
	}


	public String getModelo() {
		return modelo;
	}


	public double getPrecoDiaria() {
		return precoDiaria;
	}


	public void setPrecoDiaria(double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}


	public CategoriaCarro getCategoria() {
		return categoria;
	}


	public String toString(){
		return " ||Modelo: " + modelo 
				+ " ||Categoria: " + categoria +
				" ||Diária: " + precoDiaria;
	}
	
	
	
	
	
	
	
	
	
}

