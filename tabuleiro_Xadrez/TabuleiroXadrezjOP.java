package tabuleiro_Xadrez;

import javax.swing.JOptionPane;

public class TabuleiroXadrezjOP {
    public static void main(String[] args) {
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

        while (true) {
            try {
                peaoMovido = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual Peao voce gostaria de mover? Escolha a Coluna de 1 a 8"));
                if (peaoMovido >= 1 && peaoMovido <= 8) break;
                else JOptionPane.showMessageDialog(null, "Coluna Inválida. \n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. \n");
            }
        }

        while (true) {
            try {
                numeroCasas = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas casas você gostaria de mover o peao selecionado?"));
                if (numeroCasas == 1 || numeroCasas == 2) break;
                else JOptionPane.showMessageDialog(null, "Movimento Inválido. \n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. \n");
            }
        }

        while (true) {
            cor = JOptionPane.showInputDialog(null, "Qual a cor do peao que deve ser movido? B ou W").toUpperCase();
            if (cor.equals("B") || cor.equals("W")) break;
            else JOptionPane.showMessageDialog(null, "Cor Inválida. \n");
        }

        int coluna = peaoMovido - 1;

        if (board[6][coluna].equals("p") && cor.equals("W")) {
            board[6 - numeroCasas][coluna] = "p";
            board[6][coluna] = " ";
        } else if (board[1][coluna].equals("P") && cor.equals("B")) {
            board[1 + numeroCasas][coluna] = "P";
            board[1][coluna] = " ";
        }

        imprimirBoard(board);
    }

    private static void imprimirBoard(String[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]).append("  ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Tabuleiro de Xadrez", JOptionPane.INFORMATION_MESSAGE);
    }
}