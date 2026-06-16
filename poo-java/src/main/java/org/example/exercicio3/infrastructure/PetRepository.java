package org.example.exercicio3.infrastructure;

import org.example.exercicio3.dominio.Pet;

import java.util.Collection;
import java.util.Optional;

public interface PetRepository {
    void save(Pet pet);

    Optional<Pet> buscarPorNome(String nome);

    Collection<Pet> listarTodos();
}
