package main.br.inatel.projetojava.Model.personagens.npc;

import main.br.inatel.projetojava.Model.personagens.SerHumano;

public class NPC extends SerHumano {

    private final String ocupação;

    public NPC(String nome, int idade, String genero, String ocupacao, String arcana) {
        super(nome, idade, genero, arcana);
        this.ocupação = ocupacao;
    }

    @Override
    public void interagir() {
        System.out.println("NPC" + nome + " interage!");
    }

    @Override
    public void mostraInfoPersonagem() {
        System.out.println("\nNome do NPC: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Gênero: " + genero);
        System.out.println("Ocupação: " + ocupação);
        if(arcana == null){
            System.out.println("Não tem arcana!");
        }
        else {
            System.out.println("Arcana: " + arcana + "\n");
        }
    }

    public void darMissao(){

    }

    // String? Item é objeto:
    public void receberItem(String item){

    }

    public String getOcupação() {
        return ocupação;
    }

}
