package br.inatel.projetojava.itens.equipamentos;

import br.inatel.projetojava.itens.Itens;

public class Equipamento extends Itens {
    private double defesa;
    private String status;

    public Equipamento(String nome, String tipo, double valor, String status) {
        super(nome, tipo, valor, status);
    }

    @Override
    public void equiparItem(UsuarioPersona usuario) {

    }

    public void addEquipamento(){

    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +
                ", Tipo: " + getTipo() +
                ", Valor: " + getValor() +
                ", Status: " + getStatus();
    }



}
