package main;

import java.io.IOException;

import logica.Compilador;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String caminho = "caminho/do/arquivo/fonte";
		Compilador compilador = new Compilador(caminho);
		compilador.compilar();
	}

}
