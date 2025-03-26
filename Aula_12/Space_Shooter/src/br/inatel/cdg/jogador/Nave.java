package br.inatel.cdg.jogador;

import br.inatel.cdg.inimigo.Asteroide;

public class Nave {

    private String nome, tipoTiro;
    private double vida;

    // Agora nave pertence à classe e não mais ao método.
    public Nave (String nome, double vida, String tipoTiro){
        this.nome = nome;
        this.vida = vida;
        this.tipoTiro = tipoTiro;
    }

    public void atirar(Asteroide ast){
        ast.destruir();
    }

    public String getNome() {
        return nome;
    }

    public String getTipoTiro() {
        return tipoTiro;
    }

    public double getVida() {
        return vida;
    }
}
