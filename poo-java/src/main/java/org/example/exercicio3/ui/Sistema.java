package org.example.exercicio3.ui;

import org.example.exercicio3.dominio.Pet;
import org.example.exercicio3.dominio.PetMachine;

import java.util.Scanner;

public class Sistema {

    static Scanner scanner = new Scanner(System.in);

    static PetMachine petMachine = new PetMachine();

    public static void Sistema() {

        int escolhaPetshop = -1;

        // Agora estamos no exercicio 3
        System.out.println("Acessando o exercicio 3...");

        do {
            System.out.println("Escolha uma opcao para acessar os exercicios do petshop:");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer agua na maquina de banho");
            System.out.println("3 - Abastecer shampoo na maquina de banho");
            System.out.println("4 - Verificar agua na maquina de banho");
            System.out.println("5 - Verificar shampoo na maquina de banho");
            System.out.println("6 - Verificar se tem pet na maquina de banho");
            System.out.println("7 - Colocar pet na maquina de banho");
            System.out.println("8 - Retirar pet da maquina de banho");
            System.out.println("9 - Limpar a maquina de banho");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("==============================================");

            escolhaPetshop = scanner.nextInt();

            switch (escolhaPetshop) {
                case 1 -> {
                    try {
                        petMachine.takeAShower();
                        System.out.println("O pet foi lavado com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível dar banho no pet: " + e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        petMachine.addWater();
                        System.out.println("Água adicionada com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível adicionar água: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        petMachine.addShampoo();
                        System.out.println("Shampoo adicionado com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível adicionar shampoo: " + e.getMessage());
                    }
                }
                case 4 -> System.out.println("Água restante na máquina de banho: " + petMachine.getWater() + " litros.");
                case 5 -> System.out.println("Shampoo restante na máquina de banho: " + petMachine.getShampoo() + " unidades.");
                case 6 -> petMachine.getPet();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.washMachine();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida.");
            }
        } while (escolhaPetshop != 0);
    }

    public static void setPetInPetMachine() {
        System.out.println("Informe o nome do pet: ");
        var name = scanner.next();
        var pet = new Pet(name);
        petMachine.setPet(pet);
        System.out.println("Pet " + pet.getName() + " foi colocado na maquina de banho.");
    }


}
