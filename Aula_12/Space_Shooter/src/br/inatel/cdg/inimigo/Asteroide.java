package br.inatel.cdg.inimigo;

public class Asteroide {

    private String nome, tipoAsteroide;

    public Asteroide(String nome, String tipoAsteroide){
        this.nome = nome;
        this.tipoAsteroide = tipoAsteroide;
    }

    public void destruir(){
        System.out.println("O asteroide de nome " + this.nome + " e tipo " + this.tipoAsteroide + " foi destruído com sucesso!");
    }

}
