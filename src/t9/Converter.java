package t9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;

public class Converter {

    /**
     * Cada linha da matriz @TECLAS[][] representa uma tecla 0-9, cada coluna representa os caracteres em uma tecla.
     */
    private final String TECLAS[][] = { { " ", "", "", "" }, { "", "", "", "" }, { "A", "B", "C", "" }, { "D", "E", "F", "" }, { "G", "H", "I", "" }, { "J", "K", "L", "" }, { "M", "N", "O", "" }, { "P", "Q", "R", "S", "" }, { "T", "U", "V", "" }, { "W", "X", "Y", "Z" } };

    private String fraseOriginal, fraseConvertida;
    private boolean showNumberClicks;

    public Converter() {
	this.fraseOriginal = "";
	this.fraseConvertida = "";
    }

    public void lerFraseConsole() {
	Scanner entradaConsole = new Scanner(System.in);

	System.out.println("Escreva algo.");

	this.fraseOriginal = entradaConsole.nextLine();
	entradaConsole.close();
    }

    public void lerArquivo() {
	String diretorio, linha = "";
	Scanner entrada = new Scanner(System.in);

	System.out.println("Informe o diretório:");
	diretorio = entrada.nextLine();
	entrada.close();

	try {
	    BufferedReader br = new BufferedReader(new FileReader(diretorio)); // C:\Users\warle\Desktop\texto.txt
	    while (br.ready()) {
		linha = br.readLine();
	    }
	    br.close();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}

	this.fraseOriginal = linha;
    }

    public String toNumber() {
	Character charac;

	this.fraseOriginal = removeAcentuacao(this.fraseOriginal);

	System.out.println(this.fraseOriginal);

	for (int pos = 0; pos < this.fraseOriginal.length(); pos++) {

	    charac = this.fraseOriginal.toLowerCase().charAt(pos);

	    for (Integer i = 0; i < 10; i++) {
		for (Integer j = 0; j < 4; j++) {
		    if (charac.toString().equalsIgnoreCase(TECLAS[i][j])) {
			if (isShowingClicksNumber()) {
			    this.fraseConvertida += (++j).toString();
			}
			this.fraseConvertida += i.toString();
			break;
		    }
		}

	    }
	}
	return this.fraseConvertida;
    }

    public String toAlpha() {

	return "";
    }

    public String removeAcentuacao(String frase) {
	return Normalizer.normalize(frase, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * define se será exibido quantas vezes a tecla foi pressionada para escolha de uma letra 
     * @param value
     */
    public void setShowingClicksNumber(boolean value) {
	this.showNumberClicks = value;
    }

    public boolean isShowingClicksNumber() {
	return this.showNumberClicks;
    }
}
