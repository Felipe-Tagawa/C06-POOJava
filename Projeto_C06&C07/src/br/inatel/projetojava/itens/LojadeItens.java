package br.inatel.projetojava.itens;

import br.inatel.projetojava.personagens.npc.NPC;
import br.inatel.projetojava.personagens.jogaveis.Protagonista;

public class LojadeItens {
    NPC vendedor = new NPC("Vendedor", 43, "Masculino", "Vendedor de Armas" , "Hanged Man");
    Itens[] itens;
    private String nome;

    public LojadeItens(String nome, Itens[]itens){
        this.nome = nome;
        this.itens = itens;
    }

    public void venderItem(Protagonista protagonista, Itens item){
        // Precisamos criar um inventário para o protagonista.
        for(int i = 0; i < 10; i++) {
            while (protagonista.equipamento[i] == null) {
                protagonista.equipamento[i].addEquipamento();
            }
        }
    }

    // Fiz um for para esse métod0 e outro main(arrumar isso)...
    public void mostrarItens(){
        System.out.println("br.inatel.projetojava.itens.Itens da Loja: ");
        for(Itens item : getItens()){
            System.out.println(item);
        }
    }

    public Itens[] getItens() {
        return itens;
    }
}
