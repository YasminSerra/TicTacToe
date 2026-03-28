package org.example;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] tabuleiro = new String[3][3];

        int turno = 1;
        System.out.println("###Tic Tac Toe###");
        System.out.println("Jogador 1 - escolha X ou O:");
        String jogador1 = sc.next().toUpperCase();
        String jogador2 = jogador1.equalsIgnoreCase("x")  ? "O" : "X"  ;

        while(true) {
            String jogadorAtual = turno == 1 ? "Jogador 1" : "Jogador 2";
            System.out.print(jogadorAtual + ": digite uma linha (0 a 2) e pressione enter: ");
            int linha = sc.nextInt();
            if (linha > 2 || linha < 0){
                System.out.println("Valor inválido!");
                continue;
            }
            System.out.print(jogadorAtual + ": digite uma coluna (0 a 2) e pressione enter: ");
            int coluna = sc.nextInt();
            if (coluna > 2 || coluna < 0){
                System.out.println("Valor inválido!");
                continue;
            }

            tabuleiro[linha][coluna] = turno == 1 ? jogador1 : jogador2;

            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++) {
                    String valorAtual = tabuleiro[i][j] == null ? "#" : tabuleiro[i][j];
                    System.out.print("|" + valorAtual);
                }
                System.out.print("|\n");
            }

           if (jogoFinalizado(tabuleiro)){
               System.out.println("Deseja continuar jogando? 1 =  Sim, 2 = Não");
               int continuar = sc.nextInt();

               if (continuar == 2) {
                   break;
               }
           }

            turno = turno == 1 ? 2 : 1;
        }
    }

    public static boolean jogoFinalizado(String[][] tabuleiro){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
               if (tabuleiro[i][j] == null){
                   return false;
               }
            }

        }
         return true;
    }

}