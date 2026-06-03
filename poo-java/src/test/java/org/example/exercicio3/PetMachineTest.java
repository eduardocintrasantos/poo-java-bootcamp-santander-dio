package org.example.exercicio3;

import org.example.exercicio3.dominio.Pet;
import org.example.exercicio3.dominio.PetMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PetMachineTest {
    private PetMachine petMachine;
    private Pet pet;
    @BeforeEach
    void setUp() {
        petMachine = new PetMachine();
        pet = new Pet("Rex");
    }
    @Test
    void deveDarBanhoComSucesso() {
        petMachine.setPet(pet);
        petMachine.takeAShower();
        assertTrue(pet.isClean());
        assertEquals(20, petMachine.getWater());   // 30 - 10
        assertEquals(8, petMachine.getShampoo());  // 10 - 2
    }
}
