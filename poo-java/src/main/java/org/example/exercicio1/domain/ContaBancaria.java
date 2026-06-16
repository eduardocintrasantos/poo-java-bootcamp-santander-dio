package org.example.exercicio1.domain;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private double saldoChequeEspecial;

    public ContaBancaria(String numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        calculaChequeEspecial(saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar (double valor) {
        if (valor <= 0) throw new IllegalStateException("Valor inválido.");

        this.saldo += valor;
    }

    public void sacar (double valor) {
        double totalSaque = saldo + saldoChequeEspecial;
        if (valor <= 0) {
            throw new IllegalStateException("Valor igual ou menor que 0. Valor inválido");
        }
        if (valor > totalSaque) {
            throw new IllegalStateException("Valor maior que o saldo da conta + cheque especial");
        } else if (valor > this.saldo) {
            double resto = valor - this.saldo;

            this.saldoChequeEspecial -= resto + (resto * 0.2);
        } else {
            this.saldo -= valor;
        }
    }

    public void pagarBoleto (double valor) {
        sacar(valor);
    }

    private void calculaChequeEspecial(double valor) {
        if (valor <= 0) {
            throw new IllegalStateException("Valor de deposito inválido.");
        } else if (valor <= 500) {
            this.saldoChequeEspecial += 50;
        } else {
            this.saldoChequeEspecial += valor / 2;
        }
    }

    public double getChequeEspecial() {
        return saldoChequeEspecial;
    }


}
