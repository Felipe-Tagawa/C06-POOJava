package main.br.inatel.projetojava.Model.itens.consumiveis;

import main.br.inatel.projetojava.Model.itens.Itens;
import main.br.inatel.projetojava.Model.personagens.UsuarioPersona;

public class Consumiveis extends Itens {

    public Consumiveis(String nome, String tipo, double valor, String status) {
        super(nome, tipo, valor, status);
    }

    @Override
    public void equiparItem(UsuarioPersona usuario) {

    }

    public void usarItem(UsuarioPersona usuario){

    }

    public String toString(){
        return "Nome: " + getNome() +
                ", Tipo: " + getTipo() +
                ", Valor: " + getValor() +
                ", Status: " + getStatus();
    }

}