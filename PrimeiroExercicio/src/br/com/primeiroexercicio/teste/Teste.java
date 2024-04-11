package br.com.primeiroexercicio.teste;

import javax.swing.JOptionPane;

import br.com.primeiroexercicio.beans.Animal;
import br.com.primeiroexercicio.beans.Mamifero;

public class Teste {

	public static void main(String[] args) {
		
		Mamifero mamifero = new Mamifero();
		
		String recebeEspecie = JOptionPane.showInputDialog("Digite a espécie do animal: ");
		mamifero.setEspecie(recebeEspecie);
		
		String recebeNome = JOptionPane.showInputDialog("Digite o nome do Animal: ");
		mamifero.setNomeString(recebeNome);
		
		int recebeIdade = Integer.parseInt(JOptionPane.showInputDialog(("Digite a idade do animal: ")));
		mamifero.setIdade(recebeIdade);
		
		int recebeMesesGestacao = Integer.parseInt(JOptionPane.showInputDialog("Digite os meses de gestação do animal: "));
		mamifero.setMesesGestacao(recebeMesesGestacao);
		
		System.out.println(String.format("A espécie é %s, \n o nome do animal é %s, \n a idade do animal é %d, \n meses de gestação do animal é %d. ", recebeEspecie, recebeNome, recebeIdade, recebeMesesGestacao));
		
		
	}

}
