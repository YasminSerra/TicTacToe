package org.example;

import java.util.Scanner;
enum StatusGame{
    EMPATE,
    EM_ANDAMENTO,
    VENCEDOR;
}

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
            if (tabuleiro[linha][coluna] != null){
                System.out.println("Posição já escolhida. Escolha outra posição");
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
            StatusGame resultado = verificaResultado(tabuleiro,turno == 1 ? jogador1 : jogador2);
            if (!resultado.equals(StatusGame.EM_ANDAMENTO)){
                if (resultado.equals(StatusGame.VENCEDOR)){
                    System.out.println("Jogador " + turno + " venceu!!!");
                }
                else{
                    System.out.println("Empate!!!!");
                }

               System.out.println("Deseja continuar jogando? 1 =  Sim, 2 = Não");
               int continuar = sc.nextInt();

               if (continuar == 2) {
                   break;
               }
               tabuleiro = new String[3][3];
               turno = 1;
               continue;
           }

            turno = turno == 1 ? 2 : 1;
        }
    }

    public static StatusGame verificaResultado(String[][] tabuleiro, String jogador){
        if (venceuLinha(tabuleiro,jogador)){
            return StatusGame.VENCEDOR;
        }
        if (venceuDiagonal(tabuleiro,jogador)){
            return StatusGame.VENCEDOR;
        }
        if (venceuColuna(tabuleiro,jogador)){
            return StatusGame.VENCEDOR;
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
               if (tabuleiro[i][j] == null){
                   return StatusGame.EM_ANDAMENTO;
               }
            }

        }
         return StatusGame.EMPATE;
    }
    public static boolean venceuLinha(String[][] tabuleiro, String jogador) {
        if (jogador.equals(tabuleiro[0][0]) && jogador.equals(tabuleiro[0][1]) && jogador.equals(tabuleiro[0][2])){
            return true;
        }
        if (jogador.equals(tabuleiro[1][0]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[1][2])){
            return true;
        }
        if (jogador.equals(tabuleiro[2][0]) && jogador.equals(tabuleiro[2][1]) && jogador.equals(tabuleiro[2][2])){
            return true;
        }
        return false;
    }

    public static boolean venceuColuna(String[][] tabuleiro, String jogador) {
        if (jogador.equals(tabuleiro[0][0]) && jogador.equals(tabuleiro[1][0]) && jogador.equals(tabuleiro[2][0])){
            return true;
        }
        if (jogador.equals(tabuleiro[0][1]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[2][1])){
            return true;
        }
        if (jogador.equals(tabuleiro[0][2]) && jogador.equals(tabuleiro[1][2]) && jogador.equals(tabuleiro[2][2])){
            return true;
        }
        return false;
    }
    public static boolean venceuDiagonal(String[][] tabuleiro, String jogador) {
        if (jogador.equals(tabuleiro[0][0]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[2][2])){
            return true;
        }
        if (jogador.equals(tabuleiro[0][2]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[2][0])){
            return true;
        }
        return false;
    }
}