package org.example;

import org.example.exercicio3.ui.Sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var escolha = -1;

        do {
            System.out.println("Ola, bem vindo a lista de exercicios de Java!");
            System.out.println("Escolha uma opcao para acessar os exercicios:");

            System.out.println("1 - Exercicio 1: Conta bancaria");
            System.out.println("2 - Exercicio 2: Carro e suas funcoes");
            System.out.println("3 - Exercicio 3: Controle de banhos em um petshop");
            System.out.println("0 - Sair");
            System.out.println("==============================================");

            System.out.println("Digite o numero da opcao desejada:");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Acessando o exercicio 1...");
                    //Exercicio1.exercicio1();
                    break;
                case 2:
                    System.out.println("Acessando o exercicio 2...");
                    //Exercicio2.exercicio2();
                    break;
                case 3:
                    System.out.println("Acessando o exercicio 3...");

                    Sistema.Sistema();

                    break;
                case 0:
                    System.out.println("Programa finalizado. Obrigado por usar!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha um número entre 0 e 3.");
            }
        } while (escolha != 0);


    }
}