package JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        char[][] tabuleiro = { 
						{' ',' ',' '},
						{' ',' ',' '},
						{' ',' ',' '}};

        char jogador = 'X';
        boolean jogoEmAndamento = true;
        
        
        while (jogoEmAndamento) {
            imprimirTabuleiro(tabuleiro);

            System.out.println("Jogador " + jogador + ", faça sua jogada \n");
            
            System.out.println("Jogador " + jogador + ", fará sua jogada na linha? ");
            int linha = sc.nextInt() - 1;
            
            System.out.println("Jogador " + jogador + ", fará sua jogada na coluna? ");
            int coluna = sc.nextInt() - 1;

            if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != ' ') {
                System.out.println("Jogada inválida. Tente novamente.");
                continue;
            }

            tabuleiro[linha][coluna] = jogador;
            
            if (verificarVencedor(tabuleiro, jogador)) {
                imprimirTabuleiro(tabuleiro);
                System.out.println("Jogador " + jogador + " venceu!");
                jogoEmAndamento = false;
            }
            
            else if (tabuleiroCheio(tabuleiro)) {
                imprimirTabuleiro(tabuleiro);
                System.out.println("Empate!");
                jogoEmAndamento = false;
            }
            
            else {
                jogador = (jogador == 'X') ? 'O' : 'X';
            }
        }

        sc.close();

    }	

    private static boolean verificarVencedor(char[][] tab, char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tab[i][0] == jogador && tab[i][1] == jogador && tab[i][2] == jogador) ||
                (tab[0][i] == jogador && tab[1][i] == jogador && tab[2][i] == jogador)) {
                
                return true;
            }
        }
        
        if ((tab[0][0] == jogador && tab[1][1] == jogador && tab[2][2] == jogador) ||
            (tab[0][2] == jogador && tab[1][1] == jogador && tab[2][0] == jogador)) {
            
                return true;
        }

        return false;
    }

    private static boolean tabuleiroCheio(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    private static void imprimirTabuleiro (char[][] tabuleiro) {
        System.out.println();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                
                if (j < 2) System.out.print(" | ");
            }

            System.out.println();

            if (i < 2) System.out.println("---------");
        }

        System.out.println();
    }
}
