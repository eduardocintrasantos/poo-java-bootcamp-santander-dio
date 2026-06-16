package org.example.exercicio3.application;

import org.example.exercicio3.dominio.Pet;
import org.example.exercicio3.dominio.PetMachine;
import org.example.exercicio3.infrastructure.PetRepository;
import org.example.exercicio3.infrastructure.PetRepositoryEmMemoria;

public class PetShopService {

    private final PetMachine petMachine;
    private final PetRepository petRepository;


    public PetShopService(PetMachine petMachine, PetRepositoryEmMemoria petRepositoryEmMemoria) {
        this.petMachine = petMachine;
        this.petRepository = petRepositoryEmMemoria;
    }

    public void darBanho() {
        petMachine.takeAShower();
    }

    public void abastecerAgua() {
        petMachine.addWater();
    }

    public void abastecerShampoo() {
        petMachine.addShampoo();
    }

    public int verificarAgua() {
        return petMachine.getWater();
    }

    public int verificarShampoo() {
        return petMachine.getShampoo();
    }

    public Pet verificarPetMaquina() {
        return petMachine.getPet();
    }

    public void colocarPet(String nome) {
        Pet pet = petRepository.buscarPorNome(nome)
                .orElseGet(() -> {
                    Pet novoPet = new Pet(nome);
                    petRepository.save(novoPet);
                    return novoPet;
                });
        petMachine.setPet(pet);
    }

    public void retirarPet() {
        petMachine.removePet();
    }

    public void limparMaquina() {
        petMachine.washMachine();
    }
}
