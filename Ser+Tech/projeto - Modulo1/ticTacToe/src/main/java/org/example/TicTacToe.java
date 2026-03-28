package org.example;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] tabuleiro = new String[3][3];
        while(true) {
            System.out.println("###Tic Tac Toe###");
            System.out.print("Digite uma linha (0 a 2) e pressione enter: ");
            int linha = sc.nextInt();
            if (linha > 2 || linha < 0){
                System.out.println("Valor inválido!");
                continue;
            }
            System.out.print("Digite uma coluna (0 a 2) e pressione enter: ");
            int coluna = sc.nextInt();
            if (coluna > 2 || coluna < 0){
                System.out.println("Valor inválido!");
                continue;
            }

            tabuleiro[linha][coluna] = "X";

            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++) {
                    String valorAtual = tabuleiro[i][j] == null ? "#" : tabuleiro[i][j];
                    System.out.print("|" + valorAtual);
                }
                System.out.print("|\n");
            }

            System.out.println("Deseja continuar jogando? 1 =  Sim, 2 = Não");
            int continuar = sc.nextInt();

            if (continuar == 2) {
                break;
            }
        }
    }

}