public class Zumbi {

    String nome;
    int vida;
    int dano;

    public Zumbi() { // Construtor para compor, apenas 1 vez.
    }

    public void seAlimentar() {
        System.out.println("Zumbi " + nome + "está se alimentando...");
    }

    void mostraInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Dano: " + dano);
    }

    void causar_dano(Zumbi zumbiAlvo, int qntDano){

        zumbiAlvo.vida -= qntDano;

    }

}
