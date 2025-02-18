public class Personagem {

    String nome;
    int vida;
    Arma arma_nova;

    public void usarArma(Zumbi zumbi, int dano){
        zumbi.vida -= dano;

    }
    public void tomarDano(Personagem persona, int dano_recebido){
        persona.vida -= dano_recebido;

    }

}
