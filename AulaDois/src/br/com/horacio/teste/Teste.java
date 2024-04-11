package br.com.horacio.teste;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {

		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: "));

		if (idade >= 18) {
			// System.out.println( nome + ", você é maior de idade");
			System.out.println(String.format("%s, você é maior de idade.", nome));
		} else {
			// System.out.println(nome +", você é menor de idade");
			System.out.println(String.format("%s, você é menor de idade.", nome));
		}

	}

}
