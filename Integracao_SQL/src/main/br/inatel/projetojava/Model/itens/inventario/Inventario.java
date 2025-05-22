package main.br.inatel.projetojava.Model.itens.inventario;

import java.util.HashMap;

import main.br.inatel.projetojava.Model.itens.Itens;
import main.br.inatel.projetojava.Model.itens.consumiveis.Consumiveis;
import main.br.inatel.projetojava.Model.itens.armas.Arma;
import main.br.inatel.projetojava.Model.itens.equipamentos.Equipamento;

public class Inventario {
    private HashMap<Arma, Integer> armas;
    private HashMap<Equipamento, Integer> equipamentos;
    private HashMap<Consumiveis, Integer> consumiveis;

    public Inventario() {
        this.armas = new HashMap<>();
        this.equipamentos = new HashMap<>();
        this.consumiveis = new HashMap<>();
    }

    public void mostrarInventarioPersonagem() {
        if(!armas.isEmpty()) {
            System.out.println("\n----- Arma -----");
            for (Arma arma : armas.keySet()) {
                System.out.println(arma);
            }
        }
        else{
            System.out.println("Personagem sem armas!");
        }
        if(!equipamentos.isEmpty()) {
            System.out.println("----- Equipamento -----");
            for (Equipamento equipamento : equipamentos.keySet()) {
                System.out.println(equipamento);
            }
        }
        else{
            System.out.println("Personagem sem equipamentos!");
        }

        if(!consumiveis.isEmpty()) {
            System.out.println("----- Consumiveis -----");
            for (Consumiveis consumivel : consumiveis.keySet()) {
                System.out.println(consumivel);
            }
        }
        else{
            System.out.println("Personagem sem consumiveis!");
        }
        System.out.println();
    }


    public void adicionarArma(Arma arma, int quantidade) {
        armas.put(arma, armas.getOrDefault(arma, 0) + quantidade);
        // GetOrDefault : padrão é 0, quando se tem arma, incrementa.
    }

    public void adicionarEquipamento(Equipamento equipamento, int quantidade) {
        equipamentos.put(equipamento, equipamentos.getOrDefault(equipamento, 0) + quantidade);
    }

    public void adicionarConsumivel(Consumiveis consumivel, int quantidade) {
        consumiveis.put(consumivel, consumiveis.getOrDefault(consumivel, 0) + quantidade);
    }

    public void removerArma(Itens item) {
        if (item instanceof Arma) {
            armas.remove(item);
        }
    }

    public void removerEquipamento(Itens item) {
        if (item instanceof Equipamento) {
            equipamentos.remove(item);
        }
    }

    public void removerConsumivel(Itens item) {
        if (item instanceof Consumiveis) {
            consumiveis.remove(item);
        }
    }

    public int getQuantidadeArma(Arma arma) {
        return armas.getOrDefault(arma, 0);
    }

    public int getQuantidadeEquipamento(Equipamento equipamento) {
        return equipamentos.getOrDefault(equipamento, 0);
    }

    public int getQuantidadeConsumivel(Consumiveis consumivel) {
        return consumiveis.getOrDefault(consumivel, 0);
    }

    public HashMap<Arma, Integer> getArmas() {
        return new HashMap<>(armas);
    }

    public HashMap<Equipamento, Integer> getEquipamentos() {
        return new HashMap<>(equipamentos);
    }

    public HashMap<Consumiveis, Integer> getConsumiveis() {
        return new HashMap<>(consumiveis);
    }
}