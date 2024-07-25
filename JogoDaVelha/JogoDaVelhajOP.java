package JogoDaVelha;

import javax.swing.JOptionPane;

public class JogoDaVelhajOP {
        
    public static void main(String[] args) {

        char[][] tabuleiro = { 
                        {' ',' ',' '},
                        {' ',' ',' '},
                        {' ',' ',' '}};

        char jogador = 'X';
        boolean jogoEmAndamento = true;
        
        while (jogoEmAndamento) {
            imprimirTabuleiro(tabuleiro);

            JOptionPane.showMessageDialog(null, "Jogador " + jogador + ", faça sua jogada \n");
            
            int linha = Integer.parseInt(JOptionPane.showInputDialog("Jogador " + jogador + ", fará sua jogada na linha?")) - 1;
            int coluna = Integer.parseInt(JOptionPane.showInputDialog("Jogador " + jogador + ", fará sua jogada na coluna?")) - 1;

            if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != ' ') {
                JOptionPane.showMessageDialog(null, "Jogada inválida. Tente novamente.");
                continue;
            }

            tabuleiro[linha][coluna] = jogador;
            
            if (verificarVencedor(tabuleiro, jogador)) {
                imprimirTabuleiro(tabuleiro);
                JOptionPane.showMessageDialog(null, "Jogador " + jogador + " venceu!");
                jogoEmAndamento = false;
            }
            
            else if (tabuleiroCheio(tabuleiro)) {
                imprimirTabuleiro(tabuleiro);
                JOptionPane.showMessageDialog(null, "Empate!");
                jogoEmAndamento = false;
            }
            
            else {
                jogador = (jogador == 'X') ? 'O' : 'X';
            }
        }

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
        StringBuilder sb = new StringBuilder("\n");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tabuleiro[i][j]);
                
                if (j < 2) sb.append(" | ");
            }

            sb.append("\n");

            if (i < 2) sb.append("---------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}