package br.com.horacio.model;

public class Aluno extends Pessoa { // extends serve para herdar uma classe
	private String cursoAlocado;

	public String getCursoAlocado() {
		return cursoAlocado;
	}

	public void setCursoAlocado(String cursoAlocado) {
		this.cursoAlocado = cursoAlocado;
	}

}
