package tabuleiro_Xadrez;

import java.util.Scanner;

public class TabuleiroXadrez {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[][] board = { 
				{"R","N","B","Q","K","B","N","R"},
				{"P","P","P","P","P","P","P","P"},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{"p","p","p","p","p","p","p","p"},
				{"r","n","b","q","k","b","n","r"}};

		imprimirBoard(board);
		int peaoMovido, numeroCasas = 0;
		String cor = "";

		System.out.println("Qual Peao voce gostaria de mover? Escolha a Coluna de 1 a 8");
		while (true) {
			peaoMovido = sc.nextInt();
			if (peaoMovido >= 1 || peaoMovido >= 8) break;
			System.out.println("Coluna Inválida. \n");
			System.out.println("Qual Peao voce gostaria de mover? Escolha a Coluna de 1 a 8");
		}
		
		System.out.println("Quantas casas você gostaria de mover o peao selecionado?");
		while (true) {
			numeroCasas = sc.nextInt();
			if (numeroCasas == 1 || numeroCasas == 2) break;
			System.out.println("Movimento Inválido. \n");
			System.out.println("Quantas casas você gostaria de mover o peao selecionado?");
		}

		System.out.println("Qual a cor do peao que deve ser movido? B ou W");
		while (true) {
			cor = sc.nextLine();
			if (cor.equals("B") || cor.equals("W")) break;
			System.out.println("Cor Inválida. \n");
			System.out.println("Qual a cor do peao que deve ser movido? B ou W");
		}
		
		int coluna = peaoMovido - 1;

		if (board[6][coluna].equals("p") && cor.equals("W")) {
			board[6 - numeroCasas][coluna] = "p";
            board[6][coluna] = " ";
		} 
		
		else if (board[1][coluna].equals("P") && cor.equals("B")) {
            board[1 + numeroCasas][coluna] = "P";
            board[1][coluna] = " ";
        }

		imprimirBoard(board);
		sc.close();
	}
	
	// --------------Impressão do Tabuleiro---------------------------------------
	private static void imprimirBoard(String[][] board) {
		 for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	System.out.print(board[i][j]+"  ");
		        }

		        System.out.println("");
		    }
	}
}