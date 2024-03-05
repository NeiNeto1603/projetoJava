package SistemaVendas;

public class Veiculo {
	
	private String marca;
	private String nome;
	private double valor;
	private double quantidade;

	public String getmarca() {
		return marca;
	}

	public void setmarca(String marca) {
		this.marca = marca;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto [marca=" + marca + ", nome=" + nome + ", valor=" + valor + "]";
	}

}
