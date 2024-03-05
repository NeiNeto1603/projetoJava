package SistemaVendas;

import java.util.ArrayList;
import java.util.List;

public class Orcamento extends Pedidos {
	

	Veiculo veiculo = new Veiculo();


	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String setnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public Veiculo getProduto() {
		return veiculo;
	}

	public void setProduto(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	private List<Veiculo> listaVeiculos = new ArrayList<>();

	//lista

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculo(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
       
	//adiciona
	public void adicionarVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	
	}
     //remove
	public void removerVeiculo(String marca) {
		for (int i = 0; i < listaVeiculos.size(); i++) {
			Veiculo produto = listaVeiculos.get(i);
			if (veiculo.getmarca().equals(marca)) {
				listaVeiculos.remove(i);

			}
		}

	}

  //altera
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
