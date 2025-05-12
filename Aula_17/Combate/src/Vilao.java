public class Vilao extends Personagem implements Combater {

    public Vilao(String nome, int vida) {
        super(nome, vida);
    }

    public void usarEspecial(Personagem personagem) {
        System.out.println(nome + " usou o poder da mente e criou uma arma poderosa e matou o herói!");
        personagem.vida = 0; // Zerar a vida do herói.
    }
}
