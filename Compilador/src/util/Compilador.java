package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compilador {
	
	private final String arquivo;
	
	public Compilador(String arquivo)
	{
		this.arquivo = arquivo;
	}
	
	public void compilar() throws IOException 
	{
		FileInputStream stream = new FileInputStream(arquivo);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		String novaLinha = "";
		
		while(linha != null)
		{
			novaLinha = linha;
			System.out.println(novaLinha);
			linha = br.readLine();
		}
		
		br.close();
		
	}
}
