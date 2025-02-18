import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Personagem personagem = new Personagem();
        Arma arma = new Arma();
        Zumbi zumbi = new Zumbi();

        personagem.arma_nova = arma;

        personagem.arma_nova.nome = "Bazuka";
        personagem.arma_nova.poder = 100;
        personagem.arma_nova.resist = 200;
        personagem.arma_nova.descricao = "Arma daora";

        zumbi.vida = 50;
        personagem.vida = 10;
        zumbi.poder = 5;


        personagem.arma_nova.mostraInfoArma();

        personagem.usarArma(zumbi, personagem.arma_nova.poder);
        personagem.tomarDano(personagem, zumbi.poder);

        System.out.println("vida:" + personagem.vida);
        System.out.println("vida do zumbi:" + zumbi.vida);


    }
}