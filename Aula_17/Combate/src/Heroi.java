public class Heroi extends Personagem implements Combater{


    public Heroi(String nome, int vida) {
        super(nome, vida);
    }

    public void usarEspecial(Personagem personagem) {
        System.out.println(nome + " deu um soco tão forte que o Líder perdeu suas armas!");
        personagem.armas = null; // Anular as armas do herói.
    }
}
