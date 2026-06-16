package org.example.exercicio3.dominio;

public class PetMachine {

    // Capacidade máxima
    public static final int MAX_WATER = 30;
    public static final int MAX_SHAMPOO = 10;

    // Quanto cada operação consome ou adiciona
    public static final int REFILL_AMOUNT = 2;
    public static final int SHOWER_WATER_COST = 10;
    public static final int SHOWER_SHAMPOO_COST = 2;
    public static final int WASH_WATER_COST = 3;
    public static final int WASH_SHAMPOO_COST = 1;

    private boolean clean = true;
    private int water = MAX_WATER;
    private int shampoo = MAX_SHAMPOO;
    private  Pet pet;


    public void takeAShower() {
        if (pet == null) {
            throw new IllegalStateException("Nenhum pet na maquina.");
        }
        if (water < SHOWER_WATER_COST) {
            throw new IllegalStateException("Água insuficiente para o banho.");
        }
        if (shampoo < SHOWER_SHAMPOO_COST) {
            throw new IllegalStateException("Shampoo insuficiente para o banho.");
        }

        this.water -= SHOWER_WATER_COST;
        this.shampoo -= SHOWER_SHAMPOO_COST;
        pet.setClean(true);
    }

    public void addWater() {
        if (water == MAX_WATER) {
            throw new IllegalStateException("A maquina de banho já está cheia de água.");
        }

        water += REFILL_AMOUNT;
    }

    public void addShampoo() {
        if (shampoo == MAX_SHAMPOO) {
            throw new IllegalStateException("A máquina de banho já está cheia de shampoo.");
        }

        shampoo += REFILL_AMOUNT;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            throw new IllegalStateException("A máquina de banho está suja. Por favor, limpe a máquina antes de adicionar um pet.");
        }

        if (hasPet()) {
            throw new IllegalStateException("Já existe um pet na máquina. Por favor, remova o pet atual antes de adicionar outro.");
        }
        this.pet = pet;
    }

    public void removePet() {
        if (!hasPet()) {
            throw new IllegalStateException("Não há nenhum pet na máquina para remover.");
        }

        this.clean = this.pet.isClean();
        this.pet = null;
    }

    public void washMachine() {
        if (hasPet()) {
            throw new IllegalStateException("A máquina de banho não pode ser lavada com um pet dentro. Por favor, remova o pet antes de lavar a máquina.");
        }

        this.water -= WASH_WATER_COST;
        this.shampoo -= WASH_SHAMPOO_COST;
        this.clean = true;
    }

    public Pet getPet() {
        if (!hasPet()) {
            throw new IllegalStateException("Não há nenhum pet na máquina.");
        }
        return pet;
    }
}
