public class Zumbi {
    // Exercício com UML.

    double vida;
    String nome;

    public double mostraVida(){
        return vida;
    }

    public void transfereVida(Zumbi zumbiAlvo, double quantia){
        zumbiAlvo.vida += quantia;
        vida -= quantia;
    }

}
