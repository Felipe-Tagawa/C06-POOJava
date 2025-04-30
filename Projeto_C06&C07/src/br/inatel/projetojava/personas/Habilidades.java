package br.inatel.projetojava.personas;

import br.inatel.projetojava.personagens.SerHumano;

public class Habilidades {

    private String nome;
    private String tipo;
    private String efeito;
    private double dano;

    public Habilidades(String nome, String tipo, String efeito, double dano){
        this.nome = nome;
        this.tipo = tipo;
        this.efeito = efeito;
        this.dano = dano;
    }

    public void aplicarHabilidade(SerHumano alvo, Personas persona){ // Como vai fazer se precisar aplicar em diferentes?

    }

    public void descreverHabilidade(){
        System.out.println("Nome da Habilidade: " + this.getNome());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Efeito: " + this.getEfeito());
        System.out.println("Dano: " + this.getDano());
    }

    // Setters e Getters:


    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEfeito() {
        return efeito;
    }

    public double getDano() {
        return dano;
    }
}
