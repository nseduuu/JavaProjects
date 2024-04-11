package br.com.construtora.model;

public class Apartamento extends Imovel {

	private int quantidadeVarandas;

	public int getQuantidadeVarandas() {
		return quantidadeVarandas;
	}

	public void setQuantidadeVarandas(int quantidadeVarandas) {
		this.quantidadeVarandas = quantidadeVarandas;
	}
	
	public void retornarDados() {
		
		Apartamento apartamentoNovo =  new Apartamento();
		
		apartamentoNovo.setNome("ApartamentoDoLuvas");
		apartamentoNovo.setMetrosQuadrados(250);
		apartamentoNovo.setQuantidadeQuartos(40);
		apartamentoNovo.setQuantidadeVarandas(25);
		
		System.out.println("Nome: " + apartamentoNovo.getNome() + 
				"\nMetros quadrados: " + apartamentoNovo.getMetrosQuadrados() +
				"\nQuatidade de quartos: " + apartamentoNovo.getQuantidadeQuartos() +
				"\nQuantidade de varandas: " + apartamentoNovo.getQuantidadeVarandas());
	}
	
}
