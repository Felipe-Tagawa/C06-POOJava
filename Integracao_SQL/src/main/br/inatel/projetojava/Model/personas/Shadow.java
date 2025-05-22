package main.br.inatel.projetojava.Model.personas;

import java.util.List;

public class Shadow extends Personas {

    private double vida;

    public Shadow(String nome, int vida, int nivel, String arcana, List<String> tipo, String fraqueza, String resistencia, double dano) {
        super(nome, nivel, arcana, tipo, fraqueza, resistencia, dano);
        this.vida = vida;
    }


    @Override
    public void mostrarStatusPersona(){
        super.mostrarStatusPersona();
    }

    public String toString() {
        return String.format("\nNome: %s\nVida: %.2f\nNível: %d\nArcana: %s\nFraqueza: %s\nResistência: %s\nDano: %.2f",
                this.getNome(),
                this.vida,
                this.getNivel(),
                this.getArcana(),
                this.getFraqueza(),
                this.getResistencia(),
                this.getDano());
    }


}