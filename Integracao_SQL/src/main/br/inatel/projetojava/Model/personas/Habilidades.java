package main.br.inatel.projetojava.Model.personas;

import main.br.inatel.projetojava.Model.personagens.SerHumano;

public class Habilidades {

    private final String nome;
    private final String tipo;
    private final String efeito;
    private final double dano;

    public Habilidades(String nome, String tipo, String efeito, double dano){
        this.nome = nome;
        this.tipo = tipo;
        this.efeito = efeito;
        this.dano = dano;
    }

    public void aplicarHabilidade(SerHumano alvo, Personas persona){ // Como vai fazer se precisar aplicar em diferentes?

    }

    public void descreverHabilidade(){
        System.out.println("Nome da Habilidade: " + getNome());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Efeito: " + getEfeito());
        System.out.println("Dano: " + getDano());
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
