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
            System.out.println("A máquina de banho está suja. Por favor, limpe a máquina antes de adicionar um pet.");
            return;
        }

        if (hasPet()) {
            System.out.println("Já existe um pet na máquina. Por favor, remova o pet atual antes de adicionar outro.");
            return;
        }
        this.pet = pet;
    }

    public void removePet() {
        if (!hasPet()) {
            System.out.println("Não há nenhum pet na máquina para remover.");
            return;
        } else {
            System.out.println("Pet " + pet.getName() + " removido da máquina.");
            this.clean = this.pet.isClean();
        }
        this.pet = null;
    }

    public void washMachine() {
        if (hasPet()) {
            System.out.println("Não é possível lavar a máquina com um pet dentro. Por favor, remova o pet antes de lavar a máquina.");
            return;
        }

        this.water -= WASH_WATER_COST;
        this.shampoo -= WASH_SHAMPOO_COST;
        this.clean = true;
        System.out.println("Máquina de banho lavada e limpa!");
    }

    public void getPet() {
        if (!hasPet()) {
            System.out.println("Não há nenhum pet na máquina.");
            return;
        }
        System.out.println("O pet " + pet.getName() + " está na máquina de banho.");
    }
}
