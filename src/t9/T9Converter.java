package t9;

import java.util.Scanner;

public class T9Converter {
    public static void main(String[] args) {
	int opcao = 1;

//	Scanner entrada = new Scanner(System.in);

	//System.out.println("Escolha uma forma de entrada:" + "\n1 - Arquivo" + "\n2 - Console");

//	opcao = entrada.nextInt();
//	entrada.close();

	Converter conv = new Converter();
	
	conv.setShowingClicksNumber(true);
	
	switch (opcao) {
	case 1:
	    conv.lerArquivo();
	    break;
	case 2:
	    conv.lerFraseConsole();
	    break;
	default:
	    System.out.println("Opção inválida.");
	    break;
	}

	System.out.println(conv.toNumber());

    }
}
