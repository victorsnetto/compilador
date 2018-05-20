package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Compilador {

	private final String arquivo;


	private boolean flagErroOp;
	
	private final String[] errorsOp = {"+-", "-+", "+*", "*+", "+/", "/+", "*/", "/*"};

	private final HashMap<String, String> token = new HashMap<>();

	public Compilador(String arquivo) {
		this.arquivo = arquivo;
		this.flagErroOp = false;
	}

	public String analisadorLexico(String linha) {
		String result = "";
		int posicao = 0;
		if (!this.flagErroOp) {
			for (int i = 0; i < linha.length(); i++) {
				if (i == 0) {
					posicao = 1;
				} else {
					posicao = i - 1;
				}
				if (token.containsKey(String.valueOf(linha.charAt(i)))
						&& (String.valueOf(linha.charAt(posicao)).equals(" "))) {
					result = result.concat(" -- ");
					result = result.concat(token.get(String.valueOf(linha.charAt(i))));
				}
			}
		}
		linha = linha.concat(result);
		return linha;
	}

	public String analisadorSintatico(String linha) {
		String novaLinha = linha;
		for (String erro : this.errorsOp) {
			if (linha.contains(erro)) {
				novaLinha = linha.concat(msgErroOp());
				this.flagErroOp = true;
				break;
			} else {
				this.flagErroOp = false;
			}
		}
		return novaLinha;
	}
	
    public String msgErroOp() {
        return "----ERRO DE OPERADOR----";
    }

	public void compilar() throws IOException {
		FileInputStream stream = new FileInputStream(arquivo);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		String novaLinha = "";

		while (linha != null) {
			novaLinha = linha;
			System.out.println(novaLinha);
			linha = br.readLine();
		}

		br.close();

	}
}
