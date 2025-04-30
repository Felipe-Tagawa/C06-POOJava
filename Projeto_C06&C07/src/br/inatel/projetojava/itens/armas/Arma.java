package br.inatel.projetojava.itens.armas;

import br.inatel.projetojava.itens.Itens;

public class Arma extends Itens {

    public Arma(String nome, String tipo, double valor, String status) {
        super(nome, tipo, valor, status);
    }

    @Override
    public void equiparItem(UsuarioPersona usuario) {

    }
}
