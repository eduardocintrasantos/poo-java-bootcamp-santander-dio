package org.example.exercicio3.ui;

import org.example.exercicio3.application.PetShopService;
import org.example.exercicio3.dominio.Pet;
import org.example.exercicio3.dominio.PetMachine;
import org.example.exercicio3.infrastructure.PetRepositoryEmMemoria;

import java.util.Scanner;

public class Sistema {

    static Scanner scanner = new Scanner(System.in);

    static PetShopService petShopService = new PetShopService(
            new PetMachine(),
            new PetRepositoryEmMemoria());

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
                        petShopService.darBanho();
                        System.out.println("O pet foi lavado com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível dar banho no pet: " + e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        petShopService.abastecerAgua();
                        System.out.println("Água adicionada com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível adicionar água: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        petShopService.abastecerShampoo();
                        System.out.println("Shampoo adicionado com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível adicionar shampoo: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        int water = petShopService.verificarAgua();
                        System.out.println("Água restante na máquina de banho: " + water + " litros.");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível verificar a água: " + e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        int shampoo = petShopService.verificarShampoo();
                        System.out.println("Shampoo restante na máquina de banho: " + shampoo + " unidades.");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível verificar o shampoo: " + e.getMessage());
                    }
                }
                case 6 -> {
                    try {
                        Pet pet = petShopService.verificarPetMaquina();
                        System.out.println("O pet " + pet + " está na máquina de banho.");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível verificar se há um pet: " + e.getMessage());
                    }

                }
                case 7 -> setPetInPetMachine();
                case 8 -> {
                    try {
                        petShopService.retirarPet();
                        System.out.println("O pet foi retirado da máquina de banho.");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível retirar o pet: " + e.getMessage());
                    }

                }
                case 9 -> {
                    try {
                        petShopService.limparMaquina();
                        System.out.println("A máquina de banho foi limpa com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível limpar a máquina: " + e.getMessage());
                    }

                }
                case 0 -> {
                    try {
                        System.out.println("Voltando ao menu principal...");
                    } catch (IllegalStateException e) {
                        System.out.println("Não foi possível voltar ao menu principal: " + e.getMessage());
                    }

                }
                default -> System.out.println("Opção inválida.");
            }
        } while (escolhaPetshop != 0);
    }

    public static void setPetInPetMachine() {
        System.out.println("Informe o nome do pet: ");
        var name = scanner.next();
        //var pet = new Pet(name);
        try {
            petShopService.colocarPet(String.valueOf(name));
            System.out.println("Pet " + name + " foi colocado na maquina de banho.");
        } catch (IllegalStateException e) {
                System.out.println("Não foi possível colocar o pet na máquina de banho: " + "A máquina de banho está suja. Por favor, limpe a máquina antes de adicionar um pet.");
        }

    }


}
