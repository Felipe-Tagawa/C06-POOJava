package main.br.inatel.projetojava.Model.itens;

import main.br.inatel.projetojava.Model.itens.armas.Arma;
import main.br.inatel.projetojava.Model.itens.consumiveis.Consumiveis;
import main.br.inatel.projetojava.Model.itens.equipamentos.Equipamento;
import main.br.inatel.projetojava.Model.personagens.npc.NPC;
import main.br.inatel.projetojava.Model.personagens.jogaveis.Protagonista;

import java.util.HashSet;
import java.util.Map;

public class LojadeItens {
    NPC vendedor = new NPC("Oficial Kurosawa", 43, "Masculino", "Vendedor de Armas", null);
    private final Map<Itens, Integer> itens;
    private final String nome;

    public LojadeItens(String nome, Map<Itens, Integer> itens) {
        this.nome = nome;
        this.itens = itens;
    }

    public void mostraInfoLojadeItens(){
        System.out.println("\nNome da Loja: " + nome);
        vendedor.mostraInfoPersonagem();
    }

    public void venderItem(Protagonista protagonista, Itens novo_item) {
        if (protagonista.item == null) {
            protagonista.item = new HashSet<>();  // Inicializa o HashSet se ele for nulo
        }
        if (protagonista.getSaldo() < novo_item.getValor()) {
            System.out.println("Saldo insuficiente para realizar a compra.");
        } else {
            switch (novo_item) {
                case Arma arma -> {
                    if (this.itens.containsKey(novo_item) && this.itens.get(novo_item) > 0) {
                        protagonista.inventario.adicionarArma(arma, 1);
                        this.itens.put(novo_item, this.itens.get(novo_item) - 1);
                        if (this.itens.get(novo_item) == 0) {
                            this.itens.remove(novo_item);
                        }
                        protagonista.setSaldo(protagonista.getSaldo() - novo_item.getValor());
                    }
                }
                case Equipamento equipamento -> {
                    if (this.itens.containsKey(novo_item) && this.itens.get(novo_item) > 0) {
                        protagonista.inventario.adicionarEquipamento(equipamento, 1);
                        this.itens.put(novo_item, this.itens.get(novo_item) - 1);
                        if (this.itens.get(novo_item) == 0) {
                            this.itens.remove(novo_item);
                        }
                        protagonista.setSaldo(protagonista.getSaldo() - novo_item.getValor());
                    }
                }
                case Consumiveis consumiveis -> {
                    if (this.itens.containsKey(novo_item) && this.itens.get(novo_item) > 0) {
                        protagonista.inventario.adicionarConsumivel(consumiveis, 1);
                        this.itens.put(novo_item, this.itens.get(novo_item) - 1);
                        if (this.itens.get(novo_item) == 0) {
                            this.itens.remove(novo_item);
                        }
                        protagonista.setSaldo(protagonista.getSaldo() - novo_item.getValor());
                    }
                }
                default -> {
                }
            }
        }
    }

    public void mostrarItens() {
        System.out.println();
        System.out.println("Itens da Loja:");
        System.out.println();

        System.out.println("----- Armas para Venda -----");
        for (Map.Entry<Itens, Integer> entry : itens.entrySet()) {
            if (entry.getKey() instanceof Arma) {
                System.out.println(entry.getKey() + " - Quantidade: " + entry.getValue());
            }
        }

        System.out.println();

        System.out.println("----- Equipamentos para Venda -----");
        for (Map.Entry<Itens, Integer> entry : itens.entrySet()) {
            if (entry.getKey() instanceof Equipamento) {
                System.out.println(entry.getKey() + " - Quantidade: " + entry.getValue());
            }
        }

        System.out.println();

        System.out.println("----- Consumiveis para Venda -----");
        for (Map.Entry<Itens, Integer> entry : itens.entrySet()) {
            if (entry.getKey() instanceof Consumiveis) {
                System.out.println(entry.getKey() + " - Quantidade: " + entry.getValue());
            }
        }

        System.out.println();
    }

    public Map<Itens, Integer> getItens() {
        return itens;
    }
}
