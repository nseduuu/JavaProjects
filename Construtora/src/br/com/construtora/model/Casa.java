package br.com.construtora.model;

public class Casa extends Imovel{
	
	private double metrosQuadradosGaragem;

	public double getMetrosQuadradosGaragem() {
		return metrosQuadradosGaragem;
	}

	public void setMetrosQuadradosGaragem(double metrosQuadradosGaragem) {
		this.metrosQuadradosGaragem = metrosQuadradosGaragem;
	}
	
	public void retornarDados() {
		
		Casa casaNova = new Casa();
		
		casaNova.setNome("CasaDoLuvas");
		casaNova.setMetrosQuadrados(250000000);
		casaNova.setMetrosQuadradosGaragem(6800000);
		casaNova.setQuantidadeQuartos(50);
	}
}
