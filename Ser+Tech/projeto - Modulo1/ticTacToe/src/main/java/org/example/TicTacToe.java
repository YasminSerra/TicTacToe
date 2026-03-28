package org.example;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("###Tic Tac Toe###");
        System.out.print("Digite uma linha (0 a 2) e pressione enter: ");
        int linha = sc.nextInt();
        System.out.print("Digite uma coluna (0 a 2) e pressione enter: ");
        int coluna = sc.nextInt();

        System.out.println("A linha é: " + linha);
        System.out.println("A coluna é: " + coluna);
    }

}