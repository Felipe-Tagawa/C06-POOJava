package main.br.inatel.projetojava.Model.itens.equipamentos;

import main.br.inatel.projetojava.Model.itens.Itens;
import main.br.inatel.projetojava.Model.personagens.UsuarioPersona;

import java.util.HashSet;

public class Equipamento extends Itens {
    private final double defesa;
    private final String genero;

    public Equipamento(String nome, String tipo, double valor, double defesa, String status, String genero) {
        super(nome, tipo, valor, status);
        this.defesa = defesa;
        this.genero = genero;
    }

    @Override
    public void equiparItem(UsuarioPersona usuario) {
        if (usuario.item == null) {
            usuario.item = new HashSet<>();
        }
        usuario.item.add(this);
        if(this.getDefesa() > 0 && this.getDefesa() <= 100){
            usuario.setHp(usuario.getHp() + 20);
        }
        else if(this.getDefesa() > 100 && this.getDefesa() <= 200){
            usuario.setHp(usuario.getHp() + 40);
        }
        else{
            usuario.setHp(usuario.getHp() + 60);
        }
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +
                ", Tipo: " + getTipo() +
                ", Valor: " + getValor() +
                ", Status: " + getStatus() +
                ", Defesa: " + getDefesa() +
                ", Gênero: " + getGenero();
    }

    public String getGenero() {
        return genero;
    }

    public double getDefesa() {
        return defesa;
    }

}
