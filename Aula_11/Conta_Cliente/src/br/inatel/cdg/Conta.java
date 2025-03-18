package br.inatel.cdg;

public class Conta {

    private int numero;
    private float saldo, limite;

    private Cliente []clientes;

    public Conta() {
        setCliente(new Cliente[3]);
    }

    public void sacar(float quantia){
        if(quantia > this.saldo){
            this.saldo -= quantia;
        }
        else{
            System.out.println("Saldo Insuficiente! Deposite primeiro.");
        }
    }

    public void deposita(float quantia){
        this.saldo += quantia;
    }

    // Getters e Setters:

    public void setCliente(Cliente []clientes) {
        this.clientes = clientes;
    }

    // Não podemos setar o valor do saldo, portanto não usamos o setSaldo.
    public float getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
}
