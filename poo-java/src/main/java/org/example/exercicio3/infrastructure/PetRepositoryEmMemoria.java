package org.example.exercicio3.infrastructure;

import org.example.exercicio3.dominio.Pet;

import java.util.*;

public class PetRepositoryEmMemoria implements PetRepository{
    private final Map<String, Pet> pets = new HashMap<>();

    @Override
    public void save(Pet pet) {
        pets.put(pet.getName(), pet);
    }

    @Override
    public Optional<Pet> buscarPorNome(String nome) {
        return Optional.ofNullable(pets.get(nome));
    }

    @Override
    public Collection<Pet> listarTodos() {
        return pets.values();
    }
}
