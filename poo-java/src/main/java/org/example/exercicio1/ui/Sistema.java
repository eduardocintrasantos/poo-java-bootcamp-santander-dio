package org.example.exercicio1.ui;

import org.example.exercicio1.domain.ContaBancaria;

import java.util.Scanner;

public class Sistema {
    static Scanner scanner = new Scanner(System.in);

    static ContaBancaria conta = new ContaBancaria(
        "123", 550.00
    );

    public static void executar() {
        int escolha = -1;

        do {
            System.out.println("Escolha da conta bancaria:");
            //System.out.println("1 - Criar conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Consultar cheque especial");
            System.out.println("4 - Depositar dinheiro");
            System.out.println("5 - Sacar dinheiro");
            System.out.println("6 - Pagar boleto");
            System.out.println("0 - Sair");
            System.out.println("==============================================");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 2 -> {
                    try {
                        System.out.println("Saldo da conta: "+conta.getSaldo());
                    } catch (IllegalStateException e) {
                        System.out.println("Erro: "+e);
                    };
                }
                case 3 -> {
                    try {
                        System.out.println("Cheque especial: "+conta.getChequeEspecial());
                    } catch (IllegalStateException e) {
                        System.out.println("Erro: "+e);
                    }
                }
                case 4 -> {
                    try {
                        System.out.println("Informe o valor do deposito:");
                        double valor = scanner.nextDouble();
                        conta.depositar(valor);
                        System.out.println("Foi depositado R$"+valor);
                    } catch (IllegalStateException e) {
                        System.out.println("Erro: "+e);
                    }
                }
                case 5 -> {
                    try {
                        System.out.println("Informe o valor do saque:");
                        double valor = scanner.nextDouble();
                        conta.sacar(valor);
                        System.out.println("Foi sacado R$"+valor);
                    } catch (IllegalStateException e) {
                        System.out.println("Erro: "+e);
                    }
                }
                case 6 -> {
                    try {
                        System.out.println("Informe o valor do boleto:");
                        double valor = scanner.nextDouble();
                        conta.pagarBoleto(valor);
                        System.out.println("Boleto no valor de R$"+valor+" pago");
                    } catch (IllegalStateException e) {
                        System.out.println("Erro: "+e);
                    }
                }
            }

        } while (escolha != 0);
    }
}
