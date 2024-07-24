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

		System.out.println("Qual Peao voce gostaria de mover? Escolha a Coluna de 1 a 8");
		while (true) {
			peaoMovido = sc.nextInt() - 1;
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
		
		board[peaoMovido][2] = board[peaoMovido+numeroCasas][2];
		board[peaoMovido][2] = " ";

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