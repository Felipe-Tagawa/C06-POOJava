package main.br.inatel.projetojava.Model.itens.armas;

import main.br.inatel.projetojava.Model.itens.Itens;
import main.br.inatel.projetojava.Model.personagens.UsuarioPersona;

import java.util.HashSet;

public class Arma extends Itens {

    private final double dano;

    public Arma(String nome, String tipo, double valor, String status, double dano) {
        super(nome, tipo, valor, status);
        this.dano = dano;
    }

    @Override
    public void equiparItem(UsuarioPersona usuario) {
        if (usuario.item == null) {
            usuario.item = new HashSet<>();
        }
        usuario.item.add(this);
        if(this.getDano() > 0 && this.getDano() <= 50){
            usuario.setDanoArma(usuario.getDanoArma() + 2);
        }
        else if(this.getDano() > 50 && this.getDano() <= 60){
            usuario.setDanoArma(usuario.getDanoArma() + 4);
        }
        else if(this.getDano() > 60){
            usuario.setDanoArma(usuario.getDanoArma() + 6);
        }
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() +
                ", Tipo: " + getTipo() +
                ", Valor: " + getValor() +
                ", Status: " + getStatus() +
                ", Dano: " + this.dano;
    }

    public double getDano() {
        return dano;
    }
}
