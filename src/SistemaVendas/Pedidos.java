package SistemaVendas;

import java.util.ArrayList;

import java.util.List;

public class Pedidos {

	double valor;
	String nome;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	Veiculo veiculo = new Veiculo();

	private List<Veiculo> listaVeiculos = new ArrayList<>();

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculo(List<Veiculo> listaVeiculo) {
		this.listaVeiculos = listaVeiculo;
	}

	public void adicionarVeiculo(Veiculo veiculo) {

		listaVeiculos.add(veiculo);
		System.out.println("meu carro"+ veiculo);
		// veiculo = new Veiculo();
	}

	public void removerVeiculo(String marca) {
		for (int i = 0; i < listaVeiculos.size(); i++) {
			Veiculo veiculo = listaVeiculos.get(i);
			if (veiculo.getmarca().equals(marca)) {
				listaVeiculos.remove(i);

			}
		}

	}

	public void alterarVeiculo(Veiculo p) {
		for (int i = 0; i < listaVeiculos.size(); i++) {
			Veiculo veiculo = listaVeiculos.get(i);
			if (veiculo.getmarca().equals(p.getmarca())) {
				veiculo.setnome(p.getnome());
				veiculo.setValor(p.getValor());

			} 

		}

	}

	public double getTotal() {
		double total = 0;

		for (Veiculo veiculo : listaVeiculos) {
			total = total + (veiculo.getQuantidade() * veiculo.getValor());
		}
		return total;
	}

	
}
