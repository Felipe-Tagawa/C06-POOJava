package br.inatel.cdg.animal;

import br.inatel.cdg.Interface.Aquatico;

public class Lontra extends Mamifero implements Aquatico {
    public Lontra(String nome, double vida) {
        super(nome, vida);
    }

    @Override
    public void emitirSom() {
    }

    @Override
    public void nadar(){
        System.out.println("Lontra " + nome + " nadando...");
    }
}
