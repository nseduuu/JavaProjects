package br.com.empresa.teste;

import javax.swing.JOptionPane;

import br.com.empresa.beans.Funcionario;

public class Teste {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(JOptionPane.showInputDialog("Digite o nome do funcionário: "));
		funcionario.setSexo(JOptionPane.showInputDialog("Digite o sexo do funcionário: ")); 
		//funcionario.getIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do funcionário: ")));
		funcionario.getIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: ")));
		funcionario.setCargo(JOptionPane.showInputDialog("Digite o cargo: "));
		
		funcionario.mostrarAtributo();

	}

}
